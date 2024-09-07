package org.example

// Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
// • SP – R$67.836,43 • RJ – R$36.678,66 • MG – R$29.229,88 • ES – R$27.165,48 • Outros – R$19.849,53
// Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve
// dentro do valor total mensal da distribuidora

fun main() {
  val valorSp = Estado(67836.43, "Sp")
  val valorRj = Estado(36678.66, "Rj")
  val valorMg = Estado(29229.88, "Mg")
  val valorEs = Estado(27165.48, "Es")
  val valorOutros = Estado(19849.53, "Outros")

  val total = valorSp.valor + valorRj.valor + valorMg.valor + valorEs.valor + valorOutros.valor

  valorSp.getPercentagem(total)
  valorRj.getPercentagem(total)
  valorMg.getPercentagem(total)
  valorEs.getPercentagem(total)
  valorOutros.getPercentagem(total)
}

class Estado(var valor: Double, var nome:String) {
  fun getPercentagem(total:Double) {
    println(String.format("O estado $nome possui %.1f%% do faturamento mensal da distribuidora", valor/total*100))
  }
}