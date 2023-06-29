package com.kkkoke.lottery.rpc.req;

import java.io.Serializable;

/**
 * @author KeyCheung
 * @date 2023/06/28
 * @desc
 */
public class ActivityReq implements Serializable {

    private Long activityId;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}