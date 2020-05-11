package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import work.insertinfo;


public class login extends JFrame{
       private JFrame frame;
       private JPanel pInput;
	public void publicinfo(String useType) {
		//窗口属性
		frame=new JFrame();
		frame.setTitle("用户基本信息填写");
		frame.setSize(800,600);	
		frame.setLayout(null);//组件全局化
		frame.setResizable(false);//因为解决不了面板不随窗口动态变化大小，所以禁止了窗口变化大小
		frame.setLocationRelativeTo(getOwner());//将屏幕显示在屏幕中心
		//*****************************************************
		
		if(useType.equals("Teacher")) {pInput=teacher();}
		if(useType.equals("Student")) {pInput=student();}
		frame.add(pInput);
		frame.setVisible(true);
}
	//教师注册
	public JPanel teacher() {
		       
				//*****************************************************
		        //面板属性
			    pInput = new JPanel();	
				pInput.setBounds(0, 0, 800, 600);//设置组件位置	
				pInput.setLayout(null);//全局化
				        JLabel Text = new JLabel("教师用户注册");
				        Text.setFont(new Font("宋体",0,30));
				        Text.setBounds(300, 50, 350, 30);
				        pInput.add(Text);
				       // 创建账号与账号输入框
						JLabel NumLable = new JLabel("账号：");
						NumLable.setBounds(100, 140, 65, 30);
						JTextField NumTextField = new JTextField();
						NumTextField.setBounds(140, 140, 120, 30);
						
						//创建密码与密码输入框
						JLabel pw = new JLabel("密码：");
						pw.setBounds(300, 140 ,65, 30);
						JTextField pwTextField = new JTextField();
						pwTextField.setBounds(340, 140, 120, 30);
						
						// 创建姓名与姓名输入框
						JLabel NameLable = new JLabel("姓名：");
						NameLable.setBounds(100, 220, 65, 30);
						JTextField NameTextField = new JTextField();
						NameTextField.setBounds(140, 220, 120, 30);
						
						//创建性别选择框
						JLabel SexLable = new JLabel("性别：");
						SexLable.setBounds(300, 220, 65, 30);
						//创建组合框数据容器
						DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
						ComboBoxModel.addElement("男");
						ComboBoxModel.addElement("女");
						JComboBox<Object> ComboBoxlist = new JComboBox<>(ComboBoxModel);
						ComboBoxlist.setBounds(340, 220, 120, 30);
						
						
						// 创建学校与学校输入框
						JLabel school = new JLabel("学校：");
						school.setBounds(500, 220, 65, 30);
						JTextField schoolTextField = new JTextField();
						schoolTextField.setBounds(540, 220, 120, 30);
						
						//创建联系方式与联系方式的输入框
						JLabel phone = new JLabel("联系方式：");
						phone.setBounds(100, 300, 65, 30);
						JTextField phoneTextField = new JTextField();
						phoneTextField.setBounds(160, 300, 120, 30);
				
				       //创建任课科目名与任课科目名输入框
				       JLabel subject = new JLabel("任课科目类:");
				       subject.setBounds(300, 300, 75, 30);
				       
				     //创建任课科目名容器
				   		JComboBox<String> subject_box=new JComboBox<>();
				   		subject_box.addItem("声乐类");
				   		subject_box.addItem("乐器类");
				   		subject_box.addItem("计算机类");
				   		subject_box.addItem("舞蹈类");
				   		subject_box.addItem("棋类");
				   		subject_box.addItem("武术类");
				   		subject_box.addItem("书画类");
				   		subject_box.addItem("电子竞技");
				   		subject_box.setBounds(370, 300, 120, 30);
								
				//创建确认注册按钮
				JButton ensure=new JButton("确认注册");
				ensure.setBounds(300, 400, 100, 20);
				ensure.addActionListener(new ActionListener() {					
					public void actionPerformed(ActionEvent e) {
						
					if(checkEmpty(frame,NumTextField,"账号")) {
						if(checkEmpty(frame,pwTextField,"密码")) {
						   insertinfo t=new insertinfo();
						   //返回值为true时为注册成功，则关闭当前窗口并打开登录界面
						  if(t.net_ter_info(frame,NumTextField.getText(),pwTextField.getText(),
								NameTextField.getText(), (String)ComboBoxlist.getSelectedItem().toString(),schoolTextField.getText(),
								phoneTextField.getText(),subject_box.getSelectedItem().toString())) {
							  frame.dispose();
							  					
						}}}
					}});
				//创建返回按钮
				JButton GoBack=new JButton("返回");
				GoBack.setBounds(450, 400, 100, 20);
				GoBack.addActionListener(new ActionListener() {					
					public void actionPerformed(ActionEvent e) {
						landing land=new landing();
						frame.dispose();
					}
			    
				});
				
				pInput.add(NumLable);
				pInput.add(NumTextField);
				pInput.add(pw);
				pInput.add(pwTextField);
				pInput.add(NameLable);
				pInput.add(NameTextField);
				pInput.add(SexLable);
				pInput.add(ComboBoxlist);
				pInput.add(school);
				pInput.add(schoolTextField);
				pInput.add(phoneTextField);
				pInput.add(phone);
				pInput.add(phoneTextField);
				pInput.add(subject);
				pInput.add(subject_box);
				pInput.add(GoBack);
				pInput.add(ensure);
				return pInput;
				
	}

	//学生注册
	public JPanel student() {
		//*****************************************************
        //面板属性
	    pInput = new JPanel();	
		pInput.setBounds(0, 0, 800, 600);//设置组件位置	
		pInput.setLayout(null);//全局化
		 JLabel Text = new JLabel("学生用户注册");
	        Text.setFont(new Font("宋体",0,30));
	        Text.setBounds(300, 50, 350, 30);
	        pInput.add(Text);
	       // 创建账号与账号输入框
			JLabel NumLable = new JLabel("账号：");
			NumLable.setBounds(100, 140, 65, 30);
			JTextField NumTextField = new JTextField();
			NumTextField.setBounds(140, 140, 120, 30);
			
			//创建密码与密码输入框
			JLabel pw = new JLabel("密码：");
			pw.setBounds(300, 140 ,65, 30);
			JTextField pwTextField = new JTextField();
			pwTextField.setBounds(340, 140, 120, 30);
			
			// 创建姓名与姓名输入框
			JLabel NameLable = new JLabel("姓名：");
			NameLable.setBounds(100, 220, 65, 30);
			JTextField NameTextField = new JTextField();
			NameTextField.setBounds(140, 220, 120, 30);
			
			//创建性别选择框
			JLabel SexLable = new JLabel("性别：");
			SexLable.setBounds(300, 220, 65, 30);
			//创建组合框数据容器
			DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
			ComboBoxModel.addElement("男");
			ComboBoxModel.addElement("女");
			JComboBox<Object> ComboBoxlist = new JComboBox<>(ComboBoxModel);
			ComboBoxlist.setBounds(340, 220, 120, 30);
			
			
			// 创建学校与学校输入框
			JLabel school = new JLabel("学校：");
			school.setBounds(500, 220, 65, 30);
			JTextField schoolTextField = new JTextField();
			schoolTextField.setBounds(540, 220, 120, 30);
			
			//创建联系方式与联系方式的输入框
			JLabel phone = new JLabel("联系方式：");
			phone.setBounds(100, 300, 65, 30);
			JTextField phoneTextField = new JTextField();
			phoneTextField.setBounds(160, 300, 120, 30);
		
		
		//创建专业与专业名输入框
		JLabel subject = new JLabel("专业：");
		subject.setBounds(300, 300, 65, 30);
		JTextField subjectTextField = new JTextField();//
		subjectTextField.setBounds(340, 300, 120, 30);
		//创建班级与班级输入框
		JLabel classes = new JLabel("班级：");
		classes.setBounds(500, 300, 65, 30);
		JTextField classTextField = new JTextField();
		classTextField.setBounds(540, 300, 120, 30);
		
		//创建入学日期与入学日期输入框
		JLabel date = new JLabel("入学日期：");
		date.setBounds(100, 380, 75, 30);
		JTextField dateTextField = new JTextField();
		dateTextField.setBounds(160, 380, 120, 30);
		//创建确认注册按钮
		JButton ensure=new JButton("确认注册");
		ensure.setBounds(280, 450, 100, 20);
		ensure.addActionListener(new ActionListener() {					
			public void actionPerformed(ActionEvent e) {
				if(checkEmpty(frame,NumTextField,"账号")) {
					if(checkEmpty(frame,pwTextField,"密码")) {
				     insertinfo t=new insertinfo();
				     //返回值为true时关闭当前窗口并打开登录界面
				     if(t.net_stu_info(frame,NumTextField.getText(),pwTextField.getText(),
						NameTextField.getText(),ComboBoxlist.getSelectedItem().toString(),schoolTextField.getText(),phoneTextField.getText(),
						subjectTextField.getText(),classTextField.getText(),dateTextField.getText())) {
					landing land=new landing();
					frame.dispose();			
				}
			}}}
	    
		});
		
		//创建返回按钮
		JButton GoBack=new JButton("返回");
		GoBack.setBounds(430, 450, 100, 20);
		GoBack.addActionListener(new ActionListener() {					
			public void actionPerformed(ActionEvent e) {
				landing land=new landing();
				frame.dispose();
			}
	    
		});
		
		pInput.add(NumLable);
		pInput.add(NumTextField);
		pInput.add(pw);
		pInput.add(pwTextField);
		pInput.add(NameLable);
		pInput.add(NameTextField);
		pInput.add(SexLable);
		pInput.add(ComboBoxlist);
		pInput.add(school);
		pInput.add(schoolTextField);
		pInput.add(phoneTextField);
		pInput.add(phone);
		pInput.add(phoneTextField);
		pInput.add(subject);
		pInput.add(subjectTextField);
		pInput.add(classes);
		pInput.add(classTextField);
		pInput.add(date);
		pInput.add(dateTextField);
		pInput.add(ensure);
		pInput.add(GoBack);
		return pInput;
}
    //判空信息
	private  boolean checkEmpty(JFrame frame,JTextField tf, String msg) {

		String value = tf.getText();
		if(value.length()==0){
		JOptionPane.showMessageDialog(frame, msg + " 不能为空");
		tf.grabFocus();
		return false;
		}
		return true;
}	
}
