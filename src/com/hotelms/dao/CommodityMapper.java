package com.hotelms.dao;

import com.hotelms.bean.Commodity;
import com.hotelms.bean.CommodityVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CommodityMapper {
    /**
     * 增加商品
     * @param
     */
    public void addCommodity(Commodity commodity);
    /**
     * 修改商品
     * @param
     */
    public void updateCommodity(Commodity commodity);
    /**
     * 删除商品
     * @param
     */
    public void removeCommodityByID(int commodityID);
    /**
     * 查询商品
     * @param
     * @return int
     */
    public List<Commodity> findCommodity();
    /**
     * 查询商品数目
     * @param
     * @return int
     */
    int findCommodityTypeNum(int commodityTypeID);

    /**
     *
     * @param hashmap
     * @return
     */
    public List<Commodity> findLimitCommodityLike(HashMap hashmap);
    /**
     * 查询指定数目商品
     * @param
     * @return int
     */
    public List<Commodity> findLimitCommodityType(HashMap hashmap);
    /**
     * 查询一个商品
     * @param
     * @return int
     */
    public Commodity findCommodityByID(int commodityID);
    /**
     * 模糊查询
     * @param
     * @return int
     */
    public int findCommodityLikeNum(String commodityName);

    /**
     * 分类查询
     * @param
     * @return int
     */
    public List<Commodity> findCommodityByType(int commodityTypeID);

    /**
     * 插入商品类型
     * @param
     * @return int
     */
    void addCommodityType(int itemID,int commodityTypeID);
    /**
     * 查找是否同名
     *
     */
    Commodity checkName(String commodityName);

    /**
     * 根据商品种类的id查询商品总数
     * @param typeID 商品种类的id
     * @return 商品总数
     */
    public int selectCommodityTotalNumberByType(String typeID);

    /**
     * 根据商品种类找到规定数量的商品
     * key typeID 种类的id;
     * key offset 从第几项开始记录 商品信息
     * key limit 记录的数量
     * @param map 存放查询条件的集合
     * @return 查询结果 商品对象的集合
     */
    public List<Commodity> findLimitCommoditysByType(Map<String, Object> map);

    /**
     * 根据商品种类ID值查询对应的category名字
     * @param id   通过id找到对应的集合
     * @return 对应的集合
     */
    List<CommodityVO> findCommodityTypeName(Integer id);

    /**
     * 根据商品种类ID值查询对应的ID名字
     * @param
     * @return int 对应的商品数量
     */
    int findCommodityByLikeTypeNum(HashMap hashMap);

    /**
     *
     * @param map
     */
    List<Commodity> findLimitCommoditysByLikeType(Map<String, Object> map);
}
