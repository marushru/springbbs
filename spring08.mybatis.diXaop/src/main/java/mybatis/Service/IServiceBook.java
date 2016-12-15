package mybatis.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.modelbook;

public interface IServiceBook {
    
    public List<modelbook> getSQLSelectAll();
     
    public List<modelbook> getSQLSelectLike(String expr);

    public List<modelbook> getSQLSelectEqual(String expr);



    public int setSQLUpdate(modelbook updatevalue, modelbook searchvalue );

    public int setSQLInsert( modelbook book);

    public int setSQLDelete(modelbook book); 

    public int setTransCommit(modelbook delbook, modelbook insbook, modelbook updbook, modelbook searchbook); 


    public int setTransRollback(modelbook delbook, modelbook insbook, modelbook updbook, modelbook searchbook);

    public int setSQLInsertMulti(List<modelbook> books);

    
    
}
