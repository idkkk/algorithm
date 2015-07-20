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