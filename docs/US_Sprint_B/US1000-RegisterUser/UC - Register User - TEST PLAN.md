# US 1000 - As Administrator, I want to be able to register, disable/enable, and list users of the backoffice


## Test Plan
### 1. Sequence Diagram (SSD)



	TEST PLAN

	_______________________________
	CASO #2: Change Dish
	_______________________________

	1. Fazer o login como chef/Password1
	2. Escolher a op��o Dishes > Change DishInformation
	3. Escolher a op��o Change Nutricional Info
	4. Mostrar todos os pratos e seu estado
	5. Escolher Dish a atualizar a informa��o nutricional
	6. Escolher a op��o Dishes > Change DishInformation
	7. Escolher a op��o Change Price
	8. Escolher Dish a atualizar o pre�o
	9. Confirmar as atualiza���es efetuadas1 atrav�s de List Dishes (Dish  >  List Dish)




	ANÁLISE
	____________


	Reunião com o cliente  em 2024.03.21

	* Garantir que é usado o email para identificar qualquer utilizador do sistema. (Admin, Customer Manager, Operator)
	* É importante para cada utilizador termos o nome completo. (Customer manager, Candidate)
	* Necessário nome e endereço para empresa (Customer)


	______________________

	REGRAS DE NEGÓCIO
	_____________________


	* Não � possivel alterar informa��o sensivel do prato como o seu nome (Name) e o seu tipo (DishType)


	______________________
		
	TESTES UNIT�RIOS
	_____________________


	* testchangeNutricionalInfoToMustNotBeNull
	* testchangePriceToMustNotBeNull
	* testchangePriceToCanNotBeNegative