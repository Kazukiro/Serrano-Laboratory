public class Person {
    private String name;
    private int id;
 
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
 
    public String getName() {
        return this.name;
    }
   
    public int getID() {
        return this.id;
    }
 
    public void displayInfo() {
        System.out.println("Your name: " + name);
        System.out.println("Your ID: " + id);
    }
}