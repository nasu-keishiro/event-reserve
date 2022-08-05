package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Reserve;

public class ReserveDaoImpl implements ReserveDao {

	private DataSource ds;
	
	
	public ReserveDaoImpl(DataSource ds) {
		super();
		this.ds = ds;
	}

	@Override
	public List<Reserve> findAll() throws Exception {
		List<Reserve> reserveList = new ArrayList<>();
		
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT" 
					+ " user_list.id, user_list.user_name, user_list.user_age,"
					+ " user_list.user_address, user_list.user_tell,"
					+ " user_list.user_email, user_list.reserve_num"
					+ " FROM user_list"
					+ " JOIN event_list"
					+ " ON event_list.id = user_list.reserve_num";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				reserveList.add(mapToReserve(rs));
			}

		} catch (Exception e) {
			throw e;
		}
		
		return reserveList;
	}

	@Override
	public List<Reserve> findByReserveNum(Integer id) throws Exception {
		// (event)idをもらってreserve_numで絞って表示させる
		List<Reserve> reserveMonth = new ArrayList<>();
		
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT" 
					+ " user_list.id, user_list.user_name, user_list.user_age,"
					+ " user_list.user_address, user_list.user_tell,"
					+ " user_list.user_email, user_list.reserve_num"
					+ " FROM user_list"
					+ " JOIN event_list"
					+ " ON event_list.id = user_list.reserve_num"
					+ " WHERE event_list.id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				reserveMonth.add(mapToReserve(rs));
			}

		} catch (Exception e) {
			throw e;
		}
		
		
		
		return reserveMonth;
	}
	@Override
	public Reserve findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Reserve reserve) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void update(Reserve reserve) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void delete(Reserve reserve) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	private Reserve mapToReserve(ResultSet rs) throws Exception{
		Integer id = (Integer) rs.getObject("id");
		String name = rs.getString("user_name");
		Integer age = (Integer) rs.getObject("user_age");
		String address = rs.getString("user_address");
		Integer tell = (Integer) rs.getObject("user_tell");
		String email = rs.getString("user_email");
		Integer reserveNum = (Integer) rs.getObject("reserve_num");
		
		
		return new Reserve(id, name, age, address, tell, email, reserveNum);
	}


}
