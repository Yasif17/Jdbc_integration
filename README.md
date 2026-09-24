# JDBC Integration - Product Management

Simple Java project to connect to a MySQL database using JDBC and perform basic CRUD operations (Create, Read, Update, Delete) on a product table.

## What this project does

- Connects to a MySQL database using JDBC
- Creates a `product` table if it doesn't already exist
- Lets you insert, view, update, and delete product records
- Uses PreparedStatement everywhere to avoid SQL injection

## Tech used

- Java 11
- MySQL 8
- mysql-connector-j (JDBC driver)
- Maven

## Setup Instructions

1. Make sure MySQL Server is installed and running on your machine.

2. Open MySQL Workbench and create a new schema called `jdbc_demo`.
   (You can also just run the schema.sql file included in this project.)

3. Open the project in IntelliJ and let Maven download the dependencies from `pom.xml`.

4. Open `DatabaseConnection.java` and update these two lines with your own MySQL username and password:

```java
String user = "root";
String password = "whatever your password is";
```

5. Run `Main.java`. This will:
   - Create the `product` table (if it does not exist)
   - Run a few sample insert/update/delete/select operations

6. Open MySQL Workbench and run:

```sql
SELECT * FROM product;
```

to check that the data matches what was printed in the console.

## Project structure

```
src/
 └── org/com/jdbc_integration/
      ├── config/
      │    └── DatabaseConnection.java   -> handles connecting to MySQL
      ├── dao/
      │    └── ProductDao.java           -> insert, get, update, delete methods
      └── Main.java                      -> runs and tests everything
schema.sql                               -> CREATE TABLE statement
```

## Notes

- All queries use PreparedStatement so user input can't break or inject into the SQL.
- Connections and statements are closed automatically using try-with-resources.
- If a connection fails, check that MySQL is running and that the username/password in `DatabaseConnection.java` are correct.
