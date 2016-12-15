package mybatis.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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

import mybatis.DAO.DAOBoard;
import mybatis.DAO.IDaoBoard;
import mybatis.Service.IServiceBoard;
import mybatis.Service.IServiceBook;
import mybatis.Service.IServiceUser;
import mybatis.Service.ServiceBoard;
import mybatis.Service.ServiceBook;
import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;
import mybatis.model.modelbook;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(TestServiceBoard.class);
    
    private static SqlSession session = null;
    private static ApplicationContext context = null;
    private static IServiceBoard boardservice = null;
    
    Date from = new Date();
    SimpleDateFormat tf = new SimpleDateFormat("yy/MM/dd");
    String dtm = tf.format(from);
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        boardservice = context.getBean("boardService", IServiceBoard.class);

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
    public void test() {
        fail("Not yet implemented");
    }
    
    @Test
    public void TestgetBoardName() {
        
        
        String result = boardservice.getBoardName("free");
        
        assertEquals(result, "게시판");
       
    }

    @Test
    public void TestgetBoardOne() {
 
        ModelBoard result = boardservice.getBoardOne("free");
        
        assertEquals(result.getBoardnm(), "자유게시판");
        
    }

    @Test
    public void getBoardTotalRecord() {
        // TODO Auto-generated method stub
        
    }

    @Test
    public void getBoardList() {
        
        
        List<ModelBoard> result = boardservice.getBoardList();
        
        assertEquals(result.size(), 3);
        assertEquals(result.get(0).getBoardcd(), "qna");
        
    }

    @Test
    public void getBoardListResultMap() {
        
        
        Map<String, ModelBoard> result = boardservice.getBoardListResultMap();
        
        assertEquals(result.size(), 13);
        
    }

    @Test
    public void insertBoard() {
        
        ModelBoard board = new ModelBoard();
        board.setBoardcd("피자헛");
        board.setBoardnm("도미노피자");
        board.setUseYN(true);
        board.setInsertDT(from);
        board.setInsertUID("1");
        board.setUpdateDT(from);
        board.setUpdateUID("2");
        
        int result = boardservice.insertBoard(board);
        
        assertEquals(result, 1);
        
    }

    @Test
    public void updateBoard() {
        ModelBoard updatevalue = new ModelBoard();
        updatevalue.setBoardnm("게시판");
        updatevalue.setUseYN(false);
        
        ModelBoard searchvalue = new ModelBoard();
        searchvalue.setBoardcd("qna");
        
        
        int result = boardservice.updateBoard(updatevalue, searchvalue);
        
        assertEquals(result, 1);
        
    }

    @Test
    public void deleteBoard() {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("qna");
        
        
        int result = boardservice.deleteBoard(board);
        
        assertEquals(result, 1);
        
    }

    @Test
    public void getBoardSearch() {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("a");
        
        
        List<ModelBoard> result = boardservice.getBoardSearch(board);
        
        assertEquals(result.size(), 1);
    }

    @Test
    public void getBoardPaging() {
        
        
        String boardcd = "";
        String searchWord = "";
        int start = 1;
        int end = 10;
        
        
        
        List<ModelBoard> result = boardservice.getBoardPaging(boardcd, searchWord, start, end);
        
        assertEquals(result.size(), 10);
        
    }

    @Test
    public void insertBoardList() {
        ModelBoard board = null;
        List<ModelBoard> list = new ArrayList<ModelBoard>();
        Date from = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("yyyy.MM.dd");
        String dtm = tf.format(from);
      
        
        
        for(int i = 0; i<10; i=i+1){
            board = new ModelBoard();
            board.setBoardcd("notice" + dtm + "-" + i);
            board.setBoardnm("공지사항" + dtm + "-" + i);
            board.setUseYN(true);
            board.setInsertDT(new Date());
            board.setInsertUID("insertUID" + dtm + "-" + i);
            board.setUpdateDT(new Date());
            board.setUpdateUID("updateUID" + dtm + "-" + i);
            
            list.add(board); 
        }

        
        int result = boardservice.insertBoardList(list);
        
        assertEquals(result, 10);
        
    }

    @Test
    public void getArticleList() {
        
        
        String boardCd = "free";
        String searchWord = "test";
        int start = 2;
        int end = 7;
        
        
        
        List<ModelArticle> result = boardservice.getArticleList(boardCd, searchWord, start, end);
        
        assertEquals(result.size(), 6);
        
    }

    @Test
    public void getArticle() {
        
        
        ModelArticle result = boardservice.getArticle(10);
        
        assertSame(result.getArticleno(), 10);
        
    }

    @Test
    public void getArticleTotalRecord() {
        
        
        
        String boardcd = "free";
        String searchWord = "test";
        
        
        int result = boardservice.getArticleTotalRecord(boardcd, searchWord);
        
        assertEquals(result, 14);
        
    }

    @Test
    public void insertArticle() {
        
        ModelArticle board = null;
        Date from = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("yy/MM/dd");
        String dtm = tf.format(from);
        
        board = new ModelArticle();
        board.setBoardcd("JAVA");
        board.setTitle("article JAVA");
        board.setContent("article JAVA");
        board.setEmail("bb@bb.com");
        board.setRegdate(from);
        board.setUSEYN(true);
        board.setInsertuid("Oracle");
        board.setInsertdt(from);
        board.setUpdateuid("query");
        board.setUpdatedt(from);
        
        
        int result = boardservice.insertArticle(board);
        
        assertEquals(result, 1);
        
    }

    @Test
    public void updateArticle() {
        ModelArticle updateValue = new ModelArticle();
        updateValue.setTitle("article Oracle");
        updateValue.setContent("article Oracle");
        updateValue.setUSEYN(false);
        updateValue.setUpdateuid("쿼리");
        updateValue.setUpdatedt(new Date());
        
        
        ModelArticle searchValue = new ModelArticle();
        searchValue.setArticleno(21);
        
        
        int result = boardservice.updateArticle(updateValue, searchValue);
        
        assertEquals(result, 1);
        
        
    }

    @Test
    public void deleteArticle() {
        ModelArticle board = new ModelArticle();
        board.setArticleno(21);
        
        
        int result = boardservice.deleteArticle(board);
        
        assertEquals(result, 1);
        
    }

    @Test
    public void increaseHit() {
        
        
        int articleNo = 1;
        
        ModelArticle beforeArticle = boardservice.getArticle(articleNo);
        boardservice.increaseHit(articleNo);
        
        ModelArticle afterArticle = boardservice.getArticle(articleNo);
        
        assertSame(beforeArticle.getHit()+2, afterArticle.getHit());
        
    }

    @Test
    public void getNextArticle() {
   
        ModelArticle updateValue = new ModelArticle();
        updateValue.setBoardcd("free");
        updateValue.setArticleno(6);
        
        ModelArticle searchValue = new ModelArticle();
        searchValue.setTitle("06");

        
        ModelArticle result = boardservice.getNextArticle(updateValue, searchValue);
        
        assertEquals(result, 1);
        
    }

    @Test
    public void getPrevArticle() {
        ModelArticle updateValue = new ModelArticle();
        updateValue.setBoardcd("free");
        updateValue.setArticleno(6);
        
        ModelArticle searchValue = new ModelArticle();
        searchValue.setTitle("06");

        
        ModelArticle result = boardservice.getPrevArticle(updateValue, searchValue);
        
        assertEquals(result, 1);

        
    }

    @Test
    public void getAttachFileList() {
               
        int articleno = 1;

        List<ModelAttachfile> result = boardservice.getAttachFileList(articleno);        
        assertEquals(result.size(), 6);
        
    }

    @Test
    public void getAttachFile() {
        
        ModelAttachfile attachfileno = new ModelAttachfile();
        attachfileno.setAttachfileno(6);
        
        
        ModelAttachfile result = boardservice.getAttachFile(attachfileno);
        
        assertSame(result.getAttachfileno(), 6);
        
    }

    @Test
    public void insertAttachFile() {
        ModelAttachfile board = null;
        Date from = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("yy/MM/dd");
        String dtm = tf.format(from);
        
        board = new ModelAttachfile();
        board.setFilename("어태치파일");
        board.setFiletype("파일타입");
        board.setFilesize(10);
        board.setArticleno(1);
        board.setUseYN(true);
        board.setInsertUID("attachfile");
        board.setInsertDT(from);
        board.setUpdateUID("filetype");
        board.setUpdateDT(from);
        
        
        int result = boardservice.insertAttachFile(board);
        
        assertEquals(result, 1);
        
    }

    @Test
    public void deleteAttachFile() {
        ModelAttachfile board = new ModelAttachfile();
        board.setAttachfileno(5);
        
        
        int result = boardservice.deleteAttachFile(board);
        
        assertEquals(result, 1);
        
    }

    @Test
    public void getCommentList() {
               
        int articleno = 1;

        List<ModelComments> result = boardservice.getCommentList(articleno);        
        assertEquals(result.size(), 1);
        
    }

    @Test
    public void getComment() {

        
        ModelComments result = boardservice.getComment(1);
        
        assertSame(result.getCommentno(), 1);
        
    }

    @Test
    public void insertComment() {
        ModelComments board = null;
        Date from = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("yy/MM/dd");
        String dtm = tf.format(from);
        
        board = new ModelComments();
        board.setArticleno(2);
        board.setEmail("naver@naver.com");
        board.setMemo("ㅋㅋㅋㅋㅋ");
        board.setRegdate(from);
        board.setUseYN(true);
        board.setInsertUID("attachfile");
        board.setInsertDT(from);
        board.setUpdateUID("filetype");
        board.setUpdateDT(from);
        
        
        int result = boardservice.insertComment(board);
        
        assertEquals(result, 1);
        
    }

    @Test
    public void updateComment() {
        ModelComments updateValue = new ModelComments();
        updateValue.setMemo("ㅎㅎㅎㅎㅎㅎ");
        updateValue.setEmail("daum.hanmail.net");
        updateValue.setUseYN(false);

        
        
        ModelComments searchValue = new ModelComments();
        searchValue.setArticleno(1);
        
        
        int result = boardservice.updateComment(updateValue, searchValue);
        
        assertEquals(result, 1);
        
    }

    @Test
    public void deleteComment() {
        ModelComments board = new ModelComments();
        board.setCommentno(21);
        
        
        int result = boardservice.deleteComment(board);
        
        assertEquals(result, 1);
        
    }
}
