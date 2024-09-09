ms_example_clean_architecture

Consta de un servicio back sencillo desarrollo en Spring WebFlux, haciendo uso del Plugin de arquitectura limpia Bancolombia scaffold.
Inicialmente se construye usando malas practicas de desarrollo comunes a pesar de que estemos aplicando arquitectura limpia.

Rama master: Contiene el inicio del desarrollo con malas practicas completamente.
Rama feature/01_handle_refactor: Contiene la refactorización a la clase Handler en cargada de manejar la solicitud entrante desde algún cliente.
Rama feature/02_usecase_refactor: Contiene la refactorización del caso de uso de la aplicación.
Rama feature/03_model_refactor: Contiene la refactorización del modelo, las reglas de negocio.
Rama feature/04_adapter_refactor: Contiene la refactorización de los adaptadores usandos en la aplicación. 
Rama feature/05_inversion_of_control: Se aplica principio inversión de control (IoC).
