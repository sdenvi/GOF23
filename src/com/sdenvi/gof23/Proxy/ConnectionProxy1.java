package com.sdenvi.gof23.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 14:21
 * 动态代理
 */
public class ConnectionProxy1 implements InvocationHandler {

    private Connection connection;

    public ConnectionProxy1(Connection connection) {
        super();
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //判断是Connection接口的close方法
        if (Connection.class.isAssignableFrom(proxy.getClass()) && "close".equals(method.getName())){
            //我们不执行真正的close方法
            //method.invoke(connection, args);
            //将连接归还连接池
            DataSource.getInstance().recoveryConnection(connection);
            return null;
        } else {
            return method.invoke(connection, args);
        }
    }

    public Connection getConnectionProxy(){
        return (Connection) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{Connection.class}, this);
    }
}
