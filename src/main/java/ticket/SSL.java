package ticket;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Created by wangxizhong on 17/5/21.
 */
public class SSL {

    public static SSLContext createIgnoreVerifySSL()  {
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("SSLv3");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        try {
            sc.init(null, new TrustManager[]{trustManager}, null);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return sc;
    }
}
