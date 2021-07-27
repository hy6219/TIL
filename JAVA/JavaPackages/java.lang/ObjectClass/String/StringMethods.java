package com.objectClass.string;

public class StringMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s3 = "\u0000";
		String s4 =" ";
		
		
		char[] c = {'h','e','l','l','o'};
//		s4 = c;
		s4 = new String(c); //new String(char[])
		System.out.println("s4: "+s4);
		
		StringBuffer sb = new StringBuffer("hello");
	    s3 = new String(sb); //new String(StringBuffer());
	    System.out.println("s3: "+s3);
	    
	    /*
	     * int compareTo(String str)
	     */
	    System.out.println("======================");
	    System.out.println("compareTo");
	    int sim = s4.compareTo(s3);//0
	    System.out.println("s4: "+ s4+", s3: "+s3+", compare: "+sim);
	    sb = new StringBuffer("Aloha");
	    String s5 = new String(sb);
	    int after= s4.compareTo(s5);//s4�� ����! ��� ��ȯ
	    System.out.println("s4: "+ s4+", s5: "+s5+", compare: "+after);
	    s5 = "hhh";//s4�� ����! ������ȯ
	    int before = s4.compareTo(s5);
	    System.out.println("s4: "+ s4+", s5: "+s5+", compare: "+before);
	    
	    /*
	     * compareTo�� ���ڿ����� ����!
	     * But!!������ 0, ������ ������ -1, ������ ũ�� +1 ��ȯ
	     */
	    Integer v = 5;//�� Integer��
	    System.out.println(v.compareTo(2));//1
	    /*
	     * compare
	     * ������ 0, ������ ������ -1, ������ ũ�� +1 ��ȯ
	     */
	    System.out.println("======================");
	    System.out.println("Integer.compare");
	    int t = 5;
	    System.out.println(Integer.compare(5, 8));//-1
	    
	    /*
	     * String concat(String str) :���ڿ��� �ڿ� ������
	     * 
	     */
	    System.out.println("======================");
	    System.out.println("concat");
	    String s = "concat";
	    System.out.println("Before: "+s);
	    s= s.concat(s4);
	    System.out.println("After: "+s);
	    
	    /*
	     * boolean contains(CharSequence s) :
	     * ������ ���ڿ�s�� ���ԵǾ����� �˻�
	     */
	    System.out.println("======================");
	    System.out.println("contains");
	    String co = "con";
	    System.out.println(s.contains(co));//true
	    System.out.println(co.contains(s));//false
	    
	    /*
	     * boolean endsWith(String suffix)
	     * :������ ���ڿ�(suffix)�� �������� �˻�
	     */
	    System.out.println("======================");
	    System.out.println("endsWith");
	    System.out.println(s.endsWith(co));//false
	    System.out.println(s.endsWith("lo"));//true
	    
	    /*
	     * ��ҹ��� ���о��� ��
	     * 
	     * boolean equalsIgnoreCase(String str)
	     */
	    System.out.println("======================");
	    System.out.println("equalsIgnoreCase");
	    String a = "abc";
	    String b = "Abc";
	    String d = "aBc";
	    System.out.println(a.equalsIgnoreCase(b));//true
	    System.out.println(a.equalsIgnoreCase(d));//true
	    
	    /**
	     * int indexOf(int ch)
	     * :https://stackoverflow.com/questions/6210231/why-is-parameter-to-string-indexof-method-is-an-int-in-java
	     * �Ű����� Ÿ���� int�� ����
	     * : �ƽ�Ű�ڵ�� ó���ϱ� ���ؼ�
	     * ==�־��� ���� ch�� ���ڿ��� �����ϴ��� Ȯ���Ͽ� ��ġ�� ��ȯ
	     * -��ã���� -1 ��ȯ
	     */
	    System.out.println("======================");
	    System.out.println("indexOf(������)");
	    System.out.println("���� ch�� ���� "
	    		+ "���� ������ ��ġ�� ��ȯ");
	    String ex = "Alexander";
	    int idx = ex.indexOf('a');
	    System.out.println("index of a: "+idx);//0
	    idx = ex.indexOf('b');
	    System.out.println("index of b: "+idx);//-1
	    
	    /*
	     * int indexOf(String str)
	     * ==�־��� ���ڿ��� �����ϴ��� Ȯ���Ͽ� �� ��ġ
	     * (�־��� ���ڿ��� ù��° ������ ��ġ)�� ��ȯ
	     * -������ -1 ��ȯ
	     */
	    System.out.println("======================");
	    System.out.println("indexOf(���ڿ�)");
	    idx = ex.indexOf("der");
	    System.out.println("index of \"der\": "+idx);
	    
	    idx = ex.indexOf("zer");
	    System.out.println("index of \"zer\": "+idx);//-1
	    
	    /**
	     * int indexOf(int ch, int pos)
	     * : �־��� ���� ch�� ���ڿ��� �����ϴ��� ���� ��ġ�� pos���� Ȯ��
	     * ��ã���� -1 ��ȯ
	     */
	    System.out.println("======================");
	    System.out.println("indexOf(������, ����������ġ)");
	    idx = ex.indexOf('d',ex.length() - 2);// -1
	    System.out.println("�ڿ��� �ι�° ��ġ�������� d�� ã�� indexOf(char, startpos): "+
	    					idx);
	    idx = ex.indexOf('d',ex.length() - 3);// 6
	    System.out.println("�ڿ��� ����° ��ġ�������� d�� ã�� indexOf(char, startpos): "+
	    					idx);
	    
	    /**
	     * int indexOf(String str, int pos)
	     * : �־��� ���ڿ��� ���ڿ��� �����ϴ��� ���� ��ġ�� pos���� Ȯ��(ã���� �ϴ� ���ڿ��� ù
	     * ��ã���� -1 ��ȯ
	     */
	    System.out.println("======================");
	    System.out.println("indexOf(���ڿ�, ����������ġ)");
	    idx = ex.indexOf("der",ex.length()-3);
	    System.out.println("�ڿ��� �ι�° ��ġ�������� der�� ã�� indexOf(str, startpos): "+
				idx);//6
	    idx = ex.indexOf("der",ex.length()-2);//-1
	    System.out.println("�ڿ��� �ι�° ��ġ�������� der�� ã�� indexOf(str, startpos): "+
				idx);
	    /**
	     * String intern()
	     * :
	     * ���ڿ� ���ͷ��� ���Ǯ(constant pool)�� ���
	     * �̹� ���Ǯ�� ���� ������ ���ڿ��� �ִ� ���, �� ���ڿ��� �ּҰ��� ��ȯ!
	     */
	    System.out.println("======================");
	    System.out.println("intern()");
	    String ss = new String("alexander").intern();
	    String st = ex.intern();
	    boolean b1 = (ss == st);
	    boolean b2 = (ex == ss);
	    boolean b3 = (ex == st);
	    System.out.println("ex : "+ex+ ",hashCode: "+ex.hashCode()+","
	    		+ " identity: "+System.identityHashCode(ex));
	    System.out.println("String ss = new String(\"alexander\").intern(): "+
	    			ss+", hashCode: "+ss.hashCode()+", identity: "+
	    		System.identityHashCode(ss));//hashCode�� string���� �������̵�
	    //������ ���������� ���� ��
	    System.out.println("String st = ex.intern(): "+
    			st+", hashCode: "+st.hashCode()+", identity: "+
    		System.identityHashCode(st));
	    System.out.println("b1: "+b1+", b2: "+b2+", b3: "+b3);

	    /**
	     * int lastIndexOf(int ch)
	     * :������ ���ڳ� �����ڵ带 ���ڿ��� ������ ������ ã�Ƽ� ��ġ�� �˷��ֱ�
	     * ��ã���� -1 ��ȯ
	     */
	    System.out.println("======================");
	    System.out.println("lastIndexOf(int ch)");
	    idx = ex.lastIndexOf('r');//���������� ã�� ������ ������ �����Ѵٸ�
	    //�ش繮���� ���� ������ ���� �ε��� ���� ��ȯ�Ұ� //8
	    System.out.println("lastIndexOf: "+idx);
	    
	    idx = ex.lastIndexOf('0');//-1
	    System.out.println("lastIndexOf: "+idx);
	    
	    /**
	     * int lastIndexOf(String str)
	     * :������ ���ڿ��� ���ڿ��� ������ ������ ã�Ƽ� ��ġ�� �˷��ֱ�
	     * ��ã���� -1 ��ȯ
	     */
	    System.out.println("======================");
	    System.out.println("lastIndexOf(String str)");
	    String nn = "derder";
	    idx = nn.lastIndexOf("der");//���������� ã�� ������ ������ �����Ѵٸ�
	    //�ش繮���� ���� ������ ���� �ε��� ���� ��ȯ�Ұ� //3
	    System.out.println("lastIndexOf: "+idx);//3
	    
	    idx = ex.lastIndexOf(String.valueOf('\u0000'));//-1(�ڹٴ� ���� null���ڸ� ���� ����!)
	    System.out.println("lastIndexOf: "+idx);
	    
	    /**
	     * int lastIndexOf(int ch, int fromIdx)
	     * :������ ���ڳ� �����ڵ带 fromIdx���� 0(ó���ε���)���� ã�ƺ���  ��ġ�� �˷��ֱ�
	     * ��ã���� -1 ��ȯ
	     * 
	     * String ex ="alexander"
	     */
	    System.out.println("======================");
	    System.out.println("lastIndexOf(int ch, int fromIdx)");
	    idx = ex.lastIndexOf('d', 2);// -1
	    System.out.println("lastIndexOf with startIdx: "+idx);
	    idx = ex.lastIndexOf('d', 6);// 6
	    System.out.println("lastIndexOf with startIdx: "+idx);
	    
	    /**
	     * int lastIndexOf(String str, int fromIdx)
	     * :������ ���ڿ��� fromIdx���� 0(ó���ε���)���� ã�ƺ���  ��ġ�� �˷��ֱ�
	     * ��ã���� -1 ��ȯ
	     * 
	     * String ex ="alexander"
	     */
	    System.out.println("======================");
	    System.out.println("lastIndexOf(String str, int fromIdx)");
	    idx = ex.lastIndexOf("der", 2);// -1
	    System.out.println("lastIndexOf with startIdx: "+idx);
	    idx = ex.lastIndexOf("der", 6);// 6
	    System.out.println("lastIndexOf with startIdx: "+idx);
	    
	    /**
	     * String replace(char old, char nw)
	     * -���ڿ� �� ���� �ϳ�(old)�� ���ο� ����(nw)�� �ٲ� ���ڿ��� ��ȯ��
	     */
	    System.out.println("======================");
	    System.out.println("String replace(char old, char nw)");
	    String pr = ex.replace('e', 'i'); //���� �ٸ��� ������ �ؽ��ڵ尡 �ٸ�!
	    System.out.println("ex: "+ex+", hashCode: "+ex.hashCode()+","
	    		+ " identity: "+System.identityHashCode(ex));
	    System.out.println("pr: "+pr+", hashCode: "+pr.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pr));
	    
	    /**
	     * String replace(CharSequence old, CharSequence nw)
	     * : ���ڿ� �� ���ڿ� old�� ���ڿ� nw�� ��� �ٲ� ���ڿ��� ��ȯ��
	     */
	    System.out.println("======================");
	    System.out.println("String replace(CharSequence old, CharSequence nw)");
	    pr = ex.replace("der", "zer"); //���� �ٸ��� ������ �ؽ��ڵ尡 �ٸ�!
	    System.out.println("ex: "+ex+", hashCode: "+ex.hashCode()+","
	    		+ " identity: "+System.identityHashCode(ex));
	    System.out.println("pr: "+pr+", hashCode: "+pr.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pr));
	    
	    /**
	     * String replaceAll(String regex, String replacement)
	     * : ���ڿ� �� ������ ���ڿ��� ��ġ�ϴ� ���� ���ο� ���ڿ��� ��� ����
	     * : replace�� �޸� string�� ��!(replace�� charsequence��
	     * ������ ��� ���¿� ����)
	     * https://djusti.tistory.com/8
	     */
	    System.out.println("======================");
	    System.out.println("String replaceAll(String regex, String replacement)");
	    String pp = "dddddddaa";
	    pr = pp.replaceAll("dd", "zer"); //���� �ٸ��� ������ �ؽ��ڵ尡 �ٸ�!
	    System.out.println("pp: "+pp+", hashCode: "+pp.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pp));
	    System.out.println("pr: "+pr+", hashCode: "+pr.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pr));
	    
	    /**
	     * String replaceFirst(String regex, String replacement)
	     * : ���ڿ� �� ������ ���ڿ�(regex)�� ��ġ�ϴ� �� ��, ù ��° �͸�
	     * ���ο� ���ڿ�(replacement)�� ����
	     */
	    System.out.println("======================");
	    System.out.println("String replaceFirst(String regex, String replacement)");
	    pr = pp.replaceFirst("dd", "zer"); //���� �ٸ��� ������ �ؽ��ڵ尡 �ٸ�!
	    System.out.println("pp: "+pp+", hashCode: "+pp.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pp));
	    System.out.println("pr: "+pr+", hashCode: "+pr.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pr));//zerdddddaa
	    
	    /**
	     * String[] split(String regex)
	     * : ���ڿ��� ������ �и��ڷ� ������ ���ڿ� �迭�� ��Ƽ� ��ȯ
	     */
	    System.out.println("======================");
	    System.out.println("String[] split(String regex)");
	    String[] split = ex.split("e");
	    String toStr = null;
	    StringBuffer strb = new StringBuffer();
	    StringBuffer strb1 = new StringBuffer();
	    for(int i = 0 ; i < split.length; i++)
	    {
	    	strb.append(split[i]);
	    	strb1.append(split[i]).append(" ");
	    	System.out.println(split[i]);
	    }
	    System.out.println(new String(strb));
	    System.out.println(new String(strb1));
	    
	    
	    /**
	     * String[] split(String regex, int limit)
	     * : ���ڿ��� �и���(regex)�� ������ ���ڿ� �迭�� ��� ��ȯ
	     * : ��, ���ڿ� ��ü�� ������ ��(limit)�� �ڸ�
	     */
	    System.out.println("======================");
	    System.out.println("String[] split(String regex, int limit)");
	    String animals = "dog,"
	    		+ "cat,"
	    		+ "bear";
	    
	    String[] arr = animals.split(",",2);
	    for(String i : arr)
	    {
	    	System.out.print(i+"\t");
	    }
	    System.out.println();//dog	cat,bear
	    
	    arr = animals.split(",",3);
	    for(String i : arr)
	    {
	    	System.out.print(i+"\t");
	    }
	    System.out.println();//dog cat bear
	    
	    /**
	     * String substring(int begin)
	     * String substring(int begin, int end)
	     * 
	     * �־��� ���� ��ġ���� end-1�ε��������� ���ڿ��� �߶󳻾� ��ȯ
	     */
	    System.out.println("======================");
	    System.out.println("String substring(int begin)");
	    pr = ex.substring(6);
	    System.out.println("ex: "+ex+", hashCode: "+ex.hashCode()+","
	    		+ " identity: "+System.identityHashCode(ex));
	    System.out.println("pr: "+pr+", hashCode: "+pr.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pr));//der
	    
	    System.out.println("======================");
	    System.out.println("String substring(int begin, int end)");
	    pr = ex.substring(1,4);
	    System.out.println("ex: "+ex+", hashCode: "+ex.hashCode()+","
	    		+ " identity: "+System.identityHashCode(ex));
	    System.out.println("pr: "+pr+", hashCode: "+pr.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pr));//lex
	    
	    /**
	     * String toLowerCase() : �ҹ��ڷ� ��ȯ!
	     * String toUpperCase() : �빮�ڷ� ��ȯ!
	     * -�� �����ڰ� �ƴ� ���� �����־ �������! �����ڸ� ��ȯ!
	     */
	    System.out.println("======================");
	    System.out.println("String toLowerCase()");
	    pr = ex.toLowerCase();
	    pp = ex.toUpperCase();
	    System.out.println("ex: "+ex+", hashCode: "+ex.hashCode()+","
	    		+ " identity: "+System.identityHashCode(ex));
	    System.out.println("pr: "+pr+", hashCode: "+pr.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pr));
	    System.out.println("======================");
	    System.out.println("String toUpperCase()");
	    System.out.println("pp: "+pp+", hashCode: "+pp.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pp));
	    String mixedType = "123ex������";
	    String pt = mixedType.toUpperCase();
	    System.out.println("pt: "+pt+", hashCode: "+pt.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pt));
	    
	    /**
	     * String trim() : ���ڿ��� ���� ���� ������ ���� �ִ� ������ ���� ��� ��ȯ
	     * (���ڿ� �߰��� ������ ���ŵ��� ����)
	     */
	    System.out.println("======================");
	    System.out.println("String trim()");
	    String lets = " 12 3		";
	    String trimmed = lets.trim();
	    System.out.println("lets:"+lets+", hashCode: "+lets.hashCode()+","
	    		+ " identity: "+System.identityHashCode(lets));
	    System.out.println("trimmed:"+trimmed+", hashCode: "+
	    		trimmed.hashCode()+",identity: "+
	    		System.identityHashCode(trimmed));//12 3
	    /**
	     * static String valueOf(boolean/int/double/float/long/
	     * char/Object)
	     * -->toString�� ȣ���ϱ� ������ �Ȱ��� static!
	     */
	    /*
	     * public static String valueOf(int i) {
        return Integer.toString(i);
    }
	     */
	    System.out.println("======================");
	    System.out.println("static String valueOf");
	    boolean bbb = false;
	    float f = 123.123f;
	    
	    Object obj = String.valueOf(bbb);//�׳� valueOf�� ����, Ŭ���� ���� 
	    //�ش� �޼��带 ������ �ʾұ⿡, ������ String���� Ŭ�����޼��� Ư���� ��� ������ֱ�
	    if(obj instanceof String)
	    {
	    	System.out.println("bbb: "+bbb+", obj.toString: "+obj.toString()+
	    			", hashCode: "+obj.hashCode()+"identity: "+
	    			System.identityHashCode(obj));
	    }
	    else
	    {
	    	System.out.println("NOT");
	    }
	    
	    obj = String.valueOf(f);
	    if(obj instanceof String)
	    {
	    	System.out.println("f: "+f+", obj.toString: "+obj.toString()+
	    			", hashCode: "+obj.hashCode()+"identity: "+
	    			System.identityHashCode(obj));
	    }
	    else
	    {
	    	System.out.println("NOT");
	    }
	}

}
