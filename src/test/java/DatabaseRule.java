import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/virtual_pets_test", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deletePersonsQuery = "DELETE FROM persons *;";
      String deleteMonstersQuery = "DELETE FROM monsters *;";
      String deleteCommunitiesQuery = "DELETE FROM communities *;";
      String deleteJoinsQuery = "DELETE FROM communities_persons *;";
      con.createQuery(deletePersonsQuery).executeUpdate();
      con.createQuery(deleteMonstersQuery).executeUpdate();
      con.createQuery(deleteCommunitiesQuery).executeUpdate();
      con.createQuery(deleteJoinsQuery).executeUpdate();
    }
  }

}
