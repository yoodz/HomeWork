package com.zzuli.home.service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzuli.home.AppContext;
import com.zzuli.home.dao.AnnounceDao;
import com.zzuli.home.model.Announce;
import com.zzuli.home.model.Pagination;

@Service("announceService")
public class AnnounceService {

    @Resource
    private AnnounceDao announceDao;

    public boolean add (Announce announce) {
        announce.setCreateTime(new Date());
        announce.setCreator(AppContext.getContext().getUserName());
        int count = announceDao.add(announce);
        if (count > 0) {
            return true;
        }
        return false;
        
    }
    
    public List<Announce> find (Pagination pagination) {
        List<Announce> announce = announceDao.find(pagination);
        return announce;
        
    }
}
