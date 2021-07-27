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
	    int after= s4.compareTo(s5);//s4가 이후! 양수 반환
	    System.out.println("s4: "+ s4+", s5: "+s5+", compare: "+after);
	    s5 = "hhh";//s4가 이전! 음수반환
	    int before = s4.compareTo(s5);
	    System.out.println("s4: "+ s4+", s5: "+s5+", compare: "+before);
	    
	    /*
	     * compareTo는 문자에서도 가능!
	     * But!!같으면 0, 좌항이 작으면 -1, 좌항이 크면 +1 반환
	     */
	    Integer v = 5;//꼭 Integer로
	    System.out.println(v.compareTo(2));//1
	    /*
	     * compare
	     * 같으면 0, 좌항이 작으면 -1, 좌항이 크면 +1 반환
	     */
	    System.out.println("======================");
	    System.out.println("Integer.compare");
	    int t = 5;
	    System.out.println(Integer.compare(5, 8));//-1
	    
	    /*
	     * String concat(String str) :문자열을 뒤에 덧붙임
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
	     * 지정된 문자열s가 포함되었는지 검사
	     */
	    System.out.println("======================");
	    System.out.println("contains");
	    String co = "con";
	    System.out.println(s.contains(co));//true
	    System.out.println(co.contains(s));//false
	    
	    /*
	     * boolean endsWith(String suffix)
	     * :지정된 문자열(suffix)로 끝나는지 검사
	     */
	    System.out.println("======================");
	    System.out.println("endsWith");
	    System.out.println(s.endsWith(co));//false
	    System.out.println(s.endsWith("lo"));//true
	    
	    /*
	     * 대소문자 구분없이 비교
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
	     * 매개변수 타입이 int인 이유
	     * : 아스키코드로 처리하기 위해서
	     * ==주어진 문자 ch가 문자열에 존재하는지 확인하여 위치를 반환
	     * -못찾으면 -1 반환
	     */
	    System.out.println("======================");
	    System.out.println("indexOf(문자형)");
	    System.out.println("문자 ch가 가장 "
	    		+ "먼저 나오는 위치를 반환");
	    String ex = "Alexander";
	    int idx = ex.indexOf('a');
	    System.out.println("index of a: "+idx);//0
	    idx = ex.indexOf('b');
	    System.out.println("index of b: "+idx);//-1
	    
	    /*
	     * int indexOf(String str)
	     * ==주어진 문자열이 존재하는지 확인하여 그 위치
	     * (주어진 문자열의 첫번째 문자의 위치)를 반환
	     * -없으면 -1 반환
	     */
	    System.out.println("======================");
	    System.out.println("indexOf(문자열)");
	    idx = ex.indexOf("der");
	    System.out.println("index of \"der\": "+idx);
	    
	    idx = ex.indexOf("zer");
	    System.out.println("index of \"zer\": "+idx);//-1
	    
	    /**
	     * int indexOf(int ch, int pos)
	     * : 주어진 문자 ch가 문자열에 존재하는지 지정 위치인 pos부터 확인
	     * 못찾으면 -1 반환
	     */
	    System.out.println("======================");
	    System.out.println("indexOf(문자형, 지정시작위치)");
	    idx = ex.indexOf('d',ex.length() - 2);// -1
	    System.out.println("뒤에서 두번째 위치에서부터 d를 찾기 indexOf(char, startpos): "+
	    					idx);
	    idx = ex.indexOf('d',ex.length() - 3);// 6
	    System.out.println("뒤에서 세번째 위치에서부터 d를 찾기 indexOf(char, startpos): "+
	    					idx);
	    
	    /**
	     * int indexOf(String str, int pos)
	     * : 주어진 문자열이 문자열에 존재하는지 지정 위치인 pos부터 확인(찾고자 하는 문자열의 첫
	     * 못찾으면 -1 반환
	     */
	    System.out.println("======================");
	    System.out.println("indexOf(문자열, 지정시작위치)");
	    idx = ex.indexOf("der",ex.length()-3);
	    System.out.println("뒤에서 두번째 위치에서부터 der를 찾기 indexOf(str, startpos): "+
				idx);//6
	    idx = ex.indexOf("der",ex.length()-2);//-1
	    System.out.println("뒤에서 두번째 위치에서부터 der를 찾기 indexOf(str, startpos): "+
				idx);
	    /**
	     * String intern()
	     * :
	     * 문자열 리터럴을 상수풀(constant pool)에 등록
	     * 이미 상수풀에 같은 내용의 문자열이 있는 경우, 그 문자열의 주소값을 반환!
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
	    		System.identityHashCode(ss));//hashCode는 string내의 오버라이딩
	    //때문에 같은값으로 나올 것
	    System.out.println("String st = ex.intern(): "+
    			st+", hashCode: "+st.hashCode()+", identity: "+
    		System.identityHashCode(st));
	    System.out.println("b1: "+b1+", b2: "+b2+", b3: "+b3);

	    /**
	     * int lastIndexOf(int ch)
	     * :지정된 문자나 문자코드를 문자열의 오른쪽 끝부터 찾아서 위치를 알려주기
	     * 못찾으면 -1 반환
	     */
	    System.out.println("======================");
	    System.out.println("lastIndexOf(int ch)");
	    idx = ex.lastIndexOf('r');//끝에서부터 찾기 때문에 여러번 등장한다면
	    //해당문자의 가장 마지막 등장 인덱스 값을 반환할것 //8
	    System.out.println("lastIndexOf: "+idx);
	    
	    idx = ex.lastIndexOf('0');//-1
	    System.out.println("lastIndexOf: "+idx);
	    
	    /**
	     * int lastIndexOf(String str)
	     * :지정된 문자열을 문자열의 오른쪽 끝부터 찾아서 위치를 알려주기
	     * 못찾으면 -1 반환
	     */
	    System.out.println("======================");
	    System.out.println("lastIndexOf(String str)");
	    String nn = "derder";
	    idx = nn.lastIndexOf("der");//끝에서부터 찾기 때문에 여러번 등장한다면
	    //해당문자의 가장 마지막 등장 인덱스 값을 반환할것 //3
	    System.out.println("lastIndexOf: "+idx);//3
	    
	    idx = ex.lastIndexOf(String.valueOf('\u0000'));//-1(자바는 끝에 null문자를 넣지 않음!)
	    System.out.println("lastIndexOf: "+idx);
	    
	    /**
	     * int lastIndexOf(int ch, int fromIdx)
	     * :지정된 문자나 문자코드를 fromIdx부터 0(처음인덱스)까지 찾아보고  위치를 알려주기
	     * 못찾으면 -1 반환
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
	     * :지정된 문자열을 fromIdx부터 0(처음인덱스)까지 찾아보고  위치를 알려주기
	     * 못찾으면 -1 반환
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
	     * -문자열 중 문자 하나(old)를 새로운 문자(nw)로 바꾼 문자열을 반환함
	     */
	    System.out.println("======================");
	    System.out.println("String replace(char old, char nw)");
	    String pr = ex.replace('e', 'i'); //값이 다르기 때문에 해시코드가 다름!
	    System.out.println("ex: "+ex+", hashCode: "+ex.hashCode()+","
	    		+ " identity: "+System.identityHashCode(ex));
	    System.out.println("pr: "+pr+", hashCode: "+pr.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pr));
	    
	    /**
	     * String replace(CharSequence old, CharSequence nw)
	     * : 문자열 중 문자열 old를 문자열 nw로 모두 바꾼 문자열을 반환함
	     */
	    System.out.println("======================");
	    System.out.println("String replace(CharSequence old, CharSequence nw)");
	    pr = ex.replace("der", "zer"); //값이 다르기 때문에 해시코드가 다름!
	    System.out.println("ex: "+ex+", hashCode: "+ex.hashCode()+","
	    		+ " identity: "+System.identityHashCode(ex));
	    System.out.println("pr: "+pr+", hashCode: "+pr.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pr));
	    
	    /**
	     * String replaceAll(String regex, String replacement)
	     * : 문자열 중 지정된 문자열과 일치하는 것을 새로운 문자열로 모두 변경
	     * : replace와 달리 string이 들어감!(replace는 charsequence를
	     * 구현한 모든 형태에 먹힘)
	     * https://djusti.tistory.com/8
	     */
	    System.out.println("======================");
	    System.out.println("String replaceAll(String regex, String replacement)");
	    String pp = "dddddddaa";
	    pr = pp.replaceAll("dd", "zer"); //값이 다르기 때문에 해시코드가 다름!
	    System.out.println("pp: "+pp+", hashCode: "+pp.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pp));
	    System.out.println("pr: "+pr+", hashCode: "+pr.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pr));
	    
	    /**
	     * String replaceFirst(String regex, String replacement)
	     * : 문자열 중 지정된 문자열(regex)과 일치하는 것 중, 첫 번째 것만
	     * 새로운 문자열(replacement)로 변경
	     */
	    System.out.println("======================");
	    System.out.println("String replaceFirst(String regex, String replacement)");
	    pr = pp.replaceFirst("dd", "zer"); //값이 다르기 때문에 해시코드가 다름!
	    System.out.println("pp: "+pp+", hashCode: "+pp.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pp));
	    System.out.println("pr: "+pr+", hashCode: "+pr.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pr));//zerdddddaa
	    
	    /**
	     * String[] split(String regex)
	     * : 문자열을 지정된 분리자로 나누어 문자열 배열에 담아서 반환
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
	     * : 문자열을 분리자(regex)로 나누어 문자열 배열에 담아 반환
	     * : 단, 문자열 전체를 지정된 수(limit)로 자름
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
	     * 주어진 시작 위치부터 end-1인덱스까지의 문자열을 잘라내어 반환
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
	     * String toLowerCase() : 소문자로 변환!
	     * String toUpperCase() : 대문자로 변환!
	     * -꼭 영문자가 아닌 것이 섞여있어도 상관없음! 영문자만 변환!
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
	    String mixedType = "123ex가나다";
	    String pt = mixedType.toUpperCase();
	    System.out.println("pt: "+pt+", hashCode: "+pt.hashCode()+","
	    		+ " identity: "+System.identityHashCode(pt));
	    
	    /**
	     * String trim() : 문자열의 왼쪽 끝과 오른쪽 끝에 있는 공백을 없앤 결과 반환
	     * (문자열 중간의 공백은 제거되지 않음)
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
	     * -->toString을 호출하기 때문에 똑같이 static!
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
	    
	    Object obj = String.valueOf(bbb);//그냥 valueOf를 쓰면, 클래스 내에 
	    //해당 메서드를 만들지 않았기에, 구분을 String으로 클래스메서드 특성을 살려 사용해주기
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
