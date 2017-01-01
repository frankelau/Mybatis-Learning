package cn.com.liu.generate.helper;

import java.util.List;

/**
 * Created by liuzh on 2017/1/1.
 */
public class TableEntity {
    private String tableName;//表名
    private String tableName_o;//表类名
    private String tableName_p;//表名参数
    private String tableName_c;//表注释

    private List<ColoumnEnity> tableColoumnList;//字段列表


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName_p() {
        return tableName_p;
    }

    public void setTableName_p(String tableName_p) {
        this.tableName_p = tableName_p;
    }

    public String getTableName_c() {
        return tableName_c;
    }

    public void setTableName_c(String tableName_c) {
        this.tableName_c = tableName_c;
    }

    public String getTableName_o() {
        return tableName_o;
    }

    public void setTableName_o(String tableName_o) {
        this.tableName_o = tableName_o;
    }

    public List<ColoumnEnity> getTableColoumnList() {
        return tableColoumnList;
    }

    public void setTableColoumnList(List<ColoumnEnity> tableColoumnList) {
        this.tableColoumnList = tableColoumnList;
    }

    @Override
    public String toString() {
        return "TableEntity{" +
                "tableName='" + tableName + '\'' +
                ", tableName_o='" + tableName_o + '\'' +
                ", tableName_p='" + tableName_p + '\'' +
                ", tableName_c='" + tableName_c + '\'' +
                ", tableColoumnList=" + tableColoumnList +
                "}\n";
    }
}
