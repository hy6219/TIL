package interface_polymorphism;

public class HTMLParser implements Parseable{

	@Override
	public void parse(String fileName) {
		// TODO Auto-generated method stub
		System.out.println(fileName+"-HTML parsing completed");
	}

}
