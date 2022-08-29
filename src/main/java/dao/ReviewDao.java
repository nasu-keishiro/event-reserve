package dao;

import java.util.List;

import domain.Review;

public interface ReviewDao {

	List<Review> findAll() throws Exception;
	List<Review> findByEvent(int id) throws Exception;
	Review findById(int id) throws Exception;
	void insert(Review review) throws Exception;
	void update(Review review) throws Exception;
	void delete(Review review) throws Exception;
	Review findByEmail(int eventId, String email) throws Exception;
	
}
