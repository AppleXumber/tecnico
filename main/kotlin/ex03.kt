package org.example

import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import java.io.FileReader

fun main() {
  val listaDias = consomeJson().filter{it.valor > 0}
  val maiorFaturamento = listaDias.maxBy{it.valor}
  val menorFaturamento = listaDias.minBy{it.valor}

  val faturamentoMedio = listaDias.map{it.valor}.average()
  val listaDiasFaturamentoMaiorMedia = listaDias.filter{it.valor > faturamentoMedio}

  println("Dia de maior faturamento: ${maiorFaturamento.dia} com o valor de ${maiorFaturamento.valor}")
  println("Dia de menor faturamento: ${menorFaturamento.dia} com o valor de ${menorFaturamento.valor}")
  println("Quantidade de dias com o faturamento acima da média: ${listaDiasFaturamentoMaiorMedia.size}")
}

fun consomeJson(): MutableList<DiaValor> {
  val gson = Gson()
  val reader = FileReader("src/main/kotlin/dados.json")
  val type = object : TypeToken<MutableList<DiaValor>>() {}.type
  return gson.fromJson(reader, type)
}

data class DiaValor(val dia: Int, val valor: Double)