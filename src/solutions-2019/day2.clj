(ns solutions.day2)

(defn input [noun verb]
  (-> "src/solutions/data/day2input.txt"
    slurp
    (clojure.string/split #",")
    (->> (mapv read-string))
    (assoc 1 noun 2 verb)))

; part-1
(def opcode {1 + 2 *})

(defn process [code]
    (loop [l code p 0]
      (let [[opc i1 i2 pos] (subvec l p (+ p 4))
            op (opcode opc)]
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
