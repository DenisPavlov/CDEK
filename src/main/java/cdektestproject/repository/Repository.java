package cdektestproject.repository;

import cdektestproject.model.Entity;

import java.util.List;

public interface Repository {

    Entity save(Entity entity);

    List<Entity> getAll();
}
