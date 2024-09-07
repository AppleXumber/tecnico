package org.example

fun main(){
  val valorAlvo = 2 //insira o valor desejado aqui
  val lista = fibonacci(valorAlvo)
  val estaNaLista = lista.contains(valorAlvo)
  println("O numero $valorAlvo pertence a sequencia fibonacci?: $estaNaLista")

}

fun fibonacci(valorAlvo:Int): MutableList<Int> {
  var lista = mutableListOf<Int>()
  var soma = 0
  var a = 1
  var b = 0
  for(i in 1..valorAlvo) {
    if(soma > valorAlvo) {
      break
    }
    soma = a + b
    b = a
    a = soma
    lista.add(soma)
  }
  return lista
}