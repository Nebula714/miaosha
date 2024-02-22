package org.example.service;

import org.example.error.BussinessException;
import org.example.service.model.OrderModel;

public interface OrderService {

    // 前端传入promoId 下单接口内校验对应id是否属于对应商品且活动已开始
    OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BussinessException;

}
