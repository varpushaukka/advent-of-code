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

(defn part2-solutions []
  (for [lpw (part1-solutions)
        :when (some (fn [[_ y]] (= y 2)) (frequencies lpw))]
    lpw))

(count (part2-solutions))
