package mobile;

/**
 * Created by wangxizhong on 17/5/21.
 */
public class Main {
    public static final String UID_PREFIX = " data-uu=\"uid=";
    public static final String UID_SUFFIX = "&_m=";

    public static final String _M_PREFIX = "&_m=";
    public static final String _M_SUFFIX = "\" data-from=";

    public static String fetch_uid(String targetResponse) {
        //uid
        return targetResponse.substring(
                targetResponse.indexOf(UID_PREFIX) + UID_PREFIX.length(),
                targetResponse.indexOf(UID_SUFFIX)
        );

    }

    public static String fetch_m(String targetResponse) {
        //_m
        return targetResponse.substring(
                targetResponse.indexOf(_M_PREFIX) + _M_PREFIX.length(),
                targetResponse.indexOf(_M_SUFFIX)
        );
    }

    public static final String STR = "/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/bin/java \"-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=54558:/Applications/IntelliJ IDEA.app/Contents/bin\" -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/lib/tools.jar:/Users/wangxizhong/Documents/xm-tk/build/classes/main:/Users/wangxizhong/.gradle/caches/modules-2/files-2.1/org.apache.httpcomponents/httpcore/4.4.4/b31526a230871fbe285fbcbe2813f9c0839ae9b0/httpcore-4.4.4.jar:/Users/wangxizhong/.gradle/caches/modules-2/files-2.1/org.apache.httpcomponents/httpclient/4.5.2/733db77aa8d9b2d68015189df76ab06304406e50/httpclient-4.5.2.jar:/Users/wangxizhong/.gradle/caches/modules-2/files-2.1/commons-codec/commons-codec/1.9/9ce04e34240f674bc72680f8b843b1457383161a/commons-codec-1.9.jar:/Users/wangxizhong/.gradle/caches/modules-2/files-2.1/commons-logging/commons-logging/1.2/4bfc12adfe4842bf07b657f0369c4cb522955686/commons-logging-1.2.jar mobile.LoginWebEngine\n" +
            "objc[2883]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/bin/java and /Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre/lib/libinstrument.dylib. One of the two will be used. Which one is undefined.\n" +
            "1495367597527\n" +
            "-----------response:HttpResponseProxy{HTTP/1.1 200 OK [Server: Tengine, Content-Type: application/json; charset=utf-8, Content-Length: 110, Connection: keep-alive, Date: Sun, 21 May 2017 11:53:18 GMT, Set-Cookie: acw_tc=AQAAAGwqRntlWwoA3y+rcyxreXwgHDgK; Path=/; HttpOnly, Set-Cookie: cookie_tuid=4WM4T/8/h/QtVzOEj16RMaGftragw53kpY6WIui/stk=, Cache-Control: private, X-AspNet-Version: 4.0.30319, Set-Cookie: damai.cn_user=zY0PvLT0C4pe5j97N5ox5BrXFEGsfHDPmtLh9CnWsIhCPaYwFo8tfuP4Y+u21tQm; domain=damai.cn; path=/, Set-Cookie: damai.cn_email=15578072745; domain=damai.cn; expires=Tue, 10-Mar-2020 11:53:18 GMT; path=/, Set-Cookie: damai_cn_user=zY0PvLT0C4pe5j97N5ox5BrXFEGsfHDPmtLh9CnWsIhCPaYwFo8tfuP4Y+u21tQm; domain=damai.cn; path=/, Set-Cookie: userloginkey=b5ce979c40c6494089ae9117c61ca108_2_3; path=/, Set-Cookie: page_tran_time=203.1266; path=/, X-Powered-By: ASP.NET, Via: cache15.l2et2-1[255,200-0,M], cache3.l2et2-1[255,0], kunlun4.cn125[308,200-0,M], kunlun7.cn125[309,0], X-Cache: MISS TCP_MISS dirn:-2:-2, X-Swift-SaveTime: Sun, 21 May 2017 11:53:18 GMT, X-Swift-CacheTime: 0, Timing-Allow-Origin: *, EagleId: 6a78b50714953675986015077e] ResponseEntityProxy{[Content-Type: application/json; charset=utf-8,Content-Length: 110,Chunked: false]}}\n" +
            "[[[[[[[[[[code200\n" +
            "[[[[[[[[[[entity:{\"loginkey\":\"b5ce979c40c6494089ae9117c61ca108_2_3\",\"root\":0,\"error\":null,\"os\":true,\"us\":0,\"usercode\":64083379}\n" +
            "-----------------------------\n" +
            "-----------------------------\n" +
            "-----------------------------\n" +
            "-----------response:HttpResponseProxy{HTTP/1.1 200 OK [Server: Tengine, Content-Type: text/html; charset=utf-8, Transfer-Encoding: chunked, Connection: keep-alive, Vary: Accept-Encoding, Date: Sun, 21 May 2017 11:53:19 GMT, Vary: Accept-Encoding, Cache-Control: private, X-AspNet-Version: 4.0.30319, Set-Cookie: mcity=852; expires=Mon, 22-May-2017 11:53:19 GMT; path=/, Set-Cookie: page_tran_time=31.2428; path=/, X-Powered-By: ASP.NET, Via: cache19.l2et2-1[70,200-0,M], cache5.l2et2-1[70,0], kunlun8.cn125[96,200-0,M], kunlun7.cn125[97,0], X-Cache: MISS TCP_MISS dirn:-2:-2, X-Swift-SaveTime: Sun, 21 May 2017 11:53:19 GMT, X-Swift-CacheTime: 0, Timing-Allow-Origin: *, EagleId: 6a78b50714953675994331198e] org.apache.http.client.entity.DecompressingEntity@5e3a8624}\n" +
            "[[[[[[[[[[code200\n" +
            "[[[[[[[[[[entity:<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0\">\n" +
            "<meta name=\"format-detection\" content=\"telephone=no\">\n" +
            "<title>安全验证</title>\n" +
            "<meta name=\"screen-orientation\" content=\"portrait\"><meta name=\"x5-orientation\" content=\"portrait\"><meta name=\"full-screen\" content=\"yes\"><meta name=\"browsermode\" content=\"application\"><meta name=\"msapplication-tap-highlight\" content=\"no\"><link rel=\"stylesheet\" href=\"//dui.dmcdn.cn/??mobile/newm_2015/css/style.css,mobile/newm_2015/css/swiper.min.css?16\" />\n" +
            "<script type=\"text/javascript\">!function(a,b){if(!b.__SV){var c,d,e,f;window.dplus=b,b._i=[],b.init=function(a,c,d){function g(a,b){var c=b.split(\".\");2==c.length&&(a=a[c[0]],b=c[1]),a[b]=function(){a.push([b].concat(Array.prototype.slice.call(arguments,0)))}}var h=b;for(\"undefined\"!=typeof d?h=b[d]=[]:d=\"dplus\",h.people=h.people||[],h.toString=function(a){var b=\"dplus\";return\"dplus\"!==d&&(b+=\".\"+d),a||(b+=\" (stub)\"),b},h.people.toString=function(){return h.toString(1)+\".people (stub)\"},e=\"disable track track_links track_forms register unregister get_property identify clear set_config get_config get_distinct_id track_pageview register_once track_with_tag time_event people.set people.unset people.delete_user\".split(\" \"),f=0;f<e.length;f++)g(h,e[f]);b._i.push([a,c,d])},b.__SV=1.1,c=a.createElement(\"script\"),c.type=\"text/javascript\",c.charset=\"utf-8\",c.async=!0,c.src=\"https://w.cnzz.com/dplus.php?token=7415364c9dab5n09ff68\",d=a.getElementsByTagName(\"script\")[0],d.parentNode.insertBefore(c,d)}}(document,window.dplus||[]),dplus.init(\"7415364c9dab5n09ff68\");</script>\n" +
            "<script type=\"text/javascript\">!function(a,b){var c,d;window.__dplusDefineCacheQueue=[],b.define=function(){window.__dplusDefineCacheQueue.push(Array.prototype.slice.call(arguments))},c=a.createElement(\"script\"),c.type=\"text/javascript\",c.charset=\"utf-8\",c.async=!0,c.src=\"https://w.cnzz.com/dplus.define.php\",d=a.getElementsByTagName(\"script\")[0],d.parentNode.insertBefore(c,d)}(document,window.dplus);</script>\n" +
            "<script src=\"/js/rem.js?16\"></script></head>\n" +
            "<body class=\"m_bjfff\">\n" +
            "<div class=\"g-doc\">\n" +
            "<div class=\"g-bd\">\n" +
            "<div class=\"m-confirm\">\n" +
            "<div class=\"box\">\n" +
            "<div class=\"m-deliver\">\n" +
            "<div class=\"hd\">\n" +
            "<h2 class=\"m_sign\">安全验证</h2>\n" +
            "</div>\n" +
            "<p class=\"m_c666 m_f16 mb20\">我们已将短信下发到155****2745，请将收到的验证码填写下方</p>\n" +
            "<div class=\"bd\">\n" +
            "<div class=\"box\">\n" +
            "<div class=\"itm z-show\">\n" +
            "<div class=\"m-fm\">\n" +
            "<div class=\"row1 m_new_inp\">\n" +
            "<div class=\"ipt\">\n" +
            "<input id=\"code\" type=\"tel\" maxlength=\"6\" class=\"m_pop_nb\" style=\"border-right: 1px solid #ccc; margin-right:1rem\" placeholder=\"请填写短信验证码\">\n" +
            "<a id=\"btnSend\" class=\"m_c333 m_f14\" href=\"javascript:;\" data-b=\"0\" data-uu=\"uid=B7923865D6D69F4AA8B9F0E6A4C1EF0760A5142BC1F55BEAF7AF7795B054441297F3FA3DAA5EFEF410D86A9F45AAE77A&_m=ea74d3cf50f9b3dada483f9724e7239f\" data-from=\"%2fuserinfo.html\">获取验证码</a>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "<div class=\"ops\">\n" +
            "<a class=\"m_new_u-btn u-btn-c2\" href=\"javascript:;\" style=\"font-size:1.8rem\" id=\"btnCheck\">提交</a>\n" +
            "</div>\n" +
            "<p style=\"padding-bottom:25rem\"></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "<div class=\"m-loading z-hide\"><span class=\"itm\"></span><span class=\"itm\"></span><span class=\"itm\"></span><span class=\"itm\"></span><span class=\"itm\"></span><span class=\"itm\"></span></div>\n" +
            "<script src=\"/vendor/require/require.js\" data-main=\"/js/mobileLogin\" defer async=\"true\"></script>\n" +
            "</body>\n" +
            "</html>\n" +
            "\n" +
            "Process finished with exit code 0\n";
}
