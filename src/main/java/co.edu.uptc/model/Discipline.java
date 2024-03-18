package co.edu.uptc.model;

public class Discipline {
    private String name;
    private String description;
    private boolean group;

    public Discipline(String name, String description, boolean group) {
        this.name = name;
        this.description = description;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", group=" + group +
                '}';
    }
}
