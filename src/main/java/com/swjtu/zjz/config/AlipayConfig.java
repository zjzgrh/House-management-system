package com.swjtu.zjz.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2020-05-23
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102200740386";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIR0E3Nhq+lzAULW48wHoof1ezFv6DB3o4UaTS38J3J6wEVzlsOU4kmk0/VdmShafD9OlqkFdX+rcSnbqzW2gLyyV6fyIwn6+NhgPrxfhLWyAUbnjksF6WXTxhB7lpizm0UxrBDDhB/HhTvtr6R7BCi2sLmKDgHOnO3pHy0Q157GBYkX06BKtanqsz/yltD3saHRNdzN8Bg9NoCcys4luyG4m88UkOFlPbF3Z4e6EnHHry43sV61B8ucJ2UAi1+QZsB7pDvD7EOwKa0CkMri9ssz89VVjK8CRbsYflJBUCWMM5F52LEhGK1TUKcPnjr1crX5jcZ7wt6+lrEVGA4Mv5AgMBAAECggEABrOyYlu3zv2ycJuXW0d/+nPgxT7xP1Jj0Vc6iuBUOPXrgL8lZMwgqq4n9GBtdcY67OkjfYkhsoLy8+hr4RwyrrnL2w1bihagVI5trO+seVA+8KJKMbz2ueBV8tOla6pcKSEZJLtMHPqklEHDlSFnaq5eklBsQPlLClBpzw424nMKGihCj7ncaNfB5T7g/VwvLSaVIXT8z5UAL8wBCNNrXUeXLODzpM1fyQxN+fHQNYwaWK5QGS7awgQ8FbfJ3QgGMniGv57m73OPzilb1NdEBk3COrGAGxOzvvkTRVhiQeD8kxT7ejOmzQf89wxwHk5gi2WKSsOcvBhlfAplvAzkbQKBgQDDT3LLqWte8NXpkQ+V5CqqRASHPp9mTGrHExKM6+dot+4FEMHTLAW5GDSWwbfEPUC4RqFXKl7Gy+j7L/VjH8ZLILHZG9Zgwo8/QKENoe/R0WmMrosInonuF35TzlKkx2fLmIlscAYgKLDu2V/8/VF3kwzMSirFguMju8Rj6TFaDwKBgQCyn+1PoT7RZqxXcIQrYltcXdwAAXY1EWjQOFsvKqoTP9c43CaF3ivhqG3fdLJgVwx1fCbBOtKtrqvqToubwHagFxfT9Xz6BFUBkTchR2PTwHpYXq1/EfbyJFz2vIjfK/0+J56/geWoacidATfQwfLk70qkg8omHEos/MDVQGwhdwKBgDg4eXH4rcihiOH3+MWL7WAfvjH0K8w1uRLfAZsBGRbCw0g//5s689bJCfJPhwd9HlEtO6osryWIcuNDdd53ugvMOIWnhrlJqBRsFTAoajE6l6iAYdM0V73qk1mqbY2zPMSVfxFw2cKOFAhdGE1p2faSpL91pgQ+3gVeOnUMHkGvAoGAXBJta29NBvjqesPHjOlM+GZ1ARe/y4jmwvVZow1Vz0hH8sofnT8w1UdRIy5ux5P3GxPckht0/wubF9JWyfjB7LEamineuqzC+GTWyvOWdE6xgZ2Dxo0HAjdWJ+R0lLyC86fOfx5At7eXLb6z+4oNXo4tpnE8ILrSTTAXYZSsZ+8CgYEAlSiN1SJ7azFdXlHVI5xJ8hhDuqZqXUvscfWujO/NxTf7PirK2nEiUHpUJCvHh3MEStdsTdtlg5PDydIePMS9XcHKXHaAMsKqNYSSttCkkiQlu21Qf26NVd+ypoAxnqK3lk57yJLAazYvh8CDdhrpfeyfsR3Cx+VELMouW41Qvqo=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1P/f5uRTAc9cdk/RGi/dsXceBpV5BwicVrQecJdVl+zGzc+ivXfrkPDueWS5jFHorrA4RHdlsznHNoEb/V5F7fvKFuTyuO80MwQ3HNfcIuwVm/9nUg+jCORe74b+Y94n4DXr6fQeyt1T+hDxynnTWzozDMnqEPc8WxyHD0wN1umhDO+FwxkPqqeGFH/FZ1R8d95CIdo0jCurs3h/mmeSHFVB/hx0ePis8Wzau7i+muxgYPObLp8a1cm9J7Ou+cy1qmMp6oHlja0+YdeXbrnDZ8PFEq3zhqkB3mfBNZkqUQMZfR3SjZgk469Tu8b3CbZEQsISh/ORwOsRSU/vmpiBiwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://127.0.0.1:8080/notifyUrl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8080/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "https://openapi.alipaydev.com/gateway.do";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
