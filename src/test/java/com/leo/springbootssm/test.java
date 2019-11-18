package com.leo.springbootssm;

import com.leo.springbootssm.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 * Created by Liuq on 2019-11-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class test {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void testController(){
        // template.getForObject() 会得到 controller 返回的 json 值
        //String content = template.getForObject("/book/detail/1", String.class);
        Book book = template.getForObject("/book/findbook", Book.class);
        // 使用断言测试，使用正确的断言
       // Assert.assertEquals("detail", content);
        Assert.assertNotNull(book);
    }
}
