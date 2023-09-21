package com.alibaba.fastjson2.v1issues.issue_2200;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Issue_for_luohaoyu {
    @Test
    public void test_for_issue() {
        Map map = new HashMap();
        map.put(null, 123);

        String str = JSON.toJSONString(map);
        assertEquals("{\"null\":123}", str);

        JSONObject object = JSON.parseObject(str);
    }
}
