package net.alhazmy13.cachewithnetworkdemo.utility;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by alhazmy13 on 1/11/17.
 */

public class NetworkParser {
    public static <T extends RealmObject> List<T> cacheResponse(final List<T> passedObject) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(passedObject);
        realm.commitTransaction();
        return passedObject;
    }

    public static <T extends RealmObject> T cacheResponse(final T passedObject) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(passedObject);
        realm.commitTransaction();
        return passedObject;
    }
}
