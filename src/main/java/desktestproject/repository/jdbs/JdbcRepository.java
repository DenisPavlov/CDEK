package desktestproject.repository.jdbs;

import desktestproject.model.Entity;
import desktestproject.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.List;

@org.springframework.stereotype.Repository
public class JdbcRepository implements Repository {

    private static final BeanPropertyRowMapper<Entity> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Entity.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertEntity;

    @Autowired
    public JdbcRepository(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

        this.insertEntity = new SimpleJdbcInsert(dataSource)
                .withTableName("test_table")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Entity save(Entity entity) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("name", entity.getName());

        if (entity.isNew()) {
            Number newKey = insertEntity.executeAndReturnKey(map);
            entity.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update("UPDATE test_table SET name=:name WHERE id=:id", map);
        }
        return entity;
    }

    @Override
    public List<Entity> getAll() {
        return jdbcTemplate.query("SELECT * FROM test_table ORDER BY id", ROW_MAPPER);
    }

}
