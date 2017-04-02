Feature: Calculo do Imposto de Renda

  Scenario Outline:

  Calculo do imposto de renda aplicado a cada faixa salarial

    Given Eu recebo "<salario>" mensalmente
    When Valor minimo "<minValue>" e valor maximo "<maxValue>"
    Then seria calculado sobre o valor de "<taxas>" %
    And resultaria no valor de "<respostaCalculo>" reais

    Examples:
      | salario | minValue  | maxValue  | taxas    |respostaCalculo|
      | 1500.00 |      0.00 |   1903.98 |     0.00 |       0.0     |
      | 2000.00 |   1903.99 |   2826.65 |      7.5 |     150.0     |
      | 3000.00 |   2826.66 |   3751.05 |       15 |     450.0     |
      | 4000.00 |   3751.06 |   4664.68 |     22.5 |     900.0     |
      | 5000.00 |   4664.69 | 999999.00 |     27.5 |    1375.0     |


