<p align="center">
  <h1 align="center">Personalized Data Core v1.0</h1>

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

## Quick start
### Prerequisites

This assumes that you already have:

- [Gradle](https://gradle.org/install/) installed
- [Java 17](https://adoptium.net/installation/) installed and configured as the current Java version for the environment.
  Verify that `java -version` outputs version 17 and ensure that the `JAVA_HOME` environment variable is set to the Java
  installation directory containing `bin`.
- [Redis](https://redis.io/docs/latest/operate/oss_and_stack/install/install-redis/) installed and running


### Clone the repository

```
git clone https://github.com/thilina999/personalized-data-core.git
```

### Build the project
Open the project in IntelliJ(or any other IDEA), which will automatically build it

### Run the project
Open `application.properties` file. Update valid database connection details and make sure `spring.jpa.hibernate.ddl-auto` is set to `create` when running the application for the first time. 
Run the `PersonalizedDataCoreApp` class to run the application. This will start the application and create the required entities in the database.

## Rest API Endpoints

#### Add Product Metadata

`POST` - [http://localhost:8080/internal/api/v1/product-metadata](http://localhost:8080/internal/api/v1/product-metadata)

Request body
```application/json
{
    "productId": "BB-2144746855",
    "category": "Babies",
    "brand": "Babyom"
}
```

#### Add Product Metadata

`POST` - [http://localhost:8080/internal/api/v1/shopper-products](http://localhost:8080/internal/api/v1/shopper-products)

Request body
```application/json
{
    "shopperId": "S-1000",
    "shelf": [
        {
            "productId": "BB-2144746855",
            "relevancyScore": 55.16626010671777
        }
    ]
}
```

#### Add Product Metadata

`GET` - [http://localhost:8080/external/api/v1/products?shopperId=S-1000](http://localhost:8080/external/api/v1/products?shopperId=S-1000)

`GET` - [http://localhost:8080/external/api/v1/products?shopperId=S-1000&category=Books&brand=BrandH&limit=3000](http://localhost:8080/external/api/v1/products?shopperId=S-1000&category=Books&brand=BrandH&limit=3000)

Request Header

`Authorization: Basic (Username: actuator, Password: !data2024)`

Response Body
```application/json
[
{
    "productId": "BB-2144746855",
    "category": "Babies",
    "brand": "Babyom"
},
...
]
```
##### Import API collection at `src/main/resources/postman` to try with Postman 


<!-- LICENSE -->
<!-- ## License

Distributed under the MIT License. See `LICENSE` for more information.

 -->

<!-- CONTACT -->

## Contact

[Thilina Dissanayake](mailto:thilinad.contact@gmail.com)

Link: [https://github.com/thilina999/personalized-data-core](https://github.com/thilina999/personalized-data-core)
