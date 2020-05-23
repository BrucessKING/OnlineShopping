package top.bigking.constant;

/**
 * @Author ABKing
 * @since 2020/5/14 下午5:58
 **/

public class Constant {

    /**
     * 数据请求返回码
     */
    public static final int RESCODE_SUCCESS = 1000;             //成功
    public static final int RESCODE_SUCCESS_MSG = 1001;          //成功(有返回信息)
    public static final int RESCODE_EXCEPTION = 1002;        //请求抛出异常
    public static final int RESCODE_NOLOGIN = 1003;             //未登陆状态
    public static final int RESCODE_NOEXIST = 1004;             //查询结果为空
    public static final int RESCODE_NOAUTH = 1005;          //无操作权限
    public static final int RESCODE_LOGINEXPIRE = 1006;             //登录过期
    /**
     * token
     */
    public static final int JWT_ERRCODE_EXPIRE = 1007;//Token过期
    public static final int JWT_ERRCODE_FAIL = 1008;//验证不通过

    /**
     * jwt
     */
    public static final String JWT_ID = "jwt-ABKing";//jwt签发者
    public static final String JWT_SECRET = "Isi5Ob9OfvJt+4IHoMJlHkS1ttg=";//密匙
    public static final int JWT_TTL = 60*60*1000; // 60*60*1000;  //millisecond
    public static final int JWT_REFRESH_INTERVAL = 18*1000; //55*60*1000;  //millisecond
    public static final int JWT_REFRESH_TTL = 60*1000; // 12*60*60*1000;  //millisecond

}