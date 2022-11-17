package com.founder.rhip.portal.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

public class RandomValidateCodeUtil {
	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";//放到session中的key
    private Random random = new Random();
    private String randString = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZ";//随机产生的字符串
    private char mapTable[]={
    		   'a','b','c','d','e','f',
    		   'g','h','i','j','k','l',
    		   'm','n','o','p','q','r',
    		   's','t','u','v','w','x',
    		   'y','z','0','1','2','3',
    		   '4','5','6','7','8','9'
    		 };
    private int width = 85;//图片宽
    private int height = 20;//图片高
    private int lineSize = 40;//干扰线数量
    private int stringNum = 4;//随机产生字符数量
    /*
     * 获得字体
     */
    private Font getFont(){
        return new Font("Fixedsys",Font.CENTER_BASELINE,18);
    }
    /*
     * 获得颜色
     */
    private Color getRandColor(int fc,int bc){
        if(fc > 255)
            fc = 255;
        if(bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc-fc-16);
        int g = fc + random.nextInt(bc-fc-14);
        int b = fc + random.nextInt(bc-fc-18);
        return new Color(r,g,b);
    }
    /**
     * 生成随机图片
     */
    public void getRandcode(HttpServletRequest request,
            HttpServletResponse response) {
        HttpSession session = request.getSession();
        //BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();//产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,18));
        g.setColor(getRandColor(110, 133));
        //绘制干扰线
        for(int i=0;i<=lineSize;i++){
            drowLine(g);
        }
        //绘制随机字符
        String randomString = "";
        for(int i=1;i<=stringNum;i++){
            randomString=drowString(g,randomString,i);
        }
        session.removeAttribute(RANDOMCODEKEY);
        session.setAttribute(RANDOMCODEKEY, randomString);
        g.dispose();
        try {
        	OutputStream os=response.getOutputStream();
            ImageIO.write(image, "JPEG", os);//将内存中的图片通过流动形式输出到客户端
            os.flush();  
            os.close();
            os=null;
        } catch (Exception e) {
        	System.out.println("getWriter和getOutputStream不能同时使用!!!");
//            e.printStackTrace();
        }
    }
    /*
     * 绘制字符串
     */
    private String drowString(Graphics g,String randomString,int i){
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101),random.nextInt(111),random.nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(randString.length())));
        randomString +=rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13*i, 16);
        return randomString;
    }
    /*
     * 绘制干扰线
     */
    private void drowLine(Graphics g){
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x+xl, y+yl);
    }
    /*
     * 获取随机的字符
     */
    public String getRandomString(int num){
        return String.valueOf(randString.charAt(num));
    }
    
    public String getCertPic(int width,int height,OutputStream os){
    	  if(width<=0)
    	   width=60;
    	  if(height<=0)
    	   height=20;
    	  BufferedImage image= new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    	  //获取图形上下文
    	  Graphics g = image.getGraphics();
    	  //设定背景颜色
    	  g.setColor(new Color(0xDCDCDC));
    	  g.fillRect(0,0,width,height);
    	  //画边框
    	  g.setColor(Color.black);
    	  g.drawRect(0,0,width-1,height-1);
    	  //随机产生的验证码
    	  String strEnsure = "";
    	  //4代表4为验证码，如果要产生更多位的验证码，则加大数值
    	  for(int i = 0;i<4;++i){
    	   strEnsure += mapTable[(int) (mapTable.length*Math.random())];
    	  }
    	  //将认证码显示到图像中，如果要生成更多位的验证码，增加drawString语句
    	  g.setColor(Color.black);
    	  g.setFont(new Font("Atlantic Inline",Font.PLAIN,18));
    	  String str = strEnsure.substring(0,1);
    	  g.drawString(str,8,17);
    	  str = strEnsure.substring(1,2);
    	  g.drawString(str, 20, 15);
    	  str = strEnsure.substring(2,3);
    	  g.drawString(str, 35, 18);
    	  str = strEnsure.substring(3,4);
    	  g.drawString(str, 45, 15);
    	  //随机产生15个干扰点
    	  Random rand = new Random();
    	  for(int i=0; i<10; i++){
    	   int x = rand.nextInt(width);
    	   int y = rand.nextInt(height);
    	   g.drawOval(x,y,1,1);
    	  }
    	  //释放图形上下文
    	  g.dispose();
    	  try{
    	   //输出图形到页面
    	   ImageIO.write(image, "JPEG", os);
    	  }catch (Exception e){
    	   return "";
    	  }
    	  return strEnsure;
    }
}
