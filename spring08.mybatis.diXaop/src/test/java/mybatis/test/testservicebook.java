package mybatis.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.Service.IServiceBook;
import mybatis.Service.IServiceUser;
import mybatis.Service.ServiceBook;
import mybatis.model.modelbook;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testservicebook {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(testservicebook.class);
    
    private static SqlSession session = null;
    private static ApplicationContext context = null;
    private static IServiceBook bookservice = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        bookservice = context.getBean("bookService", IServiceBook.class);
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
    public void testgetSQLSelectAll() {
        // IServiceBook service = new ServiceBook();
        List<modelbook> result = bookservice.getSQLSelectAll();
        
        assertEquals(result.size(), 14);
    }
    @Test
    public void testgetSQLSelectLike() {
        // IServiceBook service = new ServiceBook();
        List<modelbook> result = bookservice.getSQLSelectLike("축구");
        
        assertEquals(result.size(), 3);
    }
    @Test
    public void testgetSQLSelectEqual() {
        // IServiceBook service = new ServiceBook();
        List<modelbook> result = bookservice.getSQLSelectEqual("JAVA");
        
        assertEquals(result.size(), 1);
    }
    @Test
    public void testsetSQLInsert() {
        modelbook book = new modelbook(100, "Dark", "누구냐", "2000", 20000, "04/12/06", true, 5);
        // IServiceBook service = new ServiceBook();
        int result = bookservice.setSQLInsert(book);
        
        assertEquals(result, 1);
    }
    @Test
    public void testsetSQLInsertMulti() {
        
        List<modelbook> books = new ArrayList<modelbook>();
        
        for(int i=0; i<10; i=i+1){
            modelbook book = new modelbook(200 + i, "test insert multi" + i, "test insert multi" + i, "2000", 20000, "04/12/06", true, 5);
            
            books.add(book);
        }
        
        // IServiceBook service = new ServiceBook();
        int result = bookservice.setSQLInsertMulti(books);
        
        assertEquals(result, 10);
    }
    @Test
    public void testsetSQLUpdatewithauthid() {
        modelbook updatevalue = new modelbook(30, "Oracle", "누구냐", "2000", 20000, "04/12/06", true, 69);
        
        modelbook searchvalue = new modelbook();
        searchvalue.setBookid(14);
        
        // IServiceBook service = new ServiceBook();
        int result = bookservice.setSQLUpdate(updatevalue, searchvalue);
        
        assertEquals(result, 1);
    }
    
    @Test
    public void testsetSQLUpdatewithauthidandbookname() {
        modelbook updatevalue = new modelbook(10, "Oracle", "누구냐", "2000", 20000, "04/12/06", true, 5);
        
        modelbook searchvalue = new modelbook();
        searchvalue.setBookid(17);
        searchvalue.setBookname("야구의 추억");
        
        // IServiceBook service = new ServiceBook();
        int result = bookservice.setSQLUpdate(updatevalue, searchvalue);
        
        assertEquals(result, 1);
    }
    @Test
    public void testsetSQLDelete() {
        
        modelbook book = new modelbook();

        book.setBookname("Oracle");
        book.setBookid(10);
        
        // IServiceBook service = new ServiceBook();
        int result = bookservice.setSQLDelete(book);
        
        assertEquals(result, 1);
    }
    @Test
    public void setTransCommit() {
        
        modelbook delbook = new modelbook();
        delbook.setBookid(2);
        modelbook insbook = new modelbook(88, "insert커밋", "커밋", "2000", 20000, "04/12/06", true, 55);
        modelbook updbook = new modelbook(91, "update커밋", "트랜스커밋", "2000", 20000, "04/12/06", true, 45);
        
        modelbook searchbook = new modelbook();
        searchbook.setBookid(50);
        
        // IServiceBook service = new ServiceBook();
        int result = bookservice.setTransCommit(delbook, insbook, updbook, searchbook);
        
        assertEquals(result, 1);
    }
    @Test
    public void setTransRollback() {
        
        modelbook delbook = new modelbook();
        delbook.setBookid(1);
        modelbook insbook = new modelbook(1000, "insert커밋", "커밋", "2000", 20000, "04/12/06", true, 1101);
        modelbook updbook = new modelbook(21, "update커밋", "트랜스커밋", "2000", 20000, "04/12/06", true, 45);
        
        modelbook searchbook = new modelbook();
        searchbook.setBookid(3);
        
        // IServiceBook service = new ServiceBook();
        int result = bookservice.setTransRollback(delbook, insbook, updbook, searchbook);
        
        assertEquals(result, -1);
    }
}
