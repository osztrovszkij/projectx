package entity;

/**
 * Created by roski on 20.5.16.
 */
public class Service {
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private String name;
    private String description;
}
