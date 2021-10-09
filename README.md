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

## Acesando a API
* Após rodar a imagem docker, utilize o link abaixo para acessar o Swagger da API
```
http://localhost:8080/case-validate-password/swagger-ui.html
```

## Validação de Senha
* A senha deverá seguir os critérios a seguir para ser considerada válida
* Nove ou mais caracteres 
* Ao menos 1 dígito
* Ao menos 1 letra minúscula
* Ao menos 1 letra maiúscula
* Ao menos 1 caractere especial !@#$%^&*()-+
* Não possuir caracteres repetidos dentro do conjunto
* Não possuir espaços vazios

## Observações sobre o Projeto
* O projeto está separado em camada de Controller, Model, Service, Enums, Configuration e Utils
* A API construída em SpringBoot disponibiliza dois endpoints através de Controller (ValidatePasswordController)
* Os endpoints, localizados na camada controller, recebem uma String de senha dentro de um JSON
* O endpoint "v1/password/validate" retorna um objeto contendo um booleano e uma lista de erros
* O endpoint "v1/password/validate-only" retorna apenas um booleano com o valor de acordo com a validação da senha
* Esses endpoints então, irão chamar a camada de Service para a processar a lógica de negócio.
* A camada de service está devidida em:
* Interface (ValidatePasswordService). A interface contem a documentação dos métodos em JavaDoc.
* Implementação (ValidatePasswordServiceImpl). 
* A implementação do service contem os métodos com a lógica de validação de senha que são usados na Controller
* Dentro do service, será validado cada critério da senha (citado acima) através de Expressões Regulares (Regex)
* Cada critério necessário para a validação da senha possui seu próprio Regex
* Todos os regex estão salvos na classe PasswordUtils, assim como as suas mensagens de validação
* Os regex e suas mensagens podem são estáticos e públicos, podendo ser acessado em qualquer camada da aplicação
* Há um Enum (ValidationEnum), com o regex e mensagem de cada respectiva validação
* Esse Enum é utilizado dentro de um for loop na camada de serviço
* No pacote resource/contracts está localizado o arquivo validate-password.yaml
* Esse arquivo se trata de um contrato da API em Swagger que irá servir de documentação e teste da API
* No pacote configuration há uma classe de configuração SwaggerConfig
* Essa configuração permite a interface do Swagger UI seja acessada quando a aplicação estiver rodando

