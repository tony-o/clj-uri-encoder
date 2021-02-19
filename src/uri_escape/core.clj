(ns uri-escape.core)


(defn- enchar [c]
  (let [n (int c)]
    (if (or (and (>= n 97) (<= n 122))
            (and (>= n 65) (<= n 90))
            (and (>= n 48) (<= n 57))
            (== n 45) (== n 46)
            (== n 95) (== n 126))
        (format "%s" c)
        (format "%%%02X" (int c))
    ))
)

(defn encode [s]
  (clojure.string/join "" (map enchar s))
)

(defn- decode-c ([] []) ([s & l]
  (if (nil? l) 
      [s]
      (if (== (int s) 37)
          (concat [(char (Integer/parseInt (clojure.string/join "" (take 2 l)) 16))]
                  (apply decode-c (drop 2 l)))
          (concat [s] (apply decode-c l))))
))

(defn decode [s]
  (clojure.string/join "" (apply decode-c (seq s)))
)
