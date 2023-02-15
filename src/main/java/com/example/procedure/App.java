package com.example.procedure;

import com.example.util.LocalSession;
import com.snowflake.snowpark_java.*;
import com.snowflake.snowpark_java.types.DataTypes;
import com.snowflake.snowpark_java.types.StructField;
import com.snowflake.snowpark_java.types.StructType;
import com.example.udf.Function;


public class App 
{

    public static void run(Session session) {
        DataFrame df = session.createDataFrame(
            new Row[]{
                Row.create("Welcome to", "Snowflake!"),
                Row.create("Get started", "http://www.snowflake.com/etc")
            },
            StructType.create(
                new StructField("Hello", DataTypes.StringType),
                new StructField("World", DataTypes.StringType))
        );

        df
            .select(Function.myUdf.apply(
                Functions.col("Hello"),
                Functions.col("World")))
            .show();

        session.close();
    }

    public static void main(String[] args) {
        Session session = LocalSession.getLocalSession();

        App.run(session);
    }
}
