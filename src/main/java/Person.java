import java.security.PublicKey;
import java.sql.Connection;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import  static spark.Spark.*;



// MAIN CLASS (PERSON)!
public class Person {

//   INITIALIZING CLASS NAME & EMAIL WITH PERSON!
    private String name;
    private String email;
    private int id;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

//    OVERRIDING equals()!
    @Override
    public boolean equals(Object otherPerson){
        if (!(otherPerson instanceof Person)){
            return false;
        }else{
            Person newPerson = (Person) otherPerson;
            return this.getName().equals(newPerson.getName()) &&
                    this.getEmail().equals(newPerson.getEmail());
        }
    }

//  DEFINING SAVE METHOD!
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO persons (name, email) VALUES (:name, :email)";
            con.createQuery(sql)
                    .addParameter("name", this.name)
                    .addParameter("email", this.email)
                    .executeUpdate();
        }
    }

//  GETING PERSON`S SAVED IN DATABASE!
    public static List<Person> all() {
        String sql = "SELECT * FROM persons";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Person.class);
        }
    }

}