package com.exception11;

import java.io.File;
/**
 * 
 * @author gs813
 * [메서드 예외 발생 처리]
 * 1) 호출한 메서드(main)에서 예외 처리하기 - 메서드 호출 시 넘겨받아야 할 인수가 있는 경우,
 *    메서드에서 예외를 선언하고+ 호출한 메서드(main)에서 예외처리
 * 2) 호출되는 메서드에서 예외처리 하기(호출한 메서드(main)에서는 예외가 발생한 것을
 * 	    알 수 없음) - 메서드 내부에서 자체적으로 처리가 가능한 경우
 * 
 */
public class ExceptionEx19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			File f=createFile(args[0]);
			System.out.println(f.getName()+ " 파일이 성공적으로 "
					+ "생성되었습니다");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()+" 다시 입력해주시기 "
					+ "바랍니다.");
		}
	}
	static File createFile(String fileName) throws Exception
	{
		if(fileName==null || fileName.equals(""))
		{
			throw new Exception("파일 이름이 유효하지 않습니다");//예외 발생 시키기
		}
		
		File f= new File(fileName);
		f.createNewFile();
		return f;
	}
}
