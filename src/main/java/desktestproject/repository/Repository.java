package desktestproject.repository;

import desktestproject.model.Entity;

import java.util.List;

public interface Repository {

    Entity save(Entity entity);

    List<Entity> getAll();
}
