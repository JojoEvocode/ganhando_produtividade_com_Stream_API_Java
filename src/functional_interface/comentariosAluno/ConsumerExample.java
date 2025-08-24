package functional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 Representa uma operação que aceita um argumento do tipo T e não retorna nenhum resultado. É utilizada principalmente para realizar ações, ou efeitos colaterais nos elementos do Stream sem modificar, ou retornar um valor.
 */
public class ConsumerExample {
  public static void main(String[] args) {
    // Criar uma lista de números inteiros
    // o método "Arrays.asList" é diferente do "ArrayList"
    // o método "ArrayList" é da coleção List, e cria uma lista de
    // tamanho variável e dinâmico, permitindo adicionar e
    // remover itens. Já o "Arrays.asList" funciona como um espelho
    // do array original informado, as mudanças em um refletem no outro,
    // o tamanho dele também é fixo, não pode adicionar nem remover
    // itens, apenas alterá-los
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

    // Usar o Consumer com expressão lambda para imprimir números pares:
    // A interface "Consumer" recebe um argumento de tipo T, no caso aqui
    // do tipo "Integer", uma variável chamada "imprimirNumeroPar"
    // do tipo Consumer é criada
    // a expressão Lambda é formada por "argumento -> corpo", o argumento
    // na expressão desse consumer é o "numero" que representa cada elemento
    // do stream. O corpo é o bloco de códigos entre chaves
    // onde é feito um teste if para saber se o número é par
    // e caso seja, imprime o valor do elemento
    Consumer<Integer> imprimirNumeroPar = numero -> {
      if (numero % 2 == 0) {
        System.out.println(numero);
      }
    };

    // Usar o Consumer para imprimir números pares no Stream:
    // o método ".stream" transforma a lista "numeros" em um stream
    // com o consumer configurado acima é possível usar ele nesse stream
    // o método ".forEach" recebe o "Consumer" e realiza a sua ação em
    // cada elemento do stream informado
    // ao inserir a variável consumer "imprimirNumeroPar", o "numero"
    // dentro da expressão Lambda é lido como cada elemento do stream "numeros"
    numeros.stream().forEach(imprimirNumeroPar);

    // é possível implementar o Consumer diretamente no ".forEach"
    // mas para isso, é necessário fornecer a implementação do método abstrato
    // accept,
    // uma vez que Consumer é uma interface funcional
    // dentro do método abstrato de Consumer (public void accept)
    // devemos passar o parâmetro que terá o mesmo tipo do Stream (Integer)
    // e o usá-lo no corpo do código com as intruções desejadas
    numeros.stream().forEach(new Consumer<Integer>() {

      @Override
      public void accept(Integer n) {
        if (n % 2 == 0) {
          System.out.println(n);
        }
      }
    });

    // outra forma é usando a expressão lambda do Consumer
    // compilador sabe que ".forEach" espera um Consumer<T>
    // como Consumer<T> só tem um método abstrato (accept)
    // ele entende que o lambda (n) é a implementação desse método.
    numeros.stream().forEach(n -> {
      if (n % 2 == 0) {
        System.out.println(n);
      }
    });

    // outra forma de fazer, usando o método .filter que filtra
    // os elementos de uma stream correspondentes ao especificado
    // o método ".forEach" realiza uma ação para cada elemento do stream
    // o method reference "System.out::println" chama o método "println"
    // da classe "System.out"
    numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
  }
}
