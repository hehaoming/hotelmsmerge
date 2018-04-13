package com.hotelms.service;

import com.hotelms.bean.ReceiveTargetBean;

import java.util.List;

public interface ReceiveTargetService {

    boolean addReceiveTarget(ReceiveTargetBean receiveTargetBean);

    boolean deleteReceiveTargetByID(String rt_id);

    boolean updateReceiveTarget(ReceiveTargetBean receiveTargetBean);

    ReceiveTargetBean findReceiveTargetByID(int rt_id);

    List<ReceiveTargetBean> findReceiveTargetByName(String teamName);


    List<ReceiveTargetBean> findAllReceiveTarget();



}
