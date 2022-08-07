package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
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
		// 
		Reserve reserve = new Reserve();
		
		try (Connection con = ds.getConnection()){
			String sql = "SELECT" 
					+ " user_list.id, user_list.user_name, user_list.user_age,"
					+ " user_list.user_address, user_list.user_tell,"
					+ " user_list.user_email, user_list.reserve_num"
					+ " FROM user_list"
					+ " JOIN event_list"
					+ " ON event_list.id = user_list.reserve_num"
					+ " WHERE user_list.id = ?";
			
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1,id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if(rs.next() == true) {
				reserve = mapToReserve(rs);
			}
			
			
			
		}catch(Exception e) {
			throw e;
		}
		return reserve;
	}

	@Override
	public void insert(Reserve reserve) throws Exception {
		// 
		try(Connection con = ds.getConnection()){
			String sql = "INSERT INTO user_list"
					+ " (user_name, user_age, user_address, user_tell"
					+ " user_email, reserve_num)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, reserve.getName());
			stmt.setObject(2, reserve.getAge(),Types.INTEGER);
			stmt.setString(3, reserve.getAddress());
			stmt.setObject(4, reserve.getTell(),Types.INTEGER);
			stmt.setString(5, reserve.getEmail());
			stmt.setObject(6, reserve.getReserveNum(),Types.INTEGER);
			stmt.executeUpdate();
			
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public void update(Reserve reserve) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = "UPDATE user_list"
					+ " SET user_name = ?, user_age = ?, user_address = ?,"
					+ " user_tell = ?, user_email = ?"
					+ " WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, reserve.getName());
			stmt.setObject(2, reserve.getAge(),Types.INTEGER);
			stmt.setString(3, reserve.getAddress());
			stmt.setObject(4, reserve.getTell(),Types.INTEGER);
			stmt.setString(5, reserve.getEmail());
			stmt.executeQuery();
			
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public void delete(Reserve reserve) throws Exception {
		// 
		try(Connection con = ds.getConnection()){
			String sql = "DELETE FROM user_list WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, reserve.getId(), Types.INTEGER);
			stmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			throw e;
		}
		
	}
	@Override
	public Reserve findByReserveNumAndReserveName(String reserveNum, String name) throws Exception {
		// ログイン認証と似たような流れで実装
		Reserve reserve = null;
		try(Connection con = ds.getConnection()){
			//DBの予約番号で検索(カラムをconfirmationNumで仮設定)
			String sql = "SELECT * FROM user_list WEHRE confirmationNum=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, reserveNum);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				if(name.equals(rs.getString("name"))) {
					reserve = mapToReserve(rs);
				}
			}
			
			
			
		}catch(Exception e){
			throw e;
		}
		
		
		return reserve;
	}
	
	private Reserve mapToReserve
	(ResultSet rs) throws Exception{
		Integer id = (Integer) rs.getObject("id");
		String name = rs.getString("user_name");
		Integer age = (Integer) rs.getObject("user_age");
		String address = rs.getString("user_address");
		Integer tell = (Integer) rs.getObject("user_tell");
		String email = rs.getString("user_email");
		Integer reserveNum = (Integer) rs.getObject("reserve_num");
		String confirmation = rs.getString("confirmationNum");
		
		
		return new Reserve(id, name, age, address, tell, email, reserveNum, confirmation);
	}



}
