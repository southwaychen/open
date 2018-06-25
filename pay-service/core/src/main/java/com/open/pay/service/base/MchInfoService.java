package com.open.pay.service.base;

import com.open.pay.dal.model.MchInfo;
import com.open.pay.service.base.BaseService;
import org.springframework.stereotype.Service;


/**
 * @Description:
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@Service
public class MchInfoService extends BaseService<MchInfo> {

    public MchInfo selectMchInfo(String mchId) {
        return this.selectByPrimaryKey(mchId);
    }

}
