package cn.com.liu.mapper;

import java.util.List;

public interface BaseQueryMapper<T> {
    T selectOne(int id);
    List<T> selectList(T t);

}