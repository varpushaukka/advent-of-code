(def input
  (-> "src/solutions-2021/data/day3input.txt" slurp (clojure.string/split #"\n")))

(defn gammarate [index]
  (ffirst (sort-by val > (frequencies index))))

(defn epsilonrate [index]
  (ffirst (sort-by val < (frequencies index))))

(defn rating [rate depts]
  (apply str (loop [lista (map rest depts) r [(rate (map first depts))]]
     (if (empty? (first lista)) r
         (recur (map rest lista) (conj r (rate (map first lista))))))))

;part1
(* (Integer/parseInt (rating gammarate input) 2) (Integer/parseInt (rating epsilonrate input) 2))

(defn oxgenrating [])


