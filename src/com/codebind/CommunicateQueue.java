package com.codebind;

import java.util.HashMap;
import java.util.Map;

public class CommunicateQueue {

    Map<String, Integer> hashMap = new HashMap<String, Integer>();

    public synchronized void send(String key, Integer val) {
        hashMap.put(key, val);
    }

    public synchronized Object receive() {
        if (hashMap.size() == 0)
            return null;

        Map.Entry<String, Integer> entry = hashMap.entrySet().iterator().next();
        hashMap.remove(entry.getKey());
        return entry;
    }
}
