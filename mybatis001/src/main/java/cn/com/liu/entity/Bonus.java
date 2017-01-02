package cn.com.liu.entity;


/**
 * BONUS: 奖励表
 * created by liuzh on 2017-01-01 18:14:48.
*/
public class Bonus {
    /**ENAME:员工姓名*/
    private String ename;
    /**JOB:工作*/
    private String job;
    /**SAL:薪水*/
    private Integer sal;
    /**COMM:奖励*/
    private Integer comm;

    /**ENAME:员工姓名*/
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**JOB:工作*/
    public void setJob(String job) {
        this.job = job;
    }

    /**SAL:薪水*/
    public void setSal(Integer sal) {
        this.sal = sal;
    }

    /**COMM:奖励*/
    public void setComm(Integer comm) {
        this.comm = comm;
    }


    /**ENAME:员工姓名*/
    public String getEname() {
        return ename;
    }

    /**JOB:工作*/
    public String getJob() {
        return job;
    }

    /**SAL:薪水*/
    public Integer getSal() {
        return sal;
    }

    /**COMM:奖励*/
    public Integer getComm() {
        return comm;
    }


    @Override
    public String toString() {
        return "Bonus{" +
                "ename='" + ename + "'" +
                ", job='" + job + "'" +
                ", sal='" + sal + "'" +
                ", comm='" + comm + "'" +
                "}";
    }
}