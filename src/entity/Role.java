package entity;

public class Role {
    private int id;
    private String name;

    // getters & setters

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
    //Constructeurs

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
    }
}
