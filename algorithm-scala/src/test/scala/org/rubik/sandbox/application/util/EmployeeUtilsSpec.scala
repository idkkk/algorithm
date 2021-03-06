package org.rubik.sandbox.application.util

import org.rubik.sandbox.application.model.Employee
import org.scalatest._

import scala.collection.mutable.ListBuffer

class EmployeeUtilsSpec extends FlatSpec with BeforeAndAfter {
  val data = new ListBuffer[Employee]

  before {
    data.append(Employee("BJ100102", "陈金金", 25, 12000, "人力资源"))
    data.append(Employee("SH211101", "王晓菲", 25, 15000, "人力资源"))
    data.append(Employee("SH210112", "陈洪斌", 36, 25000, "技术部"))
    data.append(Employee("HZ132142", "沈进军", 37, 20000, "技术部"))
    data.append(Employee("HZ123186", "叶飞飞", 36, 18000, "市场部"))
    data.append(Employee("HZ224731", "夏清寿", 37, 12000, "市场部"))
    data.append(Employee("HZ325137", "聂运民", 38, 20000, "技术部"))
    data.append(Employee("HZ332569", "袁丽玲", 25, 18000, "人力资源"))
    data.append(Employee("GZ550020", "张涛", 32, 30000, "技术部"))
    data.append(Employee("JX332300", "王义军", 36, 15000, "技术部"))
    data.append(Employee("JX332301", "李如钢", 36, 16000, "技术部"))
    data.append(Employee("JX332302", "陈牡蓉", 25, 16000, "人力资源"))
    data.append(Employee("JX332303", "唐建宇", 35, 16000, "财务部"))
    data.append(Employee("SZ518119", "刘颖刚", 36, 20000, "法务部"))
    data.append(Employee("GZ510003", "黎明", 36, 15000, "销售部"))
    data.append(Employee("BJ100102", "宋崇峰", 30, 20000, "技术部"))
    data.append(Employee("BJ112200", "余竞", 35, 22000, "技术部"))
    data.append(Employee("BJ101120", "王晓明", 36, 25000, "技术部"))
    data.append(Employee("BJ101132", "华永兵", 37, 20000, "技术部"))
    data.append(Employee("JX332305", "梅雪飞", 35, 12000, "人力资源"))
    data.append(Employee("JX332306", "徐杨", 36, 12000, "人力资源"))
    data.append(Employee("JX332307", "王能翔", 36, 12000, "人力资源"))
    data.append(Employee("JX332308", "施宇", 36, 13000, "人力资源"))
    data.append(Employee("BJ102303", "聂耿", 37, 22000, "组织部"))
    data.append(Employee("BJ100103", "吴智辰", 37, 25000, "技术部"))
    data.append(Employee("BJ100104", "毛杨俊", 37, 30000, "销售部"))
    data.append(Employee("BJ100105", "蒋玖平", 37, 40000, "组织部"))
    data.append(Employee("BJ100106", "丁肇龙", 37, 20000, "市场部"))
    data.append(Employee("GZ510003", "魏小恒", 36, 30000, "技术部"))
    data.append(Employee("BJ100152", "马欣", 38, 32000, "技术部"))
    data.append(Employee("BJ100142", "王菲", 32, 30000, "技术部"))
    data.append(Employee("BJ100056", "Mac", 40, 90000, "技术部"))
    data.append(Employee("BJ123102", "戴成", 32, 30000, "市场部"))
  }

  after {
    data.clear()
  }

  "the department" should "average salaries" in {
    assert(EmployeeUtils.averageSalariesOfDepartment(data.toList) == Seq(("组织部",31000), ("技术部",28000), ("销售部",22500), ("市场部",20000), ("法务部",20000), ("财务部",16000), ("人力资源",13750)))
  }

  "employees's age range" should "average salaries" in {
    assert(EmployeeUtils.averageSalariesOfAgeRange(data.toList) == List((Vector(20, 21, 22, 23, 24, 25, 26, 27, 28, 29),15250), (Vector(30, 31, 32, 33, 34, 35, 36, 37, 38, 39),21500), (Vector(40, 41, 42, 43, 44, 45, 46, 47, 48, 49),90000)))
  }

  "the department's age range" should "employee numbers" in {
    assert(EmployeeUtils.countForEmployeeOfAgeRange(data.toList) == Map("法务部" -> List((Vector(30, 31, 32, 33, 34, 35, 36, 37, 38, 39),1)), "组织部" -> List((Vector(30, 31, 32, 33, 34, 35, 36, 37, 38, 39),2)), "人力资源" -> List((Vector(20, 21, 22, 23, 24, 25, 26, 27, 28, 29),4), (Vector(30, 31, 32, 33, 34, 35, 36, 37, 38, 39),4)), "市场部" -> List((Vector(30, 31, 32, 33, 34, 35, 36, 37, 38, 39),4)), "财务部" -> List((Vector(30, 31, 32, 33, 34, 35, 36, 37, 38, 39),1)), "技术部" -> List((Vector(30, 31, 32, 33, 34, 35, 36, 37, 38, 39),14), (Vector(40, 41, 42, 43, 44, 45, 46, 47, 48, 49),1)), "销售部" -> List((Vector(30, 31, 32, 33, 34, 35, 36, 37, 38, 39),2))))
  }
}