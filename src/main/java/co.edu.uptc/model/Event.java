package co.edu.uptc.model;

public class Event {
    private String id;
    private String name;
    private String description;
    private Discipline discipline;

    public Event(String name, String description, Discipline discipline) {
        this.name = name;
        this.description = description;
        this.discipline = discipline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Event(){

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

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }



    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discipline=" + discipline +
                '}';
    }
}
