package cdektestproject.service;

import cdektestproject.model.Entity;

import java.util.List;

public interface Service {
    Entity create(Entity entity);
    List<Entity> getAll();
    List<Entity> getFiltered(String name);
}
