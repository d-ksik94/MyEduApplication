package com.ksik.myeduapplication.codeedu

fun main(){
//    firstName = "ksik"
//    lastName = "d_ksik"
//    println("firstName : ${firstName?.length}")
//    println("lastName : ${lastName.length}")
//    val pt = PropertyTest()
//    println(pt.name)
//    println(pt.age)
//    val pt2 = PropertyTest2()
//    println(pt2.name)
//    pt2.name = "d.ksik"
//    println(pt2.name)
//    val pt3 = PropertyTest3()
//    pt3.name = "d.ksik" //error :: cannot assign to name the setter is private
//    pt3.nameSet("d.ksik")
//    println(pt3.name)
//    lateinitTest()
    lazyTest()
}
var firstName:String?=null
lateinit var lastName:String

class PropertyTest(){
    val name : String = "ksik"
    get(){
        println("backing field")
        return field
    }
    val age : Int // 뒷받침하는 필드가 없기때문에 클래스 인스턴스에서 전혀 메모리를 차지하지 않는다.
    get() = 2+4
}

class PropertyTest2(){
    var name :String =""
    set(value) {
        println("name set")
        field = value
    }
}

class PropertyTest3(){
    var name :String = ""
    private set(value) {
        field=value
    }
    fun nameSet(name : String){
        this.name = name
    }

    val age : Int = 0
    get
}
lateinit var text : String
fun lateinitTest(){
    text = "hello"
    println(text)
    text = "bye"
    println(text)
}


lateinit var text1 : String
val text2 : String
get(){
    println("text2 get()")
    return "ksik"
}
fun getName():Int {
    println("getName()")
    return 2+4
}
fun lazyTest(){
    val text3 by lazy {
        println("lazy")
        getName()
    }
text1 = "han" // 사용하기 전에 초기화가 이루어져야 한다.
println(text1)
println(text2) // 사용 할 때마다 get() 함수의 계산이 이루어진다.
println(text2) // 사용 할 때마다 get() 함수의 계산이 이루어진다.
println(text3) // 사용하는 시점에 프로퍼티 초기화가 이루어진다.
}