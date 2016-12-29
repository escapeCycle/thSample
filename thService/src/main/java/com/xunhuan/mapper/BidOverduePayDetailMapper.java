package com.xunhuan.mapper;

import com.xunhuan.entity.mybatis.overdue.OverdueEEndPayDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by escapeCycle on 2016/12/15.
 */
@Repository
public interface BidOverduePayDetailMapper {

    public int insert(OverdueEEndPayDetail enity);

    List<OverdueEEndPayDetail> list(@Param("bidId") Long bidId);
}
