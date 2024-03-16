package co.edu.uptc.gestiondeportiva.model;

public class Event {
    private String name;
    private String description;
    private int podium;
    private Discipline discipline;

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

    public int getPodium() {
        return podium;
    }

    public void setPodium(int podium) {
        this.podium = podium;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
