package com.dean.demo.service.ibmmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/16 13:47
 */
public class TextMessageListener implements MessageListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            String msgStr = msg.getText();
            System.out.println("队列收到的消息: \n" + msgStr);
        } catch (Exception e) {
            logger.error("队列监听异常{}",e);
            e.printStackTrace();
        }
    }
}