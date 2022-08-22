package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import domain.Event;

public class EventDaoImpl implements EventDao {

	private DataSource ds;

	public EventDaoImpl(DataSource ds) {
		super();
		this.ds = ds;
	}

	@Override
	public List<Event> findAll() throws Exception {
		List<Event> eventList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT" 
					+ " event_list.id, event_list.event_name, event_list.event_date,"
					+ " event_list.event_place, event_list.event_capacity,"
					+ " event_list.event_contents, event_list.event_remarks"
					+ " FROM event_list";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				eventList.add(mapToEvent(rs));
			}

		} catch (Exception e) {
			throw e;
		}

		return eventList;
	}
	
	
	@Override
	public List<Event> findByMonth(String month) throws Exception {
		
		// 月を指定してリストとして返す  文字列の2022-08が返ってくる
		List<Event> monthList = new ArrayList<>();
		
		try(Connection con = ds.getConnection()){
			//受け取りString
			//SQLのWhere betweenでその月分だけを取得
			String sql ="SELECT"
					  + " event_list.id, event_list.event_name, event_list.event_date,"
					  + " event_list.event_place, event_list.event_capacity,"
					  + " event_list.event_contents, event_list.event_remarks"
					  + " FROM event_list"
					  + " WHERE date_format(event_date, \"%Y-%m\") = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, month);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				monthList.add(mapToEvent(rs));
			}
			
		}catch(Exception e){
			throw e;
		}
		
		return monthList;
	}

	@Override
	public Event findById(Integer id) throws Exception {
		Event event = new Event();
		
		try(Connection con = ds.getConnection()){
			String sql = "SELECT" 
					+ " event_list.id, event_list.event_name, event_list.event_date,"
					+ " event_list.event_place, event_list.event_capacity,"
					+ " event_list.event_contents, event_list.event_remarks"
					+ " FROM event_list"
					+ " LEFT JOIN user_list"
					+ " ON event_list.id = user_list.reserve_num"
					+ " WHERE event_list.id = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if(rs.next() == true) {
				event = mapToEvent(rs);
			}
			
			
		}catch(Exception e) {
			throw e;
		}
		
		
		return event;
	}
	
	@Override
	public Event findByMonth() throws Exception {
		// eventList.jspのaタブに入れるための情報を取得
		Event month = new Event();
		
		try(Connection con = ds.getConnection()){
			String sql = "SELECT event_date,MONTH(event_date) FROM event_list"
					   + " ORDER BY event_date";
					
					
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next() == true) {
				month = mapToEvent(rs);
			}
			
			
		}catch(Exception e) {
			throw e;
		}
		
		return month;
	}


	@Override
	public void insert(Event event) throws Exception {
		//eventFormからデータ取得
		try (Connection con = ds.getConnection()){
			
			String sql = "INSERT INTO event_list"
					   + " (event_name, event_date, event_place, event_capacity,"
					   + " event_contents, event_remarks)"
					   + " VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,event.getName());
			//パターン①×sqlよりutilが親要素のため
			//stmt.setDate(2,(java.sql.Date) event.getDate()); //キャストしますか？で出てきたまま
			//パターン②時間なし
			//java.util.Dateからjava.sql.Dateに変換(前やってた)
			//long d = event.getDate().getTime();
			//stmt.setDate(2, new java.sql.Date(d));
			//パターン③時間 試行中
			stmt.setTimestamp(2, new Timestamp(event.getDate().getTime()));
			stmt.setString(3,event.getPlace());
			stmt.setObject(4,event.getCapacity(), Types.INTEGER);
			stmt.setString(5,event.getContents());
			stmt.setString(6,event.getRemarks());
			stmt.executeUpdate();
		} catch (Exception e) {
			
			throw e;
		}

	}

	@Override
	public void update(Event event) throws Exception {
		// 
		try(Connection con = ds.getConnection()){
			String sql = "UPDATE event_list"
					+ " SET event_name = ?, event_date = ?, event_place = ?,"
					+ " event_capacity = ?, event_contents = ?, event_remarks = ?"
					+ " WHERE id = ?";
			 
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,event.getName());
			//stmt.setDate(2,(java.sql.Date) event.getDate()); //キャストしますか？で出てきたまま
			// stmt.setObject(2, event.getDate(), Types.DATE);
			//パターン③〇
			stmt.setTimestamp(2, new Timestamp(event.getDate().getTime()));
			stmt.setString(3,event.getPlace());
			stmt.setObject(4,event.getCapacity(), Types.INTEGER);
			stmt.setString(5,event.getContents());
			stmt.setString(6,event.getRemarks());
			stmt.setObject(7,event.getId(),Types.INTEGER);
			stmt.executeUpdate();
			
		}catch(Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Event event) throws Exception {
		// 
		try(Connection con = ds.getConnection()){
			String sql = "DELETE FROM event_list WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, event.getId(), Types.INTEGER);
			stmt.executeUpdate();
		
		}catch (Exception e) {
			throw e;
		}

	}

	private Event mapToEvent(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		String name = rs.getString("event_name");
		//getDate → getTimestamp変更　時間まで取得
		Date date = rs.getTimestamp("event_date");
		String place = rs.getString("event_place");
		Integer capacity = (Integer) rs.getObject("event_capacity");
		String contents = rs.getString("event_contents");
		String remarks = rs.getString("event_remarks");
		Integer remaining = 0;
		String fileName = null;

		return new Event(id, name, date, place, capacity, contents, remarks, remaining, fileName);
	}

	


}
