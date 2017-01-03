package cn.com.liu.entity;


/**
 * STUDENT: 学生表
 * created by liuzh on 2017-01-02 16:59:22.
*/
public class Student {
    /**STUDENTID:学生ID*/
    private Integer studentid;
    /**STUDENTNAME:学生姓名*/
    private String studentname;
    /**STUDENTAGE:学生年龄*/
    private Integer studentage;
    /**STUDENTPHONE:学生手机号*/
    private String studentphone;

    /** 无参构造方法 */
    public Student() {
        super();
    }

    /** 有参构造方法 */
    public Student(Integer studentid,String studentname,Integer studentage,String studentphone) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.studentage = studentage;
        this.studentphone = studentphone;
    }

    /**STUDENTID:学生ID*/
    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    /**STUDENTNAME:学生姓名*/
    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    /**STUDENTAGE:学生年龄*/
    public void setStudentage(Integer studentage) {
        this.studentage = studentage;
    }

    /**STUDENTPHONE:学生手机号*/
    public void setStudentphone(String studentphone) {
        this.studentphone = studentphone;
    }


    /**STUDENTID:学生ID*/
    public Integer getStudentid() {
        return studentid;
    }

    /**STUDENTNAME:学生姓名*/
    public String getStudentname() {
        return studentname;
    }

    /**STUDENTAGE:学生年龄*/
    public Integer getStudentage() {
        return studentage;
    }

    /**STUDENTPHONE:学生手机号*/
    public String getStudentphone() {
        return studentphone;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentid='" + studentid + "'" +
                ", studentname='" + studentname + "'" +
                ", studentage='" + studentage + "'" +
                ", studentphone='" + studentphone + "'" +
                "}";
    }
}