# InsuranceApp

The Insurance App is a web-based application built with Spring Boot and Java. It provides functionality to manage insurance policies, clients, and claims. This application allows users to create, view, update, and delete insurance policies, clients, and claims, and provides a user-friendly interface to interact with the system.

## Features

- Create, view, update, and delete insurance policies
- Create, view, update, and delete clients
- Create, view, update, and delete claims
- Associate claims with insurance policies and clients
- Search and filter insurance policies, clients, and claims
- User-friendly web interface

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- HTML/CSS

## Prerequisites

- Java 8 or above
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse)

## Getting Started

To run the Insurance Management Platform locally, follow these steps:

1. Clone the repository.
2. Import the project into your preferred IDE.
3. Build the project using Maven.
4. Run the application.
5. Access the application in your browser at `http://localhost:8072`.

## Configuration

The application uses an H2 in-memory database by default. You can change the database configuration in the `application.properties` file.

## Testing

The Insurance App has been thoroughly tested using Selenium, a powerful testing tool for web applications. The automated tests cover various aspects of the application to ensure its functionality and reliability.

### Selenium Testing

We have used Selenium to perform automated tests on the Insurance App. These tests include:

- End-to-end testing of critical workflows
- User interface testing to ensure a seamless experience
- Functional testing of key features

### How to Run Tests

To run the Selenium tests locally, follow these steps:

1. Ensure you have the required dependencies installed.
2. Configure the test environment.
3. Run the Selenium tests.

## Contributing

Contributions are welcome! If you find any issues or want to add new features, please feel free to open an issue or submit a pull request.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Bootstrap](https://getbootstrap.com/)
