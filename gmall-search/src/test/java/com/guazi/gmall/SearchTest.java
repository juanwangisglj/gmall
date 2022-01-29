package com.guazi.gmall;

import com.alibaba.fastjson.JSON;
import com.guazi.gmall.config.ElasticSearchConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author glj
 * @date 2022/1/29 6:25 下午
 */
@SpringBootTest
public class SearchTest {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void testSearch(){

        System.out.println(client);
    }

    @Test
    public void testIndex() throws IOException {
        IndexRequest indexRequest = new IndexRequest("user");
        indexRequest.id("1");
//        indexRequest.source("userName","glj","age",18);
        //直接传json数据
        User user = new User("glj","男",11);
        String jsonString = JSON.toJSONString(user);
        indexRequest.source(jsonString, XContentType.JSON);
        IndexResponse index = client.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);

        System.out.println(index);

    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class User{
        private String userName;
        private String gender;
        private Integer age;
    }



}
