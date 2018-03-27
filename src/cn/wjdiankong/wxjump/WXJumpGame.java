package cn.wjdiankong.wxjump;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WXJumpGame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//private PhoneImagePanel phoneImgPanel = null;
	private boolean isFirst = true;
	
	Point startPoint=new Point();
	Point endPoint=new Point();
	Point clickPoint=new Point(); 
	
	

	public WXJumpGame(){
		
		this.setUndecorated(true);
		this.setOpacity(0.3f);
		this.setSize(960, 960);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setContentPane(new DrawPanel());
		this.setTitle("��ͼʵ��2");//���ô������
		
		Image iconImage = null;
        try {
            iconImage = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/pic/mouse.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		Cursor cur=Toolkit.getDefaultToolkit().createCustomCursor(iconImage,new java.awt.Point(17,17), "stick");
		this.setCursor(cur);
		//��ͼ��������������¼�
		this.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent event) {
				//ÿ��������֮ǰ����Ҫ��������������㣬Ҳ�������ĵ�
				/*if(isFirst){
					prePoint.x = event.getX();
					prePoint.y = event.getY();
					isFirst = false;
					return;
				}
				curPoint.x = event.getX();
				curPoint.y = event.getY();
				//ʹ�ù��ɶ��������Ծ�ľ���
				int distance = Utils.calDistance(prePoint, curPoint);
				//�����ֵ����Ҫ�ֶ���������ģ�ÿ���ֻ��ߴ����һ������Ҫ�Լ��ֶ�����
				int time = (int)(distance/0.37);
				Utils.jump(time);
				System.out.println("distance:"+distance+",time:"+time);
				//�����ʱ����Ϊ�˵ȴ���ͼ����ͼƬ������У�ʱ��Ҳ����Ҫ�Լ��趨����Ȼͼ����ƻ���ִ���
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//Ϊ����һ���ܹ����������
				isFirst = true;
				//�����ˣ��Ϳ�ʼˢ����壬��ȡ���µ��ֻ���Ļ��Ϣ
				phoneImgPanel.validate();
				phoneImgPanel.repaint();*/
			}
			
			@Override
			public void mouseReleased(MouseEvent event) {
			}
			
			@Override
			public void mouseExited(MouseEvent event) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent event) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent event) {
				clickPoint.x=event.getXOnScreen();
				clickPoint.y=event.getYOnScreen();//�õ�������Ļ�ϵĵ��λ��
				//click_.x=event.getX();
				//click_.y=event.getY();//�õ��������jframe�ϵĵ��λ��
				//System.out.println("click_>>>----x="+click_.x+",y="+click_.y);
				//ʹ�ù��ɶ��������Ծ�ľ���
				if(isFirst){//��һ�ν�����Ϸ��û����һ����
					
					startPoint.x=clickPoint.x;
					startPoint.y=clickPoint.y;
					startPoint.showPosition("��Ϸ��ʼ��startPoint");
					isFirst=false;
					return;
				}
				
				endPoint.x=clickPoint.x;
				endPoint.y=clickPoint.y;
				
				endPoint.showPosition("endPoint");
				int distance = Utils.calDistance(startPoint, endPoint);
				System.out.println("click distance= "+distance);
				Utils.jump((int)(distance*3.59421));
				isFirst=true;
				/*startPoint.x=endPoint.x;
				startPoint.y=endPoint.y;*/
				
				
			}
		});
	}

	public static void main(String[] args){
		new WXJumpGame();
	}
	class DrawPanel extends JPanel{
		private int OVAL_WIDTH=80;
		private int OVAL_HEIGHT=80;
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2d=(Graphics2D)g;
            g.drawOval(10, 10, OVAL_WIDTH, OVAL_HEIGHT);//���Ƶ�1��Բ��
           
            
        }
    }

}

