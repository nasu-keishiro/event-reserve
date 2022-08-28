package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.Review;

public class ReviewDaoImpl implements ReviewDao {

	private DataSource ds;
	
	
	public ReviewDaoImpl(DataSource ds) {
		super();
		this.ds = ds;
	}

	@Override
	public List<Review> findAll() throws Exception {
		// TODO  未実装
		return null;
	}

	@Override
	public List<Review> findByEvent(int id) throws Exception {
		// TODO 未実装
		return null;
	}

	@Override
	public Review findById(int id) throws Exception {
		
		return null;
	}

	@Override
	public void insert(Review review) throws Exception {
		//TODO 未実装
		
	}

	@Override
	public void update(Review review) throws Exception {
		
		
	}

	@Override
	public void delete(Review review) throws Exception {
		
		
	}
	
	private Review mapToReview(ResultSet rs) throw Exception{
		
		
		
		return new Review(null);
	}

}

