package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    /*
 “country”: {
         “id”: 3,
         “name”: “USA”,
         “states”: null
  */
    /*
    <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>RELEASE</version>
    <scope>test</scope>
</dependency>
     */
   // @Getter   //kolay işlem
   // @Setter
    private int id;
    private String name;
    private String states;

    public Country(int id, String name, String states) {
        this.id = id;
        this.name = name;
        this.states = states;
    }

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", states='" + states + '\'' +
                '}';
    }
}
