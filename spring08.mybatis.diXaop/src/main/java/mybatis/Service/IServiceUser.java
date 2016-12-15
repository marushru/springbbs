package mybatis.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.ModelUser;

public interface IServiceUser {
    
    int insertUser(ModelUser user);

    ModelUser login(ModelUser user );

    int logout(String userid);

    int updateUserInfo(ModelUser updatevalue, ModelUser searchvalue);

    int updatePasswd(ModelUser updatevalue, ModelUser searchvalue);

    int UpdatedeleteUser(ModelUser searchvalue);

    ModelUser selectUserOne(ModelUser user);

    List<ModelUser> selectUserList(ModelUser user);
    
}
