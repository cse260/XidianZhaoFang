package com.cse260.lease.common.constant;

public class RedisConstant {
    public static final String ADMIN_LOGIN_PREFIX = "admin:login:";
    public static final Integer ADMIN_LOGIN_CAPTCHA_TTL_SEC = 60;
    public static final String APP_LOGIN_PREFIX = "app:login:";
    public static final Integer APP_LOGIN_CODE_RESEND_TIME_SEC = 60;
    public static final Integer APP_LOGIN_CODE_TTL_SEC = 60 * 10;
    public static final String APP_ROOM_PREFIX = "app:room:";

    public static final String COUPON_CACHE_KEY_PREFIX="prs:coupon:";

    public static final String USER_COUPON_CACHE_KEY_PREFIX="prs:user:coupon:";

}