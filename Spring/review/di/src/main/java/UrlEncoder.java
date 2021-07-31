import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

//추상화의 영향으로 상속을 받게끔 해주기
public class UrlEncoder implements IEncoder{
    @Override
    public String encode(String message){
        try {
            return URLEncoder.encode(message,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
