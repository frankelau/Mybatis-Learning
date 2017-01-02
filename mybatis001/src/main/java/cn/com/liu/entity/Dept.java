package cn.com.liu.entity;


/**
 * DEPT
 * created by liuzh on 2017-01-01 18:14:48.
*/
public class Dept {
    /**DEPTNO*/
    private Integer deptno;
    /**DNAME*/
    private String dname;
    /**LOC*/
    private String loc;

    /**DEPTNO*/
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    /**DNAME*/
    public void setDname(String dname) {
        this.dname = dname;
    }

    /**LOC*/
    public void setLoc(String loc) {
        this.loc = loc;
    }


    /**DEPTNO*/
    public Integer getDeptno() {
        return deptno;
    }

    /**DNAME*/
    public String getDname() {
        return dname;
    }

    /**LOC*/
    public String getLoc() {
        return loc;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "deptno='" + deptno + "'" +
                ", dname='" + dname + "'" +
                ", loc='" + loc + "'" +
                "}";
    }
}