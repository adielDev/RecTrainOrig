package adiel.rectrain.toolbar;

/**
 * Created by recntrek7 on 01/06/17.
 */

public class Person {

    int personType;
    String name;

    public Person(int personType, String name) {
        this.personType = personType;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonType() {
        return personType;
    }

    public void setPersonType(int personType) {
        this.personType = personType;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personType=" + personType +
                ", name='" + name + '\'' +
                '}';
    }
}
