package com.moonlight.algorithm.assist.helper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

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

    public <T> T create(ResultSet rs, Class<T> t){
        T result = null;
        Field field = null;
        try {
            Field[] declaredFields = t.getDeclaredFields();

            int[] column2Property = column2Property(rs, declaredFields);
            if (rs.next()) {
                result = t.newInstance();
                for (int i = 0, length = column2Property.length; i < length; i++) {
                    if (column2Property[i] != -1) {
                        field = declaredFields[column2Property[i]];
                        field.setAccessible(true);
                        Class<?> type = field.getType();
                        if (type == Integer.class || type == Integer.TYPE) {
                            field.set(result, rs.getInt(i));
                        } else if (type == Byte.class || type == Byte.TYPE) {
                            field.set(result, rs.getByte(i));
                        } else if (type.equals(Date.class)) {
                            field.set(result, rs.getDate(i));
                        } else if (type == String.class) {
                            field.set(result, rs.getString(i));
                        }
                    }
                }
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return result;
    }

    private int[] column2Property(ResultSet rs, Field[] fields) throws SQLException {
        int[] columnPropertyMapping = new int[fields.length];
        Arrays.fill(columnPropertyMapping, -1);

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i < columnCount + 1; i++) {
            for (int j = 0, length = fields.length; j < length; j++) {
                if (fields[j].getName().equalsIgnoreCase(metaData.getColumnName(i))) {
                    columnPropertyMapping[i] = j;
                    break;
                }
            }
        }
        return columnPropertyMapping;
    }

}
