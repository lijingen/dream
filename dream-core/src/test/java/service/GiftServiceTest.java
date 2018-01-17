package service;

import com.yy.dream.core.CoreApplication;
import com.yy.dream.core.api.bean.GiftInfo;
import com.yy.dream.core.api.service.IGiftCenterService;
import com.yy.dream.core.config.mysql.ContextHolder;
import com.yy.dream.core.config.mysql.DataSourceType;
import com.yy.dream.core.db.mapper.GiftInfoMapper;
import com.yy.dream.core.service.impl.GiftCenterServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lijingen on 2017/5/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
public class GiftServiceTest {

    @Autowired
    IGiftCenterService giftCenterService;

    @Test
    public void test() {
        GiftInfo giftInfo=new GiftInfo();
        giftInfo.setGiftName("aaa");
        giftInfo.setGiftPrice(11);
        giftInfo.setUid(12307L);
        giftCenterService.createGift(giftInfo);
    }

    @Test
    public void test2() {
    }
}
