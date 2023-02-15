# Java 11 Project Template for Snowflake

Use this project template to start writing data applications on Snowflake using Java 11.

## Start Here

First, set your account URL, username, role, database, and schema in [app.properties](src/main/resources/dev.properties).

Next, set an environment variable with your Snowflake password:

```bash
# Linux/MacOS
set SNOWFLAKE_PASSWORD=<your-password>
```

```PowerShell
# Windows
$env:SNOWFLAKE_PASSWORD = <your-password>
```

## Project Structure

- [procedure/](src/main/java/com/example/procedure/): Your stored procedures
- [udf/](src/main/java/com/example/udf/): Your user-defined functions
- [deploy.yml](.github/workflows/deploy.yaml): Deploys your Java procs and UDFs

## Docs

- [Snowpark JavaDoc](https://docs.snowflake.com/en/developer-guide/snowpark/reference/java/index.html)
- [Developer Guide](https://docs.snowflake.com/developer-guide/snowpark/java/index.html)
  - [Writing Stored Procedures](https://docs.snowflake.com/en/sql-reference/stored-procedures-java.html) ... This isn't linked in the dev guide?
