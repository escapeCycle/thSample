package com.xunhuan.logging.logback;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.PatternLayoutEncoderBase;

/**
 * Created by houzh on 16/11/10.
 */
public class TraceNoPatternLayoutEncoder extends PatternLayoutEncoderBase<ILoggingEvent> {


    public void start() {
        PatternLayout patternLayout = new TraceNoPatternLayout();
        patternLayout.setContext(this.context);
        patternLayout.setPattern(this.getPattern());
        patternLayout.setOutputPatternAsHeader(this.outputPatternAsHeader);
        patternLayout.start();
        this.layout = patternLayout;
        super.start();
    }
}
