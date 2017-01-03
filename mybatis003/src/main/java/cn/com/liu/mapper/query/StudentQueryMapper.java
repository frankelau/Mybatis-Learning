package cn.com.liu.mapper.query;

import cn.com.liu.entity.Student;
import cn.com.liu.mapper.BaseQueryMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liuzh on 2017/1/2.
 */
@Repository
public class StudentQueryMapper extends SqlSessionDaoSupport implements BaseQueryMapper<Student> {
    private static final String NAMESPACE = "cn.com.liu.mapper.query.StudentQueryMapper.";

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public Student selectOne(int studentId) {
        Student student = getSqlSession().selectOne(NAMESPACE + "selectStudentById", 1);
        return student;
    }

    @Override
    public List<Student> selectList(Student student) {
        List<Student> list = getSqlSession().selectList(NAMESPACE + "selectList", student);
        return list;
    }
}
