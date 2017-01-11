package net.alhazmy13.cachewithnetworkdemo.utility.realm;

import io.realm.RealmObject;

/**
 * Created by alhazmy13 on 1/11/17.
 */

public class RealmString extends RealmObject {
    private String val;

    public String getValue() {
        return val;
    }

    public void setValue(String value) {
        this.val = value;
    }
}