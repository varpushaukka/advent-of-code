(def input
  (-> "solutions-2021/data/day1input.txt"
      slurp
      (clojure.string/split #"\n")
      (->> (mapv read-string))))

(defn count-decreases [measurements]
  (loop [list measurements r 0]
  (cond (nil? (second list)) r
        (< (first list) (second list)) (recur (rest list) (inc r))
        :else (recur (rest list) r))))

;part 1
(count-decreases input)

;part 2
(count-decreases (map #(reduce + %) (partition 3 1 input)))