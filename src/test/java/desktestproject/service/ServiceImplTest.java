package desktestproject.service;

import desktestproject.TestData;
import desktestproject.model.Entity;
import junit.framework.AssertionFailedError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static desktestproject.TestData.ENTITY1;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:db/initDB.sql", "classpath:db/populateDB.sql"}, config = @SqlConfig(encoding = "UTF-8"))
public class ServiceImplTest {

    @Autowired
    private Service service;

    @Test
    public void create() throws Exception {
        Entity newEntity = new Entity(null, "New");
        Entity created = service.create(newEntity);
        newEntity.setId(created.getId());
        assertThat(created).isEqualToComparingFieldByField(newEntity);
    }

    @Test
    public void getAll() throws Exception {
        assertThat(service.getAll()).usingFieldByFieldElementComparator().isEqualTo(TestData.ENTITYS);
    }

    @Test
    public void getFiltered() {
        String name = "maria";
        List<Entity> list = service.getFiltered(name);
        if (list.size() > 1 || list.size() == 0) throw new AssertionFailedError();
        Entity entity = list.get(0);
        assertThat(entity).isEqualToComparingFieldByField(ENTITY1);
    }

}