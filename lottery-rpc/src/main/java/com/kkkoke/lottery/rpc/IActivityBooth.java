package com.kkkoke.lottery.rpc;

import com.kkkoke.lottery.rpc.req.ActivityReq;
import com.kkkoke.lottery.rpc.res.ActivityRes;

/**
 * @author KeyCheung
 * @date 2023/06/28
 * @desc 活动展台
 */
public interface IActivityBooth {

    ActivityRes queryActivityById(ActivityReq req);
}