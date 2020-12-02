(ns solutions.day4)

(defn part1-solutions [] 
   (for [password (range 171309 643604)
         :let [lpw (map #(Character/digit % 10) (str password))]
         :when (every? (fn [[x y]] (>= y x)) (partition 2 1 lpw))
         :when (some (fn [[x y]] (= x y)) (partition 2 1 lpw))]
     lpw))

(println (count (part1-solutions)))

(defn part2-solutions []
  (filter #(some (fn [[_ y]] (= y 2)) (frequencies %)) (part1-solutions)))

(println (count (part2-solutions)))
