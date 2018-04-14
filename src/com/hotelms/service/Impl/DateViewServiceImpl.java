package com.hotelms.service.Impl;
import com.hotelms.bean.StayRegisterBean;
import com.hotelms.dao.SatyregisterMapper;
import com.hotelms.service.DateViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DateViewServiceImpl implements DateViewService {
    @Autowired
    SatyregisterMapper satyregisterMapper;

    @Override
    public List<StayRegisterBean> analysisAllInfo() {
        List<StayRegisterBean> stayRegisterBeans = satyregisterMapper.analysisAllInfo();
        for (StayRegisterBean stayRegisterBean : stayRegisterBeans) {
            System.out.println(stayRegisterBean.getPayTime());
        }
        return stayRegisterBeans;
    }
}
