package com.kkkoke.lottery.test.dao;

import com.kkkoke.lottery.infrastructure.dao.IUserTakeActivityDao;
import com.kkkoke.lottery.infrastructure.po.UserTakeActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author KeyCheung
 * @date 2023/07/18
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTakeActivityDaoTest {

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Test
    public void testInsert() {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
//        userTakeActivity.setuId("Uhdgkw766120d"); // 1库：Ukdli109op89oi 2库：Ukdli109op811d
        userTakeActivity.setuId("kkkoke"); // 1库：Ukdli109op89oi 2库：Ukdli109op811d
        userTakeActivity.setTakeId(1454355275833278460L);
        userTakeActivity.setActivityId(100001L);
        userTakeActivity.setActivityName("测试活动");
        userTakeActivity.setTakeDate(new Date());
        userTakeActivity.setTakeCount(10);
        userTakeActivity.setUuid("kkkoke_uuid");

        userTakeActivityDao.insert(userTakeActivity);
    }

}