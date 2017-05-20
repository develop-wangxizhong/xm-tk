package ticket;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxizhong on 17/5/20.
 */
public class BaseTicketParam {
    public static final String LOGIN_URL = "http://www.228.com.cn/auth/login";

    public static final String SUBMIT_URL = "http://www.228.com.cn/saveNewOrder";

    public static final String CHANNEL_URL = "http://www.228.com.cn/";

    public static final String FETCH_USERINFO_URL = "http://www.228.com.cn/deliveryAddress/deliveryaddress";


    protected  Map accessHeaderMap = new HashMap() {{
        put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        put("Accept-Encoding", "gzip, deflate, br");
        put("Connection", "keep-alive");
        put("Upgrade-Insecure-Requests", "1");
        put("Host","secure.damai.cn");
        put("Origin","https://secure.damai.cn");
        put("Referer","https://secure.damai.cn/login.aspx?ru=https://www.damai.cn/");
        put("Cache-Control","max-age=0");
        put("Pragma","no-cache");
    }};

    protected Map commonSubmitPara = new HashMap() {{
        put("o['type']", "general");
        put("o['origin']", "1");

        //save dynamic customer data
        //-----begin
        put("o['addressid']", "");
        put("o['customerid']", "");
        put("o['tickets']", "");
        put("o['purchases']", "");
        //-----end

        put("o['payid']", "57120812");
        put("o['callbackurl']", "w.228.com.cn/payNew/weiXinPay?");
        put("o['errorurl']", "http://www.228.com.cn/nqt/common/error");
        put("o['isRedirect']", "1");
        put("o['orderUrl']", "http://order.228/order/create/general.json");

        //save dynamic customer data
        //-----begin
        put("o['productId']", "");
        //-----end

        put("o['bankcardno']", "0");
        put("o['verifycode']", "0");
        put("o['writecheckflagOld']", "2");
        put("o['writecheckflag']", "0");
        put("o['deliveryid']", "");
        put("o['writecheckaddressid']", "");
        put("o['writecheckphone']", "");
        put("o['invoiceinfo']", "");
        put("activeNo", "-1");
        put("discountdetailid", "57120812");
        put("o['orderSource']", "2");


    }};

}
