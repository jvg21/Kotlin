// 8. Crie uma classe "Funcionario" com os atributos "nome", "idade" e "salario". Crie uma função que receba uma lista de funcionários e retorne o funcionário com o maior salário. 

class Funcionario(var nome:String, var idade:Int,var salario:Double){}

fun FuncionarioMaisRico(ListaFuncionarios: List<Funcionario>):Funcionario?{
    if(ListaFuncionarios.isEmpty()){
        return null
    }
    
    var Func = ListaFuncionarios[0]
    for(funcionario in ListaFuncionarios){
        if(funcionario.salario > Func.salario){
			Func = funcionario
        }
    }
    return Func
}
fun main() {
    
     val funcionarios = listOf(
        Funcionario("João", 30, 2500.0),
        Funcionario("Maria", 35, 3000.0),
        Funcionario("Pedro", 28, 2800.0),
        Funcionario("Ana", 40, 3200.0)
    )
	
     val funcionarioMaiorSalario = FuncionarioMaisRico(funcionarios)
     
     if (funcionarioMaiorSalario != null) {
        println("O funcionário com o maior salário é: ${funcionarioMaiorSalario.nome}, com salário de ${funcionarioMaiorSalario.salario}")
    } else {
        println("Não há funcionários na lista.")
    }

}
