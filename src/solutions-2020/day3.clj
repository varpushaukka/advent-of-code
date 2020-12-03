(def input (-> "src/solutions-2020/data/day3input.txt" slurp (clojure.string/split #"\n")))

(defn count-trees [slope right down]
  (let [inds (for [[row i] (map vector (take-nth down slope) (range))]
               (get row (mod (* i right) (count row))))]
    (count (filter #{(char 35)} inds))))

(count-trees input 3 1)

(defn count-many-slope-trees []
  (* (count-trees input 1 1) 
   (count-trees input 3 1) 
   (count-trees input 5 1) 
   (count-trees input 7 1) 
   (count-trees input 1 2)))

(count-many-slope-trees)
