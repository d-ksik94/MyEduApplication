package com.ksik.myeduapplication.codeedu

import com.ksik.myeduapplication.codeedu.ObjectTest.exit

//import com.ksik.myeduapplication.codeedu.ObjectTest.*//cannot import-on-demand from object
fun main(){
//    println(ObjectTest.name)
//    println(ObjectTest)
//    exit()
//    val args = Array<String>(1){"ksik"}
//    //직접 생성자를 호출 할 수 없다.
////    val app = ObjectTest2(name)// error :: cannot access init it is private
//    val app = ObjectTest2.create(args) // 차이

//    val o = object{
//        val x = readLine()!!.toInt()
//        val y = readLine()!!.toInt()
//    }
//    println(o.x+o.y)

//    val t = test(1..5,6..10)
//    println(t.x+t.y) // error :: unresolved reference
}
object ObjectTest{
    val name ="ksik"
    override fun toString() = name

    fun exit(){}
}

class ObjectTest2 private constructor(val name : String){
    companion object Factory{ // 차이
        fun create(args : Array<String>) : ObjectTest2?{
            val name = args.firstOrNull()?:return null
            return ObjectTest2(name)
        }
    }
}
fun test(a:IntRange , b : IntRange) = object {
    val x = a.first
    val y = b.first
}
