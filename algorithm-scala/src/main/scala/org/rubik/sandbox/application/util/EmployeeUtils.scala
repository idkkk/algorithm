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
   * 求各部门员工平均薪资.
   * @param employees 员工集合
   * @return 各部门平均薪资Map
   */
  def averageSalaries(employees: List[Employee]): Map[String, BigDecimal] = {
    def averageSalariesOfDepartment(employeesOfDepartment: List[Employee]): BigDecimal = {
      employeesOfDepartment.view.map(_.salary).reduce(_ + _) / employeesOfDepartment.length
    }
    employees.groupBy(_.department).mapValues(averageSalariesOfDepartment)
  }


}