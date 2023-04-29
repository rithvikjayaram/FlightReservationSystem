package com.fight.client.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fight.client.dao.PassengerDao;
import com.fight.client.model.Passenger;
import com.fight.client.model.User;

@Transactional
@Repository
public class PassengerDaoImpl implements PassengerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override public List<Passenger> getAllPassengers() { 
		// TODO Auto-generated
	 return null;
	  }

	@Override
	public Passenger findPassengerById(int id) {
		String query = "SELECT * FROM PASSENGER WHERE id = ?";
		RowMapper<Passenger> rowMapper = new BeanPropertyRowMapper<Passenger>(Passenger.class);
		Passenger passenger = jdbcTemplate.queryForObject(query, rowMapper, id);
		return passenger;
	}

	@Override
	public Passenger addPassenger(Passenger passenger) {
		KeyHolder holder = new GeneratedKeyHolder();
		String query = "INSERT INTO PASSENGER(FIRST_NAME, LAST_NAME, EMAIL, PHONE) "
				+ "VALUES(:FIRST_NAME, :LAST_NAME, :EMAIL,:PHONE)";
	
		 SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("FIRST_NAME", passenger.getFirstName())
					.addValue("LAST_NAME", passenger.getLastName())
					.addValue("EMAIL",passenger.getEmail())
					.addValue("PHONE",passenger.getPhone());
			namedParameterJdbcTemplate.update(query, parameters, holder);
			passenger.setId(holder.getKey().intValue());
			return passenger;
	
	}

	@Override
	public void updatePassenger(Passenger Passenger) {
		// TODO Auto-generated method stub

	}

	public void deletePassenger(int id) {
		 String query = "DELETE FROM passenger WHERE id=?";
		  jdbcTemplate.update(query, id);
	}

}
