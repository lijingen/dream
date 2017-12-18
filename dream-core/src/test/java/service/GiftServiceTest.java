package service;

import com.yy.dream.core.CoreApplication;
import com.yy.dream.core.db.domain.GiftInfo;
import com.yy.dream.core.db.mapper.GiftInfoMapper;
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
    GiftInfoMapper giftInfoMapper;

    @Test
    public void test() {
        GiftInfo gift = new GiftInfo();
        gift.setGiftName("玫瑰花3");
        gift.setGiftPrice(10);
        gift.setUid(1237L);
        try {
            giftInfoMapper.insert(gift);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            GiftInfo gift = giftInfoMapper.selectByPrimaryKey(1L);
            Assert.assertTrue(gift.getId() == 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
