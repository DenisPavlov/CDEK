package cdektestproject.service;

import cdektestproject.model.Entity;
import cdektestproject.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    private final Repository repository;

    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Entity create(Entity entity) {
        return repository.save(entity);
    }

    @Override
    public List<Entity> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Entity> getFiltered(String name) {
        if (name==null || name.equalsIgnoreCase("")) return getAll();
        List<Entity> list = getAll().stream().filter((entity -> entity.getName()
                .equalsIgnoreCase(name))).collect(Collectors.toList());
        return list;
    }
}
