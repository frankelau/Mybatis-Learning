package cn.com.liu.entity;
import java.util.Date;


/**
 * EMP
 * created by liuzh on 2017-01-01 18:14:48.
*/
public class Emp {
    /**EMPNO*/
    private Integer empno;
    /**ENAME*/
    private String ename;
    /**JOB*/
    private String job;
    /**MGR*/
    private Integer mgr;
    /**HIREDATE*/
    private Date hiredate;
    /**SAL*/
    private Integer sal;
    /**COMM*/
    private Integer comm;
    /**DEPTNO*/
    private Integer deptno;

    /**EMPNO*/
    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    /**ENAME*/
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**JOB*/
    public void setJob(String job) {
        this.job = job;
    }

    /**MGR*/
    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    /**HIREDATE*/
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    /**SAL*/
    public void setSal(Integer sal) {
        this.sal = sal;
    }

    /**COMM*/
    public void setComm(Integer comm) {
        this.comm = comm;
    }

    /**DEPTNO*/
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }


    /**EMPNO*/
    public Integer getEmpno() {
        return empno;
    }

    /**ENAME*/
    public String getEname() {
        return ename;
    }

    /**JOB*/
    public String getJob() {
        return job;
    }

    /**MGR*/
    public Integer getMgr() {
        return mgr;
    }

    /**HIREDATE*/
    public Date getHiredate() {
        return hiredate;
    }

    /**SAL*/
    public Integer getSal() {
        return sal;
    }

    /**COMM*/
    public Integer getComm() {
        return comm;
    }

    /**DEPTNO*/
    public Integer getDeptno() {
        return deptno;
    }


    @Override
    public String toString() {
        return "Emp{" +
                "empno='" + empno + "'" +
                ", ename='" + ename + "'" +
                ", job='" + job + "'" +
                ", mgr='" + mgr + "'" +
                ", hiredate='" + hiredate + "'" +
                ", sal='" + sal + "'" +
                ", comm='" + comm + "'" +
                ", deptno='" + deptno + "'" +
                "}";
    }
}