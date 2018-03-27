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
		this.setTitle("绘图实例2");//设置窗体标题
		
		Image iconImage = null;
        try {
            iconImage = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/pic/mouse.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		Cursor cur=Toolkit.getDefaultToolkit().createCustomCursor(iconImage,new java.awt.Point(17,17), "stick");
		this.setCursor(cur);
		//给图像面板添加鼠标点击事件
		this.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent event) {
				//每次在跳动之前，需要点击球柱的起跳点，也就是中心点
				/*if(isFirst){
					prePoint.x = event.getX();
					prePoint.y = event.getY();
					isFirst = false;
					return;
				}
				curPoint.x = event.getX();
				curPoint.y = event.getY();
				//使用勾股定理计算跳跃的距离
				int distance = Utils.calDistance(prePoint, curPoint);
				//这个定值是需要手动调解出来的，每个手机尺寸或许不一样，需要自己手动调节
				int time = (int)(distance/0.37);
				Utils.jump(time);
				System.out.println("distance:"+distance+",time:"+time);
				//这里的时间是为了等待截图绘制图片到面板中，时间也是需要自己设定，不然图像绘制会出现错乱
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//为了下一次能够点击起跳点
				isFirst = true;
				//跳完了，就开始刷新面板，获取最新的手机屏幕信息
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
				clickPoint.y=event.getYOnScreen();//得到的在屏幕上的点击位置
				//click_.x=event.getX();
				//click_.y=event.getY();//得到的相对于jframe上的点击位置
				//System.out.println("click_>>>----x="+click_.x+",y="+click_.y);
				//使用勾股定理计算跳跃的距离
				if(isFirst){//第一次进入游戏。没有上一个点
					
					startPoint.x=clickPoint.x;
					startPoint.y=clickPoint.y;
					startPoint.showPosition("游戏开始》startPoint");
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
            g.drawOval(10, 10, OVAL_WIDTH, OVAL_HEIGHT);//绘制第1个圆形
           
            
        }
    }

}

