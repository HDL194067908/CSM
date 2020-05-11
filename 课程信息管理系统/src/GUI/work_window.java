package GUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.course;
import entity.schedule;
import entity.work;
import work.insertinfo;
import work.queryInfo;
import work.updateSql;

public  class work_window  {
	private String userType;
	private String user;
	private JFrame frame=new JFrame();
	private insertinfo info=new insertinfo();
	queryInfo query=new queryInfo();
	updateSql update=new updateSql();
	queryInfo find=new queryInfo();
	   //��¼��������ʾ
       public void work(String userType,String user) {
    	   this.userType=userType;
    	   this.user=user;
    	   frame.setTitle("��ӭʹ�ÿγ���Ϣ����ϵͳ");
    	   frame.setSize(800,600);   	   
    	   frame.setResizable(false);//��Ϊ���������岻�洰�ڶ�̬�仯��С�����Խ�ֹ�˴��ڱ仯��С
    	   frame.setLocationRelativeTo(getOwner());//����Ļ��ʾ����Ļ����
    	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   if(userType.equals("Student")) {
    		   
    		   JTabbedPane Scard=new JTabbedPane();
    		   Scard.addTab("�α�", null,get_Timetable());  	                                                 	  
    		   Scard.addTab("��ҵ", null,get_homework());
    		   Scard.addTab("ѡ��", null,get_Course());
    		   Scard.addTab("������Ϣ", null,get_person());
    		   frame.add(Scard);}
        	  
    	   
    	   if(userType.equals("Teacher")) {
    		   JTabbedPane Tcard=new JTabbedPane();
    		   Tcard.addTab("�α�", null,get_Timetable());  	                                                 	  
    		   Tcard.addTab("��ҵ", null,get_homework());
    		   Tcard.addTab("����γ�", null,get_curriculuminfo());
    		   Tcard.addTab("������Ϣ", null,get_person());
    		   frame.add(Tcard);}
    	   frame.setVisible(true);
    	   }

     //��ȡ��Ļ����
       private Component getOwner() {		
			return null;
		}
	 //���ع���γ����
      public JPanel get_curriculuminfo() {
  	  
        JPanel pInput = new JPanel();	
   		pInput.setBounds(500, 300, 375, 90);//�������λ��	
   		pInput.setLayout(null);//ȫ�ֻ�
   		
   		// ����������������
   		JLabel NumLable = new JLabel("�γ̱�ţ�");
   		JTextField NumTextField = new JTextField();
   		NumLable.setBounds(30, 300, 65, 30);
   		NumTextField.setBounds(86, 300, 65, 30);

   		// �����γ�����γ��������
   		JLabel NameLable = new JLabel("�γ�����");
   		JTextField NameTextField = new JTextField();
   		NameLable.setBounds(155, 300, 65, 30);
   		NameTextField.setBounds(200, 300, 65, 30);
   		
   		// ������ʦ���ʦ�����
   		JLabel teacher = new JLabel("��ʦ��");
   		JTextField teacherTextField = new JTextField();
   		teacher.setBounds(270, 300, 65, 30);
   		teacherTextField.setBounds(302, 300, 65, 30);
   		
   		// ����ʱ����ʱ�������
   		JLabel time = new JLabel("ʱ�䣺");
   		JTextField timeTextField = new JTextField();
   		time.setBounds(375, 300, 65, 30);
   		timeTextField.setBounds(405, 300, 65, 30);
   		
   		// �����ص���ص������
   		JLabel address = new JLabel("�ص㣺");
   		JTextField addressTextField = new JTextField();
   		address.setBounds(475, 300, 65, 30);
   		addressTextField.setBounds(505, 300, 65, 30);
   		
   		// �����γ����ʿ�
   		JLabel xz = new JLabel("�γ����ʣ�");
   		xz.setBounds(575, 300, 65, 30);
   
   		
   		//�����γ���������
   		JComboBox<String> xz_box=new JComboBox<>();
   		xz_box.addItem("������");
   		xz_box.addItem("������");
   		xz_box.addItem("�������");
   		xz_box.addItem("�赸��");
   		xz_box.addItem("����");
   		xz_box.addItem("������");
   		xz_box.addItem("�黭��");
   		xz_box.addItem("���Ӿ���");
   		xz_box.setBounds(632, 300, 100, 30);
   		
   		// ����ѧ  ʱ��ѧ  ʱ�����
   		JLabel xs = new JLabel("ѧ  ʱ��");
   		JTextField xsTextField = new JTextField();
   		xs.setBounds(30, 350, 65, 30);
   		xsTextField.setBounds(86, 350, 65, 30);
   		
   		// ��������������������
   		JLabel edrs = new JLabel("�������");
   		JTextField edrsTextField = new JTextField();
   		edrs.setBounds(155, 350, 65, 30);
   		edrsTextField.setBounds(215, 350, 75, 30);
   		
   		// ������ѡ��������ѡ���������
   		JLabel yxrs = new JLabel("��ѡ������");
   		JTextField yxrsTextField = new JTextField("0");
   		yxrs.setBounds(295, 350, 65, 30);
   		yxrsTextField.setBounds(355, 350, 65, 30);
   		
   	// ������ʦid�������
   		JLabel tid = new JLabel("��ʦ��ţ�");
   		JTextField tidTextField = new JTextField(user);
   		tid.setBounds(450, 350, 65, 30);
   		tidTextField.setBounds(510, 350, 75, 30);
   		
   		//�������Ӱ�ť
   		JButton AddBtn = new JButton("����");
   		AddBtn.setBounds(600, 350, 65, 30);
   		
   		    // ����������ݵ�����
      		Vector<Vector<Object>> contextList = new Vector<>();
      		
      		// ������ͷ����������
      		Vector<Object> titleList = new Vector<>();
      		titleList.add("�γ̱��");
      		titleList.add("��ʦ���");
      		titleList.add("�γ���");
      		titleList.add("��ʦ");
      		titleList.add("ʱ��");
      		titleList.add("�ص�");
      		titleList.add("�γ�����");
      		titleList.add("ѧʱ");
      		titleList.add("�����");
      		titleList.add("��ѡ����");
      		// ����DefaultTableModeģ�� ������������
      		DefaultTableModel model = new DefaultTableModel(contextList, titleList);
      		
      		//�������ݿ⣬�����ݴ���table
      		//--------------------------------------------------------------------
      		ArrayList list=query.search_course(frame);
      		for (int i = 0; i < list.size(); i++) {
    			course cinfo = (course) list.get(i);
    			model.addRow(new Object[] { cinfo.getCid(),cinfo.getSid(), cinfo.getCname(), cinfo.getTname(),
    					cinfo.getTime(), cinfo.getAddress(),cinfo.getChat(),cinfo.getStutime(),
    					cinfo.getEdnum(),cinfo.getYxnum()});
    		}
      		
      		// �������
      		JTable table = new JTable(model);
      	   // ���ñ���п�
      		table.setRowHeight(30);
      		//ʹ��񲻿ɱ༭
      		table.setEnabled(false);
      		// ����table��������
      		JScrollPane scrollPane = new JScrollPane(table);
      		scrollPane.setBounds(1, 1, 780, 250);	
      		
      	    //�����α�ż������
      		JLabel num=new JLabel("�γ̱��;");
      		JTextField numText=new JTextField();
      		num.setBounds(200, 420, 65, 30);
      		numText.setBounds(260, 420, 150, 30);
      		//����������ť      		
      		JButton search=new JButton("����");
      		search.setBounds(450, 420, 65, 30);
      		search.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					course cinfo=(course)find.search(frame,numText);
					if(cinfo.getCid()!=null) {
					modify_delete_course update1=new modify_delete_course();
					update1.display(cinfo,table,model);
					}
				}
      			
      		});
      		
      		//�������ӵ�pInput���
      		pInput.add(tid);
      		pInput.add(tidTextField);
      		pInput.add(search);
      		pInput.add(num);
      		pInput.add(numText);
      		pInput.add(scrollPane);
      		pInput.add(NumLable);
      		pInput.add(NumTextField);
      		pInput.add(NameLable);
      		pInput.add(NameTextField);
      		pInput.add(teacher);
      		pInput.add(teacherTextField);
      		pInput.add(time);
      		pInput.add(timeTextField);
      		pInput.add(address);
      		pInput.add(addressTextField);
      		pInput.add(xz);
      		pInput.add(xz_box);
      		pInput.add(xs);
      		pInput.add(xsTextField);
      		pInput.add(edrs);
      		pInput.add(edrsTextField);
      		pInput.add(yxrs);
      		pInput.add(yxrsTextField);
      		pInput.add(AddBtn);
      	//����������
       		AddBtn.addActionListener(new ActionListener() {
       			
       			@Override
       			public void actionPerformed(ActionEvent e) {
       				
       				String Num = NumTextField.getText();
       				String tid =tidTextField.getText();
       				String Name = NameTextField.getText();
       				String teacher = teacherTextField.getText();
       				String time = timeTextField.getText();
       				String address = addressTextField.getText();  
       				String xz = (String) xz_box.getSelectedItem();
       				String xs = xsTextField.getText();
       				String edrs = edrsTextField.getText();
       				String yxrs = yxrsTextField.getText().toString();
       				if(checkEmpty(frame,NumTextField,"�γ̱��")) {
       					if(checkEmpty(frame,NameTextField,"�γ���")) {
       					if(checkEmpty(frame,tidTextField,"��ʦ���")) {
       				       if(checkNumber(edrsTextField,"�����")) {
       					      if(checkNumber(yxrsTextField,"��ѡ����")) {
       				if(info.net_cour_info(frame,Num,tid,Name,teacher,time,address,xz,xs,Integer.parseInt(edrs),Integer.parseInt(yxrs))) {
       				//��������ӵ���
       				Vector<Object> list = new Vector<>();
       				list.addElement(Num);
       				list.addElement(tid);
       				list.addElement(Name);
       				list.addElement(teacher);
       				list.addElement(time);
       				list.addElement(address);
       				list.addElement(xz);
       				list.addElement(xs);
       				list.addElement(edrs);
       				list.addElement(yxrs);
       				//�����ݷ�������������
       				model.addRow(list);
       				
       				//���Ӻ��������
       				NumTextField.setText("");
       				NameTextField.setText("");
       				teacherTextField.setText("");
       				timeTextField.setText("");
       				addressTextField.setText("");
       				xsTextField.setText("");
       				edrsTextField.setText("");
       				yxrsTextField.setText("");}}}}}}
       			}
                 private boolean checkNumber(JTextField tf, String msg){
    	    		
    	    		String value = tf.getText();
    	    		try {
    					Integer.parseInt(value);
    				} catch (NumberFormatException e) {
    					JOptionPane.showMessageDialog(frame, msg + " ������������");
    					tf.grabFocus();
    					return false;
    				}
    				return true;
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
       		});
       		
   		
      		return pInput;
      		//**************************************************************
       }
     //������ҵ���
      public JPanel get_homework() {
    	  //�������
    	    JPanel pInput = new JPanel();	
     		pInput.setBounds(500, 300, 375, 90);//�������λ��	
     		pInput.setLayout(null);//ȫ�ֻ�
     		//**************************************************************
             
     		//�����ҵ���
     		
     		 // ����������ݵ�����
      		Vector<Vector<Object>> contextList = new Vector<>();
   
      		// ������ͷ����������
      		Vector<Object> titleList = new Vector<>();
      		titleList.add("��ҵ���");
      		titleList.add("���");      		
      		titleList.add("��Ŀ");
      		titleList.add("����");
      		titleList.add("����ʱ��");
      		titleList.add("����ʱ��");
      		
      	    // ����DefaultTableModeģ�� ������������
      		DefaultTableModel model = new DefaultTableModel(contextList, titleList);      	
      		// �������
      		JTable table = new JTable(model);
      		//ʹ��񲻿ɱ༭
      		table.setEnabled(false);
      		// ����table��������
      		JScrollPane scrollPane = new JScrollPane(table);
      		scrollPane.setBounds(1, 1, 780, 400);
      		table.setRowHeight(30);// ���ñ���п�
      		
      	     //�������ݿ⣬�����ݴ���table
      		//--------------------------------------------------------------------
      		ArrayList list=query.search_wifo(frame);
      		for (int i = 0; i < list.size(); i++) {
      			work winfo=(work) list.get(i);
    			model.addRow(new Object[] {winfo.getHID(),winfo.getClass1(),winfo.getCname(),
    					winfo.getContent(),winfo.getTime1(),winfo.getTime2()});
    		}
      		
      		//����������ҵ��ť
      		JButton pubbto=new JButton("������ҵ");
      		pubbto.setBounds(350, 450, 90, 30);
      		pubbto.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(userType.equals("Teacher")) {
					//�������
					JFrame home=new JFrame();
					home.setTitle("��ҵ��Ϣ��д");
					home.setSize(800,600);   	   
					home.setResizable(false);//��Ϊ���������岻�洰�ڶ�̬�仯��С�����Խ�ֹ�˴��ڱ仯��С
					home.setLocationRelativeTo(getOwner());//����Ļ��ʾ����Ļ����
					//home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//�������
					JPanel pInput = new JPanel();	
		     		pInput.setBounds(500, 300, 375, 90);//�������λ��	
		     		pInput.setLayout(null);//ȫ�ֻ�
		     		//**********************************************************
		     	    // ������ҵ��ż������
		       		JLabel work_no = new JLabel("��ҵ��ţ�");
		       		JTextField work_noTextField = new JTextField();
		       		work_no.setBounds(60, 30, 65, 30);
		       		work_noTextField.setBounds(120, 30, 100, 30);
		       		
		       		// ������������
		       		JLabel class1 = new JLabel("���");
		       		JTextField class1TextField = new JTextField();
		       		class1.setBounds(245, 30, 65, 30);
		       		class1TextField.setBounds(280, 30, 100, 30);
		       		
		       		// ������Ŀ�������
		       		JLabel subject = new JLabel("��Ŀ��");
		       		JTextField subjectTextField = new JTextField();
		       		subject.setBounds(405, 30, 65, 30);
		       		subjectTextField.setBounds(440, 30, 100, 30);
		       		
		       		//�������ݼ������
		       		JLabel content = new JLabel("���ݣ�");
		       		JTextArea contentLoca=new JTextArea();
		       		content.setBounds(60, 60, 65, 30);
		       		contentLoca.setBounds(95, 70, 650, 200);
		       		
		       		//�������޼������		       	
		       		JLabel timeLim= new JLabel("���ޣ�");
		       		JLabel to= new JLabel("��");
		       		JTextField time1Text = new JTextField();
		       		JTextField time2Text = new JTextField();
		       		timeLim.setBounds(60, 300, 65, 30);
		       		time1Text.setBounds(90, 300, 100, 30);
		       		to.setBounds(200, 300, 65, 30);
		       		time2Text.setBounds(220, 300, 100, 30);
		       		//********************************************************
		       		//����ȷ�Ϸ�����ť
		       		JButton yes=new JButton("ȷ�Ϸ���");
		       		yes.setBounds(350, 400, 100, 30);
		       		yes.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							
							String work_no = work_noTextField.getText();
			   				String class1 = class1TextField.getText();
			   				String subject = subjectTextField.getText();
			   				String content = contentLoca.getText();
			   				String time1 = time1Text.getText(); 
			   				String time2 = time2Text.getText();
			   				if(checkEmpty(home,work_noTextField,"���")) {
			   				       if(info.net_work_info(home,work_no,class1,subject,content,time1,time2)) {
			   			
			   				//��������ӵ���
			   				Vector<Object> list1 = new Vector<>();
			   				list1.addElement(work_no);
			   				list1.addElement(class1);
			   				list1.addElement(subject);
			   				list1.addElement(content);
			   				list1.addElement(time1);
			   				list1.addElement(time2);
			   			
			   				//�����ݷ�������������
			   				model.addRow(list1);
			   				home.dispose();
						}}}
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
		       			
		       		});
		       		
		       		pInput.add(work_no);
		       		pInput.add(work_noTextField);
		       		pInput.add(class1);
		       		pInput.add(class1TextField);		       		
		       		pInput.add(subject);
		       		pInput.add(subjectTextField);
		       		pInput.add(content);
		       		pInput.add(contentLoca);
		       		pInput.add(timeLim);
		       		pInput.add(to);
		       		pInput.add(time1Text);
		       		pInput.add(time2Text);
		       		
		       		pInput.add(yes);
		     		home.add(pInput);
					home.setVisible(true);}
					if(userType.equals("Student")) {
						JOptionPane.showMessageDialog(frame, "��û�и�Ȩ��ร�");
					}
				}});
      		//�������ӵ����
      		pInput.add(scrollPane);
      		if(userType.equals("Teacher")) {pInput.add(pubbto);}
    	  return pInput;
      }
	 //���ظ�����Ϣ���
      public JPanel get_person() {
		//�������
  	    JPanel pInput = new JPanel();	
   		pInput.setBounds(500, 300, 375, 90);//�������λ��	
   		pInput.setLayout(null);//ȫ�ֻ�
   		//******************************
   		JLabel wel = new JLabel("��ǰ�û���"+user);
   		wel.setFont(new Font("΢���ź�", Font.HANGING_BASELINE, 20));
   		wel.setBounds(280, 100, 350, 100);
   		//�����༭������Ϣ��ť
   		JButton shuaxin=new JButton("ˢ�µ�ǰ��Ϣ");
   		shuaxin.setBounds(350, 200, 120, 30);
   		//�����˳���ť
   		JButton editInfo=new JButton("��������");
   		editInfo.setBounds(350, 250, 120, 30);
   		
   	     //�����˳���ť
   		JButton exitLan=new JButton("�˳���¼");
   		exitLan.setBounds(350, 300, 120, 30);
   		//��������
   		shuaxin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				work_window w=new  work_window();
				w.work(userType,user);
				
			}
   			
   		});
   		exitLan.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				landing land=new landing();
				
			}
   			
   		});
   		editInfo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame editINfo=new JFrame();
				editINfo.setTitle("�༭������Ϣ");
				editINfo.setSize(800,600);   	   
				editINfo.setResizable(false);//��Ϊ���������岻�洰�ڶ�̬�仯��С�����Խ�ֹ�˴��ڱ仯��С
				editINfo.setLocationRelativeTo(getOwner());//����Ļ��ʾ����Ļ����   
				//****************************************************
				//�������
		  	    JPanel pInput1 = new JPanel();	
		   		pInput1.setBounds(500, 300, 375, 90);//�������λ��	
		   		pInput1.setLayout(null);//ȫ�ֻ�
		   		//����ԭʼ���뼰�����
		   		JLabel yspw = new JLabel("ԭʼ���룺");
		   		JPasswordField yspwTextField = new JPasswordField();
	       		yspw.setBounds(280, 150, 65, 30);
	       		yspwTextField.setBounds(350, 150, 150, 30);
	       	   //���������뼰�����
	       		JLabel newpw = new JLabel("�� �� �룺");
		   		JPasswordField newpwTextField = new JPasswordField();
		   		newpw.setBounds(280, 200, 65, 30);
		   		newpwTextField.setBounds(350, 200, 150, 30);
	       		//�����������������뼰�����
		   		JLabel nextpw = new JLabel("�ٴ����룺");
		   		JPasswordField nextpwTextField = new JPasswordField();
		   		nextpw.setBounds(280, 250, 65, 30);
		   		nextpwTextField.setBounds(350, 250, 150, 30);
		   		//����ȷ�ϰ�ť
		   		JButton yes=new JButton("ȷ��");
		   		yes.setBounds(300, 350, 65, 30);
		   		//����ȡ����ť
		   		JButton no=new JButton("ȡ��");
		   		no.setBounds(400, 350, 65, 30);
		   		//��������
		   		no.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						editINfo.dispose();
					}
		   			
		   		});
		   		yes.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						//�ж����������������Ƿ�һ��
					 if(newpwTextField.getText().equals(nextpwTextField.getText())) {
						if(update.updatepw(editINfo,user,yspwTextField,newpwTextField)) {
						     editINfo.dispose();
						     frame.dispose();
						     new landing();}
					}
					else {
						JOptionPane.showMessageDialog(editINfo, "�������������벻��������������룡");
					}}
		   			
		   		});
		   		
	       		pInput1.add(yspw);
	       		pInput1.add(yspwTextField);
	       		pInput1.add(newpw);
	       		pInput1.add(newpwTextField);
	       		pInput1.add(nextpw);
	       		pInput1.add(nextpwTextField);
	       		pInput1.add(yes);
	       		pInput1.add(no);
	       		editINfo.add(pInput1);
	       		editINfo.setVisible(true);
		   		
			}
   			
   		});
   		pInput.add(wel);
   		pInput.add(exitLan);
   		pInput.add(editInfo);
   		pInput.add(shuaxin);
		  return pInput;
	  }
     //����ѡ�����
      public JPanel get_Course() {
    	//�������
    	    JPanel pInput = new JPanel();	
     		pInput.setBounds(500, 300, 375, 90);//�������λ��	
     		pInput.setLayout(null);//ȫ�ֻ�
     		
     		 // ����������ݵ�����
      		Vector<Vector<Object>> contextList = new Vector<>();
      		
      		// ������ͷ����������
      		Vector<Object> titleList = new Vector<>();
      		titleList.add("�γ̱��");
      		titleList.add("�γ���");
      		titleList.add("��ʦ");
      		titleList.add("ʱ��");
      		titleList.add("�ص�");
      		titleList.add("�γ�����");
      		titleList.add("�����");
      		titleList.add("��ѡ����");
      		// ����DefaultTableModeģ�� ������������
      		DefaultTableModel model = new DefaultTableModel(contextList, titleList);
      	    //�������ݿ⣬�����ݴ���table
      		//--------------------------------------------------------------------
      		ArrayList list=query.search_course(frame);
      		for (int i = 0; i < list.size(); i++) {
    			course cinfo = (course) list.get(i);
    			model.addRow(new Object[] { cinfo.getCid(), cinfo.getCname(), cinfo.getTname(),
    					cinfo.getTime(), cinfo.getAddress(),cinfo.getChat(),
    					cinfo.getEdnum(),cinfo.getYxnum()});
    		}
      		// �������
      		JTable table = new JTable(model);
      	   // ���ñ���п�
      		table.setRowHeight(30);
      		//ʹ��񲻿ɱ༭
      		//table.setEnabled(false);
      		
      		
				// ����table��������
      		JScrollPane scrollPane = new JScrollPane(table);
      		scrollPane.setBounds(1, 1, 780, 400);
      		
      	    //����ѡ�α�ż������
      		JLabel num=new JLabel("ѡ�α��;");
      		JTextField numText=new JTextField();
      		num.setBounds(100, 450, 65, 30);
      		numText.setBounds(160, 450, 120, 30);
      		
      		//����������ť
      		JButton yes=new JButton("����");
      		yes.setBounds(300, 450, 65, 30);
      		//��������
      		yes.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(userType.equals("Student")) {
					JFrame claINfo=new JFrame();
					claINfo.setTitle("�γ���Ϣ");
					claINfo.setSize(800,600);   	   
					claINfo.setResizable(false);//��Ϊ���������岻�洰�ڶ�̬�仯��С�����Խ�ֹ�˴��ڱ仯��С
					claINfo.setLocationRelativeTo(getOwner());//����Ļ��ʾ����Ļ����   
					//****************************************************
					//���ݱ�Ų�ѯ�γ���Ϣ������һ��course����
					course cinfo=(course)find.search(claINfo,numText);
					if(cinfo.getCid()!=null) {
					//�������					
			  	    JPanel pInput1 = new JPanel();	
			   		pInput1.setBounds(500, 300, 375, 90);//�������λ��	
			   		pInput1.setLayout(null);//ȫ�ֻ�
			   		 // ����������������
   		            JLabel NumLable = new JLabel("�γ̱�ţ�"+cinfo.getCid());
                    NumLable.setBounds(250, 30, 300, 30);
                    NumLable.setFont(new Font("΢���ź�", Font.ITALIC, 20));
   		
   		            // �����γ�����γ��������
                    JLabel NameLable = new JLabel("�γ�����"+cinfo.getCname());
                    NameLable.setBounds(250, 80, 300, 30);
                    NameLable.setFont(new Font("΢���ź�", Font.ITALIC, 20));
   		
                    // ������ʦ���ʦ�����
   		            JLabel teacher = new JLabel("��ʦ��"+cinfo.getTname());
                    teacher.setBounds(250, 130, 300, 30);
                    teacher.setFont(new Font("΢���ź�", Font.ITALIC, 20));
   		
                	// ����ʱ����ʱ�������
   		            JLabel time = new JLabel("ʱ�䣺"+cinfo.getTime());
                    time.setBounds(250, 180, 300, 30);;
                    time.setFont(new Font("΢���ź�", Font.ITALIC, 20));
   		
                   // �����ص���ص������
   		           JLabel address = new JLabel("�ص㣺"+cinfo.getAddress());
                   address.setBounds(250, 230, 300, 30);;
                   address.setFont(new Font("΢���ź�", Font.ITALIC, 20));
   		
   		           // �����γ����ʿ�
   		           JLabel xz = new JLabel("�γ����ʣ�"+cinfo.getChat());
   		           xz.setBounds(250, 280, 300, 30);;
   		           xz.setFont(new Font("΢���ź�", Font.ITALIC, 20));
   
   		           // ����ѧ  ʱ��ѧ  ʱ�����
   		   		   JLabel xs = new JLabel("ѧ  ʱ��"+cinfo.getStutime());   		   		
   		   		   xs.setBounds(250, 330, 300, 30);;
   		   		   xs.setFont(new Font("΢���ź�", Font.ITALIC, 20));
   		
   		   	       // ��������������������
   		   		   JLabel edrs = new JLabel("�������"+cinfo.getEdnum());
   		   		   edrs.setBounds(250, 380, 300, 30);; 
   		   		  edrs.setFont(new Font("΢���ź�", Font.ITALIC, 20));
   	
   		   	       // ������ѡ��������ѡ���������
   		   		   JLabel yxrs = new JLabel("��ѡ������"+cinfo.getYxnum());
                   yxrs.setBounds(250, 430, 300, 30);;
                   yxrs.setFont(new Font("΢���ź�", Font.ITALIC, 20));
   		  
                   //����ȷ�ϰ�ť
                   JButton yes =new JButton("ȷ��");
                   yes.setBounds(300, 480, 65, 30);
                   //����ȡ����ť
                   JButton no =new JButton("ȡ��");
                   no.setBounds(380,480,65,30);
                   //��������
                   no.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						claINfo.dispose();
					}              	   
                   });
                   yes.addActionListener(new ActionListener() {

   					@Override
   					public void actionPerformed(ActionEvent e) {
   						if(cinfo.getEdnum()>cinfo.getYxnum()) {
   						if(info.net_course_info(claINfo,user,cinfo)) {
   							claINfo.dispose();
   						}
   						}else {
   							JOptionPane.showMessageDialog(claINfo, "�γ�����������");
   						}}           	   
                      });
                   pInput1.add(NumLable);
                   pInput1.add(NameLable);
                   pInput1.add(teacher);
                   pInput1.add(time);
                   pInput1.add(address);
                   pInput1.add(xz);
                   pInput1.add(xs);
                   pInput1.add(edrs);
                   pInput1.add(yxrs);
                   pInput1.add(yes);
                   pInput1.add(no);
			   		claINfo.add(pInput1);
			   		claINfo.setVisible(true);}}
					if(userType.equals("Teacher")) {
						JOptionPane.showMessageDialog(frame, "��ʦûȨ����Ŷ!");
					}
				}
      			
				
      		});
      		//�������ӵ�pInput���
      		pInput.add(num);
      		pInput.add(numText);
      		pInput.add(yes);
      		pInput.add(scrollPane);
    	  return pInput;
      }
     //���ؿα����
      public JPanel get_Timetable() {
    	//�������
  	    JPanel pInput = new JPanel();	
   		pInput.setBounds(500, 300, 375, 90);//�������λ��	
   		pInput.setLayout(null);//ȫ�ֻ�
   		//�����α���
   	    // ����������ݵ�����
  		Vector<Vector<Object>> contextList = new Vector<>();
  		
  		// ������ͷ����������
  		Vector<Object> titleList = new Vector<>();
  		titleList.add("�γ���");
  		if(userType.equals("Student")) {titleList.add("��ʦ");}
  		titleList.add("ʱ��");
  		titleList.add("�ص�");
  		// ����DefaultTableModeģ�� ������������
  		DefaultTableModel model = new DefaultTableModel(contextList, titleList);
  		
  	     //�������ݿ⣬�����ݴ���table
  		//--------------------------------------------------------------------
  		if(userType.equals("Student")) {
  		    ArrayList list=query.search_Scinfo(frame,user);
  		    for (int i = 0; i < list.size(); i++) {
  			schedule cinfo = (schedule) list.get(i);
			model.addRow(new Object[] {  cinfo.getCname(), cinfo.getTname(),
					cinfo.getTime(), cinfo.getAddress()});
		}}
  		if(userType.equals("Teacher")) {
  			ArrayList list=query.search_Tcinfo(frame,user);
  		    for (int i = 0; i < list.size(); i++) {
  			   course cinfo = (course) list.get(i);
			   model.addRow(new Object[] {  cinfo.getCname(),cinfo.getTime(), cinfo.getAddress()});}}
  		// �������
  		JTable table = new JTable(model);
  	    // ���ñ���п�
  		table.setRowHeight(30);
  		//ʹ��񲻿ɱ༭
  		table.setEnabled(false);
  	    
	    // ����table��������
  		JScrollPane scrollPane = new JScrollPane(table);
  		scrollPane.setBounds(1, 1, 780, 500);
  		pInput.add(scrollPane);
    	  return pInput;
      }
}


