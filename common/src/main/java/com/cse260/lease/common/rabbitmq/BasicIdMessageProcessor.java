package com.cse260.lease.common.rabbitmq;

import cn.hutool.core.lang.UUID;
import com.cse260.lease.common.constant.MqConstants;
import org.slf4j.MDC;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;


public class BasicIdMessageProcessor implements MessagePostProcessor {
    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        String requestId = MDC.get(MqConstants.REQUEST_ID_HEADER);
        if (requestId == null) {
            requestId = UUID.randomUUID().toString(true);
        }
        // 写入RequestID标示
        message.getMessageProperties().setHeader(MqConstants.REQUEST_ID_HEADER, requestId);
        return message;
    }
}
