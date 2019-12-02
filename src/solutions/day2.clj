(ns solutions.day2)

(defn input [noun verb]
  (as-> (clojure.string/split (slurp "src/solutions/data/day2input.txt") #",") i
    (map read-string i)
    (vec i)
    (assoc i 1 noun)
    (assoc i 2 verb)))

; part-1
(defn opcode [c]
  (case c
    1 +
    2 *
    99 nil))

(defn process [code]
    (loop [l code p 0]
      (let [op (opcode (get l p))
            i1 (get l (inc p))
            i2 (get l (+ 2 p))
            pos (get l (+ 3 p))]
        (if-not op
          l
          (recur (assoc l pos (op (get l i1) (get l i2))) (+ 4 p))))))

(defn part-1 []
  (process (input 12 2)))

;part-2

(defn part-2 [target]
  (let [noun-verb (zipmap (range 100) (range))
        indexs (for [[x i] noun-verb
                     [y j] noun-verb
                     :when (< i j)
                     :when (= (first (process (input x y))) target)]
                 (+ (* 100 i) j))]
    (first indexs)))

(part-2 19690720)