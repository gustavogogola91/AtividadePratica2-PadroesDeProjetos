# Atividade Prática

## Exercício 1

### Padrão escolhido: Strategy

Foi selecionado o padrão Strategy pois permite a alteração em tempo de execução da estratégia de análise sem realizar nenhuma mudança no código do cliente.

## Exercício 2

### Padrão escolhido: Adapter

Este padrão foi escolhido pois permitir ele torna possível a utilização de duas interfaces/apis com métodos diferentes, realizando a tradução das funções entre elas para que seja possível a a utilização com métodos e argumentos diferentes. 

## Exercício 3

### Padrão escolhido State

Foi escolhido o padrão state pois ele permite a criação de lógica exclusiva para cada estado e também permite a alteração em tempo de execução do estado, encapsulando o estado atual em uma variável no objeto Usina e evitando a as estruturas condicionais gigantes que seriam necessárias para a resolução do problema.

## Exercício 4

### Padrão escolhido: Chain of Responsibility

O padrão Chain foi escolhido pois permite que a requisição passe por uma cadeia de validadores, cada um com sua lógica própria. Cada um desses validadores poderá rejeitar ou passar para o próximo validador, sendo possível utilizar condicionais para realizar paradas e rollback quando necessário. 
