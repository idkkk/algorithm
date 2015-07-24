;;Author:zhangbaitong
;;Date:2015-07-22
(ns algorithm-clj.core
  (:gen-class))

(defn -main
  "practice algorithm here."
  [& args]
  (do (println args) (println "Hello, algorithm!")))

;求平均数
(defn average
	[numbers]
	(/ (apply + numbers) (count numbers)))

;交换一个有序列表中连续两个元素的位置
(defn swap-pairs
	[myseq]
	(into (empty myseq)
		(interleave
			(take-nth 2(drop 1 myseq))
			(take-nth 2 myseq))))

;;定义斐波那契数列
;;特点
;;1.接近数学表达
;;2.懒序列
(defn fibonacci []  
    (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1N])))

;;等差数列求和
(defn arithmetic-sequence-sum [n] (reduce + (range (inc n))))

;;等差数列求和-公式求和
(defn arithmetic-sequence-sum2 [n] (/ (* (+ 1 n) n) 2))

;;等差数列求和-公式求和-带步长100
(defn arithmetic-sequence-sum3 [n] (/ (* (+ 1 (+ 1 (* (- n 1) 100))) n) 2))

;;等差数列求和-迭代
(defn arithmetic-sequence-sum4 [n] (take-nth n (iterate inc 1)))



