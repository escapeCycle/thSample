package com.xunhuan.queuedemo;

import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 * Created by escapeCycle on 2016/12/21.
 */
public class Producer extends EndPoint {
    public Producer(String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("", endPointName, null, SerializationUtils.serialize(object));
    }

}
