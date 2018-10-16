import org.junit.*;
import static org.junit.Assert.*;

public class PersonTesst {


    @Test
    public void person_instantiatesCorretly_true(){
        Person testPerson = new Person("Henry","henry@vitualpets.com");
        assertEquals(true, testPerson instanceof Person);
    }

    @Test
    public void getName_personInstantiatesWithName_Henry(){
        Person testPerson = new Person("Henry","henry@vitualpets.com")
        assertEquals("Henry", testPerson.getName());
    }



}