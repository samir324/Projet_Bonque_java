import com.example.Project_Bonque.DAO.DAOAcount;
import com.example.Project_Bonque.DAOImpl.DAOImplAcount;
import com.example.Project_Bonque.model.Acount;

import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException {
        Acount acount = new Acount(3,345,00.01,"samir");
        DAOAcount daoAcount = (DAOAcount) new DAOImplAcount(); {

        };
        daoAcount.allAcount();
    }

}

