
// 13. Crie uma função de ordem superior chamada operacaoMatematica que aceita dois números e uma função lambda. A função operacaoMatematica deve aplicar a função lambda aos dois números e retornar o resultado. Em seguida, crie algumas funções lambda para realizar operações matemáticas, como soma, subtração, multiplicação e divisão. Use a função de ordem superior para realizar essas operações com diferentes pares de números.

fun operacaoMatematica(a: Int, b: Int, operacao: (Int, Int) -> Int): Int {
    return operacao(a, b)
}

val soma: (Int, Int) -> Int = { a, b -> a + b }

val subtracao: (Int, Int) -> Int = { a, b -> a - b }

val multiplicacao: (Int, Int) -> Int = { a, b -> a * b }

val divisao: (Int, Int) -> Int = { a, b -> a / b }

fun main() {
    val numero1 = 100
    val numero2 = 50

    println("Soma: ${operacaoMatematica(numero1, numero2, soma)}")
    println("Subtração: ${operacaoMatematica(numero1, numero2, subtracao)}")
    println("Multiplicação: ${operacaoMatematica(numero1, numero2, multiplicacao)}")
    println("Divisão: ${operacaoMatematica(numero1, numero2, divisao)}")
}

