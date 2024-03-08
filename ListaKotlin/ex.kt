// 4. Crie uma função que receba uma string e retorne verdadeiro se a string for um palíndromo (ou seja, pode ser lida da mesma forma de trás para frente). 

fun testarPalindromo(string:String):Boolean{
    val string = string.toLowerCase()
    val len = string.length
    for (i in 0 .. len/2){
        if(string[i] != string[len - i - 1])return false;
    }
    return true
}
fun main() {
    val string = "Renner"
    println(testarPalindromo(string))

}
