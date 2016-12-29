package com.xunhuan.service.overdue;

import com.xunhuan.entity.mybatis.overdue.OverdueEEndPayDetail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by escapeCycle on 2016/12/15.
 */
public interface BidOverduePayDetailService {

    int insert(OverdueEEndPayDetail entity);

    List<OverdueEEndPayDetail> list(Long bidId);

}
