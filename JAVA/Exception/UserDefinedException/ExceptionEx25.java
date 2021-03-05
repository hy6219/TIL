package com.exception14;

public class ExceptionEx25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			startInstall();
			copyFiles();
		}
		catch(SpaceException e)
		{
			System.out.println("에러 메시지 : "+e.getMessage());
			e.printStackTrace();
			System.out.println("공간을 확보한 후에 다시 설치하기 바랍니다");
		}
		catch(MemoryException me)
		{
			System.out.println("에러 메시지 : "+me.getMessage());
			me.printStackTrace();
			/**
			 * Runs the garbage collector. 
Calling the gc method suggests that the Java VirtualMachine expend effort toward recycling unused objects in order tomake the memory they currently occupy available for quick reuse.When control returns from the method call, the Java VirtualMachine has made a best effort to reclaim space from all discardedobjects. 

가비지 컬렉터가 사용하지 않는 메모리 공간을 청소할 수 있도록 함(->공간확보)
			 */
			System.gc();
			System.out.println("다시 설치를 시도하세요");
		}
		finally
		{
			deleteTempFiles();
		}
	}
	static void startInstall() throws SpaceException, MemoryException
	{
		if(!enoughSpace())
		{
			throw new SpaceException("설치할 공간이 부족합니다");
		}
		if(!enoughMemory())
		{
			throw new MemoryException("메모리가 부족합니다");
		}
	}
	static void copyFiles()
	{
		System.out.println("copy files...");
	}
	static void deleteTempFiles()
	{
		System.out.println("delete files...");
	}
	static boolean enoughSpace()
	{
		final int NEED   = 128;
		final int REMAIN = 100;
		
		if(REMAIN >= NEED)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	static boolean enoughMemory()
	{
		final int NEED   = 108;
		final int REMAIN = 128;
		
		if(REMAIN >= NEED)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	

}
