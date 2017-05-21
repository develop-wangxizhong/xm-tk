package ticket;

import common.HttpClientHandler;
import common.TimeUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wangxizhong on 17/5/21.
 */
public class LoginWebEngine extends BaseTicketParam {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        System.out.println(TimeUtil.currentTimestamp().getTime());

        //while (true) {
        Map paramMap = new HashMap() {{
            put("fmtoken", TimeUtil.currentTimestamp().getTime());
            put("token", "");
            put("type", "damai");
            put("name", "15578072745");
            put("pass", "961023");
        }};
        Map accessHeaderMap = new HashMap() {{
            put("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Mobile Safari/537.36");
            put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            put("Accept-Encoding", "gzip, deflate, br");
            put("Connection", "keep-alive");
            // put("Content-Length", "68");
            put("Content-Type", "application/x-www-form-urlencoded");
            put("Host", "m.damai.cn");
            put("Origin", "http://m.damai.cn");
            //put("Referer", "http://m.damai.cn/login.aspx");
            put("X-Requested-With", "XMLHttpRequest");
        }};
//login
        Map responseMap = HttpClientHandler.httpPostRequest(
                "http://m.damai.cn/login.aspx",
                accessHeaderMap,
                paramMap
        );


        System.out.println("[[[[[[[[[[code" + responseMap.get("code"));
        System.out.println("[[[[[[[[[[entity:" + responseMap.get("entity"));

        System.out.println("-----------------------------login ---end");

//userinfo
        Map responseMap1 = HttpClientHandler.httpGetRequest(
                "http://m.damai.cn/userinfo.html",
                accessHeaderMap,
                new HashMap<>()
        );


        System.out.println("[[[[[[[[[[code" + responseMap1.get("code"));
        System.out.println("[[[[[[[[[[entity:" + responseMap1.get("entity"));


        System.out.println("-----------------------------userinfo ---end");

        //vocode send

        Map codeSendMap = new HashMap<String, String>() {{
            put("_m", Main.fetch_m(responseMap1.get("entity").toString()));
            put("uid", Main.fetch_uid(responseMap1.get("entity").toString()));
            put("_action", "SendMobileVcode");
        }};
        Map responseMap8 = HttpClientHandler.httpPostRequest(
                "http://m.damai.cn/ajax.aspx",
                accessHeaderMap,
                codeSendMap
        );


        System.out.println("[[[[[[[[[[code" + responseMap8.get("code"));
        System.out.println("[[[[[[[[[[entity:" + responseMap8.get("entity"));


        System.out.println("-----------------------------send ---end");


//vcode validate

        System.out.println("[[[[[[[[[[[[[[[[[[[[" + Main.fetch_m(responseMap1.get("entity").toString()));
        System.out.println("[[[[[[[[[[[[[[[[[[[[" + Main.fetch_uid(responseMap1.get("entity").toString()));


        Map codeValiateMap = new HashMap<String, String>() {{
            put("_m", Main.fetch_m(responseMap1.get("entity").toString()));
            put("uid", Main.fetch_uid(responseMap1.get("entity").toString()));
            put("_action", "MobileLoginVcode");
            put("vcode", "8888");
        }};

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
         codeValiateMap.put("vcode", input);

        Map responseMap2 = HttpClientHandler.httpPostRequest(
                "http://m.damai.cn/ajax.aspx",
                accessHeaderMap,
                codeValiateMap
        );


        System.out.println("[[[[[[[[[[code" + responseMap2.get("code"));
        System.out.println("[[[[[[[[[[entity:" + responseMap2.get("entity"));

        System.out.println("-------------validate ----end");

        //}

       Map responseMap10 = HttpClientHandler.httpGetRequest(
                "http://m.damai.cn/userinfo.html",
                accessHeaderMap,
                new HashMap<>()
        );


        System.out.println("[[[[[[[[[[code" + responseMap10.get("code"));
        System.out.println("[[[[[[[[[[entity:" + responseMap10.get("entity"));


        System.out.println("-----------------------------userinfo ---end");

    }
}
