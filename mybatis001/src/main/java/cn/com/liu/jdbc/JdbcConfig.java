package cn.com.liu.jdbc;

import java.util.ResourceBundle;

/**
 * Created by liuzh on 2017/1/1.
 */
public class JdbcConfig {
    private static final String JDBC_DRIVER = "jdbc.driver";
    private static final String JDBC_URL = "jdbc.url";
    private static final String JDBC_USER = "jdbc.user";
    private static final String JDBC_PASSWORD = "jdbc.password";
    public static String ORACLE_DRIVER = "";
    public static String ORACLE_URL = "";
    public static String USER_NAME = "";
    public static String USER_PASSWD = "";

    static {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        ORACLE_DRIVER = rb.getString(JDBC_DRIVER);
        ORACLE_URL = rb.getString(JDBC_URL);
        USER_NAME = rb.getString(JDBC_USER);
        USER_PASSWD = rb.getString(JDBC_PASSWORD);
    }

    public static void main(String[] args) {
        System.out.println(ORACLE_DRIVER);
        System.out.println(ORACLE_URL);
        System.out.println(USER_NAME);
        System.out.println(USER_PASSWD);
    }
}