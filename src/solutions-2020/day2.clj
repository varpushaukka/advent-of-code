(def input
  (for [policy (-> "src/solutions-2020/data/day2input.txt" slurp (clojure.string/split #"\n"))]
    (re-seq #"\w+" policy)))

(defn valid-passwords [pw-policies]
  (filter (fn [[min max target password]]
            (<= (read-string min)
                (get (frequencies password) (first target) -1)
                (read-string max))) pw-policies))

(count (valid-passwords input))

(defn valid-passwords-2 [pw-policies]
  (filter (every-pred (fn [[i1 i2 target password]] (not (every? #{(first target)} [(get password (dec (read-string i1))) (get password (dec (read-string i2)))])))
                      (fn [[i1 i2 target password]] (some #{(first target)} [(get password (dec (read-string i1))) (get password (dec (read-string i2)))]))) pw-policies))

(count (valid-passwords-2 input))
