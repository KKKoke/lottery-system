package com.kkkoke.lottery.rpc.res;

import com.kkkoke.lottery.common.Result;
import com.kkkoke.lottery.rpc.dto.ActivityDto;

import java.io.Serializable;

/**
 * @author KeyCheung
 * @date 2023/06/28
 * @desc
 */
public class ActivityRes implements Serializable {

    private Result result;

    private ActivityDto activity;

    public ActivityRes() {
    }

    public ActivityRes(Result result) {
        this.result = result;
    }

    public ActivityRes(Result result, ActivityDto activity) {
        this.result = result;
        this.activity = activity;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ActivityDto getActivity() {
        return activity;
    }

    public void setActivity(ActivityDto activity) {
        this.activity = activity;
    }
}