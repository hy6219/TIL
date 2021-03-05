package com.exception13;

public class CloseableResource implements AutoCloseable{

	public void exceptionWork(boolean exception) throws WorkException
	{
		System.out.println("exceptionWork( "+exception+") 가 호출됨");
		if(exception)
		{
			throw new WorkException("WorkException 발생!!!");
		}
	}
	@Override
	public void close() throws CloseException {
		// TODO Auto-generated method stub
		System.out.println("close()가 호출됨");
		throw new CloseException("CloseException 발생!!");
	}
	
}
