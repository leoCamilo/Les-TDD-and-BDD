Feature: Navigation

  Scenario Outline:

  Inform the user which city is closest of his location if he follow the direction indicated by him.

    Given Cities are informed "<city1>", "<city2>", "<city3>", "<city4>"
    When Inserted the cardinal point "<cardinalPoint>"
    Then The answer city is "<answerCity>"

    Examples:
      |   city1  |    city2   |      city3     |     city4     | cardinalPoint |    answerCity  |
      |  Galway  |   Dublin   |    Waterford   |   Amsterdam   |     Norte     |    Amsterdam   |
      |   Paris  | Amsterdam  |    Barcelona   |     Porto     |      Sul      |     Porto      |
      | Salvador |  Curitiba  |  Florianopolis |    Vitoria    |     Leste     |     Vitoria    |

