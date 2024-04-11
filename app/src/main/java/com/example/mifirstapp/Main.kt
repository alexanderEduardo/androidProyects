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

sealed class Errors( var isSelected: Boolean = true){
    object Geneneric: Errors()
    //data class genera equals, hashcode, toString
    data class Internal(val msg: String): Errors()

}

fun main(args: Array<String>) {
    val genericError = Errors.Geneneric
    genericError.isSelected= false
    val genericError2 = Errors.Geneneric
    println("genericError.isSelected ${genericError.isSelected}")
    println("genericError2.isSelected ${genericError2.isSelected}")
    println(genericError === genericError2)

    val internal1 = Errors.Internal("error 500")
    internal1.isSelected = false
    println("internal1.hashCode() ${internal1.hashCode()}")
    val internal2 = Errors.Internal("error 500")
    println("internal2.hashCode() ${internal2.hashCode()}")
    println("internal1.isSelected ${internal1.isSelected}")
    println("internal2.isSelected ${internal2.isSelected}")
    println(internal1 === internal2)
    val listErr = mutableListOf(
        genericError,internal1,internal2
    )
    println(listErr)
    listErr.removeAt(1)
    println(listErr)
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