package mybatis.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.runners.MethodSorters;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.Service.*;
import mybatis.model.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(TestServiceUser.class);
    
    private static ApplicationContext context = null;
    private static IServiceUser userservice = null;
    
    Date from = new Date();
    SimpleDateFormat tf = new SimpleDateFormat("yy/MM/dd");
    String dtm = tf.format(from);
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        userservice = context.getBean("userService", IServiceUser.class);
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        ((ClassPathXmlApplicationContext)context).close();
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testInsertUser() {
        ModelUser board = new ModelUser();
        board.setUserid("하핫ㅋㅋ");
        board.setEmail("noonnunana@naver.com");
        board.setMobile("010-8789-2222");
        board.setInsertDT(from);
        board.setInsertUID("박진영");
        board.setName("초초");
        board.setPasswd("타닥탁탁");
        board.setUpdateDT(from);
        board.setUpdateUID("박진영");
        
        //IServiceUser service = new ServiceUser(session);
        int result = userservice.insertUser(board);
        
        assertEquals(result, 1);
    }
    @Test
    public void testLogin() {
        ModelUser board = new ModelUser();
        board.setUserid("트와이스");
        board.setPasswd("twice1234");
        //IServiceUser service = new ServiceUser(session);
        ModelUser result = userservice.login(board);
        
        assertEquals(result.getUserid(), "트와이스");
    }
    @Test
    public void testupdateUserInfo() {
        ModelUser updatevalue = new ModelUser();
        updatevalue.setEmail("sonyo@hanmail.net");
        updatevalue.setMobile("010-5555-6666");
        updatevalue.setName("소녀시대");
        updatevalue.setRetireYN(true);
        updatevalue.setPasswd("girls8888");
        updatevalue.setUpdateDT(from);
        updatevalue.setUpdateUID("JYP");
        
        ModelUser searchvalue = new ModelUser();
        searchvalue.setUserno(1); 
        
        //IServiceUser service = new ServiceUser(session);
        int result = userservice.updateUserInfo(updatevalue, searchvalue);
        
        assertEquals(result, 1);
    }
    @Test
    public void testupdatePasswd() {
        ModelUser updatevalue = new ModelUser();
        updatevalue.setPasswd("크리스마스");
        
        ModelUser searchvalue = new ModelUser();
        searchvalue.setUserid("레드벨벳"); 
        
        //IServiceUser service = new ServiceUser(session);
        int result = userservice.updatePasswd(updatevalue, searchvalue);
        
        assertEquals(result, 1);
    }
    @Test
    public void testUpdatedeleteUser() {
        ModelUser searchvalue = new ModelUser();
        searchvalue.setUserid("MISS A"); 
        
        //IServiceUser service = new ServiceUser(session);
        int result = userservice.UpdatedeleteUser(searchvalue);
        
        assertEquals(result, 1);
    }
    @Test
    public void testselectUserOne() {
        ModelUser board = new ModelUser();
        board.setUserno(5);
       // IServiceUser service = new ServiceUser(session);
        ModelUser result = userservice.selectUserOne(board);
        
        assertEquals(result.getUserid(), "MISS A");
    }
    @Test
    public void testselectUserList() {
        
        ModelUser board = new ModelUser();
        board.setName("소");

        //IServiceUser service = new ServiceUser(session);
        List<ModelUser> result = userservice.selectUserList(board);        
        assertEquals(result.size(), 4);
    }
}
