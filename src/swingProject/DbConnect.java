package swingProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	
	//url
	static final String ORACLE_CLOUD = "jdbc:oracle:thin:@db202202172315_high?TNS_ADMIN=/Users/igyeonglyong/sist0117/WalletOracle";

	
	//connection
	public Connection getOracle() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(ORACLE_CLOUD, "admin", "Lsyeugene971028*");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 연결 실패" + e.getMessage());
		}
		return conn;
	}
	
	//close select...완성형 sql(statement)
	public void dbClose(ResultSet rs, Statement stmt, Connection conn) {
		
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	//close ...완성형 sql(statement)
	public void dbClose(Statement stmt, Connection conn) {
		try {
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//close select...미완성형 sql(PrepareStatement)
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//close...미완성형 sql(PrepareStatement)
	public void dbClose(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
