package cn.com.liu.mapper.update;

import cn.com.liu.entity.Student;
import cn.com.liu.mapper.BaseUpdateMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by liuzh on 2017/1/2.
 */
@Repository
public class StudentUpdateMapper extends SqlSessionDaoSupport implements BaseUpdateMapper<Student> {
    private static final String NAMESPACE = "cn.com.liu.mapper.update.StudentUpdateMapper.";

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public int updateById(Student student) {
        return getSqlSession().update(NAMESPACE+"updateStudentById", student);
    }
    public int insert(Student student) {
        return getSqlSession().insert(NAMESPACE+"insertStudent", student);
    }

}
