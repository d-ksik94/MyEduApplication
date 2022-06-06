package com.ksik.myeduapplication.codeedu
//고차함수
/*fun main(){
    println(sum(intArrayOf(4,5,6)))
    println(max(intArrayOf(4,5,6)))
}
fun aggregate(numbers : IntArray,op : (Int,Int)->Int):Int{
    var result = numbers.firstOrNull()?:throw IllegalArgumentException("Empty array")

    for (i in 1..numbers.lastIndex){
        result = op(result,numbers[i])
    }
    return result
}
fun sum(numbers: IntArray) = aggregate(numbers) { result, op -> result + op }
fun max(numbers: IntArray) = aggregate(numbers){result,op -> if(op>result) op else result}*/


//함수타입 - SAM 인터페이스
/*fun main(){
    val consume = StringConsumer { s-> println(s) }
    consume.accept("ksik")
//함수가 인자를 하나만 받거나 전혀 받지 않는 경우에도 괄호를 꼭 쳐야한다.
    val inc : (Int)->Int = {n -> n+1}
    //함수값은 변수에 저장할 수도 있다.
//    val less :(Int,Int) -> Boolean = {a,b->a<b}
//    println(less(1,2))

    //변수 타입을 생략하면 컴파일러가 람다의 타입을 추론할 수 없다.
//    val less  = {a,b->a<b} // ERROR
    //이럴땐 파라미터에 타입을 명시하면 된다
    val less  = {a:Int,b:Int->a<b}
}
fun interface StringConsumer{
    fun accept(s:String)
}*/


//함수타입 - 내포된 고차함수
fun main(){
    val shifter : (Int)->(Int)->Int = {n->{i->i+n}}
    val inc = shifter(1)
    val dec = shifter(-1)
    println("inc : ${inc(10)} , dec : ${dec(10)}")
}


//함수타입 - 널이될수있는타입
/*
fun main(){
    println(time(null))
    println(time2(null)) // ERROR :: null can not be a value of a non-null type()
}
//action :(()->Unit)? 과 action:()->Unit? 은 물음표의 효과가 완전히 달라진다
fun time(action :(()->Unit)?):Long{
    val start = System.nanoTime()
    action?.invoke()
    return System.nanoTime()-start
}
fun time2(action:()->Unit?):Long{
    val start = System.nanoTime()
    action?.invoke()
    return System.nanoTime()-start
}*/
