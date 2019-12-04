(ns solutions.day4)

;part 1
(defn part1-solutions [] 
   (for [password (range 171309 643604)
         :let [lpw (map #(Character/digit % 10) (str password))]
         :when (every? (fn [[x y]] (>= y x)) (partition 2 1 lpw))
         :when (some (fn [[x y]] (= x y)) (partition 2 1 lpw))]
     lpw))

(count (part1-solutions))

;part 2
(defn no-groups [password]
  (let [groups (filter (fn [[x y z]] (= x y z)) (partition 3 1 password))]
    (if-not (empty? groups)
      (remove #((set (flatten groups)) %) password)
      password
      )))

(defn part2-solutions []
  (for [lpw (part1-solutions)
        :let [pw (no-groups lpw)]
        :when (some (fn [[x y]] (= x y)) (partition 2 1 pw))]
    pw))

(count (part2-solutions))
