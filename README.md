# Java 11 Project Template for Snowflake

Use this project template to start writing data applications on Snowflake using Java 11.

## Start Here

### Prerequisites

To develop your applications locally, you will need

- A Snowflake account
- [Java 11](https://adoptium.net/temurin/releases/?version=11)
- An IDE or code editor (IntelliJ, VS Code, Eclipse)

### Set credentials

Set the following environment variables with your Snowflake account information:

```bash
# Linux/MacOS
set SNOWSQL_ACCOUNT=<replace with your account identifer>
set SNOWSQL_USER=<replace with your username>
set SNOWSQL_PWD=<replace with your password>
set SNOWSQL_DATABASE=<replace with your database>
set SNOWSQL_SCHEMA=<replace with your schema>
set SNOWSQL_WAREHOUSE=<replace with your warehouse>
```

```powershell
# Windows/PowerShell
$env:SNOWSQL_ACCOUNT = "<replace with your account identifer>"
$env:SNOWSQL_USER = "<replace with your username>"
$env:SNOWSQL_PWD = "<replace with your password>"
$env:SNOWSQL_DATABASE = "<replace with your database>"
$env:SNOWSQL_SCHEMA = "<replace with your schema>"
$env:SNOWSQL_WAREHOUSE = "<replace with your warehouse>"
```

Optional: You can set this env var permanently by editing your bash profile (on Linux/MacOS) or using the System Properties menu (on Windows).

### Test connection

Once you've set your credentials, you can test your connection by running the `run()` command in [`App.java`](src/main/java/org/example/procedure/App.java). You can run this method directly from your IDE.

You should see the following output in your terminal:

```log
---------------------------------------------------
|"Hello world"                                    |
---------------------------------------------------
|Welcome to Snowflake!                            |
|Learn more: https://www.snowflake.com/snowpark/  |
---------------------------------------------------
```

### Deploy the contents

The GitHub Actions [workflow file](.github/workflows/build-and-deploy.yml) allows you to continously deploy your objects to Snowflake. When you're ready, create secrets in your GitHub repository with the same name and values as the environment variables you created earler (`SNOWSQL_PWD`, `SNOWSQL_ACCOUNT`, etc.). The workflow will create a stage, upload the compiled .jar, and create the stored procedure object. For more information, see [`resources.sql`](resources.sql).

## Project Structure

- [procedure/](src/main/java/org/example/procedure/): Directory for your stored procedures
- [udf/](src/main/java/org/example/udf/): Directory for your user-defined functions
- [util/](src/main/java/org/example/util/): Directory for methods/classes shared between procedures and UDFs
- [resources.sql](resources.sql): A deployment script for your objects
- [build-and-deploy.yaml](.github/workflows/build-and-deploy.yml): A GitHub Actions template to build and deploy your objects

## Docs

- [Snowpark JavaDoc](https://docs.snowflake.com/en/developer-guide/snowpark/reference/java/index.html)
- [Developer Guide](https://docs.snowflake.com/developer-guide/snowpark/java/index.html)
- [Writing Stored Procedures](https://docs.snowflake.com/en/sql-reference/stored-procedures-java.html)
