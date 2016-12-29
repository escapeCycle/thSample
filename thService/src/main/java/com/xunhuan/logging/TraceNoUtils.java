package com.xunhuan.logging;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

/**
 * Created by houzh on 16/11/10.
 */
public class TraceNoUtils {

    /**
     * 产生新的traceNO 放到MDC中
     */
    public static void newTraceNo(){
        MDC.put("traceNo", RandomStringUtils.randomAlphanumeric(12));
    }

    public static void newTraceNo(String parentTranceNo){
        if(StringUtils.isNotEmpty(parentTranceNo)){
            MDC.put("traceNo",parentTranceNo + "-" + RandomStringUtils.randomAlphanumeric(12));
        }else{
            newTraceNo();
        }
    }

    public static String getTraceNo(){
        return MDC.get("traceNo");
    }

    public static void clearTraceNo(){
        MDC.remove("traceNo");
    }

}
