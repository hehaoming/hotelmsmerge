package com.hotelms.service.Impl;

import com.hotelms.bean.ReceiveTargetBean;
import com.hotelms.dao.ReceiveTargetMapper;
import com.hotelms.service.ReceiveTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/*
  关于双表问题
  1.主键一致性：主表的添加命令成功后会返回主键，附表使用该主键进行添加；
  2。多数据删除问题：放弃传入String的想法，或者直接在外循环删除，考虑到小项目小数据，就在外循环删除算了；

  我一点都不烦躁，真的

 */

@Service
public class ReceiveTargetServiceImpl implements ReceiveTargetService {

    @Autowired
    ReceiveTargetMapper receiveTargetMapper;

    @Autowired
    ReceiveTargetBean receiveTargetBeanEarly;

    @Override
    public boolean addReceiveTarget(ReceiveTargetBean receiveTargetBean) {

        int ret = receiveTargetMapper.addReceiveTarget(receiveTargetBean);
        int ret2 =1;
//
//        int kk = receiveTargetBean.getRt_id();
//        System.out.println(kk);
//
//        //保证添加进去的主键和主表一致；
        if(ifTeam(receiveTargetBean)){
            ret2 = 0;
//            receiveTargetBean.setRt_id(kk);

            ret2 =receiveTargetMapper.addReceiveTargetAnother(receiveTargetBean);
        }


        return (ret > 0 && ret2>0);
    }

    //忽然想到批量删除问题，每个都要进行判断，头大如斗； 多写一个方法吧。我不烦躁！

   /* @Override
    public boolean deleteReceiveTargetByID(String rt_id) {

        String[] ids =rt_id.split(",");

        //对每个来一遍。我的天；
        boolean c = true;
        for (String id:
             ids) {
            c = isC(id);
            if (c){break;}
        }
        return c;
    }

    private boolean isC(String rt_id) {
        receiveTargetBeanEarly = findReceiveTargetByID(Integer.parseInt(rt_id));

        int ret = receiveTargetMapper.deleteReceiveTargetByID(rt_id);


        int ret2 =1;

        //判断，如果不为散客，就删除；
        //如果散客，表2不存在的；

        if (ifTeam(receiveTargetBeanEarly)){
             ret2 = 0;
             ret2 = receiveTargetMapper.deleteReceiveTargetByIDAnother(rt_id);
        }

        return (ret > 0 && ret2>0)? true : false;
    }*/

    @Override
    public boolean deleteReceiveTargetByID(String rt_id) {

        int ret = receiveTargetMapper.deleteReceiveTargetByID(rt_id);
        return ret > 0 ;
    }


    @Override
    public boolean updateReceiveTarget(ReceiveTargetBean receiveTargetBean) {

        receiveTargetBeanEarly = receiveTargetMapper.findReceiveTargetByID(receiveTargetBean.getRt_id());

        int ret = receiveTargetMapper.updateReceiveTarget(receiveTargetBean);
        int ret2 = 1;

        boolean elaryIfTeam = ifTeam(receiveTargetBeanEarly);
        boolean nowIfTeam = ifTeam(receiveTargetBean);
        //判断，散客改团队，添加；


        //判断，团队改成散客，直接删除。
        if(elaryIfTeam && nowIfTeam ){
            ret2 = 0;
            //如果均为团队，则，改
            ret2 = receiveTargetMapper.updateReceiveTargetAnother(receiveTargetBean);
        }
        //else if(elaryIfTeam && !nowIfTeam){
            //之前是团队，现在不是，删除；因为表2的联动问题，不改表2，着？！！
        //    ret2 = 0;
        //    ret2 = receiveTargetMapper.deleteReceiveTargetByIDAnother(""+receiveTargetBean.getRt_id());
        //}
        else  if (!elaryIfTeam && nowIfTeam){
            //之前不是，现在是，增加，第二个增加办法连id一起加，保险
            ret2 = 0;
            ret2 = receiveTargetMapper.addReceiveTargetAnother(receiveTargetBean);
        }
        //之前不是，现在也不是，不管！

        return (ret > 0 && ret2>0);
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


    //除非73，否则都是散客；
    //算了，想想，除了72，其他都是团队比较好吧。不要写太死；
    private boolean ifTeam(ReceiveTargetBean receiveTargetBean){
        boolean ret = false;
        if (receiveTargetBean.getTargetTypeID() != 72){
            ret = true;
        }
        return ret;
    }

}
