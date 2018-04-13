package com.hotelms.dao;

import com.hotelms.bean.ItemBean;

import java.util.List;

/*
* 获取分类
*/
public interface ItemMapper {
    /*
    * 获取某一分类下的具体类别
    * @param itemID：分类的id
    * @return List<ItemBean>分下类下的所有类别名称
    * */
    public List<ItemBean> getListOfItem(int itemID);
    /*
     * 获取某一分类下的一个类别
     * @param itemDetailsID类别表
     * @return itemBean具体的类别对象
     * */
    public ItemBean getOneOfItem(int itemDetailsID);
    /*
     * 获取某一分类下的具体类别名称
     * @param itemDetailsID类别表
     * @return String查找到的具体类别名称
     * */
    public String getOneNameOfItem(int itemDetailsID);
}
