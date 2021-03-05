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
			System.out.println("���� �޽��� : "+e.getMessage());
			e.printStackTrace();
			System.out.println("������ Ȯ���� �Ŀ� �ٽ� ��ġ�ϱ� �ٶ��ϴ�");
		}
		catch(MemoryException me)
		{
			System.out.println("���� �޽��� : "+me.getMessage());
			me.printStackTrace();
			/**
			 * Runs the garbage collector. 
Calling the gc method suggests that the Java VirtualMachine expend effort toward recycling unused objects in order tomake the memory they currently occupy available for quick reuse.When control returns from the method call, the Java VirtualMachine has made a best effort to reclaim space from all discardedobjects. 

������ �÷��Ͱ� ������� �ʴ� �޸� ������ û���� �� �ֵ��� ��(->����Ȯ��)
			 */
			System.gc();
			System.out.println("�ٽ� ��ġ�� �õ��ϼ���");
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
			throw new SpaceException("��ġ�� ������ �����մϴ�");
		}
		if(!enoughMemory())
		{
			throw new MemoryException("�޸𸮰� �����մϴ�");
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
