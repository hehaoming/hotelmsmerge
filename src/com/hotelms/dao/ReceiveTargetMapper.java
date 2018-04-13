package com.hotelms.dao;

import com.hotelms.bean.ReceiveTargetBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceiveTargetMapper {

    int addReceiveTarget(ReceiveTargetBean receiveTargetBean);

    int deleteReceiveTargetByID(@Param(value = "rt_id") String rt_id);

    int updateReceiveTarget(ReceiveTargetBean receiveTargetBean);

    ReceiveTargetBean findReceiveTargetByID(int rt_id);

    List<ReceiveTargetBean> findReceiveTargetByName(String teamName);


    //这个查询结果应该要session到文件，方便page；待我查一查session。就不写limt那一个了；
    List<ReceiveTargetBean> findAllReceiveTarget();


}
