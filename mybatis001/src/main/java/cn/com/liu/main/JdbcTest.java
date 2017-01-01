package cn.com.liu.main;


import cn.com.liu.utils.DBUtils;
import cn.com.liu.utils.SQLExecUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 传统jdbc使用
 * Created by liuzh on 2017/1/1.
 */
public class JdbcTest {
    public static void main(String[] args) {
        DBUtils dbUtils = new DBUtils();
        Connection conn = dbUtils.getConnection();
        try {
            SQLExecUtils seu = new SQLExecUtils();
            seu.setConn(conn);
            List<String> returnList = new ArrayList<>();
            returnList.add("EMPNO");
            returnList.add("ENAME");
            returnList.add("JOB");
            returnList.add("MGR");
            returnList.add("HIREDATE");
            returnList.add("SAL");
            returnList.add("COMM");
            returnList.add("DEPTNO");
            List<Map<String, Object>> list = seu.queryForList("select t.empno,t.ename,t.job,t.mgr,t.hiredate,t.sal,t.comm,t.deptno from emp t",new ArrayList(),returnList);
            System.out.println(list);
            String insertSQL="insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) values (?, ?, ?, ?, ?, ?, ?, ?)";
            List<Object> paramList = new ArrayList<>();
            paramList.add("7938");
            paramList.add(null);
            paramList.add("程序员");
            paramList.add("7782");
            paramList.add(new Date());
            paramList.add(BigDecimal.valueOf(1000.01d));
            paramList.add(1000.01d);
            paramList.add(20);
            int count = seu.insertOrUpdateOrDelete(insertSQL,paramList);
            System.out.println("插入"+count+"条");
            paramList.clear();
            paramList.add("7938");
            count =  seu.insertOrUpdateOrDelete("delete from emp where empno = ?",paramList);
            System.out.println("删除"+count+"条");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtils.releaseConnection(conn);
        }
    }
}
