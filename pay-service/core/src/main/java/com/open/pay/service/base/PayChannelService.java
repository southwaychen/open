package com.open.pay.service.base;

import com.open.pay.dal.model.PayChannel;
import com.open.pay.dal.model.PayChannelExample;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description:
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@Service
public class PayChannelService extends BaseService<PayChannel>{

    public PayChannel selectPayChannel(String channelId, String mchId) {
        PayChannelExample example = new PayChannelExample();
        PayChannelExample.Criteria criteria = example.createCriteria();
        criteria.andChannelIdEqualTo(channelId);
        criteria.andMchIdEqualTo(mchId);
        List<PayChannel> payChannelList = this.selectByExample(example);
        if(CollectionUtils.isEmpty(payChannelList)) return null;
        return payChannelList.get(0);
    }

}
