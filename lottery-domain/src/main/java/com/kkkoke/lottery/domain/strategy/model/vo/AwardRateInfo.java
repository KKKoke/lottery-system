package com.kkkoke.lottery.domain.strategy.model.vo;

import java.math.BigDecimal;

/**
 * @author KeyCheung
 * @date 2023/07/02
 * @desc 奖品概率信息，奖品编号，库存，概率
 */
public class AwardRateInfo {

    /**
     * 奖品 ID
     */
    private String awardId;

    /**
     * 中奖概率
     */
    private BigDecimal awardRate;

    public AwardRateInfo() {
    }

    public AwardRateInfo(String awardId, BigDecimal awardRate) {
        this.awardId = awardId;
        this.awardRate = awardRate;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }
}