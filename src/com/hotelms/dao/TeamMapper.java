package com.hotelms.dao;


import com.hotelms.bean.Team;

import java.util.List;

public interface TeamMapper {

    /**
     * 查询所有的团队信息
     * @return 所有团队信息集合
     */
    public List<Team> selectAllTeams();

    /**
     * 根据id查询团队负责人的电话
     * @param id 团队id
     * @return 团队负责人电话
     */
    public String selectTeamPhoneNumberByID(int id);

    /**
     * 根据id查询团队信息
     * @param tuanduiID 团队的id
     * @return 团队信息
     */
    public Team selectTeamByID(Integer tuanduiID);

    /**
     * 根据关键字模糊匹配名称查找团队id数组
     * @param txtname 模糊匹配关键字
     * @return 团队id数组
     */
    public int[] selectIDsByLikeName(String txtname);
}