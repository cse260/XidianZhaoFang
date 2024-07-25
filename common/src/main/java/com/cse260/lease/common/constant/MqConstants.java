package com.cse260.lease.common.constant;

public class MqConstants {

        public static final String REQUEST_ID_HEADER = "requestId";


        /*异常信息的交换机*/
        public static final String ERROR_EXCHANGE = "error.topic";

        /*促销服务有关的交换机*/
        public static final String COUPON_EXCHANGE = "coupon.topic";


        public static final String ERROR_QUEUE_TEMPLATE = "error.{}.queue";


        /*异常RoutingKey的前缀*/
        public static final String ERROR_KEY_PREFIX = "error.";


        /**领取优惠券的key*/
        public static final String COUPON_RECEIVE = "coupon.receive";



}
