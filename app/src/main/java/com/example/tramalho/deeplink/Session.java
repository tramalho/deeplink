package com.example.tramalho.deeplink;

/**
 * Created by trama on 26/03/18.
 */

public class Session {

    private static boolean isFirst;

    public static boolean isIsFirst() {
        return isFirst;
    }

    public static void setIsFirst(boolean isFirst) {
        Session.isFirst = isFirst;
    }
}
