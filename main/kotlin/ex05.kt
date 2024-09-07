package org.example

// Escreva um programa que inverta os caracteres de um string.
// IMPORTANTE: a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser
// previamente definida no código; b) Evite usar funções prontas, como, por exemplo, reverse;

fun main() {
  val stringPadrao = "Uma String aqui"
  var stringInvertida = ""

  for (i in stringPadrao.length-1 downTo 0 ) {
    stringInvertida += stringPadrao[i]
  }

  println(stringInvertida)
}