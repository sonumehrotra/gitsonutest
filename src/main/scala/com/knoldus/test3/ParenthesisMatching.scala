package com.knoldus.test3

import scala.collection.mutable
import scala.collection.mutable._

/**
  * Created by knoldus on 17/2/16.
  */
class ParenthesisMatching {
def matchParenthesis(input:String):Boolean={
  val openStack:Stack[Char]=Stack()
  for(i <- 0 to input.length-1) {
    if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(') {
      openStack.push(input.charAt(i))
    }
      if (input.charAt(i) == '}' || input.charAt(i) == ']' || input.charAt(i) == ')') {
        if(openStack.nonEmpty){
        val topParen = openStack.top
        //println(topParen)
        if (topParen == '{') {
          openStack.pop()
        }
      }
        else openStack.push(input.charAt(i))
    }

  }
  println(openStack)
  if(openStack.isEmpty) true
  else false
}
}

object ParenthesisMatching extends App{
  val obj= new ParenthesisMatching
  println(obj.matchParenthesis("}"))
}
