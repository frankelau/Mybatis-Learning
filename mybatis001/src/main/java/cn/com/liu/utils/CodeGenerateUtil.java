package cn.com.liu.utils;

import cn.com.liu.generate.helper.ColoumnEnity;
import cn.com.liu.generate.helper.OracleTypes;
import cn.com.liu.generate.helper.TableEntity;
import cn.com.liu.jdbc.JdbcConfig;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Created by liuzh on 2017/1/1.
 */
public class CodeGenerateUtil {


    public static Map<String, TableEntity> getTableMetaData(Connection conn) {
        Map<String, TableEntity> tables = new HashMap<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            rs = conn.getMetaData().getTables(conn.getCatalog(), "SCOTT", null, new String[]{"TABLE"});
            //1.查询所有的表
            List<String> tableNames = new LinkedList<>();
            while (rs != null && rs.next()) {
                tableNames.add(rs.getString("TABLE_NAME"));
            }
            rs.close();
            TableEntity tableEntity = null;
            for (int i = 0; i < tableNames.size(); i++) {
                tableEntity = new TableEntity();
                String tableName = tableNames.get(i);
                tableEntity.setTableName(StringUtils.getCamelFormat1(tableName));
                tableEntity.setTableName_p(StringUtils.getCamelFormat2(tableName));
                tableEntity.setTableName_o(tableName);
                //2.1.查询表注释
                String sql1 = "SELECT TABLE_NAME,COMMENTS FROM USER_TAB_COMMENTS WHERE TABLE_NAME= ? ";
                ps = conn.prepareStatement(sql1);
                ps.setString(1, tableName);
                rs = ps.executeQuery();
                if (null != rs && rs.next()) {
                    tableEntity.setTableName_c(null == rs.getString("COMMENTS") ? "" : rs.getString("COMMENTS"));
                } else {
                    continue;
                }
                rs.close();
                ps.close();

                //2.2.查询列名、列类型、列注释
                String sql2 = "SELECT A.TABLE_NAME, B.COLUMN_NAME, A.COMMENTS, B.DATA_TYPE " +
                        "FROM USER_COL_COMMENTS A JOIN USER_TAB_COLUMNS B " +
                        "ON (A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME) " +
                        "WHERE A.TABLE_NAME = ?";
                ps = conn.prepareStatement(sql2);
                ps.setString(1, tableName);
                rs = ps.executeQuery();
                ColoumnEnity coloumnEnity = null;
                List<ColoumnEnity> coloumnList = new ArrayList<>();
                while (rs != null && rs.next()) {
                    coloumnEnity = new ColoumnEnity();
                    coloumnEnity.setColoumnName(StringUtils.getCamelFormat1(rs.getString("COLUMN_NAME")));
                    coloumnEnity.setColoumnName_p(StringUtils.getCamelFormat2(rs.getString("COLUMN_NAME")));
                    coloumnEnity.setColoumnName_o(rs.getString("COLUMN_NAME"));
                    coloumnEnity.setColoumnType(rs.getString("DATA_TYPE"));
                    coloumnEnity.setColoumnComments(null == rs.getString("COMMENTS") ? "" : rs.getString("COMMENTS"));
                    coloumnList.add(coloumnEnity);
                }
                tableEntity.setTableColoumnList(coloumnList);
                rs.close();
                ps.close();
                tables.put(tableName, tableEntity);
            }
            System.out.println(tables);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭数据库，结束进程
            DBUtils.releaseConnection(conn);
        }
        return tables;
    }

    /**
     * 生成实体bean代码
     *
     * @param table            表
     * @param absoluteFilePath 生成类绝对路径 eg: D:\\github_workspace\\Mybatis-Learning\\mybatis001\\src\\main\\java\\cn\\com\\liu\\entity
     * @param packageName      包名 eg:cn.com.liu.entity
     */
    public static void generateEntityClass(TableEntity table, String absoluteFilePath, String packageName) {
        try(
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(absoluteFilePath+"/"+table.getTableName()+".java"));
             ) {
            List<ColoumnEnity> coloumnList = table.getTableColoumnList();
            String user = System.getProperty("user.name");
            StringBuilder sb = new StringBuilder("package ");
            sb.append(packageName);
            sb.append(";\n");
            for (ColoumnEnity coloumnEnity : coloumnList) {
                String str = OracleTypes.valueOf(coloumnEnity.getColoumnType()).importClassName;
                if (!StringUtils.isEmpty(str)) {
                    sb.append(str);
                    sb.append("\n");
                }
            }
            sb.append("\n\n");
            sb.append("/**\n");
            sb.append(" * ");
            sb.append(table.getTableName_o());
            if (!StringUtils.isEmpty(table.getTableName_c())) {
                sb.append(": ");
                sb.append(table.getTableName_c());
            }
            sb.append("\n");
            sb.append(" * created by ");
            sb.append(user);
            sb.append(" on ");
            sb.append(StringUtils.getCurrentTime(DateFormats.YYYY_MM_DD_HH_MM_SS));
            sb.append(".\n*/\npublic class ");
            sb.append(table.getTableName());
            sb.append(" {\n");
            for (ColoumnEnity coloumnEnity : coloumnList) {
                String str = OracleTypes.valueOf(coloumnEnity.getColoumnType()).javaTypeName;
                sb.append("    /**");
                sb.append(coloumnEnity.getColoumnName_o());
                if(!StringUtils.isEmpty(coloumnEnity.getColoumnComments())){
                    sb.append(":");
                    sb.append(coloumnEnity.getColoumnComments());
                }
                sb.append("*/\n");
                sb.append("    private ");
                sb.append(str);
                sb.append(" ");
                sb.append(coloumnEnity.getColoumnName_p());
                sb.append(";\n");
            }
            sb.append("\n");
            //生成构造方法
            sb.append("    public ");
            sb.append(table.getTableName());
            sb.append("() {\n        super();\n    }\n\n");
            sb.append("    public ");
            sb.append(table.getTableName());
            sb.append("(");
            for (int i = 0;i<coloumnList.size();i++) {
                ColoumnEnity coloumnEnity = coloumnList.get(i);
                String str = OracleTypes.valueOf(coloumnEnity.getColoumnType()).javaTypeName;
                sb.append(str);
                sb.append(" ");
                sb.append(coloumnEnity.getColoumnName_p());
                if(i == coloumnList.size()-1){
                    sb.append(") {\n");
                }else{
                    sb.append(",");
                }
            }
            for (ColoumnEnity coloumnEnity : coloumnList) {
                String str = OracleTypes.valueOf(coloumnEnity.getColoumnType()).javaTypeName;
                sb.append("        this.");
                sb.append(coloumnEnity.getColoumnName_p());
                sb.append(" = ");
                sb.append(coloumnEnity.getColoumnName_p());
                sb.append(";\n");
            }
            sb.append("    }\n\n");
            //生成setter方法
            for (ColoumnEnity coloumnEnity : coloumnList) {
                String str = OracleTypes.valueOf(coloumnEnity.getColoumnType()).javaTypeName;
                sb.append("    /**");
                sb.append(coloumnEnity.getColoumnName_o());
                if(!StringUtils.isEmpty(coloumnEnity.getColoumnComments())){
                    sb.append(":");
                    sb.append(coloumnEnity.getColoumnComments());
                }
                sb.append("*/\n");
                sb.append("    public void set");
                sb.append(coloumnEnity.getColoumnName());
                sb.append("(");
                sb.append(str);
                sb.append(" ");
                sb.append(coloumnEnity.getColoumnName_p());
                sb.append(") {\n");
                sb.append("        this.");
                sb.append(coloumnEnity.getColoumnName_p());
                sb.append(" = ");
                sb.append(coloumnEnity.getColoumnName_p());
                sb.append(";\n");
                sb.append("    }\n\n");
            }
            sb.append("\n");
            //生成getter方法
            for (ColoumnEnity coloumnEnity : coloumnList) {
                String str = OracleTypes.valueOf(coloumnEnity.getColoumnType()).javaTypeName;
                sb.append("    /**");
                sb.append(coloumnEnity.getColoumnName_o());
                if(!StringUtils.isEmpty(coloumnEnity.getColoumnComments())){
                    sb.append(":");
                    sb.append(coloumnEnity.getColoumnComments());
                }
                sb.append("*/\n");
                sb.append("    public ");
                sb.append(str);
                sb.append(" get");
                sb.append(coloumnEnity.getColoumnName());
                sb.append("() {\n");
                sb.append("        return ");
                sb.append(coloumnEnity.getColoumnName_p());
                sb.append(";\n");
                sb.append("    }\n\n");
            }
            sb.append("\n");
            //生成toString方法
            sb.append("    @Override\n    public String toString() {\n        return \"");
            sb.append(table.getTableName());
            sb.append("{\" +\n");
            for (int i=0;i<coloumnList.size();i++) {
                ColoumnEnity coloumnEnity = coloumnList.get(i);
                if(0==i){
                    sb.append("                \"");
                }else{
                    sb.append("                \", ");
                }
                sb.append(coloumnEnity.getColoumnName_p());
                sb.append("='\" + ");
                sb.append(coloumnEnity.getColoumnName_p());
                sb.append(" + \"'\" +\n");
                if(coloumnList.size()-1==i){
                    sb.append("                \"}\";\n    }\n");
                }
            }
///**

// * Created by liuzh on 2017/1/1.
// */
//        public class User {
//            private String name;
//            private Integer age;
//
//            public String getName() {
//                return name;
//            }
//
//            public Integer getAge() {
//                return age;
//            }
//
//            public void setAge(Integer age) {
//                this.age = age;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//        }
//
            sb.append("}");
            bos.write(sb.toString().getBytes());
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
