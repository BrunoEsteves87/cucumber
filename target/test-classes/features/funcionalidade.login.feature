
Feature: Realizar login no site saucedemo

como usuario do site sauce demo
quero informar os dados de acesso
para acessar a conta

Scenario: Login valido

Given que esteja na tela de login
When enviar os dados de login
Then Login realizado com sucesso

  Scenario: Login com dados inválidos
  
    Given que esteja na tela de login
    When enviar dados de login inválidos
    Then Exibir mensagem de erro de login
   
  Scenario: Login com campos em branco
  
    Given que esteja na tela de login
    When não preencher os campos de login
    Then Exibir mensagem solicitando preenchimento dos campos