package mybatis.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.DAO.DAOBoard;
import mybatis.DAO.DAOUser;
import mybatis.DAO.IDAOUser;
import mybatis.DAO.IDaoBoard;
import mybatis.model.ModelUser;

@Service("userService")
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);
    
    @Autowired
    @Qualifier("userDao")
    IDAOUser dao;

    public IDAOUser getDao() {
        return dao;
    }

    public void setDao(IDAOUser dao) {
        this.dao = dao;
    }

    public ServiceUser() {
        super();
    }

    @Override
    public int insertUser(ModelUser user) {
        
        int result = -1;
        try {
            result = dao.insertUser(user);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertUser" + e.getMessage() );
            
        }
        return result;
    }

    @Override
    public ModelUser login(ModelUser user) {
        
        ModelUser result = null;
        try {
            result = dao.login(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertUser" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUserInfo(ModelUser updatevalue, ModelUser searchvalue) {
        
        int result = -1;
        try {
            result = dao.updateUserInfo(updatevalue, searchvalue);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateUserInfo" + e.getMessage() );
            
        }
        return result;
    }

    @Override
    public int updatePasswd(ModelUser updatevalue, ModelUser searchvalue) {
        
        int result = -1;
        try {
            result = dao.updatePasswd(updatevalue, searchvalue);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateUserInfo" + e.getMessage() );
            
        }
        return result;
    }

    @Override
    public int UpdatedeleteUser(ModelUser searchvalue) {
        
        int result = -1;
        try {
            result = dao.UpdatedeleteUser(searchvalue);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateUserInfo" + e.getMessage() );
            
        }
        finally {          
                       
        }
        return result;
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) {
        
        ModelUser result = null;
        try {
            result = dao.selectUserOne(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectUserOne" + e.getMessage() );
        }
        return result;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        
        List<ModelUser> result = null;
        try {
            result = dao.selectUserList(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectUserList" + e.getMessage() );
        }
        return result;
    }


}
