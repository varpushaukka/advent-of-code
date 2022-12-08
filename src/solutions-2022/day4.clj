(ns day4
  (:require [clojure.string :as str]
            [clojure.set :as st]))

(def input
  (for [area (-> "src/solutions-2022/data/day4input.txt" slurp (str/split #"\n"))]
    (str/split area #","))
  )

;part 2
(defn parit [[area1 area2]]
   (let [[a b] (map read-string (str/split area1 #"-") )
     eka (range a (inc b))
    [x y] (map read-string (str/split area2 #"-"))
     toka (range x (inc y))
     unioni (st/intersection (set eka) (set toka))]
       ((complement empty?) unioni)))

(count (filter parit input))
