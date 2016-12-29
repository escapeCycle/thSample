package com.xunhuan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by escapeCycle on 2016/12/15.
 */
public class HelloWorld {

    protected static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        logger.info("hello world--{}","你好");
        String[] a = {"1","2"};
        try {
            System.out.printf("--"+a[3]);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            logger.error("error--{}",e.getStackTrace());
        }


    }
}
