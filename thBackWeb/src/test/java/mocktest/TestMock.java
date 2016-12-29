package mocktest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
/**
 * Created by escapeCycle on 2016/12/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-core.xml", "classpath:spring/spring-mvc.xml"})
@WebAppConfiguration
public class TestMock {

    private Logger logger = LoggerFactory.getLogger(TestMock.class);
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception{
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void test(){
        try {
//            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/overdue/test")
//                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                    .accept(MediaType.APPLICATION_JSON))
//                    .andDo(MockMvcResultHandlers.print())
//                    .andReturn();


            mockMvc.perform(get("/overdue/hello"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(view().name("hello1"));
//            String resp = result.getResponse().getContentAsString();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

    }
}
