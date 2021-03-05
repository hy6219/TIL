package com.exception16;

public class ExceptionEx27 {

	/**
	 * 
	 * @param args
	 * 
	 * 연결된 예외(chained exception)
	 * A->B ==> A는 B의 '원인예외'
	 * 
	 * 1)상속관계가 아니어도 예외를 포함시킬 수 있음
	 * 2)checked 예외를 unchecked 예외로 변경할 수 있게 함으로써
	 * 의미없는 try-catch문을 추가하는 일을 줄일 수 있음
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			install();
		}
		catch(InstallException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void install() throws InstallException
	{
		try
		{
			startInstall();
			copyFiles();
		}
		catch(SpaceException se)
		{
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(se);//ie를 se의 원인예외로 등록
			//즉, ie->se

			throw ie;//예외 되돌리기 exception re-throwing
		}
//		catch(MemoryException me)
//		{
//			InstallException e = new InstallException("설치 중 예외 발생");
//			e.initCause(me);
//			//e를 me의 원인예외로 등록
//			//즉, e->me
//			throw me;//예외 되돌리기 exception re-throwing
//		}
		finally
		{
			deleteTempFiles();
		}
	}
	
//	static void startInstall() throws SpaceException, MemoryException
//	{
//		if(!enoughSpace()) 
//		{
//			throw new SpaceException("설치 공간이 부족합니다");
//			
//		}
//		if(!enoughMemory())
//		{
//			throw new MemoryException("메모리가 부족합니다");
//		}
//	}
	static void startInstall() throws SpaceException
	{
		if(!enoughSpace()) 
		{
			throw new SpaceException("설치 공간이 부족합니다");
			
		}
		if(!enoughMemory())
		{
			throw new RuntimeException(new MemoryException("메모리가 부족합니다"));
		}
	}
	
	static void copyFiles()
	{
		System.out.println("copy..");
	}
	static void deleteTempFiles()
	{
		System.out.println("delete..");
	}
	static boolean enoughSpace()
	{
		return false;
	}
	
	static boolean enoughMemory()
	{
		return true;
	}

}
