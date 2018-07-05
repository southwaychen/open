package com.open.auth.service.biz;

import com.open.auth.dal.entity.Resource;
import com.open.auth.dal.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ResourceService{
    @Autowired
    private ResourceMapper resourceMapper;


    public Set<Resource> findAll() {
        return resourceMapper.findAll();
    }


    public Set<Resource> queryByRoleCodes(String[] roleCodes) {
        return resourceMapper.queryByRoleCodes(roleCodes);
    }
}
