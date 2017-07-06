Feature: Control Room Temperature

  Scenario Outline:

  Temperature Control

    Given The air conditioner needs to control the temperature on room
    When The Count of people "<sensor1>", "<sensor2>", "<sensor3>" was registered by the three internal sensors
    And With the values "<externalSensor1>", "<externalSensor2>", "<externalSensor3>" registered by the external sensors
    Then The people average "<peopleAverage>" and the external temperature "<externalTemperature>" are calculated
    And The room temperature is calculated and normalized

    Examples:
      | sensor1 | sensor2 | sensor3 | externalSensor1 | externalSensor2 | externalSensor3 |  peopleAverage | externalTemperature |
      |       8 |      16 |       9 |              32 |              30 |              28 |             11 |                  30 |
      |       5 |       4 |       6 |              16 |              18 |              22 |             5  |                  18 |
      |       2 |       6 |       4 |              26 |              28 |              27 |             4  |                  27 |

			
