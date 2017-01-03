package cn.com.liu.mapper.update;

import cn.com.liu.entity.Student;
import cn.com.liu.mapper.BaseUpdateMapper;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by liuzh on 2017/1/2.
 */
public class StudentUpdateMapper extends BaseUpdateMapper {
    private static StudentUpdateMapper instance = new StudentUpdateMapper();
    private static final String NAMESPACE = "cn.com.liu.mapper.update.StudentUpdateMapper.";

    private StudentUpdateMapper() {

    }

    public static StudentUpdateMapper getInstance() {
        return instance;
    }


    public int updateStudentById(Student student) {
        SqlSession ss = ssf.openSession();
        int i = 0;
        try {
            i = ss.update(NAMESPACE+"updateStudentById", student);
            ss.commit();
        } finally {
            ss.close();
        }
        return i;
    }
    public int insertStudent(Student student) {
        SqlSession ss = ssf.openSession();
        int i = 0;
        try {
            i = ss.insert(NAMESPACE+"insertStudent", student);
            ss.commit();
        } finally {
            ss.close();
        }
        return i;
    }

}
