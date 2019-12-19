package com.ms.credit.service;

import com.ms.credit.pojo.DTO.RaffleActiveWinnerDTO;

import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/19 17:06
 */
public interface RaffleActiveWinnerService {
    void insertWinner(List<RaffleActiveWinnerDTO> winnerDTOList);

    List<RaffleActiveWinnerDTO> downloadWinnerListByRaffleActiveId(Long raffleAcriveId);
}
