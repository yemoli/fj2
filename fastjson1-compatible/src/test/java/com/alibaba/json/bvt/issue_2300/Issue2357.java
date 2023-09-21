package com.alibaba.json.bvt.issue_2300;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Issue2357 {
    @Test
    public void test_for_issue() throws Exception {
        ByteBuffer buff = ByteBuffer.allocate(32);
        buff.putInt(100);
        buff.flip();

        String result = JSON.toJSONString(buff);
        System.out.println(result);

        assertEquals("{\"array\":\"AAAAZAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=\",\"limit\":4,\"position\":0}", result);

        ByteBuffer buf1 = JSON.parseObject(result, ByteBuffer.class);

        assertEquals(buff.capacity(), buf1.capacity());
        assertEquals(buff.limit(), buf1.limit());
        assertEquals(buff.position(), buf1.position());

    }
}
