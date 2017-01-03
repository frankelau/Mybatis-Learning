package cn.com.liu.mapper;

public interface BaseUpdateMapper<T> {
    int updateById(T t);
    int insert(T t);

}