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

(defn draw [l-list]
 (letfn [(pixel-color [[x y]] (if (= 2 x) y x))
         (merge-layers [l1 l2] (map pixel-color (partition 2 (interleave l1 l2))))]
   (reduce merge-layers l-list)))

(defn part-2 []
    (let [image (partition 25 (draw layers))]
      (for [line image]
        (println line))))
