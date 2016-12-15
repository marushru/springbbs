package mybatis.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.modelbook;

public interface IDAOBook {
    
    List<modelbook> getSQLSelectAll() throws SQLException;
    
    List<modelbook> getSQLSelectLike(String bookname)
            throws SQLException;
    
    List<modelbook> getSQLSelectEqual(String bookname)
            throws SQLException;
    
    int setSQLInsert(modelbook book) throws SQLException;
    
    /*int setSQLInsertSequence(String bookname, String publisher, String year,
            int price, String dtm, boolean use_yn, int authid, )
            throws SQLException;*/
    
    int setSQLUpdate(modelbook updatevalue, modelbook searchvalue)
            throws SQLException;
    
    int setSQLDelete(modelbook book) throws SQLException;

    int setSQLInsertMulti(List<modelbook> books)
            throws SQLException;
    


    
    
}
