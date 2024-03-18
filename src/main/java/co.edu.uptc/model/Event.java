package co.edu.uptc.model;

public class Event {
    private String id;
    private String name;
    private String description;
    private Discipline discipline;
    private Integer podium;

    public Event(String name, String description, Discipline discipline,Integer podium) {
        this.name = name;
        this.description = description;
        this.discipline = discipline;
        this.podium = podium;
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

    public Integer getPodium() {
        return podium;
    }

    public void setPodium(Integer podium) {
        this.podium = podium;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discipline=" + discipline +
                ", podium=" + podium +
                '}';
    }
}
