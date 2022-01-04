package com.wrh.sublet.common.core.constants;

public interface SecurityConstants {

    /**
     * 内部
     */
    String FROM_IN = "INNER";

    /**
     * 标志
     */
    String FROM = "from";


    /**
     * AUTHORIZATION
     */
    String AUTHORIZATION = "Authorization";

    /**
     * JWT令牌前缀
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * jwt-jti
     */
    String JTI = "jti";

    /**
     * exp
     */
    String EXP = "exp";

    /**
     * 请求头 clientId:secret 字段
     */
    String TOKEN_LOGOUT_PREFIX = "logout:";

    /**
     * client_id
     */
    String CLIENT_ID = "client_id";

    /**
     * secret
     */
    String SECRET = "secret";

    /**
     * grant_type
     */
    String GRANT_TYPE = "grant_type";

    /**
     * refresh_token
     */
    String REFRESH_TOKEN = "refresh_token";

    /**
     * 验证码uuid key
     */
    String VT = "vt";

    /**
     * 验证码
     */
    String VC = "vc";

    /**
     * 用户名
     */
    String IA = "ia";

    /**
     * 密码
     */
    String IP= "ip";
}
