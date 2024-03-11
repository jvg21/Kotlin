// 12. Utilize um mapa para representar um dicionário de palavras e suas traduções.

fun main() {
    // Criando um mapa para representar um dicionário de palavras e suas traduções
    val dicionario = mapOf(
        "hello" to "olá",
        "apple" to "maçã",
        "dog" to "cão",
        "cat" to "gato",
        "house" to "casa"
    )

    // Exibindo algumas traduções
    println("Tradução de 'hello': ${dicionario["hello"]}")
    println("Tradução de 'dog': ${dicionario["dog"]}")
    println("Tradução de 'house': ${dicionario["house"]}")
}
