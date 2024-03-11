// 7. Crie uma função que receba uma lista de strings e retorne a string mais longa da lista. 

fun maiorString(lista:List<String>):String?{
    if (lista.isEmpty()) return null
    
    var Maior = lista[0];
    for(string in lista){
        if(string.length> Maior.length){
            Maior = string
        }
    }
    return Maior;
}
fun main() {
	
    val listaDeStrings = listOf("gato", "cachorro", "elefante", "pássaro", "hipopótamo")
    val maisLonga = maiorString(listaDeStrings)
    println("A string mais longa na lista é: $maisLonga")

}
