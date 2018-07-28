package com.buddhist.daily;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class HelloControllerTest {

    @Autowired
    WebApplicationContext webApplicationConnect;

    private MockMvc mvc;

    @Before
    public void setup(){
        //mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
    }

    @Test
    public void testAPI() throws Exception {
        RequestBuilder request = null;
        request = MockMvcRequestBuilders.get("/hello"); //.param("userName", "WangYulin_1");
        ResultActions result = mvc.perform(request).andDo(print());
        MvcResult mvcResult = result.andReturn();
        System.out.println("------------------------");
        System.out.println(mvcResult.getResponse().getContentAsByteArray());
        System.out.println("------------------------");
        mvc.perform(request).andDo(print()).andExpect(status().isOk());
        //System.out.println(result);
        //.andExpect(status().isOk())
        //.andExpect(content().string("Wangyulin"));
        //result.andExpect(status().isOk());  //测试请求反馈状态
    }

    @Test
    public void testAPI_2() throws Exception {
        RequestBuilder request = null;
        request = MockMvcRequestBuilders.get("/hello");
        ResultActions result = mvc.perform(request).andDo(print());
        MvcResult mvcResult = result.andReturn();
        System.out.println("------------------------");
        System.out.println(new String(mvcResult.getResponse().getContentAsByteArray()));
        System.out.println("------------------------");
        mvc.perform(request).andDo(print()).andExpect(status().isOk());
    }

}
