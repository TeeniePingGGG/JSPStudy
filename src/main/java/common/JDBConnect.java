package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletContext;

		
public class JDBConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	//기본 생성자	
	public JDBConnect() {
		try {
			// 오라클 드라이버 로드	
			Class.forName("oracle.jdbc.OracleDriver");
			//커넥션 URL, 아이디, 비번							
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "musthave";
			String pwd = "1234";
			// 연결 시도 및 Connection 객체 반환
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("DB연결 성공(기본 생성자)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		// 인수생성자: 4개의 매개변수 선언
	   public JDBConnect(String driver, String url, String id, String pwd) {
		      try {
		         Class.forName("oracle.jdbc.OracleDriver");
		         con = DriverManager.getConnection(url, id, pwd);
		         System.out.println("DB 연결 성공(인수 생성자1)");
		      }
		      catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
	   
	   public JDBConnect(ServletContext application) {
			try {
				String driver = application.getInitParameter("OracleDriver");
				Class.forName(driver);
				//커넥션 URL, 아이디, 비번							
				String url = application.getInitParameter("OracleURL");
				String id = application.getInitParameter("OracleId");
				String pwd = application.getInitParameter("OraclePwd");
				con = DriverManager.getConnection(url,id,pwd);
				
				System.out.println("DB연결 성공(인수 생성자2)");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	
	// 자원 반납 하기
	public void close() {
		try {
			if(rs != null)rs.close();
			if(stmt != null)stmt.close();
			if(psmt != null)psmt.close();
			if(con != null)con.close();
			
			System.out.println("JDBC 자원 해제");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
