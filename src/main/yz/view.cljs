(ns yz.view
  (:require [reagent.core :as r]
            [yz.game :as g]))

(defn <die>
  [die-val]
  [:img.die
   {:src (str "assets/" (if (nil? die-val) "question" die-val) ".png")}])

(defn <die-set> [die-vals]
  (->> die-vals
       (map (fn [die-val] [<die> die-val]))
       (into [:div])))

(defonce !game (r/atom (g/make-game)))

(defn <game>
  []
  (let [game @!game
        can-roll? (g/can-roll? game)]
    [:div
     [:div
      [<die-set> (g/die-vals game)]]
     [:div.menu
      [:a.menu-item.button
       {:on-click (fn []
                    (swap! !game g/reset))}
       "Start"]
      [:a.menu-item.button
       {:class (when-not can-roll? :disabled)
        :on-click (when can-roll?
                    (fn []
                      (swap! !game (fn [game] (g/roll game (g/rand-roller))))))}
       "Roll"]]]))
