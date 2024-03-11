// 6. Crie uma classe "ContaBancaria" com os atributos "saldo" e "limite". Adicione um método chamado "saque" que recebe um valor como parâmetro e subtrai do saldo da conta. Se o valor do saque for maior que o saldo da conta, o método deve lançar uma exceção com a mensagem "Saldo insuficiente". 

class ContaBancaria(var saldo:Double, var limite:Double){
    
    fun saque(valor:Double){
        if (valor > saldo + limite) {
            throw IllegalArgumentException("Saldo insuficiente")
        } else {
            saldo -= valor
        }
    }
}
fun main() {
	val ContaBancaria = ContaBancaria(1000.0,1000.0)
    println(ContaBancaria.saldo)
 	try{
        ContaBancaria.saque(200.0);
        println(ContaBancaria.saldo)
    }catch(e: IllegalArgumentException){
        println(e)
    }
}
