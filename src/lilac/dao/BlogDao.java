package lilac.dao;

import lilac.model.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class BlogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	public Blog selectByUrl(final String url) {
//		String sql = "select * from SHOP where URL=?";
//		try {
//			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Blog>(Blog.class), url);
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}
}
