package desktestproject.service;

import desktestproject.model.Entity;

import java.util.List;

public interface Service {
    Entity create(Entity entity);
    List<Entity> getAll();
    List<Entity> getFiltered(String name);
}
