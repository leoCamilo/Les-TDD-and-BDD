Feature: Controlar a Temperatura da Sala

  Scenario Outline:

  Controle de Temperatura

    Given O ar condicionado precisa controlar a temperatura interna da sala
    When As quantidades de pessoas "<sensorInterno1>", "<sensorInterno2>", "<sensorInterno3>" foram registrados pelos tres sensores internos"
    And Tendo os valores "<sensorExterno1>", "<sensorExterno2>", "<sensorExterno3>" registrados pelos sensores de temperatura externos"
    Then Tanto a media de pessoas "<mediaPessoas>" quanto a media da temperatura externa "<mediaTemperaturaExterna>" são calculados
    And eh calculada e normalizada a temperatura da sala

    Examples:
      | sensorInterno1 | sensorInterno2 | sensorInterno3 | sensorExterno1 | sensorExterno2 | sensorExterno3 |  mediaPessoas |mediaTemperaturaExterna |
      |              8 |             16 |              9 |             32 |             30 |             28 |            11 |                     30 |
      |              5 |              4 |              6 |             16 |             18 |             22 |            5  |                     18 |
      |              2 |              6 |              4 |             26 |             28 |             27 |            4  |                     27 |

			
