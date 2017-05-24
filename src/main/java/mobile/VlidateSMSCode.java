package mobile;

import common.BaseTicketHeader;
import common.HttpClientHandler;
import common.StringPool;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxizhong on 17/5/24.
 */
public class VlidateSMSCode extends BaseTicketHeader {

    public void validateSMSCode(Map fetchUserInfoResponse, String inputCode) throws IOException {
        //假设分支2  就需要对短信进行验证  还是取用户信息中的字段  server端验证
        Map codeValiateMap = new HashMap<String, String>() {{
            put("_m", StringPool.fetch_m(fetchUserInfoResponse.get("entity").toString()));
            put("uid", StringPool.fetch_uid(fetchUserInfoResponse.get("entity").toString()));
            put("_action", "MobileLoginVcode");
            put("vcode", inputCode);
        }};

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
    }
}
