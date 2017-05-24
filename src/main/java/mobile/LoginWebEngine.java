package mobile;

import common.BaseTicketHeader;
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
public class LoginWebEngine extends BaseTicketHeader {
    public static Map responseFetchUserInfo;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {

        TicketLogin ticketLogin = new TicketLogin("", "");
        FetchUserInfo fetchUserInfo = new FetchUserInfo();
        responseFetchUserInfo = fetchUserInfo.fetchUserInfo();
        //如果需要短信验证码
        if (new CheckRequiredSMS().checkRequiredSMS(responseFetchUserInfo)) {
            new SendValidateSMS().sendValidateSMS(responseFetchUserInfo);//发送信息
            Scanner scanner = new Scanner(System.in);
            String inputCode = scanner.next();//阻塞
            new VlidateSMSCode().validateSMSCode(responseFetchUserInfo, inputCode);//验证Code
            responseFetchUserInfo = fetchUserInfo.fetchUserInfo();//再次拉取用户信息
        }


        CommitNewOrder commitNewOrder = new CommitNewOrder();
        commitNewOrder.commitNewOrder();

    }
}
