/*
 Autor: Jefferson Martins
 Data : 29/07/2021
 Descrição: Exercício Final - Introdução ao Kotlin
            Com os conhecimentos aplicados anteriormente,
            vamos criar uma calculadora que dado dois valores
            Float? e  um número correspondente a operação (Constante),
            retorne e imprima seu resultado como Float ou uma mensagem de 
            erro caso um dos valores um dos valores seja nulo.
 

*/
const val OPERACAO_SOMA = 1
const val OPERACAO_SUBTRACAO = 2
const val OPERACAO_MULTIPLICACAO = 3
const val OPERACAO_DIVISAO = 4

fun main(args: Array<String>) {
    
    montaMenu()
    
    val operacao = readLine()
    val op = operacao?.toIntOrNull()
    
    if (op != null && op in 1..4)  {
        processaOperacao(op)
    } else {
        println("OPERAÇÃO INVÁLIDA")
    }
    
	
}

/*
  Monta menu que será exibido ao usuário
*/
fun montaMenu() {
    println("***** CALC *****")
    println("DIGETE A OPÇÃO DESEJADA: ")
    println("${OPERACAO_SOMA} - SOMA")
    println("${OPERACAO_SUBTRACAO} - SUBTRAÇÃO")
    println("${OPERACAO_MULTIPLICACAO} - MULTIPLICAÇÃO")
    println("${OPERACAO_DIVISAO} - DIVISÃO")
    
}

/*
    Processa a opção digitada pelo usuário
*/
fun processaOperacao(operacao : Int) {
    
    // Faz a leitura dos números para realizar a operação
    val numero1 = lerNumero("DIGITE O PRIMEIRO NÚMERO: ")
    val numero2 = lerNumero("DIGITE O SEGUNDO NÚMERO: ")
    
    // Fluxo para executar a operação escolhida
    when (operacao) {
    	    OPERACAO_SOMA -> println(soma(numero1, numero2))
    	    OPERACAO_SUBTRACAO -> println(subtracao(numero1, numero2))
    	    OPERACAO_MULTIPLICACAO -> println(multiplicacao(numero1, numero2))
    	    OPERACAO_DIVISAO -> println(divisao(numero1, numero2))
    	    else -> {
    	        println("OPERAÇÃO INVÁLIDA")
    	    }
    	}
}

// Retorna a soma de 2 números
fun soma(numero1 : Float, numero2 : Float) : Float = numero1.plus(numero2)

// Retorna a divisão de 2 números
fun subtracao(numero1 : Float, numero2 : Float)  : Float = numero1.minus(numero2)

// Retorna a subtração de 2 números
fun multiplicacao(numero1 : Float, numero2 : Float)  : Float = numero1.times(numero2)

// Retorna a divisão de 2 números
fun divisao(numero1 : Float, numero2 : Float) : Float = numero1.div(numero2)

// Realiza a leitura dos números para a operação
fun lerNumero(texto : String) : Float {
    println(texto)
    
    // Leitura
    val inputNumero = (readLine() ?: "")
    val r = inputNumero.toFloatOrNull()
    
    // Valor válido retorna o que foi digitado
    if (r != null) return r
    
    // Quando um valor inválido é digitado informa o usuário "VALOR INVÁLIDO" e 
    // tenta ler o número novamente
    println("VALOR INVÁLIDO")
    lerNumero(texto)
    
    return 0.toFloat()
}