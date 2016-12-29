import com.xunhuan.entity.mybatis.overdue.OverdueEEndPayDetail;
import com.xunhuan.service.overdue.BidOverduePayDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by escapeCycle on 2016/12/15.
 */

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration("classpath:spring/spring-core.xml")
public class MockTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BidOverduePayDetailService bidOverduePayDetailService;

    @Test
    public void testOverdueService(){
        OverdueEEndPayDetail entity = new OverdueEEndPayDetail();
        entity.setBidId(121121L);
        entity.setAmount(new BigDecimal("1000.00"));
        entity.setBidSurplusAmount(new BigDecimal("500.00"));
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        entity.setOverdueOperator(1L);
        entity.setReason("测试");
        entity.setRemark("测试1");
        bidOverduePayDetailService.insert(entity);
    }

    @Test
    public void testQueryOverdue(){
        List<OverdueEEndPayDetail> list = bidOverduePayDetailService.list(113131L);
        for(OverdueEEndPayDetail entity : list){
            System.out.println(entity.getAmount());
        }

    }

}
