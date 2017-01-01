package cn.com.liu.datasource;

import cn.com.liu.jdbc.JdbcConfig;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 数据库连接池
 * Created by liuzh on 2017/1/1.
 */
public class MyDataSource {

    private static final String dirverClassName = JdbcConfig.ORACLE_DRIVER;
    private static final String url = JdbcConfig.ORACLE_URL;
    private static final String user = JdbcConfig.USER_NAME;
    private static final String pswd = JdbcConfig.USER_PASSWD;
    //连接池
    private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());
    private static MyDataSource instance = new MyDataSource();

    static {
        try {
            Class.forName(dirverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动类！");
        }
    }

    private MyDataSource() {
    }

    /**
     * 获取数据源单例
     *
     * @return 数据源单例
     */
    public MyDataSource instance() {
        if (instance == null){
            synchronized(MyDataSource.class) {
                if(instance == null){
                    instance = new MyDataSource();
                }
            }
        }
        return instance;
    }

    /**
     * 获取一个数据库连接
     *
     * @return 一个数据库连接
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        synchronized (pool) {
            if (pool.size() > 0) return pool.removeFirst();
            else return makeConnection();
        }
    }

    /**
     * 连接归池
     *
     * @param conn
     */
    public static void freeConnection(Connection conn) {
        pool.addLast(conn);
    }

    private Connection makeConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pswd);
    }

    public Connection getConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    public void setLoginTimeout(int seconds) throws SQLException {

    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }



}
