package com.ms.credit;

import com.ms.credit.pojo.DO.RaffleActiveWinner;
import com.ms.credit.pojo.DTO.RaffleActiveWinnerDTO;
import com.ms.credit.service.RaffleActiveWinnerService;
import com.ms.credit.utils.SnowFlake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/19 18:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext-*.xml")
public class GenerateWinnerList {
    @Autowired
    private RaffleActiveWinnerService raffleActiveWinnerService;

    @Autowired
    private SnowFlake snowFlake;

    @Test
    public void generateList() {

        List<RaffleActiveWinnerDTO> winnerList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            RaffleActiveWinnerDTO winnerDTO = new RaffleActiveWinnerDTO();
            winnerDTO.setActiveWinnerId(snowFlake.nextId());
            if (i % 3 == 0) {
                winnerDTO.setAwardsName("一等奖");
                winnerDTO.setPrizeName("MacBook 16-inch");
                winnerDTO.setRaffleDetailId(1207578812539080704L);
            }else if(i%3==1){
                winnerDTO.setAwardsName("二等奖");
                winnerDTO.setPrizeName("iPhone 11pro");
                winnerDTO.setRaffleDetailId(1207578812589412352L);
            }else if(i%3==2){
                winnerDTO.setAwardsName("三等奖");
                winnerDTO.setPrizeName("5000元现金");
                winnerDTO.setRaffleDetailId(1207578812606189568L);
            }
            winnerDTO.setCustDesc("描述");
            winnerDTO.setCustId("cust_id_" + i);
            winnerDTO.setCustName("Dean·" + i + "_li");
            winnerDTO.setCustNo("cust_no" + i * 2 + "_No");
            winnerDTO.setCustTel("110" + i);
            winnerDTO.setRaffleActiveName("1219添加测试");
            winnerDTO.setRaffleActiveId(1207578808466411520L);
            winnerDTO.setRaffleActiveTime(new Date());
            winnerDTO.setStatus(0);
            winnerList.add(winnerDTO);
        }
        raffleActiveWinnerService.insertWinner(winnerList);
        System.out.println("执行完毕");
    }


    @Test
    public void queryTest(){
        Map<String, Object> params = new HashMap<>();
        params.put("winnerId",120761727992712806L);
        //params.put("activityId",1207578808466411520L);
        List<Map<String, Object>> maps = raffleActiveWinnerService.queryTest(params);
        for (Map<String, Object> map : maps) {
            map.put("hou","1342345234532452======");
            System.out.println(map);
        }
    }

    @Test
    public void queryTest1(){
        Map<String, Object> params = new HashMap<>();
        System.out.println("=++++++=" + params);
        params.put("winnerId",1207617279927128064L);
        Map<String, Object> map = raffleActiveWinnerService.queryTest1(params);
        if(StringUtils.isEmpty(map)){
            System.out.println("没查到相关数据");
            return;
        }
        map.put("yuanhui","hahahahaha");
        System.out.println(map);
        System.out.println("===="+map.get("hei"));

    }
}
