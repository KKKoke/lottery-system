package com.kkkoke.lottery.application.process.res;

import com.kkkoke.lottery.common.Result;
import com.kkkoke.lottery.domain.strategy.model.vo.DrawAwardVO;

/**
 * @author KeyCheung
 * @date 2023/07/19
 * @desc 活动抽奖结果
 */
public class DrawProcessResult extends Result {

    private DrawAwardVO drawAwardVO;

    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardVO drawAwardVO) {
        super(code, info);
        this.drawAwardVO = drawAwardVO;
    }

    public DrawAwardVO getDrawAwardVO() {
        return drawAwardVO;
    }

    public void setDrawAwardVO(DrawAwardVO drawAwardVO) {
        this.drawAwardVO = drawAwardVO;
    }
}