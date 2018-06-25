package com.open.pay.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public class BaseService<T> {

    @Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return this.mapper;
    }

    public int insert(T entity) {
        return this.mapper.insert(entity);
    }

    public int insertSelective(T entity) {
        return this.mapper.insertSelective(entity);
    }

    public int deleteByPrimaryKey(Object key) {
        return this.mapper.deleteByPrimaryKey(key);
    }

    public int delete(T entity) {
        return this.mapper.delete(entity);
    }

    public int deleteByExample(Object example) {
        return this.mapper.deleteByExample(example);
    }

    public int update(T entity) {
        return this.mapper.updateByPrimaryKey(entity);
    }

    public int updateByPrimaryKeySelective(T entity) {
        return this.mapper.updateByPrimaryKeySelective(entity);
    }

    public int updateByExampleSelective(T entity, Object example) {
        return this.mapper.updateByExampleSelective(entity, example);
    }

    public T selectByPrimaryKey(Object key) {
        return this.mapper.selectByPrimaryKey(key);
    }

    public List<T> selectByExample(Object example) {
        return this.mapper.selectByExample(example);
    }

    public List<T> selectAll() {
        return this.mapper.selectAll();
    }

    public List<T> select(T entity) {
        return this.mapper.select(entity);
    }

    public T selectOne(T entity) {
        return this.mapper.selectOne(entity);
    }
}
