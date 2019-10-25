package com.ms.credit.dao;

import com.ms.credit.pojo.Menu;
import com.ms.credit.pojo.MenuExample;
import java.util.List;

public interface MenuDao {
    int deleteByPrimaryKey(String menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}