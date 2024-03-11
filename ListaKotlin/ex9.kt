// 9. Crie uma função que receba uma lista de números inteiros e retorne uma lista com os números em ordem crescente, sem usar o método de ordenação da linguagem.

fun ordenaLista(lista:List<Int>):List<Int>{
    val listaOrdenada = mutableListOf<Int>()

    for (numero in lista) {
        var inserido = false
        for (i in listaOrdenada.indices) {
            if (numero <= listaOrdenada[i]) {
                listaOrdenada.add(i, numero)
                inserido = true
                break
            }
        }
        if (!inserido) {
            listaOrdenada.add(numero)
        }
    }

    return listaOrdenada
}

fun main() {
    
    val listaDesordenada = listOf(3, 1, 5, 2, 4,4,5)
    val listaOrdenada = ordenaLista(listaDesordenada)
    
    println("Lista desordenada: $listaDesordenada")
    println("Lista ordenada: $listaOrdenada")


}
