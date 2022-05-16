package com.ksik.myeduapplication.codeedu

fun main(){
//println(binIndexOf(3, intArrayOf(0,1,2,3,4,5,6)))
    println(tryCatchEdu("Ksik"))
}
tailrec fun binIndexOf(x:Int,array: IntArray,from:Int=0,to:Int=array.size):Int{
    if(from == to) return -1
    val midIndex = (from+to -1)/2
    val mid = array[midIndex]
    return when{
        mid<x -> binIndexOf(x,array,midIndex+1,to)
        mid>x -> binIndexOf(x,array,from,midIndex)
        else -> midIndex
    }
}

fun tryCatchEdu(defalt : String) = try {
    throw Exception()
    "try내부"
}catch (e: Exception){
    defalt
}finally {
    println("try-catch 종료")
}