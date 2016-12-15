package mybatis.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.DAO.*;
import mybatis.model.*;

@Service("boardService")
public class ServiceBoard implements IServiceBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceBoard.class);
    
    @Autowired
    @Qualifier("boardDao")
    IDaoBoard dao;
    public IDaoBoard getDao() {
        return dao;
    }
    public void setDao(IDaoBoard dao) {
        this.dao = dao;
    }
    public ServiceBoard() {
        super();
    }

    @Override
    public String getBoardName(String boardcd) {

        String result = null;
        try {
            result = dao.getBoardName(boardcd);
        } catch (Exception e) {
            logger.error("getBoardName" + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {

        ModelBoard result = null;
        try {
            result = dao.getBoardOne(boardcd);
        } catch (Exception e) {
            logger.error("getBoardOne" + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<ModelBoard> getBoardList() {

        List<ModelBoard> result = null;
        try {
            result = dao.getBoardList();
        } catch (Exception e) {
            logger.error("getBoardList" + e.getMessage() );
        }

        
        return result;
    }

    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {

        Map<String, ModelBoard> result = null;
        try {
            result = dao.getBoardListResultMap();
        } catch (Exception e) {
            logger.error("getBoardListResultMap" + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertBoard(ModelBoard board) {
        
        
        
        int result = -1;
        try {
            result = dao.insertBoard(board);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertBoard" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int updateBoard(ModelBoard updatevalue, ModelBoard searchvalue) {
        
        
        int result = -1;
        try {
            result = dao.updateBoard(updatevalue, searchvalue);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateBoard" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int deleteBoard(ModelBoard boardcd){
        
        
        
        int result = -1;
        try {
            result = dao.deleteBoard(boardcd);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteBoard" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        
        
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardSearch(board);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getBoardSearch" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord,
            int start, int end) {
        
        
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardPaging(boardcd, searchWord, start, end);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getBoardPaging" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        
        
        
        int result = 0;
        try {
            result = dao.insertBoardList(list);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertBoardList" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public List<ModelArticle> getArticleList(String boardCd, String searchWord,
            int start, int end) {
        
        
        List<ModelArticle> result = null;
        try {
            result = dao.getArticleList(boardCd, searchWord, start, end);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getArticleList" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public ModelArticle getArticle(int articleNo) {
        
        
        ModelArticle result = null;
        try {
                     dao.increaseHit(articleNo);
            result = dao.getArticle(articleNo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getBoardSearch" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        
        
        int result = 0;
        try {
            result = dao.getArticleTotalRecord(boardcd, searchWord);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getArticleTotalRecord" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int insertArticle(ModelArticle article) {
        
        
        int result = -1;
        try {
            result = dao.insertArticle(article);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertArticle" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int updateArticle(ModelArticle updateValue, ModelArticle searchValue) {
        
        
        int result = -1;
        try {
            result = dao.updateArticle(updateValue, searchValue);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateBoard" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int deleteArticle(ModelArticle articleno) {
        
        
        int result = -1;
        try {
            result = dao.deleteArticle(articleno);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteArticle" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int increaseHit(int articleno) {
        
        
        int result = -1;
        try {
            result = dao.increaseHit(articleno);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateBoard" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public ModelArticle getNextArticle(ModelArticle updateValue, ModelArticle searchValue) {
        
        
        ModelArticle result = null;
        try {
            result = dao.getNextArticle(updateValue, searchValue);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getArticleList" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public ModelArticle getPrevArticle(ModelArticle updateValue, ModelArticle searchValue) {
        //*SqlSession conn = sqlMapper.openSession();
        
        ModelArticle result = null;
        try {
            result = dao.getPrevArticle(updateValue, searchValue);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getPrevArticle" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public List<ModelAttachfile> getAttachFileList(int articleno) {
        
        
        List<ModelAttachfile> result = null;
        try {
            result = dao.getAttachFileList(articleno);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getAttachFileList" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public ModelAttachfile getAttachFile(ModelAttachfile attachfileno) {
        
        
        ModelAttachfile result = null;
        try {
            result = dao.getAttachFile(attachfileno);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getAttachFile" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int insertAttachFile(ModelAttachfile attachFile) {
        
        
        int result = -1;
        try {
            result = dao.insertAttachFile(attachFile);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertAttachFile" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int deleteAttachFile(ModelAttachfile attachfileno) {
        
        
        int result = -1;
        try {
            result = dao.deleteAttachFile(attachfileno);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteArticle" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public List<ModelComments> getCommentList(int articleno) {
        
        
        List<ModelComments> result = null;
        try {
            result = dao.getCommentList(articleno);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getCommentList" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public ModelComments getComment(int commentno) {
        
        
        ModelComments result = null;
        try {
            result = dao.getComment(commentno);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getComment" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int insertComment(ModelComments comment) {
        
        
        int result = -1;
        try {
            result = dao.insertComment(comment);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertComment" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int updateComment(ModelComments updateValue, ModelComments searchValue) {
        
        
        int result = -1;
        try {
            result = dao.updateComment(updateValue, searchValue);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateComment" + e.getMessage() );
            
        }

        return result;
    }

    @Override
    public int deleteComment(ModelComments commentNo) {
        
        
        int result = -1;
        try {
            result = dao.deleteComment(commentNo);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteComment" + e.getMessage() );
            
        }

        return result;
    }
  
    
}
