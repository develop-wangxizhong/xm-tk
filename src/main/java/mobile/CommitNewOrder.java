package mobile;

import common.BaseTicketHeader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxizhong on 17/5/24.
 */
public class CommitNewOrder extends BaseTicketHeader {

    public void commitNewOrder() {
        Map commitRequestMap = new HashMap();
        commitRequestMap.put("tradeId", "7ab4537055ff69281702d53cd48d3ce4");
        commitRequestMap.put("orderId", "0");
        commitRequestMap.put("groupId", "852-3-3-1-9");
        commitRequestMap.put("projectId", "111636");
        commitRequestMap.put("commodityParams", "2|11605488^1^8919361");
        commitRequestMap.put("deliveryType", "1");
        commitRequestMap.put("payKind", "1");
        commitRequestMap.put("payMethod", "96");
        commitRequestMap.put("performId", "8919361");
        commitRequestMap.put("frontPivilege[0].privilegeId", "");
        commitRequestMap.put("frontPivilege[0].privilegeName", "");
        commitRequestMap.put("frontPivilege[0].privilegeAmount", "0");
        commitRequestMap.put("frontPivilege[0].usable", "0");
        commitRequestMap.put("frontPivilege[0].providerId", "");
        commitRequestMap.put("frontPivilege[0].describe", "");
        commitRequestMap.put("frontPivilege[0].privilegeType", "0");
        commitRequestMap.put("sKULimit[0].idType", "1");
        commitRequestMap.put("sKULimit[0].idCard", "1426011996身份证号");
        commitRequestMap.put("trader.addressId", "16072494");
        commitRequestMap.put("trader.userCode", "64083379");
        commitRequestMap.put("trader.userName", "**行");
        commitRequestMap.put("trader.prefix", "86");
        commitRequestMap.put("trader.mobilePhone", "155****2745");
        commitRequestMap.put("trader.tel", "");
        commitRequestMap.put("trader.email", "");
        commitRequestMap.put("trader.postcode", "");
        commitRequestMap.put("trader.idType", "2");
        commitRequestMap.put("trader.idCard", "14260119961023XXXX");
        commitRequestMap.put("trader.provinceId", "851");
        commitRequestMap.put("trader.provinceName", "北京");
        commitRequestMap.put("trader.cityId", "852");
        commitRequestMap.put("trader.cityName", "北京市");
        commitRequestMap.put("trader.countyId", "858");
        commitRequestMap.put("trader.countyName", "丰台区");
        commitRequestMap.put("trader.districtId", "281108");
        commitRequestMap.put("trader.districtName", "丰台区 五环内");
        commitRequestMap.put("trader.address", "咯哦哦我怕啊了");
        commitRequestMap.put("buyCommodityList[0].commodityGUID", "");
        commitRequestMap.put("buyCommodityList[0].commodityID", "11605488");
        commitRequestMap.put("buyCommodityList[0].buyNum", "1");
        commitRequestMap.put("buyCommodityList[0].cityID", "852");
        commitRequestMap.put("buyCommodityList[0].batchID", "8919361");
        commitRequestMap.put("openVerificationCode", "false");
        commitRequestMap.put("verifyCodecrypt", "3e96c0e57a130a3e5c08e88b1515bfa6");
        commitRequestMap.put("verifyCode", "");
    }
}
