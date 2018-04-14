package com.hotelms.service.Impl;


import com.hotelms.bean.Commodity;
import com.hotelms.bean.ItemBean;
import com.hotelms.dao.CommodityMapper;
import com.hotelms.dao.ItemMapper;
import com.hotelms.service.CommodityService;
import com.hotelms.bean.CommodityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("commodityservice")
public class CommodityServiceImpl implements CommodityService{


    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private ItemMapper itemMapper;


    @Override
    public void addNewCommodity(Commodity commodity) {

        commodityMapper.addCommodity(commodity);
    }

    @Override
    public List<ItemBean> commodityTypeAll() {

        return itemMapper.getListOfItem(3);

    }

    @Override
    public List<ItemBean> uOMIDAll() {

        return itemMapper.getListOfItem(4);
    }

    @Override
    public List<Commodity> findCommodityByType(int commodityTypeID) {
        return commodityMapper.findCommodityByType(commodityTypeID);
    }

    @Override
    public void addCommodityType(int itemID,int commodityTypeID) {

        commodityMapper.addCommodityType(3,commodityTypeID);
    }


    /**
     * 根据商品种类的id查询商品总数
     * @param typeID 商品种类的id
     * @return 商品总数
     */
    @Override
    public int findCommodityTotalNumberByType(String typeID) {

        int i = commodityMapper.selectCommodityTotalNumberByType(typeID);
        return i;
    }

    /**
     * 根据商品种类找到规定数量的商品
     * @param currentPage 规定数量
     * @param i 规定数量
     * @param typeID 商品种类的id
     * @return 查询结果 商品对象的集合
     */
    @Override
    public List<Commodity> findLimitCommoditysByType(int currentPage, int i, String typeID) {

        Map<String,Object> map = new HashMap<>();
        map.put("typeID",typeID);//将查询需要的条件存入map
        map.put("offset",(currentPage-1)*i);
        map.put("limit",i);
        List<Commodity> commoditys = commodityMapper.findLimitCommoditysByType(map);//根据map构建查询方法和sql语句
        return commoditys;
    }

    @Override
    public List<Commodity> findLimitCommoditysByLikeType(int currentPage, int i, String name, String typeID) {
        Map<String,Object> map = new HashMap<>();
        map.put("name","%" + name + "%");
        map.put("typeID",typeID);
        map.put("offset",(currentPage-1)*i);
        map.put("limit",i);
        List<Commodity> limitCommoditysByLikeType = commodityMapper.findLimitCommoditysByLikeType(map);
        return limitCommoditysByLikeType;
    }

    @Override
    public int findCommodityByLikeTypeNum(String typeID,String name) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("arg0",typeID);
        stringStringHashMap.put("arg1","%" + name + "%");

        int i = commodityMapper.findCommodityByLikeTypeNum(stringStringHashMap);
        return i;
    }

    @Override
    public ArrayList<CommodityVO> queryCommodityTypeName(List<Commodity> commodity) {

        //将itemdetilas名字映射到商品列表
        ArrayList<CommodityVO> commodityVOS = new ArrayList<>();
        for(Commodity c : commodity) {
            CommodityVO commodityVO = new CommodityVO();
            commodityVO.setCommodityID(c.getCommodityID());
            commodityVO.setuOM(itemMapper.getOneNameOfItem(c.getuOMID()));
            commodityVO.setCommodityType(itemMapper.getOneNameOfItem(c.getCommodityTypeID()));
            commodityVO.setCommodityName(c.getCommodityName());
            commodityVO.setSalePrice(c.getSalePrice());
            commodityVOS.add(commodityVO);
        }
        return commodityVOS;
    }

    @Override
    public int findCommodityLikeNum(String commodityName) {

        return commodityMapper.findCommodityLikeNum("%" + commodityName + "%");
    }

    @Override
    public List<HashMap> findLimitCommodityLike(int currentpage, int pageItemNum) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("limit",pageItemNum);
        stringIntegerHashMap.put("offset",(currentpage - 1)*pageItemNum);
        List<Commodity> limitCommodity = commodityMapper.findLimitCommodityLike(stringIntegerHashMap);
        ArrayList<HashMap> hashMaps = new ArrayList<>();
        for (Commodity commodity:limitCommodity) {
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("id",commodity.getCommodityID() + "");
            stringStringHashMap.put("commodityName",commodity.getCommodityName());
            stringStringHashMap.put("commodityTypeName",itemMapper.getOneNameOfItem(commodity.getCommodityTypeID()));
            stringStringHashMap.put("uOMName",itemMapper.getOneNameOfItem(commodity.getuOMID()));
            stringStringHashMap.put("salePrice",commodity.getSalePrice() + "");
            hashMaps.add(stringStringHashMap);
        }
        return hashMaps;
    }

    @Override
    public Commodity findCommodityByID(int commodityID) {

        return commodityMapper.findCommodityByID(commodityID);
    }

    @Override
    public List<HashMap> findCommodityAll() {
        List<Commodity> commodities = commodityMapper.findCommodity();
        ArrayList<HashMap> hashMaps = new ArrayList<>();
        for (Commodity commodity:commodities) {
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("id",commodity.getCommodityID() + "");
            stringStringHashMap.put("commodityName",commodity.getCommodityName());
            stringStringHashMap.put("commodityTypeName",itemMapper.getOneNameOfItem(commodity.getCommodityTypeID()));
            stringStringHashMap.put("uOMName",itemMapper.getOneNameOfItem(commodity.getuOMID()));
            stringStringHashMap.put("salePrice",commodity.getSalePrice() + "");
            hashMaps.add(stringStringHashMap);
        }
        return hashMaps;
    }

    @Override
    public int findCommodityTypeNum(int commodityTypeID) {

        return commodityMapper.findCommodityTypeNum(commodityTypeID);
    }

    @Override
    public Commodity checkName(String commodityName) {

        return commodityMapper.checkName(commodityName);
    }

    @Override
    public void updateCommodity(int id,String commodityName,int commodityTypeID,int uOMID,int salePrice) {

        Commodity commodity = new Commodity();
        commodity.setCommodityID(id);
        commodity.setCommodityName(commodityName);
        commodity.setCommodityTypeID(commodityTypeID);
        commodity.setuOMID(uOMID);
        commodity.setSalePrice(salePrice);
        commodityMapper.updateCommodity(commodity);
    }

    @Override
    public void removeCommodityByID(int commodityID) {

        commodityMapper.removeCommodityByID(commodityID);
    }

    @Override
    public List<HashMap> findLimitCommodityType(int currentpage,int pageItemNum) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("limit",pageItemNum);
        stringIntegerHashMap.put("offset",(currentpage - 1)*pageItemNum);
        List<Commodity> limitCommodity = commodityMapper.findLimitCommodityType(stringIntegerHashMap);
        ArrayList<HashMap> hashMaps = new ArrayList<>();
        for (Commodity commodity:limitCommodity) {
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("id",commodity.getCommodityID() + "");
            stringStringHashMap.put("commodityName",commodity.getCommodityName());
            stringStringHashMap.put("commodityTypeName",itemMapper.getOneNameOfItem(commodity.getCommodityTypeID()));
            stringStringHashMap.put("uOMName",itemMapper.getOneNameOfItem(commodity.getuOMID()));
            stringStringHashMap.put("salePrice",commodity.getSalePrice() + "");
            hashMaps.add(stringStringHashMap);
        }
        return hashMaps;

    }
}
