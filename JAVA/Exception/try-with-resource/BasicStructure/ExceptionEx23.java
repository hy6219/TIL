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
	 * AutoCloseable : try-with-resource ���� ���� close�� �ڵ����� ȣ��Ǳ� ����
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
			System.out.println("������ ������ "+sum+"�Դϴ�.");
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
