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


(def sword "ab dd ab aa dd ab ab ab")
;加{}作为起始参数，%1第一个赋值就是{};assoc修改map为%1里的value值%2，值为原来的值加1
(defn frequencies-top2[s]
	(reduce #(assoc %1 %2 (inc (%1 %2 0))) {} (re-seq #"\w+" s)))



;;求词频-TOIMPRO
(defn getset [m k]
	(if (contains? m k) 
		(conj m (hash-map k (+ 1 (get m k))))
		(conj m (hash-map k 1))))
(reduce getset (map (fn[a](hash-map a 1)) '("测试", "abc", "xyz", "xYz", "abc", "中国", "China", "测试", "测试abc", "abc", "xzy", "试测", "国中", "中国")))

;;给一个自然数N，找出连续自然数和等于N的组合，然后找出组合中乘积最大的
;(createlist 1 10)
(defn createlist[start end]
	(map #(range start %) (range (+ start 1N) (+ end 2N))))
;(createsumlist 100)
(defn createsumlist[n]
	(filter #(= n (reduce + %)) (reduce into (map #(createlist % n) (range 1N (+ n 1N))))))
;TOIMPRO-by macro
(defn maxnumofsumlist[n]
	(take 1 (sort-by val > (reduce into (map #(hash-map % (reduce * %)) (createsumlist n))))))

;;判断给定自然数是否是质数
;目前为止，人们未找到一个公式可求出所有质数
(defn prime? [n]
  (not-any? zero? (map #(rem n %) (range 2 n))))

;;求任意数字集合，组合成的最大数.
(defn max-number [list]
	(apply str (sort >  list)))

;;公司员工相关计算
;定义数据结构
(defrecord Employee [id name age salary department])
;数据源
(def employees
	(list 
	(->Employee "BJ100102" "陈金金" 25 12000 "人力资源")
	(->Employee "SH211101" "王晓菲" 25 15000 "人力资源") 
	(->Employee "SH210112" "陈洪斌" 36 25000 "技术部")
	(->Employee "HZ132142" "沈进军" 37 20000 "技术部")
	(->Employee "HZ123186" "叶飞飞" 36 18000 "市场部")
	(->Employee "HZ224731" "夏清寿" 37 12000 "市场部")
	(->Employee "HZ325137" "聂运民" 38 20000 "技术部")
	(->Employee "HZ332569" "袁丽玲" 25 18000 "人力资源")
	(->Employee "GZ550020" "张涛" 32 30000 "技术部")
	(->Employee "JX332300" "王义军" 36 15000 "技术部")
	(->Employee "JX332301" "李如钢" 36 16000 "技术部")
	(->Employee "JX332302" "陈牡蓉" 25 16000 "人力资源")
	(->Employee "JX332303" "唐建宇" 35 16000 "财务部")
	(->Employee "SZ518119" "刘颖刚" 36 20000 "法务部")
	(->Employee "GZ510003" "黎明" 36 15000 "销售部")
	(->Employee "BJ100102" "宋崇峰" 30 20000 "技术部")
	(->Employee "BJ112200" "余竞" 35 22000 "技术部")
	(->Employee "BJ101120" "王晓明" 36 25000 "技术部")
	(->Employee "BJ101132" "华永兵" 37 20000 "技术部")
	(->Employee "JX332305" "梅雪飞" 35 12000 "人力资源")
	(->Employee "JX332306" "徐杨" 36 12000 "人力资源")
	(->Employee "JX332307" "王能翔" 36 12000 "人力资源")
	(->Employee "JX332308" "施宇" 36 13000 "人力资源")
	(->Employee "BJ102303" "聂耿" 37 22000 "组织部")
	(->Employee "BJ100103" "吴智辰" 37 25000 "技术部")
	(->Employee "BJ100104" "毛杨俊" 37 30000 "销售部")
	(->Employee "BJ100105" "蒋玖平" 37 40000 "组织部")
	(->Employee "BJ100106" "丁肇龙" 37 20000 "市场部")
	(->Employee "GZ510003" "魏小恒" 36 30000 "技术部")
	(->Employee "BJ100152" "马欣" 38 32000 "技术部")
	(->Employee "BJ100142" "王菲" 32 30000 "技术部")
	(->Employee "BJ100056" "Mac" 40 90000 "技术部")
	(->Employee "BJ123102" "戴成" 32 30000 "市场部")))

(defn count-in-list-with-department
	;根据给定的年龄列表对[department,[employee,employee]]进行统计
	;(count-in-list-with-department #{1 25 3 4 5 6 7 8 9 10} (first (group-by :department employees)))
	[start end employees]
	;返回部门，数量成的map
	 (hash-map (str "部门：" (first employees) " 年龄区间:" start "-" end) (count (filter #(contains? (set (range start end)) (:age %)) (second employees)))))
;;各部门不同年龄段的员工数(目前只计算20-29, 30-39, 40-49区间).
(defn count-all-list-with-department[list]
	;根据指定区间查找结果
	(map (fn[x](map #(count-in-list-with-department (first x) (last x) %) (group-by :department employees))) list))
(defn average-salary-in-list-with-age[start end employees]
	;先根据区间过滤
	(let [results (filter #(contains? (set (range start end)) (:age %)) employees)]
	;求和求平均
	(str start "-" end ":" (/ (reduce (fn[a b](+ a (:salary b))) (cons 0 results)) (count results)))))
;;不同年龄区间的平均薪资(目前只计算20-29, 30-39, 40-49区间).
(defn average-salary-all-list-with-age[list]
	;根据指定区间查找结果
	(map (fn[x](average-salary-in-list-with-age (first x) (last x) employees)) list))
;;各部门员工平均薪资由高到低排序.
(defn average-salary-sorted-with-department[]
	;分组-分组内求求平均-转化为map-排序
	(sort-by val > (reduce into (map (fn[x](hash-map (first x) (let [results (second x)](/ (reduce (fn[a b](+ a (:salary b))) (cons 0 results)) (count results))))) (group-by :department employees)))))

;;flatten函数实现
(defn flatten-new[list]
	(filter (complement sequential?) (tree-seq sequential? identity list)))
;;大文本倒序
;TOIMPRO-路径抽取，参数抽取
(require '[clojure.string :refer [join split]])
(defn splitbyline[seq filename]
  (if (empty? seq) filename
    (recur 
      (do 
          (spit (str "./src/algorithm_clj/file/" filename ".txt") (reduce #(str %1 "\n" %2) (reverse (take 2000 seq))))
          (drop 2000 seq))
      (inc filename))))
(defn mergebyfile[filename]
  (if (< filename 0) "end"
        (recur (do 
          ;(prn (slurp (str "./file/" filename ".txt")))
          (spit "./src/algorithm_clj/file/reverseresult.txt" (str (slurp (str "./src/algorithm_clj/file/" filename ".txt")) "\n") :append true)
          (dec filename)))))
(defn reverse-file[name]
  (time 
    (with-open [rdr (clojure.java.io/reader (str "./src/algorithm_clj/file/" name ".txt"))]
      (let [fileseq (line-seq rdr)]
        (mergebyfile (- (splitbyline fileseq 0) 1))
        ))))
;;消除列表中连续重复的元素
(defn compresslist[list]
  (reduce #(if (= (last %1) %2)  %1 (conj %1 %2)) [] list))

;;求给定数值区间中1出现的次数
(defn counter-of-one[list]
	(count (filter #(= % \1) (reduce #(str %1 %2) list))))
;;根据指定列表中连续重复的元素来组成子集合
(defn get-val-as-coll[map key]
  (if (nil? (map key)) (conj [] key) (conj (map key) key)))
;(get-val-as-coll (array-map "a" ["a" "b"] "b" ["c" "d"]) "e")
(defn pack-coll[list]
  (vals (reduce #(assoc %1 %2 (get-val-as-coll %1 %2)) (array-map) list)))


