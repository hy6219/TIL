package interface_partial_change;

public class Factory extends Building implements Liftable{

	//���뼺�� ���̱� ���Ͽ� Liftable�� ������ Ŭ������ ���Խ��Ѽ� �̿��ϱ�!
		Lift l=new Lift();
		@Override
		public void liftOff() {
			// TODO Auto-generated method stub
			l.liftOff();
		}

		@Override
		public Building move(int x, int y) {
			// TODO Auto-generated method stub
			Building r=l.move(x, y);
			return r;
		}

		@Override
		public void stop() {
			// TODO Auto-generated method stub
			l.stop();
		}

		@Override
		public void land() {
			// TODO Auto-generated method stub
			l.land();
		}
		
		public void fa()
		{
			System.out.println(new Factory().getClass().getSimpleName());
		}
}
