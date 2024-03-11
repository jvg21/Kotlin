// 10. Crie uma classe "Triangulo" com os atributos "base" e "altura". Adicione um método chamado "area" que calcula e retorna a área do triângulo.

class Triangulo(var altura:Double, var base:Double){
    fun area():Double{
		return (base*altura)/2
    }
}

fun main() {
    val triangulo = Triangulo(5.0,4.0);
    println(triangulo.area())
}
