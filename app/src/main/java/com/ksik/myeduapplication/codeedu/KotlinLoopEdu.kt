package com.ksik.myeduapplication.codeedu

import kotlin.random.Random

fun main(){
//    doWhileEdu()
//    whileEdu()
//    whileEdu2()
//    println(forSimpleEdu("1000"))
//    forSimpleEdu2()
//    forSimpleEdu3()
//    controlLoop()
}
fun doWhileEdu(){ // num이 0이 아니면 반복해서 실행한다.
    var sum =0
    var num :Int
    do {
        num = readLine()!!.toInt()
        sum +=num
    }while (num!=0)
println("Sum : $sum")
}
fun whileEdu(){
    val num = Random.nextInt(1,101) // 1부터 100까지의 랜덤 수를 생성한다.
    var readNum =0
    while(num != readNum){
        readNum = readLine()!!.toInt()
        when(readNum>num){
            true -> println("big")
            else -> println("small")
        }
    }
    println("num : $num")
}
fun whileEdu2(){
    val num = Random.nextInt(1,101) // 1부터 100까지의 랜덤 수를 생성한다.
    loop@while(true){
        val readNum = readLine()!!.toInt()
        val msg = when{
            readNum>num -> "big"
            readNum<num -> "small"
            else -> break@loop
        }
        println("msg : $msg")
    }
}

fun forSimpleEdu(s:String , failback : Int = -1) : Int{
    var num = 0
    if(s.length !in  1..31) return failback

    for(c in s){
        if (c !in '0'..'1') return failback
        num = num*2 + (c-'0')
    }
    return num
}
fun forSimpleEdu2(){
    val a = IntArray(10){it*it}

    for(n in 0..a.lastIndex){
        if ((n%2)==0) println("짝수번째 ${a[n]} 입니다.")
    }
}
fun forSimpleEdu3(){
    val a = IntArray(20){it*it}
    for (n in a.indices step 2){
        println("짝수번째 ${a[n]} 입니다.")
    }
}

fun controlLoop(){
    val a = IntArray(10){it*it}
    val b = intArrayOf(1,2,3,4)
    outerLoop@ for (i in a.indices){
        println("a[i] : ${a[i]}")
        for (j in b.indices){
            if(b[j]==3) continue@outerLoop
        }
    }
}