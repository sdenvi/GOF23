package com.sdenvi.gof24.Proxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */
public class DataSource {
    private static LinkedList<Connection> connectionList = new LinkedList<Connection>();

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection createNewConnection() throws SQLException{
        return DriverManager.getConnection("url","username", "password");
    }

    private DataSource(){
        if (connectionList == null || connectionList.size() == 0) {
            for (int i = 0; i < 10; i++) {
                try {
                    connectionList.add(createNewConnection());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Connection getConnection() throws Exception{
        if (connectionList.size() > 0) {
            //return connectionList.remove();  这是原有的方式，直接返回连接，这样可能会被程序员把连接给关闭掉
            //下面是使用代理的方式，程序员再调用close时，就会归还到连接池
            return new ConnectionProxy(connectionList.remove());
        }
        return null;
    }

    public void recoveryConnection(Connection connection){
        connectionList.add(connection);
    }

    public static DataSource getInstance(){
        return DataSourceInstance.dataSource;
    }

    private static class DataSourceInstance{

        private static DataSource dataSource = new DataSource();

    }
}
