package com.fight.client.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fight.client.dao.UserDao;
import com.fight.client.dao.UserRowMapper;
import com.fight.client.model.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> getAllUsers() {
		String query = "SELECT * from USER";
		RowMapper<User> rowMapper = new UserRowMapper();
		List<User> list = jdbcTemplate.query(query, rowMapper);
		return list;
	}

	@Override
	public User findUserById(int id) {
		String query = "SELECT * FROM user WHERE id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(query, rowMapper, id);
		return user;
	}

	@Override
	public void addUser(User user) {
		String query = "INSERT INTO user(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
	}

	@Override
	public void updateUser(User user) {
		String query = "UPDATE user SET FIRST_NAME=?, LAST_NAME=?, EMAIL=?, PASSWORD=? WHERE id=?";
		jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
				user.getId());
	}

	@Override
	public void deleteUser(int id) {
		String query = "DELETE FROM user WHERE id=?";
		jdbcTemplate.update(query, id);
	}

	@Override
	public User findByEmail(String email) {
		String query = "SELECT * FROM user WHERE email = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(query, rowMapper, email);
		return user;
	}

}
