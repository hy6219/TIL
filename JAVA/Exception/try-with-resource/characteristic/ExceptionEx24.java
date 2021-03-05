package com.exception13;
/**
 * 
 * @author gs813
 *try-with-resource
 *:실제 예외+억제된(suppressed)예외 모두 알려줌
 *:억제된 예외는 실제 예외에 저장됨
 *
 *Throwable 내 suppressed 관련 메서드:
 *void addSuppressed(Throwable method) : 억제된 예외 추가
 *Throwable[] getSuppressed() : 억제된 예외 (배열) 를 반환
 */
public class ExceptionEx24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(CloseableResource cr = new CloseableResource())
		{
			cr.exceptionWork(false);//예외가 발생x
		}
		catch(WorkException e)
		{
			e.printStackTrace();
		}
		catch(CloseException e)
		{
			e.printStackTrace();
		}
		
		System.out.println();
		
		try(CloseableResource cr = new CloseableResource())
		{
			cr.exceptionWork(true);//예외가 발생
		}
		catch(WorkException e)
		{
			e.printStackTrace();
		}
		catch(CloseException e)
		{
			e.printStackTrace();
		}
		
		System.out.println();
	}

}
