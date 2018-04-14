package com.hotelms.service;

import com.hotelms.bean.ListBean;

import java.util.HashMap;

public interface FinancialStatisticsService {

    /**
     * 建立分页对象，根据条件查询信息
     * @param currentPage 跳转分页数
     * @param datemin 最小时间
     * @param datemax 最大时间
     * @return 包含结果信息的分页对象,总人数，总房间数，总消费金额，总金额的map对象
     */
    public HashMap<String,Object> showSomeStayRegister(String currentPage, String datemin, String datemax);

}
