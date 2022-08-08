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
			String sql = "SELECT * FROM user_list"
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
			String sql = "SELECT * FROM user_list"
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
					+ " user_list.user_email, user_list.reserve_num, user_list.confirmationNum"
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
					+ " (user_name, user_age, user_address, user_tell,"
					+ " user_email, reserve_num, confirmationNum)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, reserve.getName());
			stmt.setObject(2, reserve.getAge(),Types.INTEGER);
			stmt.setString(3, reserve.getAddress());
			stmt.setObject(4, reserve.getTell(),Types.INTEGER);
			stmt.setString(5, reserve.getEmail());
			stmt.setObject(6, reserve.getReserveNum(),Types.INTEGER);
			stmt.setString(7, reserve.getConfirmationNum());
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
	public Reserve findByReserveNumAndReserveName(String confirmationNum, String name) throws Exception {
		// ログイン認証と似たような流れで実装
		Reserve reserve = null;
		try(Connection con = ds.getConnection()){
			//DBの予約番号で検索
			String sql = "SELECT * FROM user_list WHERE confirmationNum=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, confirmationNum);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				if(name.equals(rs.getString("user_name"))) {
					reserve = mapToReserve(rs);
				}
			}
			
			
			
		}catch(Exception e){
			throw e;
		}
		
		
		return reserve;
	}
	
	@Override
	public long NumberOfReservations(Integer id) throws Exception {
		//Count関数はLong型を使用する
		
		//eventIdからreserveNumをカウント
		long num = 0;
		try(Connection con = ds.getConnection()){
			//カウント関数で予約数を検索
			String sql = "SELECT COUNT(*) AS num FROM event_reserve.user_list"
					   + " WHERE reserve_num=?";
			//ASで一時的なカラム名を決めて取り出すときに使う
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,  id);
			ResultSet rs = stmt.executeQuery();
			//ReseultSetはSQL文の表みたいなイメージで、next()で行を指す
			//いくつも行を取り出すときはWhileでループ
			if(rs.next()) {
				num = rs.getLong("num");
			}
			
			
			
			
		}catch(Exception e) {
			throw e;
		}
		
		return num;
	}
	
	private Reserve mapToReserve(ResultSet rs) throws Exception{
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
