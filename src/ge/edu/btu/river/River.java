package ge.edu.btu.river;

public class River {

    private long id;

    private String name;

    private int length;

    public River() {}

    public River(long id, String name, int length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }

    public long getId() {
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
