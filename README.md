<p align="center">
  <h1 align="center">Personalized Data Core v0.1</h1>

This is a spring boot application for a personalized data REST API service that provides shoppers personalized
information to eCommerce servers.

The service consists of 2 main parts:

1. Interface with data team (internal) - Receiving shoppers’ personalized information and product metadata from our data
   team and storing it in a specified database.
2. Interface with eCommerce (external) - Provide fast-reading operation for the shoppers’ personalized information.
   ![image](https://github.com/thilina999/personalized-data-core/assets/28834233/7c39ba15-a973-4c09-b57a-62b9fe22ec9d)

## Built With

* Build: Gradle
* [Spring boot 3.3.1](https://spring.io/projects/spring-boot)</br>
    - [Spring JPA](https://spring.io/projects/spring-data-jpa) | [Spring Security](https://spring.io/projects/spring-security) |
      Lombok

* [PosrgresSQL](https://www.postgresql.org/)

* Java Version (Java 17)

#### Spring Initializr

![init](https://github.com/thilina999/personalized-data-core/assets/28834233/6dd37f64-86db-4636-b448-e4fb10f9f414)

<!-- FUNCTIONS -->

## Functions

1. ADD product metadata
2. ADD shoppers’ personalized information
3. GET personalized information by shopper
    1. Filter by Category & Brand
    2. Limit (default - 10, max - 100)

<!-- LICENSE -->
<!-- ## License

Distributed under the MIT License. See `LICENSE` for more information.

 -->

<!-- CONTACT -->

## Contact

[Thilina Dissanayake](mailto:thilinad.contact@gmail.com)

Link: [https://github.com/thilina999/personalized-data-core](https://github.com/thilina999/personalized-data-core)
