package cn.com.liu.utils;

import cn.com.liu.jdbc.JdbcConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by liuzh on 2017/1/1.
 */
public class DBUtils {
    private Connection connection = null;
    private static String url = "";

    static {
        try {
            Class.forName(JdbcConfig.ORACLE_DRIVER);//实例化oracle数据库驱动程序(建立中间件)
            url = JdbcConfig.ORACLE_URL;//@localhost为服务器名，sjzwish为数据库实例名
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public Connection getConnection() {
        if(connection == null){
            try {
                connection = DriverManager.getConnection(url, JdbcConfig.USER_NAME, JdbcConfig.USER_PASSWD);//连接数据库，a代表帐户,a代表密码
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    /**
     *释放数据库连接
     * @param conn
     */
    public static void releaseConnection(Connection conn) {
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
