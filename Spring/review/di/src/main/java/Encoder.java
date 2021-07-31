public class Encoder {
    //다형성 적용
    private IEncoder iEncoder;
    //외부에서 사용할 객체를 주입해줄 수 있도록
    //public Encoder(IEncoder iEncoder)
    public Encoder(IEncoder iEncoder){
        this.iEncoder=iEncoder;
        /*
        * public Encoder(){
        *  this.iEncoder=new Base64Encoder();
        * }
        * 처럼 작성하게 되면, 인코더 종류가 바뀔때마다 생성자 부분을 수정해주어야 하는
        * 본질의 클래스 변경과 함께 비효율성을 건드리게 됨!
        *
        * */
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
