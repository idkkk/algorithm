;;定义斐波那契数列
;;特点
;;1.接近数学表达
;;2.懒序列
(defn fibonacci []  
    (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1])))  
;;使用
(nth (fibonacci) 66) 