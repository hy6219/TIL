package com.exception13;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionEx23 implements Closeable{

	/**
	 * 
	 * @param args
	 * 
	 * 
	 * AutoCloseable : try-with-resource 문에 의해 close가 자동으로 호출되기 위함
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 0, sum = 0;
		
		try(FileInputStream fis = new FileInputStream("score.dat");
				DataInputStream dis = new DataInputStream(fis))
		{
			while(true)
			{
				score = dis.readInt();
				System.out.println(score);
				sum  += score;
			}
		}
		catch(EOFException e)
		{
			System.out.println("점수의 총합은 "+sum+"입니다.");
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("IOException");
	}


}
