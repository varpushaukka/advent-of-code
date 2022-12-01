(ns solutions-2022.day1
   (:require [clojure.string :as str]))

(def input
  (for [basket (-> "src/solutions-2022/data/day1input.txt" slurp (str/split #"\n\n"))]
    (re-seq #"\w+" basket)))

;part 1
(reduce max (map (comp #(reduce + %) #(map read-string %)) input))

;part 2
(defn collect-max [top3 next-basket]
  (let [stop3 (sort top3)]
  (if (< (first stop3) next-basket) (conj (rest stop3) next-basket)
      top3)))

(let [baskets (map (comp #(reduce + %) #(map read-string %)) input)
      init (take 3 baskets)]
     (reduce + (reduce collect-max init baskets)))

  
  

