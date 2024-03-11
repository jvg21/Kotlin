//14. Crie uma função de extensão chamada isPalindromo para a classe String que verifica se a string é um palíndromo. A função deve ignorar espaços em branco e ser case-insensitive (não distinguir maiúsculas de minúsculas). Em seguida, use essa função para verificar se algumas palavras são palíndromos.

fun String.isPalindromo(): Boolean {
    val textoLimpo = this.toLowerCase().replace("\\s".toRegex(), "")
    return textoLimpo == textoLimpo.reversed()
}

fun main() {
    val palavra1 = "socorram me subi no onibus em marrocos"
    val palavra2 = "arara"
    val palavra3 = "cachorro"

    println(" ${palavra1.isPalindromo()}")
    println(" ${palavra2.isPalindromo()}")
    println(" ${palavra3.isPalindromo()}")

}
