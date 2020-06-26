package com.moonlight.algorithm.assist;

import com.moonlight.algorithm.assist.helper.AbstractHelper;
import com.moonlight.algorithm.assist.helper.HelperFactory;
import com.moonlight.algorithm.assist.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/6/26 14:04
 * @Version V1.0
 **/
public class AssistTest {

    public static void main (String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String dbConnStr = "jdbc:mysql://localhost:3306/assist_test?user=root&password=root";
        Connection conn = DriverManager.getConnection(dbConnStr);
        Statement stmt = conn.createStatement();

        String sql = "select * from test_user";

        ResultSet rs = stmt.executeQuery(sql);

        //
        AbstractHelper helper = HelperFactory.getEntityHelper(User.class);

        long start = System.currentTimeMillis();

        while (rs.next()) {
            // 创建新的实体对象
            User user = (User) helper.create(rs);
            System.out.println(user.toString());
        }

        // 获取结束时间
        long end = System.currentTimeMillis();

        // 关闭数据库连接
        stmt.close();
        conn.close();

        // 打印赋值时间消耗
        System.out.println("use time: " + (end - start) + "ms");
    }

}
