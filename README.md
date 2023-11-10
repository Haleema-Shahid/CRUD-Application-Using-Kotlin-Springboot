# Team Service

## Overview

This Kotlin Spring Boot application provides functionality to manage teams and users through RESTful APIs. Users can be part of zero or more teams, and each team has one user as a team lead.

## Requirements

- Java 8 or higher
- Docker
- Docker Compose

## How to Run the Code

### Using Docker Compose

Alternatively, you can use Docker Compose to simplify the setup:

1. Clone the repository:

   ```bash
   git clone https://github.com/Haleema-Shahid/CRUD-Application-Using-Kotlin-Springboot.git
   ```

2. Navigate to the project directory:

   ```bash
   cd CRUD-Application-Using-Kotlin-Springboot
   ```

3. Run the Docker Compose:

   ```bash
   docker compose up
   ```

The application should be available at `http://localhost:8080`.

## Given API Endpoints

- **Users API:** `https://cgjresszgg.execute-api.eu-west-1.amazonaws.com/users/`
- **Teams API:** `https://cgjresszgg.execute-api.eu-west-1.amazonaws.com/teams/`

For detailed information about each entity, append the ID of a user or team to the respective API endpoint.

## Team Roles

The service introduces Team Roles, with three pre-defined roles:

1. Developer
2. Product Owner
3. Tester

"Developer" is set as the default role.

## Added API Endpoints

To load data (all users all developers by default)
-**/load** `http://localhost:8080/load`

To assign roles to product owners (assumption: team leads are product owners)
-**/assignRoles** `http://localhost:8080/assignRoles`

To assign role TESTER to user with given userId
-**/assignTesterRoleTo/{userID}** `http://localhost:8080/assignTesterRoleTo/{id}`

## Unit Tests

The project includes unit tests to ensure the correctness of the implemented functionalities.

## Improvements and Modifications

If modifications were possible to the Users or Teams APIs, the following requests could aid in enhancing this service:

1. **User API Modification Request:**
   - Include an API endpoint to retrieve a user's teams.

2. **Team API Modification Request:**
   - Include an API endpoint to retrieve team members.

## Recommendations

- **Validation and Edge Cases:**
  - Implemented thorough validation for input data.
  - Handled edge cases, including scenarios where data referenced is deleted.

- **REST API Tests:**
  - Implemented comprehensive REST API tests for all endpoints.

- **Architecture Considerations:**
  - Organized the codebase in a modular and scalable way.
  - Avoided placing business logic where it does not belong; followed separation of concerns.


## Contact

For any questions or issues, please contact Haleema Shahid at [haleemashahid20@gmail.com].
