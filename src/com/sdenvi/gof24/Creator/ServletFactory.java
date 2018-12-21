package com.sdenvi.gof24.Creator;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
/** 相当于简单工厂模式中的产品接口 */
interface Servlet{}
/** 相当于简单工厂模式中的抽象父类产品。 */
/** 注意，简单工厂在网络上的资料大部分为了简单容易理解都是只规划了一个产品接口，但这不代表就只能有一个，设计模式的使用要灵活多变。 */
class HttpServlet implements Servlet{}
/** 具体的产品 */
class LoginServlet extends HttpServlet{}
class RegisterServlet extends HttpServlet{}
class LoginoutServlet extends HttpServlet{}
/** 产品工厂 */
public class ServletFactory {
    private ServletFactory(){}
    //典型的创造产品的方法，一般是静态的，因为工厂不需要有状态。
    public static Servlet createServlet(String servletName){
        if (servletName.equals("login")) {
            return new LoginServlet();
        }else if (servletName.equals("register")) {
            return new RegisterServlet();
        }else if (servletName.equals("loginout")) {
            return new LoginoutServlet();
        }else {
            throw new RuntimeException();
        }
    }
}
