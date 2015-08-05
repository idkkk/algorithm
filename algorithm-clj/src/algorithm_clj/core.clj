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


(def ^{:doc "Count items matching a filter"} count-if (comp count filter))
;;硬币问题-求连续两次正面的次数
(defn count-coins
	"n是连续次数，pred是相同两个正面条件，coll是集合"
	[n pred coll]
	(count-if #(every? pred %) (partition n 1 coll)))

;;求词频
(defn frequencies-top
	"词频，排序"
	[n]
	(take 1 (sort-by val > (frequencies n))))

;;求词频-TOIMPRO
(defn getset [m k]
	(if (contains? m k) 
		(conj m (hash-map k (+ 1 (get m k))))
		(conj m (hash-map k 1))))
(reduce getset (map (fn[a](hash-map a 1)) '("测试", "abc", "xyz", "xYz", "abc", "中国", "China", "测试", "测试abc", "abc", "xzy", "试测", "国中", "中国")))

;;给一个自然数N，找出连续自然数和等于N的组合，然后找出组合中乘积最大的
;(createlist 1 10)
(defn createlist[start end]
	(map #(range start %) (range (+ start 1) (+ end 2))))
;(createsumlist 100)
(defn createsumlist[n]
	(filter #(= n (reduce + %)) (reduce into (map #(createlist % n) (range 1 (+ n 1))))))
;TOIMPRO-by macro
(defn maxnumofsumlist[n]
	(take 1 (sort-by val > (reduce into (map #(hash-map % (reduce * %)) (createsumlist n))))))


