package dao;

import java.util.List;

import domain.Event;

public interface EventDao {
	List<Event> findAll() throws Exception;
	List<Event> findByMonth(String month) throws Exception;
	Event findById(Integer id) throws Exception;
	Event findByMonth() throws Exception;
	void insert(Event event) throws Exception;
	void update(Event event) throws Exception;
	void delete(Event event) throws Exception;
}
