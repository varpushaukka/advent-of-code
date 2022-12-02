(ns solutions-2022.day2
  (:require [clojure.string :as str]))

(def input
  (for [game (-> "src/solutions-2022/data/day2input.txt" slurp (str/split #"\n"))]
    (re-seq #"\w+" game)))

(defn parse-hand [hand parse-map]
  (map
   (comp #(read-string %) #(str/replace % #"A|B|C|X|Y|Z" parse-map))
   hand))

; part 1
(defn calc-points [[a b]]
     (cond 
       (= (mod a 3) (dec b)) (+ 6 b)
       (= a b) (+ 3 b)
       :else b
       ))

(reduce + (map (comp calc-points #(parse-hand % {"A" "1" "B" "2" "C" "3" "X" "1" "Y" "2" "Z" "3"})) input))

; part 2
(defn new-strategy [[a b]]
    (case b
      0 (calc-points [a (get {1 3 2 1 3 2} a)])
      3 (calc-points [a a])
      6 (calc-points [a (get {1 2 2 3 3 1} a)])
    ))

(reduce + (map (comp new-strategy #(parse-hand % {"A" "1" "B" "2" "C" "3" "X" "0" "Y" "3" "Z" "6"})) input))
