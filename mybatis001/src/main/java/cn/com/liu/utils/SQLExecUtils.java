package cn.com.liu.utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by liuzh on 2017/1/1.
 */
public class SQLExecUtils {
    private Connection conn = null;

    public void setConn(Connection conn) {
        this.conn = conn;
    }


    /**
     * 增删改
     *
     * @param sql       eg:insert into user(name,age) values(?,?)
     *                  update user set age = age+? where id = ?
     *                  delete from  user  where id = ?
     * @param paramList
     * @return
     */
    public int insertOrUpdateOrDelete(String sql, List<Object> paramList) {
        if (null == conn) {
            System.out.println("尚未获得数据库链接。。。");
            return 0;
        } else {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                if(null != paramList){
                    for (int i = 0; i < paramList.size(); i++) {
                        Object o = paramList.get(i);
                        //此处根据需求增加
                        if(null==o){
                            ps.setString(i + 1, null);
                        }else if (o instanceof Integer) {
                            ps.setInt(i + 1, (Integer) paramList.get(i));
                        } else if (o instanceof Date) {
                            ps.setDate(i + 1, new java.sql.Date(((Date) paramList.get(i)).getTime()));
                        } else if (o instanceof BigDecimal) {
                            ps.setBigDecimal(i + 1, (BigDecimal) paramList.get(i));
                        } else if (o instanceof Double) {
                            ps.setDouble(i + 1, (Double) paramList.get(i));
                        } else {
                            ps.setString(i + 1, (String) paramList.get(i));
                        }
                    }
                }
                return ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    /**
     * 查询：
     *
     * @param sql        eg:select name,age from user where id = ?;
     * @param paramList  id值：6
     * @param returnList NAME,AGE（返回字段名称，大写）
     * @return
     */
    public List<Map<String, Object>> queryForList(String sql, List<Object> paramList, List<String> returnList) {
        List<Map<String, Object>> list = null;
        if (null == conn) {
            System.out.println("尚未获得数据库链接。。。");
            return null;
        } else {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                if(null != paramList){
                    for (int i = 0; i < paramList.size(); i++) {
                        Object o = paramList.get(i);
                        //此处根据需求增加
                        if(null==o){
                            ps.setString(i + 1, null);
                        }else if (o instanceof Integer) {
                            ps.setInt(i + 1, (Integer) paramList.get(i));
                        } else if (o instanceof Date) {
                            ps.setDate(i + 1, new java.sql.Date(((Date) paramList.get(i)).getTime()));
                        } else if (o instanceof BigDecimal) {
                            ps.setBigDecimal(i + 1, (BigDecimal) paramList.get(i));
                        } else if (o instanceof Double) {
                            ps.setDouble(i + 1, (Double) paramList.get(i));
                        } else {
                            ps.setString(i + 1, (String) paramList.get(i));
                        }
                    }
                }
                ResultSet rs = ps.executeQuery();
                Map<String,Object> map = null;
                list = new ArrayList<>();
                while (null != rs && rs.next()) {
                    map = new HashMap<>();
                    for(String str:returnList){
                        map.put(str,rs.getString(str));
                    }
                    list.add(map);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


}
