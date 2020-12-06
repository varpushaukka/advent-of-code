(ns solutions-2020.day6
  (:require [clojure.string :as str]
            [clojure.set :refer [intersection]]))

(def input (-> "src/solutions-2020/data/day6input.txt" 
               slurp 
               (str/split #"\n\n")))

(defn count-yes-answers [answers]
  (reduce + (map #(count (set (remove #{(char 10)} %))) answers)))

(count-yes-answers input)

(defn count-mutual-yes-answers [answers]
  (reduce + (map #(count (apply intersection (map (comp set char-array) (str/split % #"\n")))) answers)))

(count-mutual-yes-answers input)
