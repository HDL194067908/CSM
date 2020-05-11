package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import work.queryInfo;

public class landing {
	JFrame frame=new JFrame();	
	landing(){
	frame.setSize(800,600);	
	frame.setTitle("登录界面"); //设置窗口左上角命名
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	frame.setLayout(new BorderLayout());//组件全局化
	frame.setResizable(false);//因为解决不了面板不随窗口动态变化大小，所以禁止了窗口变化大小
	frame.setLocationRelativeTo(getOwner());//将屏幕显示在屏幕中心
	//***********************************************************

	JPanel pInput = new JPanel();		
	pInput.setLayout(null);//全局化
	pInput.setBounds(1, 1, 75, 90);//设置组件位置
	
	JLabel Text=new JLabel("课程信息管理系统");
	Text.setBounds(260, 100, 600, 50);
	Text.setFont(new Font("宋体",0,30));
	pInput.add(Text);
	
	JLabel user = new JLabel("用户名：");//文本区域
	JTextField userText = new JTextField();//文本输入区域	
	user.setBounds(220, 200, 65, 30);
	userText.setBounds(270, 200, 250, 30);
	
	JLabel pw = new JLabel("密    码：");
	JPasswordField pwText = new JPasswordField();
	pw.setBounds(220, 250, 65, 30);
	pwText.setBounds(270, 250, 250, 30);
	pInput.add(user);//将文本/及文本输入域添加到组件
	pInput.add(userText);
	pInput.add(pw);
	pInput.add(pwText);
	//***********************************************************	
	ButtonGroup group = new ButtonGroup();
	JRadioButton TeacherButton = new JRadioButton("教师", true);
	group.add(TeacherButton);
	JRadioButton studentButton = new JRadioButton("学生", false);
	group.add(studentButton);
	TeacherButton.setBounds(220, 300, 65, 30);
	studentButton.setBounds(300, 300, 65, 30);
	pInput.add(TeacherButton);
	pInput.add(studentButton);
	//***********************************************************
	JButton ensure=new JButton("登录");
	JButton login=new JButton("注册");
	ensure.setBounds(280, 360, 80, 20);
	login.setBounds(380,360,80,20);
	
	ensure.addActionListener(new ActionListener() {					
		public void actionPerformed(ActionEvent e) {
			String userType = null;
			if(TeacherButton.isSelected()){
				userType="Teacher";
			}
			if(studentButton.isSelected()){
				userType="Student";
			}
			queryInfo Verification=new queryInfo();
			Verification.landinfo(frame,userType,userText,pwText);
			
		}   
	});
	login.addActionListener(new ActionListener() {					
		public void actionPerformed(ActionEvent e) {
			String userType = null;
			if(TeacherButton.isSelected()){
				userType="Teacher";
			}
			if(studentButton.isSelected()){
				userType="Student";
			}
			login in=new login();
			in.publicinfo(userType);
			frame.dispose();
			}
	});
	
	//***********************************************************
	pInput.add(ensure);
	pInput.add(login);
	frame.add(pInput);
	frame.setVisible(true);}
	private Component getOwner() {
		return null;
	}
}
