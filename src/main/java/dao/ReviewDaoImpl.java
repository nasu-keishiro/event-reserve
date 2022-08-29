package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		
		List<Review> reviewList = new ArrayList<>();
		
		try(Connection con = ds.getConnection()){
			
			String sql = "SELECT * FROM review"
					   + " JOIN event_list"
					   + " ON event_list.id = review.event_num"
					   + " WHERE review.event_num = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				reviewList.add(mapToReview(rs));
			}
			
		}catch(Exception e) {
			throw e;
		}
		
		
		return reviewList;
	}

	@Override
	public Review findById(int id) throws Exception {
		
		return null;
	}

	@Override
	public void insert(Review review) throws Exception {
		
		try(Connection con = ds.getConnection()){
			
			String sql = "INSERT INTO review"
					   + " (name, email, evaluation, comment, event_num)"
					   + " VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, review.getName());
			stmt.setString(2, review.getEmail());
			stmt.setObject(3, review.getEvaluation());
			stmt.setString(4, review.getComment());
			stmt.setObject(5, review.getEventNum());
			stmt.executeUpdate();
			
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public void update(Review review) throws Exception {
		
		
	}

	@Override
	public void delete(Review review) throws Exception {
		
		
	}
	
	@Override
	public Review findByEmail(int id, String email) throws Exception {
		
		return null;
	}
	
	private Review mapToReview(ResultSet rs) throws Exception{
		Integer id = (Integer) rs.getObject("id");
		String name = rs.getString("name");
		String email = rs.getString("email");
		Integer evaluation = (Integer)rs.getObject("evaluation");
		String comment = rs.getString("comment");
		Integer eventNum = (Integer) rs.getObject("event_num");
		
		
		return new Review(id, name, email, evaluation, comment, eventNum);
	}


}

