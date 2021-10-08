# API Reset de Senha

## Tabela de Conteúdo
* [Informações Gerais](#informações-gerais)
* [Tecnologias](#tecnologias)
* [Setup](#setup)
* [Validação de Senha](#validação-de-senha)
* [Observações sobre o Projeto](#observações-sobre-o-projeto)

## Informações Gerais
Este projeto consiste numa Web API que valida se uma senha é válida.

## Tecnologias
O projeto foi criado com:
* Java 11
* Spring Boot
* JUnit

## Setup

## Ferramentas necessárias
* Docker (https://hub.docker.com/)

Para acessar a aplicação é necessário que todos os pré requisitos estejam instalados.

## Baixando o projeto

* Agora vamos baixar o projeto, abra o terminal(shell ou CMD) e digite:

```
docker pull helioortega/case-validate-password
```

## Rodando a aplicação

* Após baixar o projeto vamos rodar a aplicação, abra o terminal(shell ou CMD) e digite:

```
docker run -d -p 8080:8080 helioortega/case-validate-password
```
## Validação de Senha
* A senha deverá seguir os critérios a seguir para ser considerada válida
* Nove ou mais caracteres 
* Ao menos 1 dígito
* Ao menos 1 letra minúscula
* Ao menos 1 letra maiúscula
* Ao menos 1 caractere especial !@#$%^&*()-+
* Não possuir caracteres repetidos dentro do conjunto

## Observações sobre o Projeto
* A API construída em SpringBoot disponibiliza um endpoint através de um RestController
* Esse endpoint localizado na camada controller, recebe uma String de senha dentro de um JSON
* Feito isso será chamado a camada de service
* Em service, será validado através de Expressão Regular (Regex) cada critério necessário para a senha
* Após isso, será devolvido para o usuário, uma Response contendo o valor booleano
* Esse booleano retornará true para senha válida e false para senha inválida
* Também no Response terá uma lista de mensagens, contendo cada critério que falhou na senha
* Ou apenas uma mensagem positiva em caso da senha ser válida

