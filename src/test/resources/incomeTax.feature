Feature: Income Tax Calc

  Scenario Outline:

    Income tax calc based on salary

    Given My salary is "<salary>"
    And My income tax is "<calcAnswer>"

    Examples:
      | salary  | calcAnswer |
      | 1050.0  |     0.0    |
      | 2000.00 |    150.0   |
      | 3000.00 |    450.0   |
      | 4000.00 |    900.0   |
      | 5000.00 |   1375.0   |