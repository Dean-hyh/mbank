package com.dean.demo.service.ibmmq;

import com.dean.demo.service.DreamPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private DreamPageService dreamPageService;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            String msgStr = msg.getText();
            logger.info("MQ监听到的消息："+ msgStr);
            //调用service方法处理消息
            dreamPageService.increaseDreamValue(msgStr);


        } catch (Exception e) {
            logger.error("队列监听异常{}",e);
            e.printStackTrace();
        }
    }
}