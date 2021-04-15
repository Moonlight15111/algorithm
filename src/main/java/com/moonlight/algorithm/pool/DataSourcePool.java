package com.moonlight.algorithm.pool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @ClassName DataSourcePool
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/9/26 12:10
 * @Version V1.0
 **/
public class DataSourcePool {

    public static void main(String[] args)throws Exception {
        DataSource blueDataSource = new MyDataSourcePool();
        Connection connection = blueDataSource.getConnection();
        connection.close();
        System.out.println(connection);
    }

    static class DataSourceAdapter implements DataSource {

        @Override
        public Connection getConnection() throws SQLException {
            return null;
        }

        @Override
        public Connection getConnection(String username, String password) throws SQLException {
            return null;
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return null;
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }

        @Override
        public PrintWriter getLogWriter() throws SQLException {
            return null;
        }

        @Override
        public void setLogWriter(PrintWriter out) throws SQLException {

        }

        @Override
        public void setLoginTimeout(int seconds) throws SQLException {

        }

        @Override
        public int getLoginTimeout() throws SQLException {
            return 0;
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }
    }

    static class MyDataSourcePool extends DataSourceAdapter {
        private final List<Connection> POOL = new LinkedList<>();
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                for (int i = 0; i < 10; i++) {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wxmp", "root", "root");
                    Connection proxyConnection = (Connection)Proxy.newProxyInstance(MyDataSourcePool.class.getClassLoader(),
                            new Class<?>[]{Connection.class}, new ConnectionProxy(connection, POOL));
                    POOL.add(proxyConnection);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static class ConnectionProxy implements InvocationHandler {

            private Connection connection;
            private List<Connection> pool;

            ConnectionProxy (Connection connection, List<Connection> pool) {
                this.connection = connection;
                this.pool = pool;
            }

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("close".equals(method.getName())) {
                    pool.add((Connection) proxy);
                    return null;
                }
                return method.invoke(connection, args);
            }
        }

        @Override
        public Connection getConnection() throws SQLException {
            if(POOL.isEmpty()){
                System.out.println("pool is empty");
                return null;
            }
            Connection remove = POOL.remove(0);
            System.out.println("get Connection success current pool size:"+POOL.size());
            return remove;
        }
    }

}
