Feature: Calculadora Polonesa

  Scenario Outline:

  Efetuar cálculos utilizando notacao polonesa inversa

    Given a necessidade de realizar um calculo em notacao polonesa inversa
    When for inserida a entrada "<Entrada>"
    Then terei a saida "<Saida>"

    Examples:
      | Entrada           | Saida |
      | 5 1 2 + 4 * + 3 - |  14.0 |
