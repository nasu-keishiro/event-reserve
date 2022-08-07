package dao;

import java.util.List;

import domain.Reserve;


public interface ReserveDao {
	List<Reserve> findAll() throws Exception;
	List<Reserve> findByReserveNum(Integer id) throws Exception;
	Reserve findById(Integer id) throws Exception;
	void insert(Reserve reserve) throws Exception;
	void update(Reserve reserve) throws Exception;
	void delete(Reserve reserve) throws Exception;
	Reserve findByReserveNumAndReserveName(String reserveNum, String name);
}
