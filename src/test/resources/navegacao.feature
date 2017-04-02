Feature: Navegacao

  Scenario Outline:

  Informar ao usuário qual das cidades indicadas esta mais proxima de sua localizacao se seguir a direcao indicada tambem por ele.

    Given Sao informadas as cidades "<cidade1>", "<cidade2>", "<cidade3>", "<cidade4>"
    When inserido o ponto cardeal "<pontoCardeal>"
    Then terei como retorno a cidade "<cidadeResposta>"

    Examples:
      | cidade1  |   cidade2  |     cidade3    |    cidade4    | pontoCardeal | cidadeResposta |
      | Galway   |   Dublin   |    Waterford   |   Amsterdam   |    Norte     |    Amsterdam   |
      |  Paris   | Amsterdam  |    Barcelona   |     Porto     |     Sul      |     Porto      |
      | Salvador |  Curitiba  |  Florianopolis |    Vitoria    |    Leste     |     Vitoria    |

