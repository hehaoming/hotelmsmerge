package com.hotelms.service.Impl;

import com.hotelms.bean.ReceiveTargetBean;
import com.hotelms.dao.ReceiveTargetMapper;
import com.hotelms.service.ReceiveTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReceiveTargetServiceImpl implements ReceiveTargetService {

    @Autowired
    ReceiveTargetMapper receiveTargetMapper;


    @Override
    public boolean addReceiveTarget(ReceiveTargetBean receiveTargetBean) {

        int ret = receiveTargetMapper.addReceiveTarget(receiveTargetBean);


        return ret > 0 ? true : false;
    }

    @Override
    public boolean deleteReceiveTargetByID(String rt_id) {

        int ret = receiveTargetMapper.deleteReceiveTargetByID(rt_id);
        return ret > 0 ? true : false;
    }

    @Override
    public boolean updateReceiveTarget(ReceiveTargetBean receiveTargetBean) {

        int ret = receiveTargetMapper.updateReceiveTarget(receiveTargetBean);
        return ret > 0 ? true : false;
    }

    @Override
    public ReceiveTargetBean findReceiveTargetByID(int rt_id) {
        return receiveTargetMapper.findReceiveTargetByID(rt_id);
    }

    @Override
    public List<ReceiveTargetBean> findReceiveTargetByName(String teamName) {
        return receiveTargetMapper.findReceiveTargetByName(teamName);
    }

    @Override
    public List<ReceiveTargetBean> findAllReceiveTarget() {

        return receiveTargetMapper.findAllReceiveTarget();
    }
}
