package cn.com.liu.generate.helper;

/**
 * Created by liuzh on 2017/1/1.
 */
public class ColoumnEnity {
    private String coloumnName;//字段名
    private String coloumnName_o;//原表名
    private String coloumnName_p;//字段名参数
    private String coloumnType;//字段类型
    private String coloumnComments;//字段注释

    public String getColoumnName() {
        return coloumnName;
    }

    public void setColoumnName(String coloumnName) {
        this.coloumnName = coloumnName;
    }

    public String getColoumnName_p() {
        return coloumnName_p;
    }

    public void setColoumnName_p(String coloumnName_p) {
        this.coloumnName_p = coloumnName_p;
    }

    public String getColoumnType() {
        return coloumnType;
    }

    public void setColoumnType(String coloumnType) {
        this.coloumnType = coloumnType;
    }

    public String getColoumnComments() {
        return coloumnComments;
    }

    public void setColoumnComments(String coloumnComments) {
        this.coloumnComments = coloumnComments;
    }

    public String getColoumnName_o() {
        return coloumnName_o;
    }

    public void setColoumnName_o(String coloumnName_o) {
        this.coloumnName_o = coloumnName_o;
    }

    @Override
    public String toString() {
        return "ColoumnEnity{" +
                "coloumnName='" + coloumnName + '\'' +
                ", coloumnName_o='" + coloumnName_o + '\'' +
                ", coloumnName_p='" + coloumnName_p + '\'' +
                ", coloumnType='" + coloumnType + '\'' +
                ", coloumnComments='" + coloumnComments + '\'' +
                "}\n";
    }
}
