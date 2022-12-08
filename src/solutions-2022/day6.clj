(ns day6 
  (:require [clojure.string :as str]))

(def input
  (-> "src/solutions-2022/data/day6input.txt" slurp seq))

(loop [ffour (take 14 input) signals (drop 1 input) index 14]
  (if (empty? signals) index
      (if (= 14 (count (set ffour))) index
          (recur (take 14 signals) (drop 1 signals) (inc index)))))

