package gov.cygs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.cci.ResultSet;
import javax.sql.DataSource;

public class DB_Conn {
	public static DataSource dataSource = null;
	
	public DB_Conn(){
		try{
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:/CygsDS");
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	
	public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs ){
		try { 
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public DataSource getDataSource(){
		return this.dataSource;
	}
	
}
