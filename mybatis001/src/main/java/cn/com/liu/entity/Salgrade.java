package cn.com.liu.entity;


/**
 * SALGRADE
 * created by liuzh on 2017-01-01 18:14:48.
*/
public class Salgrade {
    /**GRADE*/
    private Integer grade;
    /**LOSAL*/
    private Integer losal;
    /**HISAL*/
    private Integer hisal;

    /**GRADE*/
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**LOSAL*/
    public void setLosal(Integer losal) {
        this.losal = losal;
    }

    /**HISAL*/
    public void setHisal(Integer hisal) {
        this.hisal = hisal;
    }


    /**GRADE*/
    public Integer getGrade() {
        return grade;
    }

    /**LOSAL*/
    public Integer getLosal() {
        return losal;
    }

    /**HISAL*/
    public Integer getHisal() {
        return hisal;
    }


    @Override
    public String toString() {
        return "Salgrade{" +
                "grade='" + grade + "'" +
                ", losal='" + losal + "'" +
                ", hisal='" + hisal + "'" +
                "}";
    }
}