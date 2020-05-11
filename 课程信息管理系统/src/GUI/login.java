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
		//��������
		frame=new JFrame();
		frame.setTitle("�û�������Ϣ��д");
		frame.setSize(800,600);	
		frame.setLayout(null);//���ȫ�ֻ�
		frame.setResizable(false);//��Ϊ���������岻�洰�ڶ�̬�仯��С�����Խ�ֹ�˴��ڱ仯��С
		frame.setLocationRelativeTo(getOwner());//����Ļ��ʾ����Ļ����
		//*****************************************************
		
		if(useType.equals("Teacher")) {pInput=teacher();}
		if(useType.equals("Student")) {pInput=student();}
		frame.add(pInput);
		frame.setVisible(true);
}
	//��ʦע��
	public JPanel teacher() {
		       
				//*****************************************************
		        //�������
			    pInput = new JPanel();	
				pInput.setBounds(0, 0, 800, 600);//�������λ��	
				pInput.setLayout(null);//ȫ�ֻ�
				        JLabel Text = new JLabel("��ʦ�û�ע��");
				        Text.setFont(new Font("����",0,30));
				        Text.setBounds(300, 50, 350, 30);
				        pInput.add(Text);
				       // �����˺����˺������
						JLabel NumLable = new JLabel("�˺ţ�");
						NumLable.setBounds(100, 140, 65, 30);
						JTextField NumTextField = new JTextField();
						NumTextField.setBounds(140, 140, 120, 30);
						
						//�������������������
						JLabel pw = new JLabel("���룺");
						pw.setBounds(300, 140 ,65, 30);
						JTextField pwTextField = new JTextField();
						pwTextField.setBounds(340, 140, 120, 30);
						
						// �������������������
						JLabel NameLable = new JLabel("������");
						NameLable.setBounds(100, 220, 65, 30);
						JTextField NameTextField = new JTextField();
						NameTextField.setBounds(140, 220, 120, 30);
						
						//�����Ա�ѡ���
						JLabel SexLable = new JLabel("�Ա�");
						SexLable.setBounds(300, 220, 65, 30);
						//������Ͽ���������
						DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
						ComboBoxModel.addElement("��");
						ComboBoxModel.addElement("Ů");
						JComboBox<Object> ComboBoxlist = new JComboBox<>(ComboBoxModel);
						ComboBoxlist.setBounds(340, 220, 120, 30);
						
						
						// ����ѧУ��ѧУ�����
						JLabel school = new JLabel("ѧУ��");
						school.setBounds(500, 220, 65, 30);
						JTextField schoolTextField = new JTextField();
						schoolTextField.setBounds(540, 220, 120, 30);
						
						//������ϵ��ʽ����ϵ��ʽ�������
						JLabel phone = new JLabel("��ϵ��ʽ��");
						phone.setBounds(100, 300, 65, 30);
						JTextField phoneTextField = new JTextField();
						phoneTextField.setBounds(160, 300, 120, 30);
				
				       //�����οο�Ŀ�����οο�Ŀ�������
				       JLabel subject = new JLabel("�οο�Ŀ��:");
				       subject.setBounds(300, 300, 75, 30);
				       
				     //�����οο�Ŀ������
				   		JComboBox<String> subject_box=new JComboBox<>();
				   		subject_box.addItem("������");
				   		subject_box.addItem("������");
				   		subject_box.addItem("�������");
				   		subject_box.addItem("�赸��");
				   		subject_box.addItem("����");
				   		subject_box.addItem("������");
				   		subject_box.addItem("�黭��");
				   		subject_box.addItem("���Ӿ���");
				   		subject_box.setBounds(370, 300, 120, 30);
								
				//����ȷ��ע�ᰴť
				JButton ensure=new JButton("ȷ��ע��");
				ensure.setBounds(300, 400, 100, 20);
				ensure.addActionListener(new ActionListener() {					
					public void actionPerformed(ActionEvent e) {
						
					if(checkEmpty(frame,NumTextField,"�˺�")) {
						if(checkEmpty(frame,pwTextField,"����")) {
						   insertinfo t=new insertinfo();
						   //����ֵΪtrueʱΪע��ɹ�����رյ�ǰ���ڲ��򿪵�¼����
						  if(t.net_ter_info(frame,NumTextField.getText(),pwTextField.getText(),
								NameTextField.getText(), (String)ComboBoxlist.getSelectedItem().toString(),schoolTextField.getText(),
								phoneTextField.getText(),subject_box.getSelectedItem().toString())) {
							  frame.dispose();
							  					
						}}}
					}});
				//�������ذ�ť
				JButton GoBack=new JButton("����");
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

	//ѧ��ע��
	public JPanel student() {
		//*****************************************************
        //�������
	    pInput = new JPanel();	
		pInput.setBounds(0, 0, 800, 600);//�������λ��	
		pInput.setLayout(null);//ȫ�ֻ�
		 JLabel Text = new JLabel("ѧ���û�ע��");
	        Text.setFont(new Font("����",0,30));
	        Text.setBounds(300, 50, 350, 30);
	        pInput.add(Text);
	       // �����˺����˺������
			JLabel NumLable = new JLabel("�˺ţ�");
			NumLable.setBounds(100, 140, 65, 30);
			JTextField NumTextField = new JTextField();
			NumTextField.setBounds(140, 140, 120, 30);
			
			//�������������������
			JLabel pw = new JLabel("���룺");
			pw.setBounds(300, 140 ,65, 30);
			JTextField pwTextField = new JTextField();
			pwTextField.setBounds(340, 140, 120, 30);
			
			// �������������������
			JLabel NameLable = new JLabel("������");
			NameLable.setBounds(100, 220, 65, 30);
			JTextField NameTextField = new JTextField();
			NameTextField.setBounds(140, 220, 120, 30);
			
			//�����Ա�ѡ���
			JLabel SexLable = new JLabel("�Ա�");
			SexLable.setBounds(300, 220, 65, 30);
			//������Ͽ���������
			DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
			ComboBoxModel.addElement("��");
			ComboBoxModel.addElement("Ů");
			JComboBox<Object> ComboBoxlist = new JComboBox<>(ComboBoxModel);
			ComboBoxlist.setBounds(340, 220, 120, 30);
			
			
			// ����ѧУ��ѧУ�����
			JLabel school = new JLabel("ѧУ��");
			school.setBounds(500, 220, 65, 30);
			JTextField schoolTextField = new JTextField();
			schoolTextField.setBounds(540, 220, 120, 30);
			
			//������ϵ��ʽ����ϵ��ʽ�������
			JLabel phone = new JLabel("��ϵ��ʽ��");
			phone.setBounds(100, 300, 65, 30);
			JTextField phoneTextField = new JTextField();
			phoneTextField.setBounds(160, 300, 120, 30);
		
		
		//����רҵ��רҵ�������
		JLabel subject = new JLabel("רҵ��");
		subject.setBounds(300, 300, 65, 30);
		JTextField subjectTextField = new JTextField();//
		subjectTextField.setBounds(340, 300, 120, 30);
		//�����༶��༶�����
		JLabel classes = new JLabel("�༶��");
		classes.setBounds(500, 300, 65, 30);
		JTextField classTextField = new JTextField();
		classTextField.setBounds(540, 300, 120, 30);
		
		//������ѧ��������ѧ���������
		JLabel date = new JLabel("��ѧ���ڣ�");
		date.setBounds(100, 380, 75, 30);
		JTextField dateTextField = new JTextField();
		dateTextField.setBounds(160, 380, 120, 30);
		//����ȷ��ע�ᰴť
		JButton ensure=new JButton("ȷ��ע��");
		ensure.setBounds(280, 450, 100, 20);
		ensure.addActionListener(new ActionListener() {					
			public void actionPerformed(ActionEvent e) {
				if(checkEmpty(frame,NumTextField,"�˺�")) {
					if(checkEmpty(frame,pwTextField,"����")) {
				     insertinfo t=new insertinfo();
				     //����ֵΪtrueʱ�رյ�ǰ���ڲ��򿪵�¼����
				     if(t.net_stu_info(frame,NumTextField.getText(),pwTextField.getText(),
						NameTextField.getText(),ComboBoxlist.getSelectedItem().toString(),schoolTextField.getText(),phoneTextField.getText(),
						subjectTextField.getText(),classTextField.getText(),dateTextField.getText())) {
					landing land=new landing();
					frame.dispose();			
				}
			}}}
	    
		});
		
		//�������ذ�ť
		JButton GoBack=new JButton("����");
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
    //�п���Ϣ
	private  boolean checkEmpty(JFrame frame,JTextField tf, String msg) {

		String value = tf.getText();
		if(value.length()==0){
		JOptionPane.showMessageDialog(frame, msg + " ����Ϊ��");
		tf.grabFocus();
		return false;
		}
		return true;
}	
}
