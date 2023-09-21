package com.alibaba.fastjson2.annotation;

import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONTypeIgnores {
    @Test
    public void test0() {
        Bean bean = new Bean();
        bean.id = 101;
        bean.name = "DataWorks";
        assertEquals("{\"id\":101}", JSON.toJSONString(bean));
    }

    @Test
    public void test1() {
        Bean1 bean = new Bean1();
        bean.id = 101;
        bean.name = "DataWorks";
        assertEquals("{\"id\":101}", JSON.toJSONString(bean));
    }

    @JSONType(ignores = "name")
    public static class Bean {
        public int id;
        public String name;
    }

    @JSONType(ignores = "name")
    public static class Bean1 {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
