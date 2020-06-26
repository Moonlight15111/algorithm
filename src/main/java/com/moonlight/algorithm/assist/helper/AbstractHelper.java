package com.moonlight.algorithm.assist.helper;

import java.sql.ResultSet;

/**
 * @ClassName AbstractHelper
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/6/26 14:07
 * @Version V1.0
 **/
public abstract class AbstractHelper {

    /**
     * @Author Moonlight
     * @Description 将数据库查询出来的数据集转换为实体对象
     * @Date 2020/6/26 14:08
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public abstract Object create(ResultSet rs);

}
