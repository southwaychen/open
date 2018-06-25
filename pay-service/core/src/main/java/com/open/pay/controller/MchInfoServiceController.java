package com.open.pay.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.open.pay.dal.model.MchInfo;
import com.open.pay.service.base.MchInfoService;
import com.open.pay.service.mq.KafkaProducer;
import org.apache.commons.lang3.StringUtils;
import com.open.common.util.Base64Utils;
import com.open.common.util.MyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: 商户信息接口
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@RestController
public class MchInfoServiceController {

    private final MyLog _log = MyLog.getLog(MchInfoServiceController.class);

    @Autowired
    private MchInfoService mchInfoService;
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/mch_info/select")
    public String selectMchInfo(@RequestParam String jsonParam) {
        for(int i =0;i<1000;i++){
            redisTemplate.opsForValue().set("key","value");
            kafkaProducer.sendMessage("key","hello");
        }
        // TODO 参数校验
        String param = new String(Base64Utils.decode(jsonParam));
        JSONObject paramObj = JSON.parseObject(param);
        String mchId = paramObj.getString("mchId");
        MchInfo mchInfo = mchInfoService.selectMchInfo(mchId);
        JSONObject retObj = new JSONObject();
        retObj.put("code", "0000");
        if(StringUtils.isBlank(jsonParam)) {
            retObj.put("code", "0001"); // 参数错误
            retObj.put("msg", "缺少参数");
            return retObj.toJSONString();
        }
        if(mchInfo == null) {
            retObj.put("code", "0002");
            retObj.put("msg", "数据对象不存在");
            return retObj.toJSONString();
        }
        retObj.put("result", JSON.toJSON(mchInfo));
        _log.info("result:{}", retObj.toJSONString());
        return retObj.toJSONString();
    }



}
