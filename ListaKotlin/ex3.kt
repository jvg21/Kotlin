// 3. Crie uma classe chamada "Pessoa" com os atributos "nome" e "idade". Em seguida, crie uma lista de objetos "Pessoa" e ordene a lista em ordem alfabética pelo atributo "nome". 

class Pessoa(val nome:String,val idade:Int)

fun main() {
	val pessoas = listOf(
    	Pessoa("João",19),
        Pessoa("Bruno",20),
        Pessoa("Giovanni",19)
    )
    
    val pessoasOrdenadas = pessoas.sortedBy {it.nome}
    
    for (pessoa in pessoasOrdenadas) {
        println("Nome: ${pessoa.nome}, Idade: ${pessoa.idade}")
    }
}
