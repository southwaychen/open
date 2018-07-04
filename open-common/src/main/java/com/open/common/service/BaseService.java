package com.open.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.open.common.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public abstract class BaseService<M extends Mapper<T>, T> {

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

    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
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

    public PageInfo<T> selectPageByQuery(Query query){
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
            }
        }
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return new PageInfo<T>(mapper.selectByExample(example));
    }
}
