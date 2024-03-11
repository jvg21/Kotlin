// 11. Crie uma função que receba uma lista de strings e retorne uma lista com todas as strings que começam com a letra "A", em ordem alfabética.

fun stringsComLetraA(lista: List<String>): List<String> {
    val stringsComA = lista.filter { it.startsWith("A", ignoreCase = true) }
    return stringsComA.sorted()
}

fun main() {
    val listaDeStrings = listOf("Abacaxi", "Maçã", "Amora", "Banana", "laranja", "Abóbora")

    val stringsComAOrdenadas = stringsComLetraA(listaDeStrings)

    println("Strings que começam com a letra 'A' em ordem alfabética:")
    stringsComAOrdenadas.forEach { println(it) }
}
