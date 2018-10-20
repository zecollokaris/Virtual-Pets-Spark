//Class PersonTest Imports!
import org.junit.*;
import static org.junit.Assert.*;
//IMPORT DB!
import org.sql2o.*;

public class PersonTest {

//  DATABASERULE
    @Rule
    Public DatabaseRule database = new DatabaseRule();

    @Test
//  TEST INITIALIZATION OF PERSON CLASS
    public void person_instantiatesCorretly_true() {
        Person testPerson = new Person("Henry","henry@vitualpets.com");
        assertEquals(true, testPerson instanceof Person);
    }

//  TEST IF PERSON INITIALIZES WITH NAME IN PERSON CLASS
    @Test
    public void getName_personInstantiatesWithName_Henry() {
        Person testPerson = new Person("Henry","henry@vitualpets.com");
        assertEquals("Henry", testPerson.getName());
    }

//    TEST IF PERSON INITIALIZES WITH EMAIL IN PERSON CLASS
    @Test
    public void getName_personInstantiatesWithEmail_String() {
        Person testPerson = new Person("Henry", "henry@vitualpets.com");
        assertEquals("henry@vitualpets.com", testPerson.getEmail());
    }

    @Test
    public void equals_returnsTrueIfNameAndEmailAreSame_true() {
        Person firstPerson = new Person("Henry", "henry@vitualpets.com");
        Person anotherPerson = new Person("Henry", "henry@vitualpets.com");
        assertTrue(firstPerson.equals(anotherPerson));
    }

//  TEST IF OBJECTS INSERT INTO DATABASE!
    @Test
    public void save_insertObjectIntoDatabase_Person(){
        Person testPerson = new Person("Henry", "henry@vitualpets.com");
        testPerson.save();
        assertTrue(Person.all().get(0).equals(testPerson));
    }
}