package org.rubik.sandbox.application.util

import org.rubik.sandbox.application.model.Employee

/**
 * 员工工具类.
 *
 * @author xiajinxin
 * @since 2015-08-06
 */
object EmployeeUtils {
  /**
   * 各部门不同年龄段的员工数(目前只计算20-29, 30-39, 40-49区间).
   * @param employes 员工集合
   * @return 各部门不同年龄段的员工数: Map(部门名, List( (年龄区间, 员工数) ) )
   */
  def countForEmployeeOfAgeRange(employes: List[Employee]): Map[String, List[(Seq[Int], Int)]] = {
    val rangeOfAge = (20 to 49).sliding(10, 10).toList
    employes.groupBy(_.department).mapValues(subList => {
      for(v <- rangeOfAge; data = employes.count(e => subList.head.department==e.department && v.contains(e.age)) if data!=0) yield (v, data)
    })
  }


  /**
   * 不同年龄区间的平均薪资(目前只计算20-29, 30-39, 40-49区间).
   * @param employes 员工集合
   * @return 不同年龄区间的平均薪资: List( (年龄区间, 平均薪资) )
   */
  def averageSalariesOfAgeRange(employes: List[Employee]): List[(Seq[Int], BigDecimal)] = {
    val rangeOfAge = (20 to 49).sliding(10, 10).toList
    for(v <- rangeOfAge) yield (v, averageSalariesOfEmployes(employes.filter(e => v.contains(e.age))))
  }

  /**
   * 各部门员工平均薪资由高到低排序.
   * @param employes 员工集合
   * @return 各部门平均薪资排序( (部门名, 平均薪资) )
   */
  def averageSalariesOfDepartment(employes: List[Employee]): Seq[(String, BigDecimal)] = {
    employes.groupBy(_.department).mapValues(averageSalariesOfEmployes).toSeq.sortBy(_._2).reverse
  }

  // ================================================================================  priavte
  /**
   * 获取特定员工集合的平均薪资.
   * @param employes 员工集合
   * @return 平均薪资
   */
  private def averageSalariesOfEmployes(employes: List[Employee]): BigDecimal = {
    employes.map(_.salary).reduce(_ + _) / employes.length
  }
}