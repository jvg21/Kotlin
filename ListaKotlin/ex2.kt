// 2. Crie uma função que receba um array de inteiros e retorne o maior número. 
fun retornaMaior(numberArray:Array<Int>):Int{
    var maior = numberArray[0];
    
    for(number in numberArray){
		if(number > maior)maior = number
    }
    return maior
}

fun main() {
    val numberArray = arrayOf(6,5,6,8,4,2,25,10,25)
    println(retornaMaior(numberArray))
}
