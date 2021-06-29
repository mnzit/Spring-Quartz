package com.mnzit.service;

import java.util.HashMap;
import java.util.Map;

public class Tester {

    public Map<String, String> map = new HashMap<>();

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getValue(String key) {
        return map.get(key);
    }

    public void setValue(String key, String value) {
        this.map.put(key, value);
    }

    public void testMethod(String o) {
        if (map.get("runOnce") != null) {
            testMethod2();
        } else {
            testMethod2();
            testMethod2();
        }
    }

    public String testMethod2() {
        return "asd";
    }
}
