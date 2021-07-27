package interface_polymorphism;

public class ParserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parseable p=ParserManager.getParser("XML");
		p.parse("document.xml");
		Parseable p1=ParserManager.getParser("HTML");
		p1.parse("document.html");
	}

}
