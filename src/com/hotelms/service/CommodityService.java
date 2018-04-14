package com.hotelms.service;

import com.hotelms.bean.Commodity;
import com.hotelms.bean.ItemBean;
import com.hotelms.bean.CommodityVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface CommodityService {

    List<ItemBean> commodityTypeAll(); //拿到商品的类别。

    List<ItemBean> uOMIDAll();//拿到所有计量单位

    void addNewCommodity(Commodity commodity);//增加商品信息

    List<HashMap> findCommodityAll();//拿到商品信息

    int findCommodityTypeNum(int commodityTypeID);//得到每个类别商品数目

    List<HashMap> findLimitCommodityType(int currentpage,int pageItemNum);//分页用的指定数目商品

    void removeCommodityByID(int commodityID);//删除商品

    void updateCommodity(int id,String commodityName,int commodityTypeID,int uOMID,int salePrice);//更新商品信息

    Commodity findCommodityByID(int commodityID);//查找单个商品信息

    int findCommodityLikeNum(String commodityName);//模糊查询要数量

    List<HashMap> findLimitCommodityLike(int currentpage,int pageItemNum);

    List<Commodity> findCommodityByType(int commodityTypeID);//分类查询

    Commodity checkName(String commodityName); //比较传入的名字与数据库的

    void addCommodityType(int itemID,int commodityTypeID);

    /**
     * 根据商品种类的id查询商品总数
     * @param typeID 商品种类的id
     * @return 商品总数
     */
    public int findCommodityTotalNumberByType(String typeID);

    /**
     * 根据商品种类找到规定数量的商品
     * @param currentPage 规定数量
     * @param i 规定数量
     * @param typeID 商品种类的id
     * @return 查询结果 商品对象的集合
     */
    List<Commodity> findLimitCommoditysByType(int currentPage, int i, String typeID);

    /**
     * 根据模糊查询及单一种类查询商品
     * @param name 模糊的名字
     * @return int 查询出来的商品数量
     */
    int findCommodityByLikeTypeNum(String typeID,String name);

    /**
     * 根据商品种类ID值查询对应的ID名字
     * @param
     * @return 对应的集合
     */
    ArrayList<CommodityVO> queryCommodityTypeName(List<Commodity> commodity);
    /**
     * 根据商品种类找到规定数量的商品
     * @param currentPage 规定数量
     * @param i 规定数量
     * @param typeID 商品种类的id
     * @param name 模糊查询对象
     * @return 查询结果 商品对象的集合
     */
    List<Commodity> findLimitCommoditysByLikeType(int currentPage, int i, String name, String typeID);
}
