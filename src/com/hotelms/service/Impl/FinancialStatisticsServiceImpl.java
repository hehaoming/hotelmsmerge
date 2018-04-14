package com.hotelms.service.Impl;

import com.hotelms.bean.*;
import com.hotelms.dao.FinancialStatisticsMapper;
import com.hotelms.dao.PassengerMapper;
import com.hotelms.dao.RoomsetMapper;
import com.hotelms.dao.TeamMapper;
import com.hotelms.service.FinancialStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("FinancialStatisticsService")
public class FinancialStatisticsServiceImpl implements FinancialStatisticsService {

    @Autowired
    FinancialStatisticsMapper financialStatisticsMapper;

    @Autowired
    PassengerMapper passengerMapper;

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    RoomsetMapper roomsetMapper;

    /**
     * 建立分页对象，根据条件查询信息
     * @param currentPage 跳转分页数
     * @param datemin 最小时间
     * @param datemax 最大时间
     * @return 包含结果信息的分页对象,总人数，总房间数，总消费金额，总金额的map对象
     */
    @Override
    public HashMap<String,Object> showSomeStayRegister(String currentPage, String datemin, String datemax) {

        HashMap<String,Object> allResultMap = new HashMap<>();//结果集合

        ListBean list = new ListBean();//分页工具对象
        if(currentPage == null || currentPage.length() == 0) {
            list.setCurrentPage(1);
        }else {
            list.setCurrentPage(Integer.parseInt(currentPage));
        }
        //构造查询条件
        HashMap<String,Object> map = new HashMap<>();
        map.put("datemin",datemin);
        map.put("datemax",datemax);
        map.put("limit",10);
        map.put("offset",(list.getCurrentPage() - 1) * 10);
        //查询总数
        int totalNumber = financialStatisticsMapper.selectAllBilledStayRegisterNumberWithDate(map);
        int totalPeopleNumber = 0;//总人数
        int totalConsumptionMoney = 0;//总消费金额
        int totalMoney = 0;//总金额
        //查询对象
        List<StayRegister> result = financialStatisticsMapper.selectSomeBilledStayRegistersWithDate(map);
        list.setTotalPageByItemNum(totalNumber,10);
        //填充其他信息
        for(StayRegister stayRegister : result) {
            Roomset roomset = roomsetMapper.selectRoomByID(stayRegister.getRoom());
            totalPeopleNumber += roomset.getRoomAmount();//累计每个房间床位作为总人数
            stayRegister.setRoomNumber(String.valueOf(roomset.getRoomNumber()));
            if(stayRegister.getTeam() == null || stayRegister.getTeam() == 0) {
                stayRegister.setReceptionName("散客");
                stayRegister.setPersonName(passengerMapper.selectPassengerByID(stayRegister.getPassenger()).getName());
            }else {
                Team team = teamMapper.selectTeamByID(stayRegister.getTeam());
                stayRegister.setReceptionName(team.getTeamName());
                stayRegister.setPersonName(team.getPrincipal());
            }
            totalMoney += Integer.parseInt(stayRegister.getSumConst());//累计总金额
            List<Consumption> consumptions = financialStatisticsMapper
                    .selectConsumptionsByStayId(stayRegister.getStayRegisterDetailId());
            for(Consumption consumption : consumptions) {
                totalConsumptionMoney += consumption.getConsumptionNumber() * consumption.getCommoditySalePrice();
            }
        }
        list.setResult(result);
        allResultMap.put("list",list);
        allResultMap.put("chuZuFangJianShu",totalNumber);//出租房间数
        allResultMap.put("zhuSuRenShu",totalPeopleNumber);//住宿总人数
        allResultMap.put("xiaoFeiJinE",totalConsumptionMoney);//消费总金额
        allResultMap.put("JieZhangJinE",totalMoney);//结账总金额

        return allResultMap;
    }
}
