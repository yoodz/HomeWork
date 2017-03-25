package com.zzuli.home.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("baseDao")
public abstract class BaseDao<T, K> extends SqlSessionDaoSupport {

    protected static String SQL_ID_ADD = ".add";
    protected static String SQL_ID_UPDATE = ".update";
    protected static String SQL_ID_DELETE = ".delete";
    protected static String SQL_ID_BY_ID = ".getById";
    private Class<T> clz;

    @Override
    @Resource
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @SuppressWarnings("unchecked")
    protected Class<T> getClz() {
        if (clz == null)
            clz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clz;
    }

    public boolean add(T obj) {
        getSqlSession().insert(this.getClz().getName() + SQL_ID_ADD, obj);
        return true;
    }

    public boolean delete(K id) {
        getSqlSession().delete(this.getClz().getName() + SQL_ID_DELETE, id);
        return true;
    }

    public boolean update(T obj) {
        getSqlSession().update(this.getClz().getName() + SQL_ID_UPDATE, obj);
        return true;
    }

    @SuppressWarnings("unchecked")
    public T getById(K id) {
    	System.out.println(this.getClz().getName() + SQL_ID_BY_ID);
        return (T) getSqlSession().selectOne(this.getClz().getName() + SQL_ID_BY_ID, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findByQueryId(String sqlId, Object parameters) {
        return (List<T>) getSqlSession().selectList(this.getClz().getName() + sqlId, parameters);
    }

}