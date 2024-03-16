package co.edu.uptc.GestionDeportiva.model;

public class Event {
    private String name;
    private String description;
    private Integer podium;
    private Discipline discipline;

    public Event(String name, String description, Integer podium, Discipline discipline) {
        this.name = name;
        this.description = description;
        this.podium = podium;
        this.discipline = discipline;
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

    public Integer getPodium() {
        return podium;
    }

    public void setPodium(Integer podium) {
        this.podium = podium;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
