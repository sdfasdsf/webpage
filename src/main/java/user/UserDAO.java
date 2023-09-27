package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS?characterEncoding=UTF-8&serverTimezone=UTC";
			//localhost:3306 => 내컴퓨터에 설치된 MySQL, port 3306의 BBS라는 DB에 접속
			
			String dbID = "root";
			String dbPassWord = "root";
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn = DriverManager.getConnection(dbURL, dbID, dbPassWord);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) 
	{
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		
		try 
		{
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  userID);
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				if(rs.getString(1).contentEquals(userPassword))
					return 1; // �α��� ����
				else
					return 0; // ��й�ȣ ����ġ
			}
			return -1; // ���̵� ����
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return -2; // ������ ���̽� ����
	}
	
	public int join(User user)
	{
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
		return -1; //������ ���̽� ����
	}
	
}