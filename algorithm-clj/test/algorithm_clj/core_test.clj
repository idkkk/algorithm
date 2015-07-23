(ns algorithm-clj.core-test
  (:require [clojure.test :refer :all]
            [algorithm-clj.core :refer :all]))

(deftest average-test
  (testing "the average number"
    (is (= 3 (average [1 2 3 4 5])))))

(deftest swap-pairs-test
  (testing "the seq list"
    (is (= '(1 0 3 2 5 4 7 6 9 8) (swap-pairs (apply vector (range 10)))))))

(deftest fibonacci-test
  (testing "the fibonacci number"
    (is (= 573147844013817084101N (nth (fibonacci) 100) ))))

(deftest arithmetic-sequence-sum-test
  (testing "the arithmetic-sequence-sum"
    (is (= 5050 (arithmetic-sequence-sum 100)))))


(deftest arithmetic-sequence-sum2-test
  (testing "the arithmetic-sequence-sum2"
    (is (= 5050 (arithmetic-sequence-sum2 100)))))


(deftest arithmetic-sequence-sum3-test
  (testing "the arithmetic-sequence-sum3"
    (is (= 604 (arithmetic-sequence-sum3 4)))))

(deftest arithmetic-sequence-sum4-test
  (testing "the arithmetic-sequence-sum2"
    (is (= 5050 (arithmetic-sequence-sum2 100)))))
