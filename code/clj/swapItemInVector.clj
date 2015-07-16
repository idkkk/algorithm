;;交换一个有序列表中连续两个元素的位置
;;input:0 1 2 3 4 5 6 7 8 9
;;output:1 0 3 2 5 4 7 6 9 8

(defn swap-pairs
	[myseq]
	(into (empty myseq)
		(interleave
			(take-nth 2(drop 1 myseq))
			(take-nth 2 myseq))))

;;useage
;;(swap-pairs (apply vector (range 10)))