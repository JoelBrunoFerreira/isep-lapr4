UseCase explanation --> Disable a Candidate:

    Operator: The actor initiating the use case.

    OperatorMainMenu (UI): Presentation layer where the operator selects the option to disable a candidate.
    DeactivateUserController (Controller): Application layer managing the deactivation process.
    SystemUser (Domain): Domain layer representing the user entity.
    PersistenceContext (Persistence): Persistence layer managing the repository context.
    RepositoryFactory (Factory): Factory creating the appropriate repositories.
    UserRepository (Repository): Repository where the user data is saved.

Steps:

    The Operator selects "Disable a Candidate" from the OperatorMainMenu.
    The OperatorMainMenu calls the deactivateUserAction() method on the DeactivateUserController.
    The DeactivateUserController retrieves the list of active users from the SystemUser domain.
    The OperatorMainMenu asks the Operator for the candidate number.
    The Operator provides the candidate number.
    If the option is not 0, the OperatorMainMenu shows the list of active users.
    The Operator selects the user to deactivate.
    The OperatorMainMenu calls the deactivateUser(selectedUser) method on the DeactivateUserController.
    The DeactivateUserController deactivates the user.
    The DeactivateUserController interacts with the PersistenceContext to get the repository context.
    The PersistenceContext creates the repository factory.
    The DeactivateUserController gets the user repository from the factory.
    The DeactivateUserController saves the deactivated user in the UserRepository.
    The DeactivateUserController returns the user to the OperatorMainMenu.
    The OperatorMainMenu displays the user info to the Operator.