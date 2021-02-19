(ns uri-escape.core-test
  (:require [clojure.test :refer :all]
            [uri-escape.core :as esc :refer :all]))

(deftest a-test
  (testing "encode hello world" (is (= (esc/encode "hello world") "hello%20world")))
  (testing "encode !@#$%^&*()-_.~" (is (= (esc/encode "!@#$%^&*()-.~_") "%21%40%23%24%25%5E%26%2A%28%29-.~_")))
)

(deftest b-test
  (testing "encode hello world" (is (= (esc/decode "hello%20world") "hello world")))
  (testing "encode !@#$%^&*()" (is (= (esc/decode "%21%40%23%24%25%5E%26%2A%28%29-.~_%25") "!@#$%^&*()-.~_%")))
)
