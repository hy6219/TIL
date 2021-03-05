package com.exception13;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionEx22 {
/**
 * 
 * @param args
 * 
 * try-with-resource
 * : 자동 자원 반환
 * : 입출력과 관련된 클래스를 사용할 때 유용
 * 
 * 입출력에 사용되는 클래스 중 사용한 후 꼭 닫아주어야 하는 경우가 존재
 * -사용했던 자원(resources)이 반환될 수 있도록 하기 위함
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis;
		DataInputStream dis = null;
		
		try
		{
			fis=new FileInputStream("score.dat");
			dis=new DataInputStream(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				dis.close();//예외를 발생시킬 수 있기 때문에 try-catch로 감싸기
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
