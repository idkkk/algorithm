(defn average
	[numbers]
	(/ (apply + numbers) (count numbers)))

;usage
;(average [60 80 199 450])