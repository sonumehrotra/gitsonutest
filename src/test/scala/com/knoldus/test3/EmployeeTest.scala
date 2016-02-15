package com.knoldus.test3

import org.scalatest.FunSuite

/**
  * Created by knoldus on 15/2/16.
  */
class EmployeeTest extends FunSuite{

  val emp =  Employee(5,"Sonu",1000)
  val emp2= Employee(3,"Kunal",2000)
  val emp3= Employee(2,"Rishabh",2000)
  val emp4= Employee(7,"Deepti",2000)

  test("This is to test proper sorting"){

    val list=List(emp, emp2)
    val result= list.sorted.map(_.id)
    val finalResult= List(3,5)
    assert(result===finalResult)
  }

  test("This is to test for 4 employees"){

    val list=List(emp, emp2, emp3, emp4)
    val result= list.sorted.map(_.id)
    val finalResult= List(2,3,5,7)
    assert(result===finalResult)
  }

}
