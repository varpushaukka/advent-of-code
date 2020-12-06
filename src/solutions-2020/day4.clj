(def input
  (-> "src/solutions-2020/data/day4input.txt"
      slurp
      (clojure.string/split #"\n\n")
      (->> (map (fn [passport] (map #(clojure.string/split % #"\:") (clojure.string/split passport #"\n| ")))))))

(defn valid-passports-1 [passports]
    (filter #(> (count %) 6) (map #(keep (fn [[x _]] (re-matches #"iyr|ecl|pid|byr|hgt|eyr|hcl" x)) %) passports)))

(count (valid-passports-1 input))
