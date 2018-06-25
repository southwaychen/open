package com.open.pay.service.base;

import com.open.pay.dal.model.PayOrder;
import com.open.pay.dal.model.PayOrderExample;
import com.open.common.constant.PayConstant;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Tony on 6/6/2018.
 */
@Service
public class PayOrderService extends BaseService<PayOrder>{


    public int createPayOrder(PayOrder payOrder) {
        return this.insertSelective(payOrder);

    }

    public PayOrder selectPayOrder(String payOrderId) {
        return this.selectByPrimaryKey(payOrderId);
    }

    public PayOrder selectPayOrderByMchIdAndPayOrderId(String mchId, String payOrderId) {
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andMchIdEqualTo(mchId);
        criteria.andPayOrderIdEqualTo(payOrderId);
        List<PayOrder> payOrderList = this.selectByExample(example);
        return CollectionUtils.isEmpty(payOrderList) ? null : payOrderList.get(0);
    }

    public PayOrder selectPayOrderByMchIdAndMchOrderNo(String mchId, String mchOrderNo) {
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andMchIdEqualTo(mchId);
        criteria.andMchOrderNoEqualTo(mchOrderNo);
        List<PayOrder> payOrderList = this.selectByExample(example);
        return CollectionUtils.isEmpty(payOrderList) ? null : payOrderList.get(0);
    }

    public int updateStatus4Ing(String payOrderId, String channelOrderNo) {
        PayOrder payOrder = new PayOrder();
        payOrder.setStatus(PayConstant.PAY_STATUS_PAYING);
        if(channelOrderNo != null) payOrder.setChannelOrderNo(channelOrderNo);
        payOrder.setPaySuccTime(System.currentTimeMillis());
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayOrderIdEqualTo(payOrderId);
        criteria.andStatusEqualTo(PayConstant.PAY_STATUS_INIT);
        return this.updateByExampleSelective(payOrder, example);
    }

    public int updateStatus4Success(String payOrderId) {
        PayOrder payOrder = new PayOrder();
        payOrder.setPayOrderId(payOrderId);
        payOrder.setStatus(PayConstant.PAY_STATUS_SUCCESS);
        payOrder.setPaySuccTime(System.currentTimeMillis());
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayOrderIdEqualTo(payOrderId);
        criteria.andStatusEqualTo(PayConstant.PAY_STATUS_PAYING);
        return this.updateByExampleSelective(payOrder, example);
    }

    public int updateStatus4Complete(String payOrderId) {
        PayOrder payOrder = new PayOrder();
        payOrder.setPayOrderId(payOrderId);
        payOrder.setStatus(PayConstant.PAY_STATUS_COMPLETE);
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayOrderIdEqualTo(payOrderId);
        criteria.andStatusEqualTo(PayConstant.PAY_STATUS_SUCCESS);
        return this.updateByExampleSelective(payOrder, example);
    }

    public int updateNotify(String payOrderId, byte count) {
        PayOrder newPayOrder = new PayOrder();
        // TODO 并发下次数问题待解决
        newPayOrder.setNotifyCount(count);
        newPayOrder.setLastNotifyTime(System.currentTimeMillis());
        newPayOrder.setPayOrderId(payOrderId);
        return this.updateByPrimaryKeySelective(newPayOrder);
    }

    public int updateNotify(PayOrder payOrder) {
        return this.updateByPrimaryKeySelective(payOrder);
    }

}
