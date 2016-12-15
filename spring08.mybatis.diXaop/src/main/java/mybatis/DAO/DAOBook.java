package mybatis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.modelbook;

@Repository("bookDao")
public class DAOBook implements IDAOBook {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    public DAOBook(SqlSession session) {
        super();
        this.session = session;
    }
    public SqlSession getSession() {
        return session;
    }
    public void setSession(SqlSession session) {
        this.session = session;
    }
    public DAOBook() {
        super();
    }

    @Override
    public List<modelbook> getSQLSelectAll() throws SQLException {
        
        return session.selectList("mybatis.mapper.mapperBook.getSQLSelectAll");
    }

    @Override
    public List<modelbook> getSQLSelectLike(String bookname)
            throws SQLException {

        return session.selectList("mybatis.mapper.mapperBook.getSQLSelectLike", bookname);

    }

    @Override
    public List<modelbook> getSQLSelectEqual(String bookname)
            throws SQLException {
        return session.selectList("mybatis.mapper.mapperBook.getSQLSelectEqual", bookname);
    }

    @Override
    public int setSQLInsert(modelbook book)
            throws SQLException {      
        return session.insert("mybatis.mapper.mapperBook.setSQLInsert", book);
    }
    @Override
    public int setSQLInsertMulti(List<modelbook> books )
            throws SQLException {     
        return session.insert("mybatis.mapper.mapperBook.setSQLInsertMulti", books);
    }

/*    @Override
    public int setSQLInsertSequence(modelbook updatevalue, modelbook searchvalue,
            ) throws SQLException {
        int result = 1;      
        result = session.insert("mybatis.mapper.mapperBook.setSQLInsert", book);
        return result;
    }*/

    @Override
    public int setSQLUpdate(modelbook updatevalue, modelbook searchvalue
            ) throws SQLException { 
        Map<String, modelbook> parameter = new HashMap<String, modelbook>();
        
        
        parameter.put("updatevalue",              updatevalue);
        parameter.put("searchvalue",             searchvalue);

        return session.update("mybatis.mapper.mapperBook.setSQLUpdate", parameter);
    }

    @Override
    public int setSQLDelete(modelbook book){
    Map<String, modelbook> parameter = new HashMap<String, modelbook>();
    
    
    parameter.put("book",              book);
    return session.delete("mybatis.mapper.mapperBook.setSQLDelete", parameter);

    }


}
