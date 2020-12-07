(ns solutions-2020.day5
  (:require [clojure.string :as str]
            [clojure.data :as data]))

(def input (-> "src/solutions-2020/data/day5input.txt" slurp (str/split #"\n")))

(defn seat-num [seat x y]
  (Integer/parseInt (subs (str/replace seat #"F|B|L|R" {"F" "0" "B" "1" "L" "0" "R" "1"}) x y) 2))

(defn find-seat [seats] 
    (map (fn [row column] (+ (* row 8) column)) (map #(seat-num % 0 7) seats) (map #(seat-num % 7 10) seats)))

(defn part1 [seat]
  (apply max (find-seat seat)))

(defn part2 [seat] 
  (first (filter some? (first (data/diff (range (apply min (find-seat seat)) (inc (part1 seat))) (sort (find-seat seat)))))))
