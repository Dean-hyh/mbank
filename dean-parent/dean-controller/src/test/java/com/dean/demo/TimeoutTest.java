package com.dean.demo;

import com.dean.demo.utils.JsonUtils;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

public class TimeoutTest {
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long start = System.currentTimeMillis();
        String result = timeoutMethod(1000);
        System.out.println("方法实际耗时：" + (System.currentTimeMillis() - start) + "毫秒");
        System.out.println("结果：" + result);

        try {
            Thread.sleep(8000);
            long start1 = System.currentTimeMillis();
            String result1 = timeoutMethod(5000);
            System.out.println("方法实际耗时：" + (System.currentTimeMillis() - start1) + "毫秒");
            System.out.println("结果：" + result1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 有超时时间的方法
     * @param timeout
     * @return
     */
    private static String timeoutMethod(int timeout) {
        String result;
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return unknowMethod();
            }
        });

        executorService.execute(futureTask);
        try {
            result = futureTask.get(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            futureTask.cancel(true);
            result = "默认";
        }

        return result;
    }

    /**
     * 这个方法的耗时不确定
     * @return
     */
    private static String unknowMethod() {
        Random random = new Random();
        int time = (random.nextInt(10) + 1) * 1000;
        System.out.println("任务将耗时： " + time + "毫秒");
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "获得方法执行后的返回值";
    }

    @Test
    public void test7(){
        String str = "{\n" +
                "    \"code\":\"AAAAAA\",\n" +
                "    \"response\":{\n" +
                "        \"STATUS\":\"1\",\n" +
                "        \"MSG\":\"交易完成\",\n" +
                "        \"data\":{\n" +
                "            \"A000000001\":{\n" +
                "                \"taskProgress1\":\"0\",\n" +
                "                \"taskProgress2\":\"1\",\n" +
                "                \"taskIsCompleted\":\"0\"\n" +
                "            },\n" +
                "            \"A000000002\":{\n" +
                "                \"taskProgress1\":\"1\",\n" +
                "                \"taskProgress2\":\"1\",\n" +
                "                \"taskIsCompleted\":\"1\"\n" +
                "            },\n" +
                "            \"A000000003\":{\n" +
                "                \"taskProgress1\":\"500\",\n" +
                "                \"taskProgress2\":\"1000\",\n" +
                "                \"taskIsCompleted\":\"0\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(str);

    }
}