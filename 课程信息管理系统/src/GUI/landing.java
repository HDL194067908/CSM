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
	frame.setTitle("��¼����"); //���ô������Ͻ�����
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	frame.setLayout(new BorderLayout());//���ȫ�ֻ�
	frame.setResizable(false);//��Ϊ���������岻�洰�ڶ�̬�仯��С�����Խ�ֹ�˴��ڱ仯��С
	frame.setLocationRelativeTo(getOwner());//����Ļ��ʾ����Ļ����
	//***********************************************************

	JPanel pInput = new JPanel();		
	pInput.setLayout(null);//ȫ�ֻ�
	pInput.setBounds(1, 1, 75, 90);//�������λ��
	
	JLabel Text=new JLabel("�γ���Ϣ����ϵͳ");
	Text.setBounds(260, 100, 600, 50);
	Text.setFont(new Font("����",0,30));
	pInput.add(Text);
	
	JLabel user = new JLabel("�û�����");//�ı�����
	JTextField userText = new JTextField();//�ı���������	
	user.setBounds(220, 200, 65, 30);
	userText.setBounds(270, 200, 250, 30);
	
	JLabel pw = new JLabel("��    �룺");
	JPasswordField pwText = new JPasswordField();
	pw.setBounds(220, 250, 65, 30);
	pwText.setBounds(270, 250, 250, 30);
	pInput.add(user);//���ı�/���ı���������ӵ����
	pInput.add(userText);
	pInput.add(pw);
	pInput.add(pwText);
	//***********************************************************	
	ButtonGroup group = new ButtonGroup();
	JRadioButton TeacherButton = new JRadioButton("��ʦ", true);
	group.add(TeacherButton);
	JRadioButton studentButton = new JRadioButton("ѧ��", false);
	group.add(studentButton);
	TeacherButton.setBounds(220, 300, 65, 30);
	studentButton.setBounds(300, 300, 65, 30);
	pInput.add(TeacherButton);
	pInput.add(studentButton);
	//***********************************************************
	JButton ensure=new JButton("��¼");
	JButton login=new JButton("ע��");
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
