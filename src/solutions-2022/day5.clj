(ns day5
  (:require [clojure.string :as str]))

(def input2
  (take-nth 4 (-> "src/solutions-2022/data/day5input.txt"
                  slurp
                  (str/split #"\n\n")
                  first
                  rest)))

(defn only-letters [pile]
  (filter #(Character/isLetter %) pile))

(defn lists [input] (zipmap (range 1 10) (map only-letters (apply map vector (partition 9 input)))))

(defn parse-commands []
  (let [[_ commands] (-> "src/solutions-2022/data/day5input.txt" slurp (str/split #"\n\n"))
        rows (str/split commands #"\n")
        clist (map #(re-seq #"\d+" %) rows)
        ints (map #(map read-string %) clist)]
    ints))

(defn move [amount origin destination crate-piles]
  (let [org-pile (get crate-piles origin)
        dest-pile (get crate-piles destination)
        upd-org (drop amount org-pile)
        upd-dest (apply conj dest-pile (reverse (take amount org-pile)))
        drop-amount (assoc crate-piles origin upd-org)]
    (assoc drop-amount destination upd-dest)))

;part 1
(apply str (map first (vals (sort (loop [commands (parse-commands)
                                         stacks (lists input2)]
                                    (let [[am org dest] (first commands)]
                                      (if (empty? commands) stacks
                                          (recur (rest commands) (move am org dest stacks)))))))))



