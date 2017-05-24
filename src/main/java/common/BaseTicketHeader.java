package common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxizhong on 17/5/24.
 */
public class BaseTicketHeader {

    protected static Map accessHeaderMap = new HashMap() {{
        put("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Mobile Safari/537.36");
        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        put("Accept-Encoding", "gzip, deflate, br");
        put("Connection", "keep-alive");
        put("Content-Type", "application/x-www-form-urlencoded");
        put("Host", "m.damai.cn");
        put("Origin", "http://m.damai.cn");
        put("X-Requested-With", "XMLHttpRequest");
    }};
}
