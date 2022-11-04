package com.sgtesting.db;

public class ExecutionDatbaseDemo {
public static void main(String[] args) {
		
		int rc=DatabaseUtil.getRecords("select * from dept2");
		System.out.println("Number of Records :"+rc);

		int cc=DatabaseUtil.getColumnsCount("select * from dept2");
		System.out.println("Number of Columns :"+cc);
		
		String val=DatabaseUtil.getColumnData("select * from dept2 where deptno=60", "DNAME");
		System.out.println("Column Data :"+val);
	}



}
