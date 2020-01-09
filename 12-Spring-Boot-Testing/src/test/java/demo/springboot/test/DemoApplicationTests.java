package demo.springboot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads1() throws Exception {
        String mrbird = mockMvc.perform(MockMvcRequestBuilders.get("/user/{userName}", "mrbird")).andReturn().getResponse().getContentAsString();
        System.out.println(mrbird);
        String content = mockMvc.perform(MockMvcRequestBuilders.post("/user/{id}", 1)).andReturn().getResponse().getContentAsString();
        System.out.println(content);
    }

    /**
     * 在执行中会出现异常：
     * java.lang.NullPointerException
     * 	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:95)
     * 	at org.springframework.test.web.servlet.setup.PatternMappingFilterProxy.doFilter(PatternMappingFilterProxy.java:102)
     * 	at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
     * 	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
     * 	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
     * 	...
     *
     * 	解决方案：将druid中的filter设置改成false:
     * 	spring.datasource.druid.WebStatFilter.enabled=false
     * @throws Exception
     */
    @Test
    void contextLoads() throws Exception {
        String content = mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andReturn().getResponse().getContentAsString();
        System.out.println(content);
    }
}
