package co.edu.uptc.GestionDeportiva.model;

public class Discipline {
    private boolean group;
    private String name;
    private String description;

    public Discipline(boolean group, String name, String description) {
        this.group = group;
        this.name = name;
        this.description = description;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
