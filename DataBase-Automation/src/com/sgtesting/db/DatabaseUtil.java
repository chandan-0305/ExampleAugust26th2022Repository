package com.sgtesting.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DatabaseUtil {
	/**
	 * Get Number of Records
	 */
	public static int getRecords(String query)
	{
		int recordsCount=0;
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Tiger");
			
			PreparedStatement stmt=conn.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				recordsCount+=1;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return recordsCount;
	}

	/**
	 * Get Numbers of Columns
	 */
	public static int getColumnsCount(String query)
	{
		int columnsCount=0;
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Tiger");
						
			PreparedStatement stmt=conn.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			ResultSetMetaData rsdata=rs.getMetaData();
			columnsCount=rsdata.getColumnCount();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return columnsCount;
	}
	
	/**
	 * Get One Specific Column Data
	 */
	public static String getColumnData(String query,String columnname)
	{
		String columnData=null;
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Tiger");
						
			PreparedStatement stmt=conn.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			ResultSetMetaData rsdata=rs.getMetaData();
			int columnsCount=rsdata.getColumnCount();
			if(columnsCount>1)
			{
				columnData=null;
			}
			rs.next();
			columnData=rs.getString(columnname);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return columnData;
	}

}
