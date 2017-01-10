package net.alhazmy13.cachewithnetworkdemo.Utility;

/**
 * Created by alhazmy13 on 1/9/17.
 */

public class UrlHelper {
    private final static String PROD_URL = "https://jsonplaceholder.typicode.com/";
    private final static String DEVELOP_URL = "";
    public static String getBaseUrl(){
        return PROD_URL;
    }
}
