package com.kkkoke.lottery.application.process.res;

import com.kkkoke.lottery.common.Result;
import com.kkkoke.lottery.domain.strategy.model.vo.DrawAwardInfo;

/**
 * @author KeyCheung
 * @date 2023/07/19
 * @desc 活动抽奖结果
 */
public class DrawProcessResult extends Result {

    private DrawAwardInfo drawAwardInfo;

    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardInfo drawAwardInfo) {
        super(code, info);
        this.drawAwardInfo = drawAwardInfo;
    }

    public DrawAwardInfo getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardInfo drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }
}