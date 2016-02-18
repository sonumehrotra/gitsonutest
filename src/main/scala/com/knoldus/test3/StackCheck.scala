package com.knoldus.test3

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Stack}

class StackCheck {

  def stackOperations(str: String): Int = {

    val stack: Stack[Char] = Stack()
    val list: ListBuffer[Char] = ListBuffer()
    for (i <- 0 to str.length - 1) {
      if (str.charAt(i) == '(') {
        stack.push(str.charAt(i))
      }
      if (str.charAt(i).isDigit) {
        list append (str.charAt(i))
      }
      if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
        stack.push(str.charAt(i))
      }
      if (str.charAt(i) == ')') {
        while (stack.nonEmpty && (stack.top != '(')) {
          list append stack.pop
        }
        stack.pop()
      }
    }
    while (stack.nonEmpty) {
      list append stack.pop() // final infix notation
    }
    def doCalculation(list:ListBuffer[Char]):Int={
      val digitStack:Stack[Int]=Stack()
      val operatorStack:Stack[Char]=Stack()
      for(i <- 0 to list.length-1){
        if(list(i).isDigit){
          digitStack.push(list(i).getNumericValue)
        }
        if(list(i)=='+' || list(i)=='-' || list(i)=='*' || list(i)=='/' ){
          operatorStack.push(list(i))
        }
      }

      val finalOperatorStack:mutable.Stack[Char]= operatorStack.reverse
      while(digitStack.nonEmpty && finalOperatorStack.nonEmpty){

        val first=digitStack.pop()
        val second=digitStack.pop()
        val operator=finalOperatorStack.pop()

        def opCalc(first:Int,second:Int,operator:Char):Int={

          operator match {
            case '+' => first+second
            case '-' => first-second
            case '*' => first*second
            case '/' => first/second
          }
        }
        digitStack.push(opCalc(first,second,operator))
      }
      digitStack.pop()
    }
    doCalculation(list)
  }
}

object StackCheck extends App{
  val obj= new StackCheck
  println(obj.stackOperations("(1+(2+3*5))"))
}
