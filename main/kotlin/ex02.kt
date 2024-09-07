package org.example

// Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2
// valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que
// desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o
// número informado pertence ou não a sequência.
// IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser
// previamente definido no código;

fun main() {
  val valorAlvo = 22 //insira o valor desejado aqui
  val lista = fibonacci(valorAlvo)
  val estaNaLista = lista.contains(valorAlvo)
  println("O numero $valorAlvo pertence a sequencia fibonacci?: $estaNaLista")

}

fun fibonacci(valorAlvo: Int): MutableList<Int> {
  val lista = mutableListOf<Int>()
  var soma = 0
  var a = 1
  var b = 0
  for (i in 1..valorAlvo) {
    if (soma > valorAlvo) {
      break
    }
    soma = a + b
    b = a
    a = soma
    lista.add(soma)
  }
  return lista
}