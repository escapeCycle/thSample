package com.xunhuan.controller;

import com.xunhuan.entity.mybatis.overdue.OverdueEEndPayDetail;
import com.xunhuan.service.overdue.BidOverduePayDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by escapeCycle on 2016/12/15.
 */
@Controller
@RequestMapping(value = "/overdue")
public class BidOverduePayDetailController {

    @Autowired
    private BidOverduePayDetailService bidOverduePayDetailService;

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response){
        List<OverdueEEndPayDetail> list = bidOverduePayDetailService.list(113131L);
        for(OverdueEEndPayDetail entity : list){
            System.out.println(entity.getAmount());
        }
        return "index";
    }
    @RequestMapping(value = "add")
    public String add(HttpServletRequest request, HttpServletResponse response){
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
        return "index";
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String demo(@RequestParam(value = "postData", required = false) final String postData) throws Exception {
        return "{'foo':'bar'}";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello1";
    }

}
