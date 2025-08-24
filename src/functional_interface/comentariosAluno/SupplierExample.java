package functional_interface.examples;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 Representa uma operação que não aceita nenhum argumento e retorna um resultado do tipo T.
 É comumente usada para criar ou fornecer novos objetos de um determinado tipo.
 */
public class SupplierExample {
  public static void main(String[] args) {
    // Usar o Supplier com expressão lambda para fornecer uma saudação
    // personalizada:
    // a variável "saudacao" do tipo Supplier foi criada, e retorna uma String
    // por ser Supplier, não aceita argumentos, por isso os parênteses vazios
    // o retorno é a String no corpo do Lambda
    // Não existe classe anônima explícita aqui. O que acontece
    // é que o lambda substitui a escrita da classe anônima que seria feito
    // com "new Supplier<String>() { }"
    Supplier<String> saudacao = () -> "Olá, seja bem-vindo(a)!";

    // Usar o Supplier para obter uma lista com 5 saudações:
    // o método ".generate" de Stream recebe um Supplier (saudacao)
    // o método ".limit" determina o limite máximo
    // como o objetivo é gerar uma lista, o método ".collect" que
    // recebe um coletor (Collectors), que tem o método ".toList"
    // que irá transformar numa lista
    // é possível encurtar o código, retirando o collect e Collectors
    // e deixando apenas o ".toList();"

    // O Collectors.toList() é uma implementação pronta de Collector
    // que é um objeto usado para transformar (reduzir) o stream em uma
    // coleção. No caso, ele coleta todos os elementos do stream e
    // os coloca numa lista.
    List<String> listaSaudacoes5 = Stream.generate(saudacao)
        .limit(5)
        .collect(Collectors.toList());

    // similarmente ao Consumer, o Supplier pode ser implementado
    // diretamente no ".generate", sende necessário sobrescrever
    // o seu método abstrato "get()" que não recebe nenhum parâmetro
    List<String> listaSaudacoes2 = Stream.generate(
        new Supplier<String>() {

          @Override
          public String get() {
            return "Olá, seja bem-vindo(a)!";
          }
        })
        .limit(2)
        .collect(Collectors.toList());

    // alterando para uso com Expressão lambda, como o supplier não
    // aceita argumentos, o argumento da expressão lambda são os
    // parênteses vazios "()"
    List<String> listaSaudacoes3 = Stream.generate(() -> "Olá, seja bem-vindo(a)!")
        .limit(3)
        .collect(Collectors.toList());

    // Imprimir as saudações geradas usando Expressão Lambda
    listaSaudacoes5.forEach(s -> System.out.println(s));
    listaSaudacoes2.forEach(s -> System.out.println(s));
    listaSaudacoes3.forEach(s -> System.out.println(s));

    // Imprimir as saudações geradas usando Method Reference
    listaSaudacoes5.forEach(System.out::println);
    listaSaudacoes2.forEach(System.out::println);
    listaSaudacoes3.forEach(System.out::println);
  }
}
