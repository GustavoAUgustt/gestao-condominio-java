# gestao-condominio-java

Sistema de gestão de condomínio desenvolvido em Java, aplicando conceitos de POO, herança, encapsulamento, polimorfismo, interfaces, coleções e JPA.

## Objetivo acadêmico

Este projeto foi desenvolvido como estudo prático de Programação Orientada a Objetos, com foco na modelagem de um sistema de condomínio e na aplicação dos principais conceitos abordados no estudo bibliográfico. O objetivo é demonstrar, em um cenário realista, como classes, herança, interfaces, exceções, coleções e persistência podem ser integrados em uma solução Java organizada.

## Tecnologias utilizadas

- Java 17
- Maven
- Hibernate ORM
- Jakarta Persistence API (JPA)
- Banco H2 em memória
- JUnit 5

## Pré-requisitos

- JDK 17 ou superior
- Maven 3.8 ou superior
- Git

## Como baixar e executar

```bash
git clone https://github.com/GustavoAUgustt/gestao-condominio-java.git
cd gestao-condominio-java
git checkout feat/poo-condominio-jpa
mvn clean test
mvn exec:java -Dexec.mainClass="br.edu.catolica.ucb.poo.application.SistemaCondominio"
```

## Estrutura de pastas

```text
src/
  main/
    java/
      br/edu/catolica/ucb/poo/
        application/
        interfaces/
        model/
        service/
        util/
    resources/
      META-INF/
        persistence.xml
  test/
    java/
      br/edu/catolica/ucb/poo/service/
README.md
pom.xml
.gitignore
```

## Conceitos de POO implementados

### 1. Polimorfismo

A classe `Pessoa` representa o tipo genérico e as subclasses `Morador` e `Funcionario` sobrescrevem o método `exibirDetalhes()`. Assim, o mesmo código pode tratar diferentes tipos de pessoa de forma integrada.

### 2. Interfaces

A interface `Notificavel` define o método `enviarNotificacao(String mensagem)`, implementado por `Morador` e `Funcionario`.

### 3. Exceções

A classe `ServicoCobranca` valida valores e lança `IllegalArgumentException` quando o valor da cobrança é inválido.

### 4. Coleções

A classe `ServicoMorador` usa `List` e `ArrayList` para registrar e listar moradores.

### 5. JPA e entidades mapeadas

As entidades `Pessoa`, `Morador`, `Funcionario` e `Cobranca` estão mapeadas com JPA. A herança de `Pessoa` utiliza `@Inheritance(strategy = InheritanceType.JOINED)`.

## Principais classes

- `Pessoa`: classe base do sistema, representa uma pessoa do condomínio.
- `Morador`: especialização de pessoa, com apartamento, bloco e notificações.
- `Funcionario`: especialização de pessoa, com cargo e salário.
- `Cobranca`: entidade que representa uma cobrança do condomínio.
- `ServicoPessoa`: demonstra o uso de polimorfismo com referências de tipo `Pessoa`.
- `ServicoMorador`: gerencia uma lista de moradores em coleções.
- `ServicoCobranca`: valida valores de cobrança e trata erros.
- `JpaUtil`: inicializa o `EntityManagerFactory` do JPA.
- `SistemaCondominio`: exemplo de execução do sistema.

## Configuração do banco de dados

O projeto usa H2 em memória para facilitar a execução e os testes. A configuração está em `src/main/resources/META-INF/persistence.xml`. O banco é recriado ao iniciar a aplicação, portanto os dados não são persistidos entre execuções.

## Exemplos de execução

Ao executar a classe `SistemaCondominio`, o programa demonstra:

- cadastro de moradores e funcionários;
- exibição de detalhes com polimorfismo;
- envio de notificações via interface;
- criação de cobrança com validação;
- persistência em banco H2 em memória.

## Integrante

- GustavoAUgustt (identificação utilizada no GitHub)

## Escopo do projeto

A configuração atual é voltada a estudos e testes locais. Banco de dados e credenciais para produção não fazem parte do escopo desta versão.

## Referência bibliográfica

Este projeto foi desenvolvido como aplicação prática dos conceitos de Programação Orientada a Objetos, especialmente herança, encapsulamento, polimorfismo, interfaces, coleções e persistência de dados em JPA.
