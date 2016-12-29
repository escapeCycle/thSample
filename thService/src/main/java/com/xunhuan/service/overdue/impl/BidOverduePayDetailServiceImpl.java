package com.xunhuan.service.overdue.impl;

import com.xunhuan.entity.mybatis.overdue.OverdueEEndPayDetail;
import com.xunhuan.mapper.BidOverduePayDetailMapper;
import com.xunhuan.service.overdue.BidOverduePayDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by escapeCycle on 2016/12/15.
 */
@Service
@Transactional
public class BidOverduePayDetailServiceImpl implements BidOverduePayDetailService{

    @Autowired
    private BidOverduePayDetailMapper bidOverduePayDetailMapper;

    public int insert(OverdueEEndPayDetail entity) {
        return bidOverduePayDetailMapper.insert(entity);
    }

    public List<OverdueEEndPayDetail> list(Long bidId) {
        return bidOverduePayDetailMapper.list(bidId);
    }
}
