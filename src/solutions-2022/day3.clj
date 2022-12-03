(ns day3
  (:require [clojure.string :as str]
            [clojure.set :as st]))

(def input
  (-> "src/solutions-2022/data/day3input.txt" slurp (str/split #"\n")))

(defn char-value [item]
  (inc (str/index-of "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" item)))

;part 1
(defn priority [rucksack]
  (let [[a b] ((juxt take drop) (/ (count rucksack) 2) rucksack)
        common-char (first (st/intersection (set a) (set b)))]
    (char-value common-char)))

(reduce + (map priority input))

;part 2
(defn priority3 [[a b c]]
    (char-value (first (st/intersection (set a) (set b) (set c)))))

(reduce + (map priority3 (partition 3 input)))
