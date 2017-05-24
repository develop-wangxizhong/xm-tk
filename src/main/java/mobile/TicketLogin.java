package mobile;

import common.BaseTicketHeader;
import common.HttpClientHandler;
import common.TimeUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxizhong on 17/5/24.
 */
public class TicketLogin extends BaseTicketHeader {

    private Log logger = LogFactory.getLog(getClass());

    public TicketLogin(String username, String password) throws IOException {
        login(username, password);
    }

    public void login(String username, String password) throws IOException {
        Map paramMap = new HashMap() {{
            put("fmtoken", TimeUtil.currentTimestamp().getTime());
            put("token", "");
            put("type", "damai");
            put("name", "15578072745");
            put("pass", "961023");
        }};


        //尝试登录系统
        Map loginResponse = HttpClientHandler.httpPostRequest(
                "http://m.damai.cn/login.aspx",
                accessHeaderMap,
                paramMap
        );

        String responseCode = loginResponse.get("code").toString();
        if (!responseCode.equals("200") || !responseCode.equals("302")) {
            logger.error("----------登入错误!   错误码:" + responseCode + "  错误信息:" + loginResponse.get("entity"));
        } else {
            logger.info("----------登入成功!");
        }

    }
}
