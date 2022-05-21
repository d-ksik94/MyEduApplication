package com.ksik.myeduapplication.codeedu

fun main(){
//    TestClass("ksik")

//    val cl = TestClass2("ksik")
//    cl.testFun()
//    TestClass3("ksik",29).testFun()
//    val test = TestClass5(TestClass4(),TestClass4("ksik"), TestClass4("k_sik"))
//    test.showNames()
//    TestClass6("ksik",29)
    Person("H","ksik",29)
}
class TestClass(name : String){
    val mName = name
    init {
//        if(mName=="ksik") return
    }
}
class TestClass2(name : String){
    val mName = name //OK
    init {
        println("name : $name") // OK
    }

    fun testFun(){
//        println("name2 : $name") // error Unresolved reference: name
    }

}

class TestClass3(val name: String , var age:Int){
    init {
        println("$name // $age") //OK 생성자 파라미터를 가르킨다.
}
    fun testFun(){
        println("$name // $age")//OK 초기화된 프로퍼티를 가르킨다.
    }
}
class TestClass4(val name:String = "d.ksik")
class TestClass5(private vararg val persons:TestClass4){
    fun showNames(){
        for (person in persons) println("이름 ${person.name}")
    }
}

class TestClass6{
    constructor(name : String, age : Int){
        println("name : $name , age : $age")
    }
    constructor(name : String){
        println("name : $name")
    }
}

class Person{
    val fullName : String
    val age : Int
    constructor(firstName:String , lastName : String,age: Int):
            this("$firstName $lastName",age)
    constructor(fullName:String,age: Int){
        this.fullName = fullName
        this.age = age
        println("name : $fullName , age : $age")
    }

}
class Person2(val fullName: String,val age: Int){
    constructor(firstName:String , lastName : String,age: Int):
            this("$firstName $lastName",age)
}