package common;

/**
 * Created by wangxizhong on 17/5/24.
 */
public class StringPool {
    public static final String UID_PREFIX = " data-uu=\"uid=";
    public static final String UID_SUFFIX = "&_m=";

    public static final String _M_PREFIX = "&_m=";
    public static final String _M_SUFFIX = "\" data-from=";

    public static String fetch_uid(String targetResponse) {
        //uid
        return targetResponse.substring(
                targetResponse.indexOf(UID_PREFIX) + UID_PREFIX.length(),
                targetResponse.indexOf(UID_SUFFIX)
        );

    }

    public static String fetch_m(String targetResponse) {
        //_m
        return targetResponse.substring(
                targetResponse.indexOf(_M_PREFIX) + _M_PREFIX.length(),
                targetResponse.indexOf(_M_SUFFIX)
        );
    }


}
