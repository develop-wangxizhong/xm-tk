package mobile;

import common.BaseTicketHeader;

import java.util.Map;

/**
 * Created by wangxizhong on 17/5/24.
 */
public class CheckRequiredSMS extends BaseTicketHeader {

    public boolean checkRequiredSMS(Map fetchUserInfoResponse) {
        //假设进入分支2 判断是否开启短信验证功能  表达式为true
        return fetchUserInfoResponse.get("entity").toString().contains("请将收到的验证码填写下方");
    }
}
