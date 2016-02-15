package com.knoldus.test3
import scala.collection.mutable.Stack
import scala.collection.mutable.ListBuffer


/**
  * Created by knoldus on 15/2/16.
  */
class BodmasString {

  def inString(str: String): ListBuffer[Char] = {

    var stack: Stack[Char] = Stack()
    println(stack)
    var list: ListBuffer[Char] = ListBuffer()
    val len = str.length
    for(i <- 0 to len-1)
    {
      if(str.charAt(i).isDigit ){
        list ++= ListBuffer(str.charAt(i))
        println(list)
      }
      if(str.charAt(i)=="("){
        stack=stack.push(str.charAt(i))
      println(stack)
      }
      if(str.charAt(i)==")"){
        while(!stack.isEmpty && stack.top!="("){
          list ++= ListBuffer(stack.pop)
          println(list)
        }
        stack.pop
      }
      if(str.charAt(i)=="+" || str.charAt(i)=="-" || str.charAt(i)=="/" || str.charAt(i)=="*" ){
        if(stack.isEmpty || stack.top == "("){
          stack=stack.push(str.charAt(i))
        }
        else while(!stack.isEmpty && stack.top != "(" && (str.charAt(i) < stack.top)){
          list ++= ListBuffer(stack.pop)
        }
        stack=stack.push(str.charAt(i))
      }

    }
    while(!stack.isEmpty){
      list ++= ListBuffer(stack.pop())
    }
    list
  }
}

object BodmasString extends App{
  val obj= new BodmasString
  println(obj.inString("(2+(4*5))"))
}
