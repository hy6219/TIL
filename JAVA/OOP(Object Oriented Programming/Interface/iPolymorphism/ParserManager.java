package interface_polymorphism;

public class ParserManager{

	public static Parseable getParser(String type)
	{
		//� Ÿ������ ��ȯ����
		if(type.contentEquals("XML"))
		{
			return new XMLParser();
		}
		else
		{
			//Polymorphism of interface
			/*
			 * Class a implements (interface) b
			 * -->a: child, b: parent
			 * ==>b obj=new a();
			 */
			Parseable p=new HTMLParser();
			return p;
		}
	}

}
