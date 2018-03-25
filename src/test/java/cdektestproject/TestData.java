package cdektestproject;

import cdektestproject.model.Entity;

import java.util.Arrays;
import java.util.List;

public class TestData {
    public static final Entity ENTITY1 = new Entity(1, "Maria");
    public static final Entity ENTITY2 = new Entity(2, "Denis");
    public static final Entity ENTITY3 = new Entity(3, "Anna");
    public static final Entity ENTITY4 = new Entity(4, "Alex");
    public static final Entity ENTITY5 = new Entity(5, "Pavel");
    public static final Entity ENTITY6 = new Entity(6, "Max");

    public static final List<Entity> ENTITYS = Arrays.asList(ENTITY1, ENTITY2, ENTITY3, ENTITY4, ENTITY5, ENTITY6);

}
