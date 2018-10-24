package examples.dao.dao;

import examples.dao.dto.Board;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class BoardDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;

    public BoardDao(DataSource dataSource) {
        System.out.println("BoardDao()");
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                                .withTableName("board")
                                .usingGeneratedKeyColumns("id");
    }

    public Long addBoard(Board board) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(board);
        return insertAction.executeAndReturnKey(params).longValue();
    }

    public int updateCount(Long id) {
        String sql = "update board set read_count = read_count+1 where id = :id";
        Map<String, Long> map = Collections.singletonMap("id", id);
        return jdbc.update(sql, map);
    }

    public Board getBoard(Long id) {
        String sql = "SELECT id, name, title, content, regdate, read_count" +
                "from board where id = :id";

        try{
            RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
            Map<String, ?> params = Collections.singletonMap("id", id);
            return jdbc.queryForObject(sql, params, rowMapper);
        }catch (Exception ex) {
            return null;
        }
    }

    public List<Board> getBoards() {
        String sql = "select id, name, title, content, regdate, read_count" +
                "from board order by id desc";

        try{
            RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
            return jdbc.query(sql, rowMapper);
        }catch (Exception ex) {
            return null;
        }
    }
}
