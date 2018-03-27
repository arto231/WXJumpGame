package cn.wjdiankong.wxjump;

public class cal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point p1=new Point();
		Point p2=new Point();
		p1.x=166;
		p1.y=534;
		p2.x=373;
		p2.y=581;
		int distance=Utils.calDistance(p1, p2);
		System.out.println(800.0/distance);
		

	}

}
