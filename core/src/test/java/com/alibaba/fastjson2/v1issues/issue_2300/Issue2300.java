package com.alibaba.fastjson2.v1issues.issue_2300;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Issue2300 {
    @Test
    public void test_for_issue() {
        String text = "{\"createTime\":1548166745}";

        Order o = JSON.parseObject(text, Order.class);
        assertEquals(1548166745000L, o.createTime.getTime());

        String json = JSON.toJSONString(o);
        assertEquals("{\"createTime\":1548166745}", json);

        //新增校验1
        JSONObject jsonObject = JSON.parseObject(text);
        Order order1 = jsonObject.toJavaObject(Order.class);
        //校验不通过
        assertEquals(1548166745000L, order1.createTime.getTime());

        //新增校验2
        Order order2 = jsonObject.toJavaObject(Order.class);
        //校验不通过
        assertEquals(1548166745000L, order2.createTime.getTime());
    }

    public static class Order {
        @JSONField(format = "unixtime")
        public Date createTime;
    }
}
