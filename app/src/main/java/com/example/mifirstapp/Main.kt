package com.example.mifirstapp

import android.widget.ListAdapter
import java.lang.Error

class Main {

}

interface Sound {
    fun makeSound()
}

class Dog : Sound {
    override fun makeSound() {
        println("Woof")
    }
}

class Robot(private val sound: Sound) : Sound by sound {
    // Aquí se delega la implementación de makeSound a la instancia de Sound
    /*override fun makeSound(){
        println("Bip Bip")
    }*/
}

fun main(args: Array<String>) {
    println(args.contentToString())
    println(variables())
    println(whenCondicion("86".toInt()))
    val t1:Long = 222
    println(getType(t1))
    test()
    val robot = Robot(Dog())
    robot.makeSound()
}

fun variables():Int{
    val a: Int = 1  // immediate assignment
    val b = 2   // `Int` type is inferred
    val c: Int  // Type required when no initializer is provided
    c = 3       // deferred assignment
    return a+b+c;
}

fun whenCondicion(month: Int):Any{
    var res = when(month){
        in 1..6->"Primer Semestre"
        in 7..12->"Segundo Semestre"
        else -> "error"
    }
    return res
}

fun getType(variable: Any):Any{
    return when(variable){
        is Boolean -> "is Boolean"
        is String -> return "is String"
        is Int -> {
            println("innesary logic");
            return "is Integer"
        }
        is Long -> "is Long"
        is Double -> "is Double"
        is Float -> "is Float"
        is Char -> "is Char"
        else -> "is unknown"
    }
}

fun test(){
    val list: List<String> = arrayListOf("Lunes","Martes","Miercoles");
    val list2: MutableList<String> = arrayListOf("dolar","sol","peso");
    println(list)
    println(list2)
}