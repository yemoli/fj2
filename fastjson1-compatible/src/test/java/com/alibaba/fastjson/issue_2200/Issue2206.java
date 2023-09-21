package com.alibaba.fastjson.issue_2200;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class Issue2206 {
    @Test
    public void test_for_issue() throws Exception {
        JSON.parseObject("{\"date\":\"20181229162849\"}", Model.class);
    }

    public static class Model {
        public LocalDateTime date;
    }
}
