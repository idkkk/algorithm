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

(deftest count-coins-test
  (testing "the count of coins"
    (is (= 3 (count-coins 2 #(= % 1) [1 0 0 1 1 0 1 1 0 1 1])))))

(deftest frequencies-top-test
  (testing "the frequencies top number"
    (is (= '(["abc" 3]) (frequencies-top '("测试", "abc", "xyz", "xYz", "abc", "中国", "China", "测试", "测试abc", "abc", "xzy", "试测", "国中", "中国"))))))

(deftest maxnumofsumlist-test
  (testing "get the max num of sum list"
    (is (= '([(9 10 11 12 13 14 15 16) 518918400]) (maxnumofsumlist 100)))))

(deftest prime-test
  (testing "get the max num of sum list"
    (do (is (= true (prime? 2)))
      (is (= true (prime? 3)))
      (is (= false (prime? 6)))
      (is (= true (prime? 23))))))

(deftest max-number-test
  (testing "get the max num of int list"
    (do (is (= "5431" (max-number '(5 3 4 1))))
      (is (= "9753" (max-number '(5 3 7 9)))))))

(deftest max-number-test
  (testing "get the max num of int list"
    (do (is (= "5431" (max-number '(5 3 4 1))))
      (is (= "9753" (max-number '(5 3 7 9)))))))

(deftest count-all-list-with-department-test
  (testing "查找20-30年龄段人力资源的人"
    (is (= '(4) (map val (first (first (count-all-list-with-department [[20 30] [30 40]]))))))))

