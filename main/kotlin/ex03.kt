package org.example

// Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem
// que desejar, que calcule e retorne:
// • O menor valor de faturamento ocorrido em um dia do mês;
// • O maior valor de faturamento ocorrido em um dia do mês;
// • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
// IMPORTANTE:
// a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
// b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser
// ignorados no cálculo da média;

import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import java.io.FileReader

fun main() {
  val listaDias = consomeJson().filter { it.valor > 0 }
  val maiorFaturamento = listaDias.maxBy { it.valor }
  val menorFaturamento = listaDias.minBy { it.valor }

  val faturamentoMedio = listaDias.map { it.valor }.average()
  val listaDiasFaturamentoMaiorMedia = listaDias.filter { it.valor > faturamentoMedio }

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