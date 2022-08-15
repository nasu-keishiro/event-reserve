package calculation;

import dao.DaoFactory;
import dao.EventDao;
import dao.ReserveDao;
import domain.Event;

public class Capacity {

	/**
	 * 残り予約数を計算するメゾット
	 * @param eventId イベントのID情報(int)
	 * @return 残り予約数(int)
	 */
	public int getRemaining(int i) {
			
		int remaining = 0;
		
			//イベントのcapacityを取得 eventDao
		try {
			EventDao eventDao = DaoFactory.createEventDao();
			Event event = eventDao.findById(i);
			int capacity = event.getCapacity();
			
			//予約が入っているカラム数を取得 reserveDao
			ReserveDao reserveDao = DaoFactory.createReserveDao();
			long num = reserveDao.NumberOfReservations(i);
			int num2 = (int)num;
			
			//引き算
			remaining = capacity - num2;
			
		} catch (Exception e) {
			// 
			e.printStackTrace();
		}
		
		
		
		
		return remaining ;
	}
	
	
}
