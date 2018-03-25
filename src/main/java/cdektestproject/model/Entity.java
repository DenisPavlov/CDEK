package cdektestproject.model;

public class Entity {
    private Integer id;
    private String name;

    public Entity() {
    }

    public Entity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isNew() {
        return this.id == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Entity %s (%s)", getClass().getName(), id);
    }
}
