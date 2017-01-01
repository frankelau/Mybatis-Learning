package cn.com.liu.generate.helper;


/**
 * Created by liuzh on 2017/1/1.
 */
public enum OracleTypes {
    INTEGER(
            "INTEGER",
            "Integer",
            ""
    ),
    CHAR(
            "CHAR",
            "String",
            ""
    ),
    VARCHAR(
            "VARCHAR",
            "String",
            ""
    ),
    DATE(
            "DATE",
            "Date",
            "import java.util.Date;"
    ),
    VARCHAR2(
            "VARCHAR2",
            "String",
            ""
    ),
    NUMBER(
            "NUMBER",
            "Integer",
            ""
    );


    public String oracleTypeName;
    public String importClassName;
    public String javaTypeName;

    private OracleTypes(String oracleTypeName, String javaTypeName, String importClassName) {
        this.oracleTypeName = oracleTypeName;
        this.javaTypeName = javaTypeName;
        this.importClassName = importClassName;
    }


    public static void main(String[] args) {
        System.out.println(OracleTypes.valueOf("CHAR").javaTypeName);
    }
}
