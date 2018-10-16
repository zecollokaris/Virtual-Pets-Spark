import org.junit.*;
import static org.junit.Assert.*;

public class PersonTest {


    @Test
    public void person_instantiatesCorretly_true(){
        Person testPerson = new Person("Henry","henry@vitualpets.com");
        assertEquals(true, testPerson instanceof Person);
    }

    @Test
    public void getName_personInstantiatesWithName_Henry(){
        Person testPerson = new Person("Henry","henry@vitualpets.com");
        assertEquals("Henry", testPerson.getName());
    }

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

}