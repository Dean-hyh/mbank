package com.dean.demo.service.ibmmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author Dean
 * @version 1.0
 * @date 2020/5/3 14:13
 */
@Service
public class IbmMqSendService {

    @Resource(name="senderJmsTemplate")
    private JmsTemplate jmsTemplate;

    public void sendMessage(final String message) {
        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
