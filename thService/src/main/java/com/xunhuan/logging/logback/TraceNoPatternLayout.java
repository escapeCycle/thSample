package com.xunhuan.logging.logback;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by houzh on 16/11/10.
 */
public class TraceNoPatternLayout extends PatternLayout {

    @Override
    public String doLayout(ILoggingEvent event) {

        String s = super.doLayout(event);

        String traceNo = event.getMDCPropertyMap().get("traceNo");
        if(s!= null && event.getThrowableProxy() != null && traceNo != null){
            if(s.endsWith("\n")){
                s = StringUtils.replace(s.substring(0, s.length() - 1), "\n", "\n[" + traceNo + "]\t")+"\n";
            }else {
                s = StringUtils.replace(s, "\n", "\n[" + traceNo + "]\t");
            }
        }
        return s;
    }
}
