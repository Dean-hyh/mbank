package com.ms.credit.service;

import com.ms.credit.pojo.DTO.RaffleActivePageDTO;
import com.ms.credit.pojo.VO.RaffleActivePageVO;

import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/16 13:47
 */
public interface RaffleActivePageService {

    /**
     * 添加活动页面数据
     * @param raffleActivePageDTO
     */
    void addRafflePage (RaffleActivePageDTO raffleActivePageDTO);

    List<RaffleActivePageVO> getRaffleList();

    RaffleActivePageDTO getRaffleById(Long raffleActiveId);

    void deleteRaffleActive(Long raffleActiveId);
}
