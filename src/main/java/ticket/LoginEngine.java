package ticket;

import common.HttpClientHandler;
import common.TimeUtil;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxizhong on 17/5/21.
 */
public class LoginEngine extends BaseTicketParam {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        System.out.println(TimeUtil.currentTimestamp().getTime());

        while (true) {
            Map paramMap = new HashMap() {{
                put("token", TimeUtil.currentTimestamp().getTime());
                put("nationPerfix", "86");
                put("login_email", "15578072745");
                put("login_pwd", "961023");
            }};
            Map accessHeaderMap = new HashMap() {{
                put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
                put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
                put("Accept-Encoding", "gzip, deflate, br");
                put("Connection", "keep-alive");
                put("Upgrade-Insecure-Requests", "1");
                put("Host", "secure.damai.cn");
                put("Origin", "https://secure.damai.cn");
                put("Referer", "https://secure.damai.cn/login.aspx?ru=https://www.damai.cn/");
                put("Cache-Control", "max-age=0");
                put("Pragma", "no-cache");
            }};

            HttpClientHandler.httpGetRequest("https://www.damai.cn/");


            Map responseMap = HttpClientHandler.httpPostRequest(
                    "https://secure.damai.cn/login.aspx?ru=https://www.damai.cn/",
                    accessHeaderMap,
                    paramMap
            );


            System.out.println("[[[[[[[[[[code" + responseMap.get("code"));
            System.out.println("[[[[[[[[[[entity:" + responseMap.get("entity"));
            System.out.println("[[[[[[[[[[responseInfo" + responseMap.get("responseInfo"));

        }
    }
}
