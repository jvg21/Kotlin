// 1. Crie uma função que receba um número inteiro e retorne verdadeiro se o número for par e falso caso contrário. 
fun verificaPar(number:Int):Boolean{
    return number % 2 == 0;
}

fun main() {
    val number = 6
    println(verificaPar(number))
}
