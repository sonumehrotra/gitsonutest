package com.knoldus.test3

/**
  * Created by knoldus on 15/2/16.
  */
case class Employee(val id:Int, val name:String, val salary:Int) {
}

object Employee{

  implicit val check= new Ordering[Employee]{

    def compare(first:Employee,second:Employee)= implicitly[Ordering[Int]].compare(first.id,second.id)
  }
}