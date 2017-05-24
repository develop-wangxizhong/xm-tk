package mobile;

import common.BaseTicketHeader;
import common.HttpClientHandler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxizhong on 17/5/24.
 */
public class FetchUserInfo extends BaseTicketHeader {

    public Map fetchUserInfo() throws IOException, URISyntaxException {
        //登录之后需要拉取用户信息---->会出现两种情况    1.拉取成功   2.拉取失败进入短信验证
        return HttpClientHandler.httpGetRequest(
                "http://m.damai.cn/userinfo.html",
                accessHeaderMap,
                new HashMap<>()
        );
    }
}
