;;定义斐波那契数列
;;特点
;;1.接近数学表达
;;2.懒序列
(defn fibonacci []  
    (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1N])))
;;使用
(nth (fibonacci) 100) 


;;等差数列求和
(defn arithmetic-sequence-sum [n] (reduce + (range (inc n))))
;;使用
(arithmetic-sequence-sum 100)
;;等差数列求和-公式求和
(defn arithmetic-sequence-sum2 [n] (/ (* (+ 1 n) n) 2))
;;使用
(arithmetic-sequence-sum2 100)
;;等差数列求和-公式求和-带步长100
(defn arithmetic-sequence-sum3 [n] (/ (* (+ 1 (+ 1 (* (- n 1) 100))) n) 2))
;;使用
(arithmetic-sequence-sum3 4)
