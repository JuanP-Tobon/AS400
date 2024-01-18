Feature:enter iseries and test its functionalities

  Scenario: Login successfully
    Given The user opens the session and logs in
  @this
  Scenario: User Consult query directly
    Given the user performs a direct query to the DB


  Scenario Outline: User Consult mongodb query
    Given The user connects and consult
      | cedula   | nombre   | precioProducto   |
      | <cedula> | <nombre> | <precioProducto> |
    Then He should see that the rate and date are correct
    Examples:
      | cedula | nombre        | precioProducto |
      | 2224   | David Perez   | 20000          |
      | 123    | Juan Tobon    | 42000          |
      | 111    | Luis Ramirez  | 150000         |
      | 222    | Danila Arango | 59000          |
      | 333    | Edgar Suarez  | 4233122        |
      | 244523 | Sofia Marquez | 453000         |
