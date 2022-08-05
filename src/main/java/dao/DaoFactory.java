package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoFactory {
	
	public static LoginDao createLoginDao() {
		return new LoginDaoImpl(getDataSource());
	}
	
	public static EventDao createEventDao() {
		return new EventDaoImpl(getDataSource());
	}
	
	public static ReserveDao createReserveDao() {
		return new ReserveDaoImpl(getDataSource());
	}

	private static DataSource getDataSource() {
		InitialContext ctx = null;
		DataSource ds = null;
		
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/event_reserve");
			
		} catch (NamingException e) {
			if(ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e1) {
					
				    throw new RuntimeException(e1);
				}
			}
			throw new RuntimeException(e);
		}
		
		
		return ds;
	}
}
