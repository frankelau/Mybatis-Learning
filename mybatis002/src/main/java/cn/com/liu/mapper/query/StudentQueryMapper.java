package cn.com.liu.mapper.query;

import cn.com.liu.entity.Student;
import cn.com.liu.mapper.BaseQueryMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by liuzh on 2017/1/2.
 */
public class StudentQueryMapper extends BaseQueryMapper {
    private static StudentQueryMapper instance = new StudentQueryMapper();

    private StudentQueryMapper() {

    }

    public static StudentQueryMapper getInstance() {
        return instance;
    }


    public Student selectStudentById(int studentId) {
        SqlSession ss = ssf.openSession();
        Student student = null;
        try {
            student = ss.selectOne("cn.com.liu.mapper.query.StudentQueryMapper.selectStudentById", 1);
        } finally {
            ss.close();
        }
        return student;
    }
    public List<Student> selectList(Student student) {
        List<Student> list = null;
        SqlSession ss = ssf.openSession();
        try {
            list = ss.selectList("cn.com.liu.mapper.query.StudentQueryMapper.selectList", student);
        } finally {
            ss.close();
        }
        return list;
    }
}
