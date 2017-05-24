package mobile;

import common.BaseTicketHeader;
import common.HttpClientHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxizhong on 17/5/24.
 */
public class SendValidateSMS extends BaseTicketHeader {

    public void sendValidateSMS(Map fetchUserInfoResponse) throws IOException {
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
    }
}
