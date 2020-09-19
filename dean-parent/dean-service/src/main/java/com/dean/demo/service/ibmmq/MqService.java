package com.dean.demo.service.ibmmq;

import com.dean.demo.enums.DbankExceptionEnum;
import com.dean.demo.exception.DbankException;
import com.dean.demo.utils.JsonUtils;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.ibm.mq.*;
import com.ibm.mq.constants.MQConstants;
import org.springframework.stereotype.Service;
import sun.awt.windows.ThemeReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Dean
 * @version 1.0
 * @date 2020/5/3 12:15
 */
@Service
public class MqService {

    //队列信息
    private static MQQueueManager qMgr;
    private static final String MQ_MANAGER = "MQ_LINUX";
    private static final String QUEUE_NAME = "QUEUE_RES";
    //连接信息
    private static final String HOST = "192.168.230.129";
    private static final String CHANNEL = "CONN_CHANNEL";
    private static final Integer PORT = 1414;
    private static final String USER_ID = "mqm";
    private static final String PWD = "hz13554";
    private static Integer CCSID = 1208;
    private static Long start = 0L;
    private static Long end = 0L;

    public static void connect() throws MQException {
        MQEnvironment.hostname = HOST;
        MQEnvironment.channel = CHANNEL;
        MQEnvironment.port = PORT;
        MQEnvironment.userID = USER_ID;
        MQEnvironment.password = PWD;
        MQEnvironment.CCSID = CCSID;
        start = System.currentTimeMillis();
        System.out.println("===connect===" + start + "======");
        qMgr = new MQQueueManager(MQ_MANAGER);
    }

    public static void sendMsg(String msgStr) throws Exception {
        int openOptions = MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_OUTPUT | MQC.MQOO_INQUIRE;
        MQQueue queue = null;
        try {
            /*建立Q1通道的连接*/
            queue = qMgr.accessQueue(QUEUE_NAME, openOptions, null, null, null);
            /*要写入队列的消息*/
            MQMessage msg = new MQMessage();
            msg.format = MQC.MQFMT_STRING;
            msg.characterSet = CCSID;
            msg.encoding = CCSID;
            msg.writeString(msgStr);
            MQPutMessageOptions pmo = new MQPutMessageOptions();
            /*设置消息永不过期*/
            msg.expiry = -1;
            /*将消息放入队列*/
            queue.put(msg, pmo);
        }finally {
            if (queue != null) {
                try {
                    queue.close();
                    qMgr.disconnect();
                } catch (MQException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void receiveMsg() {
        int openOptions = MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_OUTPUT | MQC.MQOO_INQUIRE;
        MQQueue queue = null;
        try {
            queue = qMgr.accessQueue(QUEUE_NAME, openOptions, null, null, null);
            System.out.println("该队列当前的深度为:" + queue.getCurrentDepth());
            int depth = queue.getCurrentDepth();
            /*将队列的里的消息读出来*/
            while (depth-- > 0) {
                /*要读的队列的消息*/
                MQMessage msg = new MQMessage();
                MQGetMessageOptions gmo = new MQGetMessageOptions();
                queue.get(msg, gmo);
                System.out.println("消息的int大小为：" + msg.getDataLength());
                System.out.println("消息的内容：\n" + msg.readStringOfByteLength(msg.getDataLength()));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (queue != null) {
                try {
                    queue.close();
                } catch (MQException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean sendMessageToMq(String msg,int count){
        Boolean flag = false;
        if(count<4){
            System.out.println("第" + count + "次");
            try {
                connect();
                sendMsg(msg);
                flag = true;
            }catch (MQException e){
                end = System.currentTimeMillis();
                System.out.println("===MQException===" + end + "======");
                System.out.println("第" + count + "次连接时间：" + (end-start)/1000 + "秒");
                count++;
                sendMessageToMq(msg,count);
                e.printStackTrace();
            }catch (Exception e){
                sendMessageToMq(msg,count);
            }
        }else {
            System.out.println("系统异常，数据入库");
            return flag;
        }
        return flag;
    }

    public static void sendMessageToMq(String msg,int count,boolean b) throws Exception{
        try {
            connect();
            sendMsg(msg);
        }catch (MQException e){
            System.out.println("===MQException===" + System.currentTimeMillis() + "======");
            sendMessageToMq(msg,count);
        }catch (Exception e){
            sendMessageToMq(msg,count);
        }
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("date","20200504");
        map.put("time","12110101");
        map.put("desc","折扣");
        map.put("value","10");
        map.put("serNo","1001");
        map.put("task_id","T000000001");
        final String msg = JsonUtils.toString(map);
        try {
            sendMessageToMq(msg,3);
        }catch (Exception e){
            System.out.println("系统异常，数据入库" + JsonUtils.toMap(msg,String.class,Object.class));
            e.printStackTrace();
        }
    }

   /* public static void main(String[] args) throws InterruptedException, TimeoutException {
        Map<String,Object> map = new HashMap<>();
        map.put("date","20200504");
        map.put("time","12110101");
        map.put("desc","折扣");
        map.put("value","10");
        map.put("serNo","1001");
        final String msg = JsonUtils.toString(map);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("----==:" + Thread.currentThread().getName());
                    sendMessageToMq(msg,3,false);
                } catch (InterruptedException e) {
                    System.out.println(1233);
                    e.printStackTrace();
                    return;
                }catch (Exception e){
                    System.out.println(1234);
                    System.out.println("mq连接异常");
                    return;
                }
                System.out.println("继续执行任务");
            }
        });

        System.out.println(Thread.currentThread().getName());
        thread.start();
        TimeUnit.SECONDS.timedJoin(thread,5);
        if(thread.isAlive()){
            System.out.println(thread.getName() + ":" + thread.isAlive());
            thread.interrupt();
            //thread.stop();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("===TimeoutException===" + System.currentTimeMillis() + "======");
                throw new TimeoutException(thread.getName() + "Thread 超时");
            }
        }
        System.out.println(thread.getName() + ":" + thread.isAlive());
    }*/

    /*static class SendMsgToMq implements Callable<Boolean> {
        private String msg;
        private int count;

        public SendMsgToMq(String msg, int count) {
            this.msg = msg;
            this.count = count;
        }

        @Override
        public Boolean call() throws Exception {
            try {
                sendMessageToMq(msg,count);
                System.out.println(msg);
                System.out.println(count);
            } catch (InterruptedException e) {
                System.out.println(" is interrupted when calculating, will stop...");
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("date","20200504");
        map.put("time","12110101");
        map.put("desc","折扣");
        map.put("value","10");
        map.put("serNo","1001");
        final String msg = JsonUtils.toString(map);

        ExecutorService executor = Executors.newCachedThreadPool();
        SendMsgToMq task = new SendMsgToMq(msg,3);
        Future<Boolean> f1 = executor.submit(task);
        try {
            //future将在3秒之后取结果
            if (f1.get(3, TimeUnit.SECONDS)) {
                System.out.println("one complete successfully");
            }
        } catch (InterruptedException e) {
            System.out.println("future在睡着时被打断");
            executor.shutdownNow();
        } catch (ExecutionException e) {
            System.out.println("future在尝试取得任务结果时出错");
            executor.shutdownNow();
        } catch (TimeoutException e) {
            System.out.println("future时间超时");
            f1.cancel(true);
        } finally {
            executor.shutdownNow();
        }
    }*/

    /*public static void testTimeOut(){
        ExecutorService executor = Executors.newFixedThreadPool(1);
        SimpleTimeLimiter stl = new SimpleTimeLimiter(executor);
        String result = null;
        try {
            result = stl.callWithTimeout(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(10000);
                    return "qqqq";
                }
            },5,TimeUnit.SECONDS,true);
            System.out.println("正常使用：" + result);
        }catch (Exception ex){
            System.out.println("正常使用：" + result);
        }finally {
            executor.shutdown();
        }
    }*/

    /*public static void main(String[] args) {
        testTimeOut();
    }*/

    /*public static void errTest(){
        throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
    }

    public static void main(String[] args) {
        try {
            errTest();
        } catch (Exception e) {
            System.out.println("捕获到了异常");
            System.out.println("异常信息：" + e.getMessage());
        }
    }*/
}
