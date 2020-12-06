(ns solutions-2020.day5
  (:require [clojure.string :as str]
            [clojure.data :as data]))

(def input (-> "src/solutions-2020/data/day5input.txt" slurp (str/split #"\n")))

(defn row-num [seat]
  (Integer/parseInt (subs (str/replace seat #"F|B" {"F" "0" "B" "1"}) 0 7) 2))

(defn col-num [seat]
  (Integer/parseInt (subs (str/replace seat #"L|R" {"L" "0" "R" "1"}) 7 10) 2))

(defn find-seat [seats] 
    (map (fn [row column] (+ (* row 8) column)) (map #(row-num %) seats) (map #(col-num %) seats)))

(defn part1 [seat]
  (apply min (find-seat seat)))

(defn part2 [seat] 
  (first (filter some? (first (data/diff (range 48 923) (sort (find-seat seat)))))))