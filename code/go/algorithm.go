package main

import (
	"fmt"
)

func main() {
	intList := []int{1, -2, 5, -8, 10, 3}
	maxSubSum(intList)
}

func getMax(array []int) int {
	temp := 0
	for i := 0; i < len(array); i++ {
		temp = max(temp, array[i])
	}
	return temp
}

//求最大值
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

//;;求子数组的最大和(整数，可以包含负数)
func maxSubSum(args []int) {
	sum := make([]int, len(args))
	for i := 0; i < len(args); i++ {
		//fmt.Println(args[i])
		//动态规划第一阶段
		if i == 0 {
			sum[i] = args[i]
			//fmt.Println(sum[i])
		} else {
			sum[i] = max(args[i], sum[i-1]+args[i])
		}
	}
	//fmt.Println(sum)
	//动态规划第二阶段
	fmt.Println(getMax(sum))
}
