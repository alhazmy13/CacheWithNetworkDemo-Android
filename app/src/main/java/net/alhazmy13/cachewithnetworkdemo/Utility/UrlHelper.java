package net.alhazmy13.cachewithnetworkdemo.utility;

import net.alhazmy13.cachewithnetworkdemo.BuildConfig;

/**
 * Created by alhazmy13 on 1/9/17.
 */

public class UrlHelper {
    private final static String PROD_URL = "http://jsonplaceholder.typicode.com";
    private final static String DEVELOP_URL = "";

    public static String getBaseUrl() {
        switch (BuildConfig.FLAVOR) {
            case "prod":
                return PROD_URL;
            case "dev":
                return DEVELOP_URL;
            default:
                return DEVELOP_URL;
        }
    }
}
