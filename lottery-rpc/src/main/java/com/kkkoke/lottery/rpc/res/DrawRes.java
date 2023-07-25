package com.kkkoke.lottery.rpc.res;

import com.kkkoke.lottery.common.Result;
import com.kkkoke.lottery.rpc.dto.AwardDTO;

import java.io.Serializable;

/**
 * @author KeyCheung
 * @date 2023/07/25
 * @desc 抽奖结果
 */
public class DrawRes extends Result implements Serializable {


    private AwardDTO awardDTO;

    public DrawRes(String code, String info) {
        super(code, info);
    }

    public AwardDTO getAwardDTO() {
        return awardDTO;
    }

    public void setAwardDTO(AwardDTO awardDTO) {
        this.awardDTO = awardDTO;
    }

}