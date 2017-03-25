package com.zzuli.home.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zzuli.home.model.Announce;
import com.zzuli.home.model.Pagination;
import com.zzuli.home.model.User;

@Repository("announceDao")
public class AnnounceDao extends BaseDao<User, Integer>{

    private static final String CLASS_NAME = Announce.class.getName();
    private static final String SQL_ID_ADD = ".add";
    private static final String SQL_ID_FIND = ".find";
    
    public int add(Announce announce) {
        return getSqlSession().insert(CLASS_NAME + SQL_ID_ADD, announce);
    }

    public List<Announce> find(Pagination pagination) {
        Map<String, Object> params = new HashMap<String, Object>();
        //params.put("userId", userId);
        params.put("offset", pagination.getOffset());
        params.put("pageSize", pagination.getPageSize());


        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND, params);
    }
}
