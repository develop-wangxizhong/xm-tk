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
            put("Content-Type", "application/x-www-form-urlencoded");
            put("Host", "m.damai.cn");
            put("Origin", "http://m.damai.cn");
            put("X-Requested-With", "XMLHttpRequest");
        }};

        //尝试登录系统
        Map loginResponse = HttpClientHandler.httpPostRequest(
                "http://m.damai.cn/login.aspx",
                accessHeaderMap,
                paramMap
        );

        System.out.println("[[[[[[[[[[code" + loginResponse.get("code"));
        System.out.println("[[[[[[[[[[entity:" + loginResponse.get("entity"));
        System.out.println("---------------------------------------------------login ---end");

        //登录之后需要拉取用户信息---->会出现两种情况    1.拉取成功   2.拉取失败进入短信验证
        Map fetchUserInfoResponse = HttpClientHandler.httpGetRequest(
                "http://m.damai.cn/userinfo.html",
                accessHeaderMap,
                new HashMap<>()
        );

        System.out.println("[[[[[[[[[[code" + fetchUserInfoResponse.get("code"));
        System.out.println("[[[[[[[[[[entity:" + fetchUserInfoResponse.get("entity"));

        //假设进入分支2 判断是否开启短信验证功能  表达式为true
        System.out.println(fetchUserInfoResponse.get("entity").toString().contains("请将收到的验证码填写下方"));
        System.out.println("-----------------------------userinfo ---end");

        //假设进入分支2  就需要用用户信息中的字段进行短信发送
        Map codeSendMap = new HashMap<String, String>() {{
            put("_m", Main.fetch_m(fetchUserInfoResponse.get("entity").toString()));
            put("uid", Main.fetch_uid(fetchUserInfoResponse.get("entity").toString()));
            put("_action", "SendMobileVcode");
        }};
        Map responseMap8 = HttpClientHandler.httpPostRequest(
                "http://m.damai.cn/ajax.aspx",
                accessHeaderMap,
                codeSendMap
        );
        //返回 104非法参数  或者200发送成功  或者 109 请等待X秒后重发验证码！（发送频繁）
        System.out.println("[[[[[[[[[[code" + responseMap8.get("code"));
        System.out.println("[[[[[[[[[[entity:" + responseMap8.get("entity"));
        System.out.println("-----------------------------send ---end");


        //假设分支2  就需要对短信进行验证  还是取用户信息中的字段  server端验证
        Map codeValiateMap = new HashMap<String, String>() {{
            put("_m", Main.fetch_m(fetchUserInfoResponse.get("entity").toString()));
            put("uid", Main.fetch_uid(fetchUserInfoResponse.get("entity").toString()));
            put("_action", "MobileLoginVcode");
            put("vcode", "8888");
        }};

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        codeValiateMap.put("vcode", input);//用户输入验证码

        //发送验证请求
        Map responseMap2 = HttpClientHandler.httpPostRequest(
                "http://m.damai.cn/ajax.aspx",
                accessHeaderMap,
                codeValiateMap
        );
        //验证通过  code 200
        System.out.println("[[[[[[[[[[code" + responseMap2.get("code"));
        System.out.println("[[[[[[[[[[entity:" + responseMap2.get("entity"));
        System.out.println("-------------validate ----end");


        //再次拉取用户信息
        Map againFetchUserInfoResponse = HttpClientHandler.httpGetRequest(
                "http://m.damai.cn/userinfo.html",
                accessHeaderMap,
                new HashMap<>()
        );
        System.out.println("[[[[[[[[[[code" + againFetchUserInfoResponse.get("code"));
        System.out.println("[[[[[[[[[[entity:" + againFetchUserInfoResponse.get("entity"));
        //登录成功
    }
}
