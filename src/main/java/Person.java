// MAIN CLASS (PERSON)!
public class Person {

//   INITIALIZING CLASS NAME & EMAIL WITH PERSON!
    private String name;
    private String email;

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
//    @Override
//    public boolean equals(Object otherPerson){
//        if (!(otherPerson instanceof Person)){
//            return false;
//        }else{
//            Person newPerson = (Person) otherPerson;
//            return this.getName().equals(newPerson.getName()) &&
//                    this.getEmail().equals(newPerson.getEmail());
//        }
//    }

}