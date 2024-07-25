package com.cse260.lease.web.app.handle;


import com.cse260.lease.common.constant.MqConstants;
import com.cse260.lease.web.app.dto.coupon.UserCouponDTO;
import com.cse260.lease.web.app.service.UserCouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CouponHandler {

    @Autowired
    private UserCouponService userCouponService;
    @RabbitListener(bindings = @QueueBinding(value =@Queue(value="coupon.receive.queue",durable = "true"),
            exchange =@Exchange(value = MqConstants.COUPON_EXCHANGE, type= ExchangeTypes.TOPIC),
            key=MqConstants.COUPON_RECEIVE))
    public void onMsg(UserCouponDTO msg){
        log.debug("收到领卷消息 {}",msg);

        userCouponService.createUserCoupon(msg);
    }
}
