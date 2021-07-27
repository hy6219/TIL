package com.objectClass.string.stringBuffer;

public class methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1 = new StringBuffer();//����ũ�� : 16���� ���� �� �� ����
		StringBuffer sb2 = new StringBuffer(32); //32��ŭ 
		StringBuffer sb3 = new StringBuffer("abcdefg");//7+16=23��ŭ
		/*
		 * int length():  StringBuffer �ν��Ͻ��� ����� ���ڿ��� ���̸� ��ȯ
		 * 
		 * int capacity() : StringBuffer �ν��Ͻ��� ���� ���� ũ�� ��ȯ
		 */
		System.out.println("sb1: "+sb1+", sb1.length(): "+sb1.length()+", "
				+"capacity : "+sb1.capacity());
		System.out.println("sb2: "+sb2+", sb2.length(): "+sb2.length()+", "
				+"capacity : "+sb2.capacity());
		System.out.println("sb3: "+sb3+", sb3.length(): "+sb3.length()+", "
				+"capacity : "+sb3.capacity());
		/*
		 * 
		 * 
		 * sb1: , sb1.length(): 0, capacity : 16
sb2: , sb2.length(): 0, capacity : 32
sb3: abcdefg, sb3.length(): 7, capacity : 23
		 */
		System.out.println("===");
		sb1.append("def");
		System.out.println("sb1: "+sb1+", sb1.length(): "+sb1.length()+", "
				+"capacity : "+sb1.capacity());
/*
 * sb1: , sb1.length(): 0, capacity : 16
sb2: , sb2.length(): 0, capacity : 32
sb3: abcdefg, sb3.length(): 7, capacity : 23
===
sb1: def, sb1.length(): 3, capacity : 16
 */
		StringBuffer sb4 = sb2.append("def");//length�� ���ص� capacity�� ������ ����!
		System.out.println("sb2: "+sb2+", sb2.length(): "+sb2.length()+", "
				+"capacity : "+sb2.capacity()+",hashCode: "+sb2.hashCode());
		//capacity�� ���� ����Ǿ ������� ����!
		
		System.out.println("sb4: "+sb4+", sb4.length(): "+sb4.length()+", "
				+"capacity : "+sb4.capacity()+",hashCode: "+sb4.hashCode());
		sb4.append(1.25f);
		System.out.println("sb4: "+sb4+", sb4.length(): "+sb4.length()+", "
				+"capacity : "+sb4.capacity()+",hashCode: "+sb4.hashCode());//���̴� 7
		//capacity: 7+16=23
		/*
		 * ���� ũ�Ⱑ ��������? �׶��� ���� capacity�� �״���ϱ�?
		 */
		
		StringBuffer sb5 = new StringBuffer(3);
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());//capacity: 3
		sb5.append("abcdef");
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());//capacity: 8
		
		System.out.println("===");
		/*
		 * char charAt(int index) : ������ �ε���(index)�� �ִ� ���ڸ� ��ȯ
		 */
		System.out.println("sb5.charAt(2): "+sb5.charAt(2));//c
		
		System.out.println("===");
		/**
		 * StringBuffer deleteCharAt(int index) : ������ �ε���(index)�� �ִ�
		 * ���ڸ� ����
		 */
		sb5.deleteCharAt(2);
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());//abdef
		
		/**
		 * StringBuffer delete(int start, int end) :
		 * start �ε������� end-1 �ε������� ����
		 */
		System.out.println("===");
		sb5.delete(1,4);//af
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());
		
		/**
		 * StringBuffer insert(int pos, type t)
		 * : pos �ε��� �տ� ����!(�߰�����!)
		 * append�� �ڿ��� ����!
		 */
		System.out.println("===");
		sb5.insert(0, 1.2f); //1.2af
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());
		sb5.insert(1, false); //1false.2af
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());
		
		/**
		 * StringBuffer replace(int start, int end, String str)
		 * : start~end-1 �ε��� ������ str�� �ٲٱ�!
		 */
		System.out.println("===");
		sb5.replace(2, 5, "true");//���ڸ��� �Ѿ��?
		//1ftruee.2af -->�������! start~end-1 �� ���ڿ� �Ϻθ� �׳� str�� �ٲٴ� ��!
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());
		
		/**
		 * StringBuffer reverse()
		 * : StringBuffer �ν��Ͻ��� ����Ǿ� �ִ� ���ڿ� ������ �Ųٷ� ����!
		 */
		System.out.println("===");//
		sb5.reverse();//fa2.eeurtf1
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());
		
		/*
		 * void setLength(int newLength)
		 * : ������ ���̷� ���ڿ� ���� ����
		 * -���̸� �ø��� ���, ������ ������� �ι��ڷ� ä��
		 */
		StringBuffer ext = new StringBuffer("123456");
		System.out.println("ext length: "+ext.length()+", ext : "+ext+"]");//6
		//ext length: 6, ext : 123456]
		
		
		ext.setLength(10);
		System.out.println("ext length: "+ext.length()+", ext : "+ext+"]");//10
		//ext length: 10, ext : 123456    ]
		
		/*
		 * String substring(int start) -start ~ ������
		 * String substring(int start, int end) - start ~ end-1����
		 * 
		 * ���ڿ��� �߶�
		 * 
		 */
		System.out.println("===");
		String s = ext.substring(1);//23456
		String s2 = ext.substring(1,4);//234
		System.out.println("ext: "+ext);
		System.out.println("s: "+s);
		System.out.println("s2: "+s2);
		/*
		 * substring�� return super.substring()�̰�
		 * 
		 * �ٸ� StringBuffer ��ȯ�޼���� return this;�� �Ǳ� ������ ����
		 * ������ �������� �ʾƵ� ��
		 */
		
	}

}
