(ns yz.app
  (:require-macros [yz.ppp])
  (:require [clojure.test :as t]
            [clojure.pprint]
            [reagent.core :as r]
            [yz.view :as v]))

(defn <root>
  []
  [v/<game>])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn ^:export main []
  (r/render [<root>] (js/document.getElementById "app")))
