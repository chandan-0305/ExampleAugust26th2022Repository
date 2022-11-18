package com.sgtesting.calculator.sourcecode;

public class Calculator {
	/**
	 * Method Name: Addition
	 */
	public int addition(int num1,int num2)
	{
		int result=0;
		try
		{
			result=(num1+num2);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Method Name: Addition with More Numbers
	 */
	public int addition(int nums[])
	{
		int result=0;
		try
		{
			for(int i=0;i<nums.length;i++)
			{
				result=result+nums[i];
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Method Name: Multiplication
	 */
	public int multiplication(int num1,int num2)
	{
		int result=1;
		try
		{
			result=(num1*num2);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Method Name: Multiplication with more Numbers
	 */
	public int multiplication(int nums[])
	{
		int result=1;
		try
		{
			for(int i=0;i<nums.length;i++)
			{
				result=result*nums[i];
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Method Name: Substraction
	 */
	public int Subtraction(int num1,int num2)
	{
		int result=0;
		try
		{
			result=(num1-num2);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Method Name: Division
	 */
	public int division(int num1,int num2)
	{
		int result=0;
		try
		{
			result=(num1/num2);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}


}
