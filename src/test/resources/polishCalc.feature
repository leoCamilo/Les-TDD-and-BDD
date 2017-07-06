Feature: Polish Calculator

  Scenario Outline:

  Make calculations using reverse polish notation

  Given The need to calculate an equation using reverse polish notation
  When If the input is "<input>"
  Then The output is "<output>"

  Examples:
    |       input       |  output |
    | 5 1 2 + 4 * + 3 - |  -14.0  |
    | 1 4 + 5 * 3 - 6 + |  -16.0  |
    | 3 6 4 8 / + 3 - * |  -15.0  |