import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource{

    @Override
    protected void before(){
        DB.sql2o = new Sql2o("jdbc:postgrssql://localhost:5432/virtual_pets_test","karis""Kar!s123");
    }

//  ONCE DONE WITH THE TEST DATABASE SHOULD DELETE CONTENT FROM TABLE PERSONS
    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deletePersonsQuery = "DELETE FROM persons*;";
            con.createQuery(deletePersonsQuery).executeUpdate();
        }
    }
}