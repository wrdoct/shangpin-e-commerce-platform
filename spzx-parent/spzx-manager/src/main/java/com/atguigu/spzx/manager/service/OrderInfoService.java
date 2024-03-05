package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.order.OrderStatisticsDto;
import com.atguigu.spzx.model.vo.order.OrderStatisticsVo;

public interface OrderInfoService {

    public OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto);

}
