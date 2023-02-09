package com.example.udf;

import com.snowflake.snowpark_java.Functions;
import com.snowflake.snowpark_java.UserDefinedFunction;
import com.snowflake.snowpark_java.types.DataType;
import com.snowflake.snowpark_java.types.DataTypes;

import java.io.Serializable;

public class Function implements Serializable {

    public static UserDefinedFunction myUdf = Functions.udf(
        (String a, String b) -> Function.combineStrings(a,b),
        new DataType[]{DataTypes.StringType, DataTypes.StringType},
        DataTypes.StringType
    );

    private static String combineStrings(String a, String b) {
        return a.concat(b);
    }

}
