package com.kkkoke.lottery.application.process.res;

import com.kkkoke.lottery.common.Result;

/**
 * @author KeyCheung
 * @date 2023/07/25
 * @desc
 */
public class RuleQuantificationCrowdResult extends Result {

    /**
     * 活动ID
     */
    private Long activityId;

    public RuleQuantificationCrowdResult(String code, String info) {
        super(code, info);
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}