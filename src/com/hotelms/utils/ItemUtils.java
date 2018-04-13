package com.hotelms.utils;

import com.hotelms.bean.ItemBean;
import com.hotelms.dao.ItemMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ItemUtils {

    private final static ItemMapper itemMapper;

    static {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        itemMapper = applicationContext.getBean(ItemMapper.class);
    }


    /*
     * 获取某一分类下的具体类别
     * @param itemID：分类的id
     * @return List<ItemBean>分下类下的所有类别名称
     * */
    public static List<ItemBean> getListOfItem(int itemID){
        return itemMapper.getListOfItem(itemID);
    };
    /*
     * 获取某一分类下的一个类别
     * @param itemDetailsID类别表
     * @return itemBean具体的类别对象
     * */
    public static ItemBean getOneOfItem(int itemDetailsID){
        return itemMapper.getOneOfItem(itemDetailsID);
    };
    /*
     * 获取某一分类下的具体类别名称
     * @param itemDetailsID类别表
     * @return String查找到的具体类别名称
     * */
    public static String getOneNameOfItem(int itemDetailsID){
        return itemMapper.getOneNameOfItem(itemDetailsID);
    };
}
