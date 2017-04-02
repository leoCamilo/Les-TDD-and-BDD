Feature: Calculadora Polonesa

  Scenario Outline:

  Efetuar cálculos utilizando notacao polonesa inversa

    Given a necessidade de realizar um calculo em notacao polonesa inversa
    When for inserida a entrada "<Entrada>"
    Then terei a saida "<Saida>"

    Examples:
      | Entrada           | Saida |
      | 5 1 2 + 4 * + 3 - |  14.0 |
      | 1 4 + 5 * 3 - 6 + |  28.0 |
      | 3 6 4 8 / + 3 - * |  15.0 |


