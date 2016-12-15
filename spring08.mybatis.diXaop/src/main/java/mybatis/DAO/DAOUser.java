package mybatis.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelBoard;
import mybatis.model.ModelUser;

@Repository("userDao")
public class DAOUser implements IDAOUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(DAOUser.class);
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    public DAOUser(SqlSession session) {
        super();
        this.session = session;
    }
    public SqlSession getSession() {
        return session;
    }
    public void setSession(SqlSession session) {
        this.session = session;
    }
    public DAOUser() {
        super();
    }

    @Override
    public int insertUser(ModelUser user) {
        return session.insert("mybatis.mapper.mapperuser.insertUser", user);   
    }

    @Override
    public ModelUser login(ModelUser user) {
        return session.selectOne("mybatis.mapper.mapperuser.login", user);
    }

    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUserInfo(ModelUser updatevalue, ModelUser searchvalue) {
        Map<String, ModelUser> parameter = new HashMap<String, ModelUser>(); 
        parameter.put("updatevalue",              updatevalue);
        parameter.put("searchvalue",             searchvalue);
        return session.update("mybatis.mapper.mapperuser.updateUserInfo", parameter);
    }

    @Override
    public int updatePasswd(ModelUser updatevalue, ModelUser searchvalue) {
        Map<String, ModelUser> parameter = new HashMap<String, ModelUser>(); 
        parameter.put("updatevalue",              updatevalue);
        parameter.put("searchvalue",             searchvalue);
        return session.update("mybatis.mapper.mapperuser.updatePasswd", parameter);
    }

    @Override
    public int UpdatedeleteUser(ModelUser searchvalue) { 
        Map<String, ModelUser> parameter = new HashMap<String, ModelUser>(); 
        parameter.put("searchvalue",             searchvalue);
        return session.update("mybatis.mapper.mapperuser.UpdatedeleteUser", parameter);
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) {
        return session.selectOne("mybatis.mapper.mapperuser.selectUserOne", user);
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        return session.selectList("mybatis.mapper.mapperuser.selectUserList", user);
    }
}
