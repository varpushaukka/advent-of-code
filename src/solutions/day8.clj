(ns solutions.day8)

(def layers
  (->> (slurp "src/solutions/data/day8input.txt")
       (map #(Character/digit % 10))
       butlast
       (partition (* 25 6))))

(defn find-fewest-0-digits [l-list]
  (let [zfreq (fn [x y] (if (< (get (frequencies x) 0) (get (frequencies y) 0)) x y))]
    (reduce zfreq l-list)))

(defn part-1 []
  (let [freq (frequencies (find-fewest-0-digits layers))
        ones (get freq 1)
        twos (get freq 2)]
    (* ones twos)))
