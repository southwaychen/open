package com.open.common.controller;

import com.github.pagehelper.PageInfo;
import com.open.common.service.BaseService;
import com.open.common.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-15 8:48
 */
public class BaseController<Biz extends BaseService,Entity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Biz baseBiz;

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public ResponseWrapper<Entity> add(@RequestBody Entity entity){
        baseBiz.insertSelective(entity);
        return new ResponseWrapper<Entity>();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseWrapper<Entity> get(@PathVariable int id){
        ResponseWrapper<Entity> responseWrapper = new ResponseWrapper<Entity>();
        Object o = baseBiz.selectByPrimaryKey(id);
        responseWrapper.setData((Entity)o);
        return responseWrapper;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseWrapper<Entity> update(@RequestBody Entity entity){
        baseBiz.updateByPrimaryKeySelective(entity);
        return new ResponseWrapper<Entity>();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseWrapper<Entity> remove(@PathVariable int id){
        baseBiz.deleteByPrimaryKey(id);
        return new ResponseWrapper<Entity>();
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    public ResponseWrapper<List<Entity>> all(){
        ResponseWrapper<List<Entity>> responseWrapper = new ResponseWrapper<List<Entity>>();
        responseWrapper.setData(baseBiz.selectAll());
        return responseWrapper;
    }
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public ResponseWrapper<PageInfo<Entity>> list(@RequestParam Map<String, Object> params){
        ResponseWrapper<PageInfo<Entity>> responseWrapper = new ResponseWrapper<PageInfo<Entity>>();
        Query query = new Query(params);
        responseWrapper.setData(baseBiz.selectPageByQuery(query));
        return responseWrapper;
    }
}
