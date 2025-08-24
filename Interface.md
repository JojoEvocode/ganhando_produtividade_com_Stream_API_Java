### Interfaces
As interfaces são um tipo especial em Java, elas se assemelham a Classes Abstratas porque podem declarar métodos sem corpo, mas não são classes. Elas funcionam como um **contrato**, pois elas definem o que uma Classe **deve fazer**, mas **não como** ela o faz.
**Por exemplo:**
```
interface Animal {
    void comer();
    void dormir();
}
```
A Interface `Animal` define dois **métodos abstratos**, ou seja, métodos sem corpo (implementação). Exatamente o que **deve** ser feito (comer e dormir), mas sem dizer **como** fazer (não há implementação).
As interfaces precisam ser **implementadas** por uma Classe para serem usadas. Uma mesma Classe pode implementar **múltilplas** interfaces. Quando uma Classe implementar a Interface, ela deverá obrigatoriamente implementar também os seus métodos.

### Classes Concretas
Classes concretas são as Classes comuns em Java. Elas podem **declarar atributos** e **implementar métodos com corpo**, e seus objetos podem ser **instanciados diretamente** (ou seja, podemos usar `new` para criar instâncias delas).
Elas implementam Interfaces, assim como os seus métodos definindo o corpo deles.
**Por exemplo:**
```
class Cachorro implements Animal {
    
    @Override
    public void comer() {
        System.out.println("Cachorro comendo.");
    }

    @Override
    public void dormir() {
        System.out.println("Cachorro dormindo.");
    }
}
```
A Classe `Cachorro` implementa a Interface `Animal`, e na sequência, implementa os seus métodos abstratos usando `@Override`. Agora os métodos têm **corpo** e fica definido **como** eles vão fazer suas ações. Isso poderá ser colocado em prática num programa.
**Por Exemplo:**
```
public class Main {
    
    public static void main(String[] args) {
        
        Animal rex = new Cachorro();
        rex.comer();
        rex.dormir();
    }
}
```
**Saída:** 
```
Cachorro comendo.
Cachorro dormindo.
```
Aqui um objeto da Classe `Cachorro` é criado com o nome `rex`. Ao chamar os métodos `comer()` e `dormir()`, o objeto executa o que foi definido na Classe `Cachorro`.

### Classes Abstratas
Classes Abstratas são Classes especiais que servem como **modelo** ou **base** para outras Classes no contexto de **herança**. Elas não podem ser instanciadas diretamente, mas podem declarar atributos. Seus métodos podem ter implementação (com corpo), mas se contiverem métodos abstratos (sem implementação), esses métodos devem ser implementados pelas Subclasses Concretas.
Elas implementam Interfaces, mas **não implementam seus métodos**, a implementação deles deve ser feita pelas Subclasses Concretas que herdam a Classe Abstrata.
**Por Exemplo:**
```
abstract class Pet implements Animal {    
    
    public void fome() {
        System.out.print("Seu pet precisa comer. ");
        comer();
    }

    public void sono() {
        System.out.print("Seu pet precisa dormir. ");
        dormir();
    }    
}
```
A Classe Asbtrata `Pet` implementa a Interface `Animal`, e na sequência, implementa os seus métodos `fome` e `sono`. Esses métodos chamam os métodos `comer` e `dormir` da Interface, mas **não são implementados**. Agora uma Subclasse Concreta poderá **herdar** a Classe Abstrata `Pet` e implementar os métodos da Interface.
**Por Exemplo:**
```
class Cachorro extends Pet {
    
    @Override
    public void comer() {
        System.out.println("Dando osso para o cachorrinho.");
    }

    @Override
    public void dormir() {
        System.out.println("Cachorro na casinha dormindo.");
    }
}
```
A Classe `Cachorro` aqui **herda**, pelo comando `extends`, a Classe Abstrata `Pet`. Nesse momento, os métodos da Interface são implementados. Agora Isso poderá ser colocado em prática num programa.
**Por Exemplo:**
```
public class Main {
    
    public static void main(String[] args) {
        
        Animal rex = new Cachorro();
        rex.fome();
        rex.sono();
    }
}
```
**Saída:** 
```
Seu pet precisa comer. Dando osso para o cachorrinho.
Seu pet precisa dormir. Cachorro na casinha dormindo.
```
### Classes Anônimas
A **Classe Anônima** é um tipo particular de Classe em Java. É uma Classe **sem nome**, e que é **declarada e instanciada em uma única expressão**. Ela serve para **implementações únicas e pontuais**, basicamente para três finalidades:
- Implementar Interfaces.
- Herdar Classes Abstratas.
- Sobrescrever métodos de Classes Concretas.
  
A Classe `Cachorro` apresentada anteriormente não é anônima: ela **tem nome** (Cachorro), e ela é declarada em um momento (onde os métodos e atributos são definidos) e instanciada em outro (onde seus objetos são criados.)
**Declaração:**
```
class Cachorro implements Animal {atributos e métodos}
```
**Instanciação:**
```
Animal rex = new Cachorro();
```

A Classe Anônima sempre partirá de um Elemento, Classe ou Interface, **já existente**, por isso não tem **"nome próprio"**, como a Classe `Cachorro`. Além disso, no momento é que ela é declarada, um objeto já é instaciado (criado). Além disso, a Classe Anônima sempre termina com **"};"** quando atribuída a uma variável.
**Declaração e Instanciação:**
```
NomeDoElemento obj = new NomeDoElemento() {
    
    @Override
    public void metodo() {       
    }
};
```

Ao usar a Classe Anônima ela deverá chamar o Elemento que ela se refere (seja Interface ou Classe) pelo nome. Na sequência deverá criar um objeto desse Elemento, e implmentar os seus métodos. Se criar novos métodos, eles **só serão acessíveis dentro da própria Classe Anônima**.

**Implementação de Interfaces:**
```
MinhaInterface obj = new MinhaInterface() {
    
    @Override
    public void metodo() {       
    }
};
```
Chama a Interface `MinhaInterface` e cria no ato um objeto `obj`. O métodos são implementados com o uso do `@Override`.

**Extensão de Classes Abstratas:**
```
MinhaClasseAbstrata obj = new MinhaClasseAbstrata() {
    
    @Override
    public void metodoClasseAbstrata() {
    }
    
    public void metodoCriado() {
    }
};
```
Chama a Classe Abstrata `MinhaClasseAbstrata` e cria no ato um objeto `obj`. O método `metodoClasseAbstrata` é implementado com o uso do `@Override`. Método `metodoCriado` é introduzido na Classe Anônima.
**Extensão de Classes Concretas:**
```
MinhaClasseConcreta obj = new MinhaClasseConcreta() {
    
    @Override
    public void metodoClasseConcreta() {    
    }

    public void metodoCriado() {
    }
};
```
Chama a Classe Concreta `MinhaClasseConcreta` e cria no ato um objeto `obj`. O método `metodoClasseConcreta` é sobrescrito com o uso do `@Override`. Método `metodoCriado` é introduzido na Classe Anônima.

A Classe Anônima **implementa a Interface Animal**.
**Por Exemplo:**
```
Animal a = new Animal() {
            
            @Override
            public void comer() {
                System.out.println("Animal está comendo agora...");
            }

            @Override
            public void dormir() {
                System.out.println("Animal está dormindo agora...");
            }
        };
```
A Classe Anônima não tem nome próprio, diferentemente da Classe `Cachorro`. Além disso, o objeto `a` é instanciado na hora em que Classe é declarada. Na sequência, os métodos da Interface são implementados. Agora, esse objeto pode utilizar os métodos implementados.
**Por Exemplo:**
```
public class Main {
    
    public static void main(String[] args) {
        
        Animal a = new Animal() {  
            ...
        };

        a.comer();
        a.dormir();
    }
}
```
**Saída:** 
```
Animal está comendo agora...
Animal está dormindo agora...
```
Como a Classe Anônima é para **implementações únicas**, os métodos que ela implementa devem estar no escopo de sua declaração. Para usar uma Classe Anônima dentro de um método, a **declaração precisa estar dentro do mesmo escopo**, por isso a declação da Classe Anônima está dentro da Classe Main. No exemplo, a implementação foi substituida pelas reticências para ganhar espaço.

### Interface Funcional
A **Interface Funcional** é um **contrato** tal qual a Interface Comum. Entretanto, ela possui apenas **um único método abstrato**.
**Por Exemplo:**
```
@FunctionalInterface
interface Operacao {
    int calcular(int a, int b);
}
```
A Interface `Operacao` é Funcional, nela consta apenas o método `calcular` que não tem corpo, por tanto, é abstrato. A Notação `@FunctionalInterface` não é obrigatória, mas **recomendada**, pois sinaliza claramente a intenção de usar a Interface como Funcional, o que permite ao compilador **verificar** se a interface realmente tem apenas um método abstrato, retornando um erro caso não haja.

### Interfaces Funcionais nas Classes Concretas
Como qualquer outra Interface, a Interface Funcional pode ser implementada numa Classe Concreta.
**Por Exemplo:**
```
class Soma implements Operacao {
    
    @Override
    public int calcular(int a, int b) {
        return a + b;
    }
}
```
A **Classe Concreta** `Soma` implementa a Interface Funcional `Operacao` definindo um corpo para o seu método `calcular`. Trata-se de uma **Classe Concreta**, pois tem nome próprio (Soma) e sua implementação não inclui nenhuma instanciação. Agora, seu método poderá ser colocado em prática num programa.
**Por Exemplo:**
```
public class Main {
    
    public static void main(String[] args) {
        
        Soma adicao = new Soma();
        System.out.println(adicao.calcular(5, 3));
    }
}
```
**Saída:** 
```
8
```
A Classe `Soma` é instanciada com a criação de um objeto `adicao`. O objeto chama o método `calcular` implementado anteriormente, e imprime o resultado da operação "8".

### Interfaces Funcionais nas Classes Abstratas
Igualmente como nas Interfaces Comuns, uma Classe Abstrata pode implementar uma Interface Funcional desde que os métodos sejam instanciados nas suas Subclasses Concretas.
**Por Exemplo:**
```
abstract class OperacaoBase implements Operacao {
    
    public void exibirResultado(int a, int b) {
        System.out.println("Resultado: " + calcular(a, b));
    }
}
```
A **Classe Abstrata** `OperacaoBase` implementa a Interface Funcional `Operacao`. Ela implementa um método próprio `exibirResultado` que recebe dois parâmetros e usa o método `calcular(a, b)` da Interface Funcional, mas **não faz sua implementação**. Caberá à Subclasse Concreta implementar o método da Interface.
**Por Exemplo:**
```
class Multiplicacao extends OperacaoBase {
    
    @Override
    public int calcular(int a, int b) {
        return a * b;
    }
}
```
A **Subclasse Concreta** `Multiplicacao` estende a Classe Abstrata `OperacaoBase` e implementa o método `calcular` da Interface Funcional. Agora, seu método poderá ser chamado num programa.
**Por Exemplo:**
```
public class Main {
    
    public static void main(String[] args) {
        
        Multiplicacao mult = new Multiplicacao();
        mult.exibirResultado(5, 3);
    }
}
```
**Saída:** 
```
Resultado: 15
```
A Classe `Multiplicacao` é instanciada com a criação de um objeto `mult`. O objeto chama o método `exibirResultados`, da Classe Abstrata Pai, e como os métodos da Interface Funcional foram anteriormente implementados, consegue imprime o resultado da operação "Resultado: 15".

### Interfaces Funcionais nas Classes Anônimas
Igualmente à Interface Comum, uma Classe Anônima pode implementar uma Interface Funcional. Para isso, a Classe não terá nome e chamará apenas o nome da própria Interface. Além disso, a declaração deve ser seguida imediamente de uma instanciação de objeto.
**Por Exemplo:**
```
Operacao divisao = new Operacao() {
            
            @Override
            public int calcular(int a, int b) {
                return a / b;
            }
        };
```
A **Classe Anônima** implementa a Interface Funcional `Operacao`. Ela  chama a interface pelo nome dela, e a Classe em si não tem nome. O objeto `divisao` é instanciado no momento da declaração. E o método `calcular` é implementado. Agora, seus métodos podem ser executados, desde que estejam no **mesmo escopo da sua declaração**.
**Por Exemplo:**
```
public class Main {
    
    public static void main(String[] args) {
        
        Operacao divisao = new Operacao() {  
            ...
        };

        divisao.calcular(10,5);
    }
}
```
**Saída:** 
```
2
```
A declação da Classe Anônima está dentro da Classe Main, por isso o objeto `divisao` e o método `calcular` funcionam.

### Função Lambda
As Funções Lambda são expressões que **implementam de forma concisa** o método abstrato de uma Iinterface Funcional.. Lambdas só funcionam com **Interfaces Funcionais**, visto que essas têm apenas um método abstrato, e o compilador saberá qual método deve implementar.

Trata-se de uma Função **sem declaração**, ou seja, ela não leva um nome, um tipo de retorno (void, int, double...) e o modificador de acesso (public, protected, private).

A expressão Lambda permite passar **comportamentos (implementações de métodos)** como argumento para outros métodos. Funções normais passam apenas valores (números, Strings, objetos comuns etc.).

A ideia da Função Lambda é declarar o método no mesmo momento em que ele será usado, pois ela dispensa a declaração explícita de uma Classe implementando a Interface Funcional.

A Função Lambda é sempre uma **instância direta da Interface Funcional**. Ou seja, a Função Lambda gera uma **implementação anônima** do método abstrato da Interface Funcional que ela instancia. A Função Lambda não entra no corpo de uma Classe Concreta ou Abstrata para substituir o método, porque nessas Classes é preciso declarar o método de forma tradicional.

> A Função Lambda só pode substituir Classes Anônimas, **nunca o corpo de uma Classe Concreta ou Abstrata**.

Sua sintaxe consiste de três elementos: parâmetro, operador seta e corpo (expressão)
**Sintaxe Simples:**
```
parâmetro -> expressão
```
**Sintaxe Composta:**
```
(parâmetros) -> {
    expressão
    return resultado;}
```
Quando recebe mais de um parâmetro (a, b), é obrigatório o uso de parêteses. E quando a mais de uma linha de código na expressão, usa-se chaves e tem-se um retorno.

### Obtendo Função Lambda
A Função Lambda é **instância de uma Interface Funcional**, e permite executar o método abstrato dessa de maneira mais concisa.
**Por Exemplo:**
```
@FunctionalInterface
public interface Saudacao {
    void exibir(String nome);
}
```
A Interface Funciona `Saudacao` tem o método abstrato `exibir` que tem como parâmetro uma String `nome`. A partir dessa Interface, uma Classe Anônima poderia ser gerada para implementação direta do método.
**Por Exemplo:**
```
Saudacao brasil = new Saudacao(){
    
    @Override
    public void exibir(String nome) {
        System.out.println("Bom dia, " + nome);
    }
}
```
Com a Função Lambda, a declaração da Classe Anônima repete a chamada da Interface Funcional `Saudacao` com a variável criada `brasil`. Mas substitui o resto da declaração a partir de `new Saudacao()` pela Expressão Lambda.
**Por Exemplo:**
```
Saudacao brasil = nome -> System.out.Println("Bom dia, " + nome);
```
O objeto `brasil` está sendo criado implementando o **único método que ele tem** (`exibir`) com o corpo `System.out.Println("Bom dia, " + nome);`, e estabelecendo `nome` como parâmetro. A Função Lambda permite automatizar as etapas verbosas da implementação manual da Classe Anônima. Agora, é possível executar o método.
**Por Exemplo:**
```
public class Main {
    
    public static void main(String[] args) {
        
        Saudacao brasil = nome -> System.out.Println("Bom dia, " + nome);

        brasil.exibir("Pedro");
    }
}
```
**Saída:** 
```
Bom dia, Pedro
```
### Principais Interfaces Funcionais em Java
Java forcene em seu pacote **java.util.function** algumas Interfaces Funcionais prontas, que servem como **blocos de construção reutilizáveis** num contexto de **Programação Funcional**. 

É possível usar tais Interfaces sempre que for necessário passar um comportamento como parâmetro, umas vez que elas são basicamente como **"contratos prontos"**.

Essas Interfaces têm um **Generic**, que define o tipo do elemento sobre o qual a ação será executada. Esse elemento **não pode ser de tipo primitivo**, ele deve necessariamente ser de **tipo referenciável**, ou seja, tipos de dado que se referem a um **objeto**, em vez de armazenar diretamente os valores. Alguns dos tipos referenciáveis em Java são: Classes, Strings, Arrays, Classes "wrapper" (Integer, Double, Boolean, Character, Long, Float, Short, Byte), Coleções, null entre outros.

#### Consumer
A Interface Funcional `Consumer<T>` é declarada assim:
```
@FunctionalInterface
public interface Consumer<T>{
    void accept(T t);
}
```
A Função é definida para um Generic (T), tem como método abstrato `void accept(T t)`, que recebe uma variável (t) do tipo genérico especificado (T). Ela **não retorna** nada. Ela recebe e processa um valor.

Como é uma Interface Funcional, ela pode ser implementada por uma **Classe Anônima**.
**Por Exemplo:**
```
Consumer<Integer> exibe = new Consumer<Integer>(){
    
    @Override
    public void accept(Integer n){
       System.out.println("Número: " + n); 
    }
};

exibe.accept(30);
```
**Saída:**
```
Número: 30
```
Na declaração da Classe, a Interface foi definina no Generics `Integer`, e o objeto `exibe` foi instanciado. O método foi implementado, recebendo o argumento `n`, seguido pela instrução de execução. O valor "30" é passado como argumento para o método sobrescrito accept(Integer n) na linha `exibe.accept(30)`. Essa mesma implementação pode ser reescrita no formato de uma **Função Lambda**.
**Por Exemplo:**
```
Consumer<Integer> exibe = n -> System.out.println("Número: " + n);

exibe.accept(30);
```
**Saída:**
```
Número: 30
```
A Função Lambda insere no argumento de sua expressão o mesmo parâmetro recebido pelo método accept `n`. E define na sua expressão o mesmo código declarado na linha de execução.

#### Supplier
A Interface Funcional `Supplier<T>` é declarada assim:
```
@FunctionalInterface
public interface Supplier<T>{
    T get();
}
```
A Função é definida para um Generic (T) e tem como método abstrato `T get()`, que **não recebe variável alguma**. Entretanto, a Função precisa ter **retorno** definido. Ela fornece um valor do tipo especificado.

Como é uma Interface Funcional, ela pode ser implementada por uma **Classe Anônima**.
**Por Exemplo:**
```
Supplier<Integer> angulo = new Supplier<Integer>(){
        
    @Override
    public Integer get(){
       System.out.print("Posição: ");
       return 360; 
    }
};

System.out.println(angulo.get());;
```
**Saída:**
```
Posição: 360
```
Na declaração da Classe, a Interface foi definina no Generics `Integer`, e o objeto `angulo` foi instanciado. O método foi implementado sem receber argumentos, seguido pela instrução de execução. Na chamada do método, a função `sout` é usada para imprimir o retorno, no caso o valor 360. Essa mesma implementação pode ser reescrita no formato de uma **Função Lambda**.
**Por Exemplo:**
```
Supplier<Integer> posicao = () -> 360;
```
Na versão com Lambda, os parênteses ficam vazios porque o método `get()` da interface Supplier não recebe parâmetros. Na sua expressão, é especificado o retorno do método.

Se o corpo do get() for fixo, como em `return 360`, a Função sempre fornecerá o mesmo valor. Mas valores diferentes podem ser fornecidos. Ao usar Classes Anônimas, variáveis podem ser declaradas como atributos da **Classe Anônima**, e isso pode ser usado dentro do corpo do get() para definir uma **lógica dinâmica** e gerar valores diferentes. Entretanto, em Funções Lambda não é possível declarar atributos internos, e outro métodos precisam ser empregados de acordo com a necessidade (como wrappers e objetos externos mutáveis).

#### Function
A Interface Funcional `Function<T,R>` é declarada assim:
```
@FunctionalInterface
public interface Function<T,R>{
    R apply(T t);
}
```
A Função é definida para um Generic (T) e outro (R), tem como método abstrato `R apply(T t)`, que recebe uma variável (t) do tipo genérico especificado (T) e retorna um valor do outro tipo genérico (R). Ela precisa ter **retorno** definido. A Função recebe um valor e retorna outro, é ideal para conversões e transformações.

Como é uma Interface Funcional, ela pode ser implementada por uma **Classe Anônima**.
**Por Exemplo:**
```
Function<Integer, String> converse = new Function<Integer, String>() {
    
    @Override
    public String apply(Integer numero) {
        return "Número: " + numero;
    }
};

System.out.println(converse.apply(32));
```
**Saída:**
```
Número: 32
```
Na declaração da Classe, a Interface foi definina com Generics de entrada `Integer` e de saída `String`. O objeto `converse` foi instanciado. O método foi implementado, recebendo o argumento `numero` e o retorno é configurado para uma `String`. Na chamada do método, a função `sout` é usada para imprimir a String gerada. Essa mesma implementação pode ser reescrita no formato de uma **Função Lambda**.
**Por Exemplo:**
```
Function<Integer, String> converse = numero -> "Número: " + numero;

System.out.println(converse.apply(32));
```
**Saída:**
```
Número: 32
```
A Função Lambda insere no argumento de sua expressão o mesmo parâmetro recebido pelo método apply `numero`. E define na sua expressão o mesmo código declarado na linha de execução.

#### Predicate
A Interface Funcional `Predicate<T>` é declarada assim:
```
@FunctionalInterface
public interface Predicate<T>{
    public boolean test(T t);
}
```
A Função é definida para um Generic de tipo (T), e tem como método abstrato `boolean test(T t)`, que recebe uma variável (t) do tipo genérico especificado (T) e retorna um valor `True` ou `False`. Ela precisa ter **retorno** definido. A Função recebe um argumento e retorna um resultado lógico, é ideal para testes de condição para aplicar filtros.

Como é uma Interface Funcional, ela pode ser implementada por uma **Classe Anônima**.
**Por Exemplo:**
```
Predicate<Integer> ePar = new Predicate<Integer>() {
    
    @Override
    public boolean test(Integer numero) {
        return numero % 2 == 0;
    }
};


System.out.println(ePar.test(10));
System.out.println(ePar.test(7));
```
**Saída:**
```
True
False
```
Na declaração da Classe, a Interface foi definina com Generics de entrada `Integer` e o objeto `ePar` foi instanciado. O método foi implementado, recebendo o argumento `numero` e o retorno é configurado é o resultado do teste lógico `% 2 == 0`. Na chamada do método, a função `sout` é usada para imprimir o resultado do teste lógico. Essa mesma implementação pode ser reescrita no formato de uma **Função Lambda**.
**Por Exemplo:**
```
Predicate<Integer> ePar = numero -> numero % 2 == 0;

System.out.println(ePar.test(10));
System.out.println(ePar.test(7));
```
**Saída:**
```
True
False
```
A Função Lambda insere no argumento de sua expressão o mesmo parâmetro recebido pelo método test `numero`. E define na sua expressão o mesmo teste lógico declarado na linha de execução.

#### BinaryOperator
A Interface Funcional `BinaryOperator<T>` é declarada assim:
```
@FunctionalInterface
public interface BinaryOperator<T,T>{
    public T apply(T t1, T t2);
}
```
A Função é definida para um Generic de tipo (T), e tem como método abstrato `T apply(T t1, T t2)`, que recebe duas variáveis (t1, t2) do tipo genérico especificado (T) e retorna um valor do mesmo tipo genérico (T). Ela precisa ter **retorno** definido. A Função recebe dois argumentos e fornece um outro do mesmo tipo, é ideal para operações de redução (somar, multiplicar, concatenar etc.). Trata-se um caso especial de `BiFunction<T, T, T>`.

Como é uma Interface Funcional, ela pode ser implementada por uma **Classe Anônima**.
**Por Exemplo:**
```
BinaryOperator<Integer> soma = new BinaryOperator<Integer>() {
    
    @Override
    public Integer apply(Integer num1, Integer num2) {
        return num1 + num2;
    }
};


System.out.println(soma.apply(10, 5));
System.out.println(soma.apply(8, 4));
```
**Saída:**
```
15
12
```
Na declaração da Classe, a Interface foi definina com Generics de entrada `Integer` e o objeto `soma` foi instanciado. O método foi implementado, recebendo os argumentos `num1` e `num2`. O seu retorno é outro Integer, resultado da soma dos argumentos. Na chamada do método, a função `sout` é usada para imprimir o resultado da operação; Essa mesma implementação pode ser reescrita no formato de uma **Função Lambda**.
**Por Exemplo:**
```
BinaryOperator<Integer> soma = (num1, num2) -> num1 + num2;

System.out.println(soma.apply(10, 5));
System.out.println(soma.apply(8, 4));
```
**Saída:**
```
15
12
```
A Função Lambda insere no argumento de sua expressão os mesmos parâmetros recebidos pelo método apply `num1` e `num2`. Como são dois argumentos, eles devem estar **entre parênteses**. Em seguida, define na sua expressão o mesmo código declarado na linha de execução.

### Integração com API Stream
API são *"Application Programming Interface"* (Interface de Programação de Aplicações). Consiste em um conjunto de **regras**, **protocolos** e **ferramentas** que permite que **diferentes sistemas** e aplicações **se comuniquem** e troquem dados de forma padronizada.

São úteis por permitir que desenvolvedores usem **funcionalidades prontas** sem precisar entender a implementação interna, promovendo reuso de código e interoperabilidade.

### API Stream
A API Stream permite trabalhar com Coleções de **Forma Funcional**. Coleções são elementos que **agrupam múltiplos elementos** de um **Tipo Referenciável** em uma única unidade. Ela representa uma **abstração de fluxo de dados**, existindo apenas durante o processamento. A API Stream é integrada com o **Collections Framework** (ver material de Coleções).

O seu funcionamento segue a lógica de um **Pipeline**, encadeando várias operações de forma sequencial, como uma **esteira de processamento**. Ou seja, cada operação pega a saída da anterior como entrada, sem modificar a coleção original. As operações da API Stream recebem como parâmetro uma **Interface Funcional**, que define o comportamento a ser aplicado aos elementos da Coleção.
**Ou Seja:**
- **Coleções:** Armazenam os dados a serem processados
- **Interfaces Funcionais:** Definem as operação a serem feitas nos elementos da Coleção
- **Streams:**: Encadeamento de operações para processamento de forma declarativa

Como as Streams recebem Interfaces Funcionais, elas podem utilzar Funções Lambda para reescrita concisa dos códigos.
**Em resumo:**
>A Coleção fornece elementos **→** o Stream os encadeia em um Pipeline de ações **→** cada etapa do Pipeline recebe um contrato definido por uma Interface Funcional **→** o contrato é implementado por uma Lambda que define o que fazer com cada elemento.

#### Consumer + Stream
Como vimos, a Interface Funcional `Consumer` recebe valores, os processa, e não retorna nada. Ela pode ser empregada nos elementos de uma Coleção de **Forma Funcional** através do Stream.
**Por Exemplo:**
```
List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
```
1. A Coleção do tipo `List` com Generic `Integer` é instanciada com o nome `numeros`. Ela contem uma Coleção de 1 a 10.
```
Consumer<Integer> imprimirNumeroPar = n -> {
    if (n % 2 == 0) {
        System.out.println(n);
    }
};
```
2. A Interface Funcional `Consumer` é implementada instanciando o objeto `imprimirNumeroPar` e com o Lambda para implementar o seu método `accept()`. No caso, o método da Interface receberá o argumento `n` e testará a sua paridade através do módulo da divisão por 2. Caso seja par, o argumento será impresso.
```
numeros.stream().forEach(imprimirNumeroPar);
```
3. Finalmente, a Coleção `numeros` é inserida na Pipeline através do método `Stream()` do pacote `Java.util.Collection`. Isso faz com que a lista seja transformada em um **fluxo de dados**. O método `stream()` possui outros métodos, como o `forEach()`, que recebe um objeto do tipo `Consumer`. Por isso o objeto `imprimirNumeroPar` é passado como argumento. O método `forEach()` percorre os elementos dp fluxo criado pelo `stream()` e executará a ação implementada na Interface Funcional `Consumer` em todos os elementos do fluxo gerado a partir da Coleção `numeros` (entretanto, a **Função Lambda** descrita na Interface `n -> {if (n % 2 == 0) {System.out.println(n)}}` poderia ser passada como argumento diretamente). Ou seja, cada elemento da Coleção, será passado como argumento `n` da Interface para o método `accetp` que irá verificar a paridade do número e rotorná-lo caso ele seja par.

#### Supplier + Stream
Como vimos, a Interface Funcional `Supplier` não recebe valores, mas retorna um do tipo genérico especificado. Ela pode ser empregada nos elementos de uma Coleção de **Forma Funcional** através do Stream.
**Por Exemplo:**
```
List<String> listaSaudacoes5 = new ArrayList<>();
```
1. Uma Coleção do tipo `List` com Generic `String` é instanciada com o nome `listaSaudacoes5`. Ela contem uma Lista vazia.
```
Supplier<String> saudacao = () -> "Olá, seja bem-vindo(a)!";
```
2. A Interface Funcional `Supplier` é implementada instanciando o objeto `saudacao` e com o Lambda para implementar o seu método `get()`. O método da Interface não recebe argumentos `()` e retorna uma String.
```
List<String> listaSaudacoes5 = Stream.generate(saudacao).limit(5).toList();
```
3. Importante destacar que a Interface Supplier **não consome nada**, ela apebas **fornece dados novos**. Por isso, não é possível chamar o método `stream()` direto na Lista `listaSaudacoes5`, essa lista está **vazia**, o método `stream()` não tem como gerar um fluxo de dados. Nesse caso, é preciso usar o método `Stream.generate()`, que criará um fluxo a partir de um objeto de tipo `Supplier`, por isso mesmo, o método recebe como argumento o Supplier `saudacao` (entretanto, a Função Lambda descrita na Interface `() -> "Olá, seja bem-vindo(a)!"` poderia ser passada como argumento diretamente).. O método `limit()` determina o tamanho máximo do Stream que será gerado. Finalmente, o método `toList()` permite converter os dados para uma Lista. Entretanto, essa Lista precisa ser atribuída a algum objeto, por isso utilizamos a atribuição ao `listaSaudacoes5`
> O método `.toList()` é próprio do API Stream, e retorna uma **Lista de tamanho fixo**. É possível retornar uma lista mutável utilizando um método estático da Classe Utilitária `Collectors` junto com o método `collect()` da API Stream. A Classe `Collectors` possui diversos métodos para retornar objetos do tipo Collector, um deles é o `.toList()`. O método `collect` da API Stream recebe como argumento um Collector. Por isso `Collectors.toList()` pode ser passado como argumento para o método `collect()`, que seguira o fluxo de dados do `Stream.generate()` e retornará a **Lista de tamanho variável**.

#### Function + Stream
Como vimos, a Interface Funcional `Function` recebe valores e retorna outros do mesmo tipo genérico especificado. Ela pode ser empregada nos elementos de uma Coleção de **Forma Funcional** através do Stream.
**Por Exemplo:**
```
List<Integer> numeros = List.of(1, 2, 3, 4, 5);
```
1. A Coleção do tipo `List` com Generic `Integer` é instanciada com o nome `numeros`. Ela contem uma Coleção de 1 a 5.
```
Function<Integer, Integer> dobrar = numero -> numero * 2;
```
2. A Interface Funcional `Function` é implementada instanciando o objeto `dobrar` e com o Lambda para implementar o seu método `apply()`. O método da Interface recebe o argumento do tipo Integer `(numero)`, que será multiplicado por dois e retornado.
```
List<Integer> numerosDobrados = numeros.stream().map(dobrar).toList();
```
3. Como a Coleção `numeros` não é vazia, ela pode ser inserida na Pipeline através do método `Stream()` do pacote `Java.util.Collection`, assim como foi feito com a Interface `Consumer`, transformando ela em um **fluxo de dados**. Outro métoda de `stream()` é o `.map()`, que recebe uma objeto do tipo Function para ser executado em cada elemento da Stream, e produz um nova Stream com os resultados. O objeto `dobrar` é passado como argumento para `.map()` (entretanto, a **Função Lambda** descrita na Interface `numero -> numero * 2` poderia ser passada como argumento diretamente). Finalmente o método `toList()` é usado para transformar a Stream numa Coleção do tipo Lista (aqui também poderia ser usado o `collect()`). A nova lista é atribuída a `numerosDobrados`, onde poderá ser acessada posteriormente.
   
#### Predicate + Stream
Como vimos, a Interface Funcional `Predicate` recebe valores e retorna um booleano de verdadeiro ou falso. Ela pode ser empregada nos elementos de uma Coleção de **Forma Funcional** através do Stream.
**Por Exemplo:**
```
List<String> palavras = List.of("java", "kotlin", "python", "javascript", "c", "go", "ruby");
```
1. A Coleção do tipo `List` com Generic `String` é instanciada com o nome `palavras`. Ela contem uma Coleção de 7 palavras.
```
Predicate<String> maisDeCincoCaracteres = palavra -> palavra.length() > 5;
```
2. A Interface Funcional `Predicate` é implementada instanciando o objeto `maisDeCincoCaracteres` e com o Lambda para implementar o seu método `test()`. O método da Interface recebe o argumento `palavra` do tipo String, que verificará se seu tamanho é maior do que 5 caracteres.
```
palavras.stream().filter(maisDeCincoCaracteres).forEach(p -> System.out.println(p));
```
3. Como a Coleção `palavras` não é vazia, ela pode ser inserida na Pipeline através do método `Stream()` do pacote `Java.util.Collection`, assim como foi feito com a Interface `Consumer` e `Function`, transformando ela em um **fluxo de dados**. Outro método de `stream()` é o `.filter()`, que recebe como argumento um objeto do tipo Predicate, executando o teste lógico em cada elemento da Stream, e produzindo um nova Stream os elementos que retornam `True` no teste. O objeto `maisDeCincoCaracteres` é passado como argumento para `.filter()` (entretanto, a **Função Lambda** descrita na Interface `palavra.length() > 5` poderia ser passada como argumento diretamente). Finalmente o método `forEach()` é usado para correr os elementos do Stream como vimos anteriormente. Porém, ele precisa de um objeto do tipo `Consumer` para funcionar. Como nenhum objeto `Consumer` foi instanciado, podemos passar diretamente a Função Lambda com a expressão que desejamos, pois Java identifica o argumento do `forEach()` e automaticamente transforma de maneira implícita essas expressões em um objeto que implementará a Interface Funcional `Consumer`.

#### BinaryOperator + Stream
Como vimos, a Interface Funcional `BinaryOperator` recebe dois valores e retorna outro do mesmo tipo genérico especificado. Ela pode ser empregada nos elementos de uma Coleção de **Forma Funcional** através do Stream.
**Por Exemplo:**
```
List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8);
```
1. A Coleção do tipo `List` com Generic `Integer` é instanciada com o nome `numeros`. Ela contem uma Coleção de 1 a 8.
```
BinaryOperator<Integer> somar = (num1, num2) -> num1 + num2;
```
2. A Interface Funcional `BinaryOperator` é implementada instanciando o objeto `somar` e com o Lambda para implementar o seu método `apply()`. O método da Interface recebe os argumentos `num1` e `num2` do tipo Integer, e efetuará a soma deles.

```
int resultado = numeros.stream().reduce(0, somar);
```
1. Como a Coleção `palavras` não é vazia, ela pode ser inserida na Pipeline através do método `Stream()` do pacote `Java.util.Collection`, assim como foi feito com a Interface `Consumer`, `Function` e `Predicate`, transformando ela em um **fluxo de dados**. Outro método de `stream()` é o `.reduce()`, que recebe como arumento um valor de identidade (que funciona como uma variável temporária para contagem), e um objeto do tipo `BinaryOperator`. O objeto `somar` e passado como argumento (entretanto, a **Função Lambda** descrita na Interface `(num1, num2) -> num1 + num2;` poderia ser passada como argumento diretamente), e o valor de identidade é declarado como zero (pois o objetivo é **somar** os valores). A função `.reduce()` combina todos os elementos da Stream em um único resultado, aplicando uma operação de acumulação repetidamente.