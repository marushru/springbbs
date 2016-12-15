package mybatis.DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;
import mybatis.model.modelbook;

@Repository("boardDao")
public class DAOBoard implements IDaoBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(DAOBoard.class);
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
       
    public DAOBoard(SqlSession session) {
        super();
        this.session = session;
    }
    public SqlSession getSession() {
        return session;
    }
    public void setSession(SqlSession session) {
        this.session = session;
    }

    public DAOBoard() {
        super();
    }
    @Override
    public int getBoardTotalRecord(HashMap<String, String> hashmap) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public String getBoardName(String boardcd) {

        return session.selectOne("mybatis.mapper.mapperBoard.getBoardName", boardcd);

    }
    @Override
    public ModelBoard getBoardOne(String boardcd) {
        return session.selectOne("mybatis.mapper.mapperBoard.getBoardOne", boardcd);
    }
    @Override
    public List<ModelBoard> getBoardList() {
        Map<String, ModelBoard> boardcd = new HashMap<String, ModelBoard>();
        return session.selectList("mybatis.mapper.mapperBoard.getBoardList", boardcd);
    }
    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {
        Map<String, ModelBoard> boardcd = new HashMap<String, ModelBoard>();
        return session.selectMap("mybatis.mapper.mapperBoard.getBoardListResultMap", "boardcd");
    }
    @Override
    public int insertBoard(ModelBoard board)  {     
        return session.insert("mybatis.mapper.mapperBoard.insertBoard", board);    
    }
    @Override
    public int updateBoard(ModelBoard updatevalue, ModelBoard searchvalue)  {
        Map<String, ModelBoard> parameter = new HashMap<String, ModelBoard>();
        
        
        parameter.put("updatevalue",              updatevalue);
        parameter.put("searchvalue",             searchvalue);

        return session.update("mybatis.mapper.mapperBoard.updateBoard", parameter);
    }
    @Override
    public int deleteBoard(ModelBoard boardcd)  {    
        return session.delete("mybatis.mapper.mapperBoard.deleteBoard", boardcd);
    }
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
     
        return session.selectList("mybatis.mapper.mapperBoard.getBoardSearch", board);
        
    }
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord,
            int start, int end) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("boardcd",              boardcd);
        parameter.put("searchWord",             searchWord);
        parameter.put("start",             start);
        parameter.put("end",             end);
        return session.selectList("mybatis.mapper.mapperBoard.getBoardPaging", parameter);
    }
    @Override
    public int insertBoardList(List<ModelBoard> list) {
  
        return session.insert("mybatis.mapper.mapperBoard.insertBoardList", list);
        

    }
    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) { 
        Map<String, String> parameter = new HashMap<String, String>();
        parameter.put("boardcd",              boardcd);
        parameter.put("searchWord",             searchWord);
        return session.selectOne("mybatis.mapper.mapperBoard.getArticleTotalRecord", parameter);

    }
    @Override
    public List<ModelArticle> getArticleList(String boardCd, String searchWord,
            int start, int end) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("boardCd",              boardCd);
        parameter.put("searchWord",             searchWord);
        parameter.put("start",             start);
        parameter.put("end",             end);
        return session.selectList("mybatis.mapper.mapperBoard.getArticleList", parameter);

    }
    @Override
    public ModelArticle getArticle(int articleNo) {     
        return session.selectOne("mybatis.mapper.mapperBoard.getArticle", articleNo);

    }
    @Override
    public int insertArticle(ModelArticle article) {    
        return session.insert("mybatis.mapper.mapperBoard.insertArticle", article);
        
    }
    @Override
    public int updateArticle(ModelArticle updateValue, ModelArticle searchValue) {
        Map<String, ModelArticle> parameter = new HashMap<String, ModelArticle>();
        
        
        parameter.put("updateValue",              updateValue);
        parameter.put("searchValue",             searchValue);

        return session.update("mybatis.mapper.mapperBoard.updateArticle", parameter);

    }
    @Override
    public int deleteArticle(ModelArticle articleno) {
     
        return session.delete("mybatis.mapper.mapperBoard.deleteArticle", articleno);
        

    }
    @Override
    public int increaseHit(int articleno) {
   
        return session.update("mybatis.mapper.mapperBoard.increaseHit", articleno);
        

    }
    @Override
    public ModelArticle getNextArticle(ModelArticle updateValue, ModelArticle searchValue) {

        Map<String, ModelArticle> parameter = new HashMap<String, ModelArticle>();
        
        
        parameter.put("updateValue",              updateValue);
        parameter.put("searchValue",             searchValue);

        return session.selectOne("mybatis.mapper.mapperBoard.getNextArticle", parameter);

    }
    @Override
    public ModelArticle getPrevArticle(ModelArticle updateValue, ModelArticle searchValue) {

        Map<String, ModelArticle> parameter = new HashMap<String, ModelArticle>();
        
        
        parameter.put("updateValue",              updateValue);
        parameter.put("searchValue",             searchValue);

        return session.selectOne("mybatis.mapper.mapperBoard.getPrevArticle", parameter);

    }
    @Override
    public ModelAttachfile getAttachFile(ModelAttachfile attachfileno) {

        return session.selectOne("mybatis.mapper.mapperBoard.getAttachFile", attachfileno);

    }
    @Override
    public List<ModelAttachfile> getAttachFileList(int articleno) {
 
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("articleno",              articleno);

        return session.selectList("mybatis.mapper.mapperBoard.getAttachFileList", parameter);
        
    }
    @Override
    public int insertAttachFile(ModelAttachfile attachFile) {
   
        return session.insert("mybatis.mapper.mapperBoard.insertAttachFile", attachFile);
        

    }
    @Override
    public int deleteAttachFile(ModelAttachfile attachfileno) {
     
        return session.delete("mybatis.mapper.mapperBoard.deleteAttachFile", attachfileno);
        

    }
    @Override
    public int insertComment(ModelComments comment) {
   
        return session.insert("mybatis.mapper.mapperBoard.insertComment", comment);
        

    }
    @Override
    public int updateComment(ModelComments updateValue, ModelComments searchValue) {

        Map<String, ModelComments> parameter = new HashMap<String, ModelComments>();
        
        
        parameter.put("updateValue",              updateValue);
        parameter.put("searchValue",             searchValue);

        return session.update("mybatis.mapper.mapperBoard.updateComment", parameter);

    }
    @Override
    public int deleteComment(ModelComments commentNo) {
    
        return session.delete("mybatis.mapper.mapperBoard.deleteComment", commentNo);

    }
    @Override
    public ModelComments getComment(int commentno) {
     
        return session.selectOne("mybatis.mapper.mapperBoard.getComment", commentno);
        

    }
    @Override
    public List<ModelComments> getCommentList(int articleno) {

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("articleno",              articleno);

        return session.selectList("mybatis.mapper.mapperBoard.getCommentList", parameter);
        

    }
    
    
}
