(ns solutions.day3
  (:require [clojure.string :as s]))

(defn wires []
  (map #(clojure.string/split % #",") 
     (clojure.string/split (slurp "src/solutions/data/day3input.txt") #"\n")))

(defn wire-coordinates [wire]
  (loop [w wire lastmove [0 0] coordlist []]
    (if-not (empty? w)
      (let [move (first w)
            d (first move)
            coords (for [c (range 1 (inc (read-string (subs move 1))))]
                     (case d
                       \R [(+ (first lastmove) c) (last lastmove)]
                       \L [(- (first lastmove) c) (last lastmove)]
                       \U [(first lastmove) (+ (last lastmove) c)]
                       \D [(first lastmove) (- (last lastmove) c)]))]
        (recur (rest w) (last coords) (conj coordlist coords)))
      coordlist
      )))

(defn min-distance [w1 w2]
  (let [wire-cross-points (clojure.set/intersection
                           (set (apply concat (wire-coordinates w1)))
                           (set (apply concat (wire-coordinates w2))))
        dist (fn [[x y]] (+ (Math/abs x) (Math/abs y)))]
    (apply min (map dist wire-cross-points)))
    )

(min-distance (first (wires)) (last (wires)))