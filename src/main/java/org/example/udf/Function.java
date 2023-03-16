package org.example.udf;

import java.io.Serializable;

public class Function implements Serializable {

    public static String combineStrings(String a, String b) {
        return a.concat(b);
    }
}
