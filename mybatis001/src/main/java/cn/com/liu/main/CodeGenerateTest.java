package cn.com.liu.main;


import cn.com.liu.generate.helper.TableEntity;
import cn.com.liu.utils.CodeGenerateUtil;
import cn.com.liu.utils.DBUtils;

import java.sql.Connection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 传统jdbc使用
 * Created by liuzh on 2017/1/1.
 */
public class CodeGenerateTest {
    public static void main(String[] args) {
        DBUtils dbUtils = new DBUtils();
        Connection conn = dbUtils.getConnection();
        Map<String, TableEntity> tables = CodeGenerateUtil.getTableMetaData(conn);
        System.out.println(tables);
        Set<String> keys = tables.keySet();
        Iterator iterator = keys.iterator();
        while (null != iterator && iterator.hasNext()) {
            CodeGenerateUtil.generateEntityClass(tables.get(iterator.next()), "D:/github_workspace/Mybatis-Learning/mybatis001/src/main/java/cn/com/liu/entity", "cn.com.liu.entity");
        }
    }
}
