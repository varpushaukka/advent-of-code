(def input
  (-> "src/solutions-2020/data/day1input.txt"
      slurp
      (clojure.string/split #"\n")
      (->> (mapv read-string))))

(defn two-sum [nums target]
  (let [nums-index (zipmap nums (range))
        sums (for [[x i] nums-index
                   [y j] nums-index
                   :when (< i j)
                   :when (= (+ x y) target)]
               (* x y))]
    (first sums)))

(two-sum input 2020)

(defn three-sum [nums target]
  (let [nums-index (zipmap nums (range))
        sums (for [[x i] nums-index
                   [y j] nums-index
                   [z n] nums-index
                   :when (< i j n)
                   :when (= (+ x y z) target)]
               (* x y z))]
    (first sums)))

(three-sum input 2020)