package mybatis.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.DAO.*;
import mybatis.model.modelbook;

@Service("bookService")
public class ServiceBook implements IServiceBook {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceBook.class);
    
    @Autowired
    @Qualifier("bookDao")
    IDAOBook dao ;
    
    public IDAOBook getDao() {
        return dao;
    }

    public void setDao(IDAOBook dao) {
        this.dao = dao;
    }

    public ServiceBook() {
        super();
    }

    @Override
    public List<modelbook> getSQLSelectAll() {

        List<modelbook> result = null;
        try {
            result = dao.getSQLSelectAll();
        } catch (SQLException e) {
            logger.error("getSQLSelectAll" + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public List<modelbook> getSQLSelectLike(String expr) {
        
        List<modelbook> result = null;
        try {
            result = dao.getSQLSelectLike(expr);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getSQLSelectLike" + e.getMessage() );

        }
        return result;
    }

    @Override
    public List<modelbook> getSQLSelectEqual(String expr) {
        
        List<modelbook> result = null;
        try {
            result = dao.getSQLSelectEqual(expr);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getSQLSelectEqual" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int setSQLInsert(modelbook book) {
        
        int result = -1;
        try {
            result = dao.setSQLInsert(book);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("setSQLInsert" + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int setSQLInsertMulti(List<modelbook> books) {

        int result = 0;
        try {
            for(int i = 0; i < books.size(); i=i+1){
                result += dao.setSQLInsert(books.get(i));
            }          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("setSQLInsertMulti" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int setSQLUpdate(modelbook updatevalue, modelbook searchvalue) {
        
        int result = -1;
        try {
            result = dao.setSQLUpdate(updatevalue, searchvalue);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("setSQLUpdate" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int setSQLDelete(modelbook book) {
        
        int result = -1;
        try {
            result = dao.setSQLDelete(book);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("setSQLDelete" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int setTransCommit(modelbook delbook, modelbook insbook, modelbook updbook, modelbook searchbook) {

        int result = -1;
        try {
            dao.setSQLInsert(insbook);
            dao.setSQLUpdate(updbook, searchbook);
            dao.setSQLDelete(delbook);
            
            result = 1;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("setTransCommit" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int setTransRollback(modelbook delbook, modelbook insbook, modelbook updbook, modelbook searchbook) 
    {
        int result = -1;
        try {
            dao.setSQLInsert(insbook);
            dao.setSQLUpdate(updbook, searchbook);
            dao.setSQLDelete(delbook);
            
            result = 1;
            throw new SQLException("rollback test");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("setTransCommit" + e.getMessage() );
            result = -1;
        }
        return result;
    }



}