package org.example.procedure;

import org.example.util.LocalSession;
import com.snowflake.snowpark_java.*;
import com.snowflake.snowpark_java.types.DataType;
import com.snowflake.snowpark_java.types.DataTypes;
import com.snowflake.snowpark_java.types.StructField;
import com.snowflake.snowpark_java.types.StructType;
import org.example.udf.Function;


public class App 
{

    public static Integer run(Session session) {
        DataFrame df = session.createDataFrame(
            new Row[]{
                Row.create("Welcome to ", "Snowflake!"),
                Row.create("Learn more: ", "https://www.snowflake.com/snowpark/")
            },
            StructType.create(
                new StructField("Hello", DataTypes.StringType),
                new StructField("World", DataTypes.StringType))
        );

        UserDefinedFunction combine = session.udf().registerTemporary(
            (String a, String b) -> Function.combineStrings(a,b),
            new DataType[]{DataTypes.StringType, DataTypes.StringType},
            DataTypes.StringType);

        df.select(
            combine.apply(
                Functions.col("Hello"),
                Functions.col("World"))
            )
        .show();

        return 1;
    }

    public static void main(String[] args) {
        Session session = LocalSession.getLocalSession();

        App.run(session, "");
    }
}
