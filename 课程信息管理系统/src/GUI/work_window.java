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
	   //登录主界面显示
       public void work(String userType,String user) {
    	   this.userType=userType;
    	   this.user=user;
    	   frame.setTitle("欢迎使用课程信息管理系统");
    	   frame.setSize(800,600);   	   
    	   frame.setResizable(false);//因为解决不了面板不随窗口动态变化大小，所以禁止了窗口变化大小
    	   frame.setLocationRelativeTo(getOwner());//将屏幕显示在屏幕中心
    	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   if(userType.equals("Student")) {
    		   
    		   JTabbedPane Scard=new JTabbedPane();
    		   Scard.addTab("课表", null,get_Timetable());  	                                                 	  
    		   Scard.addTab("作业", null,get_homework());
    		   Scard.addTab("选课", null,get_Course());
    		   Scard.addTab("个人信息", null,get_person());
    		   frame.add(Scard);}
        	  
    	   
    	   if(userType.equals("Teacher")) {
    		   JTabbedPane Tcard=new JTabbedPane();
    		   Tcard.addTab("课表", null,get_Timetable());  	                                                 	  
    		   Tcard.addTab("作业", null,get_homework());
    		   Tcard.addTab("管理课程", null,get_curriculuminfo());
    		   Tcard.addTab("个人信息", null,get_person());
    		   frame.add(Tcard);}
    	   frame.setVisible(true);
    	   }

     //获取屏幕中心
       private Component getOwner() {		
			return null;
		}
	 //返回管理课程面板
      public JPanel get_curriculuminfo() {
  	  
        JPanel pInput = new JPanel();	
   		pInput.setBounds(500, 300, 375, 90);//设置组件位置	
   		pInput.setLayout(null);//全局化
   		
   		// 创建编号与编号输入框
   		JLabel NumLable = new JLabel("课程编号：");
   		JTextField NumTextField = new JTextField();
   		NumLable.setBounds(30, 300, 65, 30);
   		NumTextField.setBounds(86, 300, 65, 30);

   		// 创建课程名与课程名输入框
   		JLabel NameLable = new JLabel("课程名：");
   		JTextField NameTextField = new JTextField();
   		NameLable.setBounds(155, 300, 65, 30);
   		NameTextField.setBounds(200, 300, 65, 30);
   		
   		// 创建教师与教师输入框
   		JLabel teacher = new JLabel("教师：");
   		JTextField teacherTextField = new JTextField();
   		teacher.setBounds(270, 300, 65, 30);
   		teacherTextField.setBounds(302, 300, 65, 30);
   		
   		// 创建时间与时间输入框
   		JLabel time = new JLabel("时间：");
   		JTextField timeTextField = new JTextField();
   		time.setBounds(375, 300, 65, 30);
   		timeTextField.setBounds(405, 300, 65, 30);
   		
   		// 创建地点与地点输入框
   		JLabel address = new JLabel("地点：");
   		JTextField addressTextField = new JTextField();
   		address.setBounds(475, 300, 65, 30);
   		addressTextField.setBounds(505, 300, 65, 30);
   		
   		// 创建课程性质框
   		JLabel xz = new JLabel("课程性质：");
   		xz.setBounds(575, 300, 65, 30);
   
   		
   		//创建课程性质容器
   		JComboBox<String> xz_box=new JComboBox<>();
   		xz_box.addItem("声乐类");
   		xz_box.addItem("乐器类");
   		xz_box.addItem("计算机类");
   		xz_box.addItem("舞蹈类");
   		xz_box.addItem("棋类");
   		xz_box.addItem("武术类");
   		xz_box.addItem("书画类");
   		xz_box.addItem("电子竞技");
   		xz_box.setBounds(632, 300, 100, 30);
   		
   		// 创建学  时与学  时输入框
   		JLabel xs = new JLabel("学  时：");
   		JTextField xsTextField = new JTextField();
   		xs.setBounds(30, 350, 65, 30);
   		xsTextField.setBounds(86, 350, 65, 30);
   		
   		// 创建额定人数与额定人数输入框
   		JLabel edrs = new JLabel("额定人数：");
   		JTextField edrsTextField = new JTextField();
   		edrs.setBounds(155, 350, 65, 30);
   		edrsTextField.setBounds(215, 350, 75, 30);
   		
   		// 创建已选人数与已选人数输入框
   		JLabel yxrs = new JLabel("已选人数：");
   		JTextField yxrsTextField = new JTextField("0");
   		yxrs.setBounds(295, 350, 65, 30);
   		yxrsTextField.setBounds(355, 350, 65, 30);
   		
   	// 创建教师id及输入框
   		JLabel tid = new JLabel("教师编号：");
   		JTextField tidTextField = new JTextField(user);
   		tid.setBounds(450, 350, 65, 30);
   		tidTextField.setBounds(510, 350, 75, 30);
   		
   		//创建增加按钮
   		JButton AddBtn = new JButton("增加");
   		AddBtn.setBounds(600, 350, 65, 30);
   		
   		    // 创建表格内容的容器
      		Vector<Vector<Object>> contextList = new Vector<>();
      		
      		// 创建表头的数据容器
      		Vector<Object> titleList = new Vector<>();
      		titleList.add("课程编号");
      		titleList.add("教师编号");
      		titleList.add("课程名");
      		titleList.add("教师");
      		titleList.add("时间");
      		titleList.add("地点");
      		titleList.add("课程性质");
      		titleList.add("学时");
      		titleList.add("额定人数");
      		titleList.add("已选人数");
      		// 创建DefaultTableMode模型 管理数据容器
      		DefaultTableModel model = new DefaultTableModel(contextList, titleList);
      		
      		//连接数据库，将数据传到table
      		//--------------------------------------------------------------------
      		ArrayList list=query.search_course(frame);
      		for (int i = 0; i < list.size(); i++) {
    			course cinfo = (course) list.get(i);
    			model.addRow(new Object[] { cinfo.getCid(),cinfo.getSid(), cinfo.getCname(), cinfo.getTname(),
    					cinfo.getTime(), cinfo.getAddress(),cinfo.getChat(),cinfo.getStutime(),
    					cinfo.getEdnum(),cinfo.getYxnum()});
    		}
      		
      		// 创建表格
      		JTable table = new JTable(model);
      	   // 设置表格行宽
      		table.setRowHeight(30);
      		//使表格不可编辑
      		table.setEnabled(false);
      		// 创建table滚动窗体
      		JScrollPane scrollPane = new JScrollPane(table);
      		scrollPane.setBounds(1, 1, 780, 250);	
      		
      	    //创建课编号及输入框
      		JLabel num=new JLabel("课程编号;");
      		JTextField numText=new JTextField();
      		num.setBounds(200, 420, 65, 30);
      		numText.setBounds(260, 420, 150, 30);
      		//创建搜索按钮      		
      		JButton search=new JButton("搜索");
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
      		
      		//将组件添加到pInput面板
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
      	//创建监听器
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
       				if(checkEmpty(frame,NumTextField,"课程编号")) {
       					if(checkEmpty(frame,NameTextField,"课程名")) {
       					if(checkEmpty(frame,tidTextField,"教师编号")) {
       				       if(checkNumber(edrsTextField,"额定人数")) {
       					      if(checkNumber(yxrsTextField,"已选人数")) {
       				if(info.net_cour_info(frame,Num,tid,Name,teacher,time,address,xz,xs,Integer.parseInt(edrs),Integer.parseInt(yxrs))) {
       				//将数据添加到表
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
       				//将数据放入数据容器中
       				model.addRow(list);
       				
       				//增加后清空数据
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
    					JOptionPane.showMessageDialog(frame, msg + " 必须是整数！");
    					tf.grabFocus();
    					return false;
    				}
    				return true;
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
       		});
       		
   		
      		return pInput;
      		//**************************************************************
       }
     //返回作业面板
      public JPanel get_homework() {
    	  //面板属性
    	    JPanel pInput = new JPanel();	
     		pInput.setBounds(500, 300, 375, 90);//设置组件位置	
     		pInput.setLayout(null);//全局化
     		//**************************************************************
             
     		//添加作业表格
     		
     		 // 创建表格内容的容器
      		Vector<Vector<Object>> contextList = new Vector<>();
   
      		// 创建表头的数据容器
      		Vector<Object> titleList = new Vector<>();
      		titleList.add("作业编号");
      		titleList.add("班别");      		
      		titleList.add("科目");
      		titleList.add("内容");
      		titleList.add("发布时间");
      		titleList.add("截至时间");
      		
      	    // 创建DefaultTableMode模型 管理数据容器
      		DefaultTableModel model = new DefaultTableModel(contextList, titleList);      	
      		// 创建表格
      		JTable table = new JTable(model);
      		//使表格不可编辑
      		table.setEnabled(false);
      		// 创建table滚动窗体
      		JScrollPane scrollPane = new JScrollPane(table);
      		scrollPane.setBounds(1, 1, 780, 400);
      		table.setRowHeight(30);// 设置表格行宽
      		
      	     //连接数据库，将数据传到table
      		//--------------------------------------------------------------------
      		ArrayList list=query.search_wifo(frame);
      		for (int i = 0; i < list.size(); i++) {
      			work winfo=(work) list.get(i);
    			model.addRow(new Object[] {winfo.getHID(),winfo.getClass1(),winfo.getCname(),
    					winfo.getContent(),winfo.getTime1(),winfo.getTime2()});
    		}
      		
      		//创建发布作业按钮
      		JButton pubbto=new JButton("发布作业");
      		pubbto.setBounds(350, 450, 90, 30);
      		pubbto.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(userType.equals("Teacher")) {
					//框架属性
					JFrame home=new JFrame();
					home.setTitle("作业信息填写");
					home.setSize(800,600);   	   
					home.setResizable(false);//因为解决不了面板不随窗口动态变化大小，所以禁止了窗口变化大小
					home.setLocationRelativeTo(getOwner());//将屏幕显示在屏幕中心
					//home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//面板属性
					JPanel pInput = new JPanel();	
		     		pInput.setBounds(500, 300, 375, 90);//设置组件位置	
		     		pInput.setLayout(null);//全局化
		     		//**********************************************************
		     	    // 创建作业编号及输入框
		       		JLabel work_no = new JLabel("作业编号：");
		       		JTextField work_noTextField = new JTextField();
		       		work_no.setBounds(60, 30, 65, 30);
		       		work_noTextField.setBounds(120, 30, 100, 30);
		       		
		       		// 创建班别及输入框
		       		JLabel class1 = new JLabel("班别：");
		       		JTextField class1TextField = new JTextField();
		       		class1.setBounds(245, 30, 65, 30);
		       		class1TextField.setBounds(280, 30, 100, 30);
		       		
		       		// 创建科目及输入框
		       		JLabel subject = new JLabel("科目：");
		       		JTextField subjectTextField = new JTextField();
		       		subject.setBounds(405, 30, 65, 30);
		       		subjectTextField.setBounds(440, 30, 100, 30);
		       		
		       		//创建内容及输入框
		       		JLabel content = new JLabel("内容：");
		       		JTextArea contentLoca=new JTextArea();
		       		content.setBounds(60, 60, 65, 30);
		       		contentLoca.setBounds(95, 70, 650, 200);
		       		
		       		//创建期限及输入框		       	
		       		JLabel timeLim= new JLabel("期限：");
		       		JLabel to= new JLabel("至");
		       		JTextField time1Text = new JTextField();
		       		JTextField time2Text = new JTextField();
		       		timeLim.setBounds(60, 300, 65, 30);
		       		time1Text.setBounds(90, 300, 100, 30);
		       		to.setBounds(200, 300, 65, 30);
		       		time2Text.setBounds(220, 300, 100, 30);
		       		//********************************************************
		       		//创建确认发布按钮
		       		JButton yes=new JButton("确认发布");
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
			   				if(checkEmpty(home,work_noTextField,"编号")) {
			   				       if(info.net_work_info(home,work_no,class1,subject,content,time1,time2)) {
			   			
			   				//将数据添加到表
			   				Vector<Object> list1 = new Vector<>();
			   				list1.addElement(work_no);
			   				list1.addElement(class1);
			   				list1.addElement(subject);
			   				list1.addElement(content);
			   				list1.addElement(time1);
			   				list1.addElement(time2);
			   			
			   				//将数据放入数据容器中
			   				model.addRow(list1);
			   				home.dispose();
						}}}
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
						JOptionPane.showMessageDialog(frame, "你没有该权限喔！");
					}
				}});
      		//将表格添加到面板
      		pInput.add(scrollPane);
      		if(userType.equals("Teacher")) {pInput.add(pubbto);}
    	  return pInput;
      }
	 //返回个人信息面板
      public JPanel get_person() {
		//面板属性
  	    JPanel pInput = new JPanel();	
   		pInput.setBounds(500, 300, 375, 90);//设置组件位置	
   		pInput.setLayout(null);//全局化
   		//******************************
   		JLabel wel = new JLabel("当前用户："+user);
   		wel.setFont(new Font("微软雅黑", Font.HANGING_BASELINE, 20));
   		wel.setBounds(280, 100, 350, 100);
   		//创建编辑个人信息按钮
   		JButton shuaxin=new JButton("刷新当前信息");
   		shuaxin.setBounds(350, 200, 120, 30);
   		//创建退出按钮
   		JButton editInfo=new JButton("重置密码");
   		editInfo.setBounds(350, 250, 120, 30);
   		
   	     //创建退出按钮
   		JButton exitLan=new JButton("退出登录");
   		exitLan.setBounds(350, 300, 120, 30);
   		//创建监听
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
				editINfo.setTitle("编辑个人信息");
				editINfo.setSize(800,600);   	   
				editINfo.setResizable(false);//因为解决不了面板不随窗口动态变化大小，所以禁止了窗口变化大小
				editINfo.setLocationRelativeTo(getOwner());//将屏幕显示在屏幕中心   
				//****************************************************
				//面板属性
		  	    JPanel pInput1 = new JPanel();	
		   		pInput1.setBounds(500, 300, 375, 90);//设置组件位置	
		   		pInput1.setLayout(null);//全局化
		   		//创建原始密码及输入框
		   		JLabel yspw = new JLabel("原始密码：");
		   		JPasswordField yspwTextField = new JPasswordField();
	       		yspw.setBounds(280, 150, 65, 30);
	       		yspwTextField.setBounds(350, 150, 150, 30);
	       	   //创建新密码及输入框
	       		JLabel newpw = new JLabel("新 密 码：");
		   		JPasswordField newpwTextField = new JPasswordField();
		   		newpw.setBounds(280, 200, 65, 30);
		   		newpwTextField.setBounds(350, 200, 150, 30);
	       		//创建重新输入新密码及输入框
		   		JLabel nextpw = new JLabel("再次输入：");
		   		JPasswordField nextpwTextField = new JPasswordField();
		   		nextpw.setBounds(280, 250, 65, 30);
		   		nextpwTextField.setBounds(350, 250, 150, 30);
		   		//创建确认按钮
		   		JButton yes=new JButton("确认");
		   		yes.setBounds(300, 350, 65, 30);
		   		//创建取消按钮
		   		JButton no=new JButton("取消");
		   		no.setBounds(400, 350, 65, 30);
		   		//创建监听
		   		no.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						editINfo.dispose();
					}
		   			
		   		});
		   		yes.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						//判断新密码两次输入是否一致
					 if(newpwTextField.getText().equals(nextpwTextField.getText())) {
						if(update.updatepw(editINfo,user,yspwTextField,newpwTextField)) {
						     editINfo.dispose();
						     frame.dispose();
						     new landing();}
					}
					else {
						JOptionPane.showMessageDialog(editINfo, "新密码两次输入不相符，请重新输入！");
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
     //返回选课面板
      public JPanel get_Course() {
    	//面板属性
    	    JPanel pInput = new JPanel();	
     		pInput.setBounds(500, 300, 375, 90);//设置组件位置	
     		pInput.setLayout(null);//全局化
     		
     		 // 创建表格内容的容器
      		Vector<Vector<Object>> contextList = new Vector<>();
      		
      		// 创建表头的数据容器
      		Vector<Object> titleList = new Vector<>();
      		titleList.add("课程编号");
      		titleList.add("课程名");
      		titleList.add("教师");
      		titleList.add("时间");
      		titleList.add("地点");
      		titleList.add("课程性质");
      		titleList.add("额定人数");
      		titleList.add("已选人数");
      		// 创建DefaultTableMode模型 管理数据容器
      		DefaultTableModel model = new DefaultTableModel(contextList, titleList);
      	    //连接数据库，将数据传到table
      		//--------------------------------------------------------------------
      		ArrayList list=query.search_course(frame);
      		for (int i = 0; i < list.size(); i++) {
    			course cinfo = (course) list.get(i);
    			model.addRow(new Object[] { cinfo.getCid(), cinfo.getCname(), cinfo.getTname(),
    					cinfo.getTime(), cinfo.getAddress(),cinfo.getChat(),
    					cinfo.getEdnum(),cinfo.getYxnum()});
    		}
      		// 创建表格
      		JTable table = new JTable(model);
      	   // 设置表格行宽
      		table.setRowHeight(30);
      		//使表格不可编辑
      		//table.setEnabled(false);
      		
      		
				// 创建table滚动窗体
      		JScrollPane scrollPane = new JScrollPane(table);
      		scrollPane.setBounds(1, 1, 780, 400);
      		
      	    //创建选课编号及输入框
      		JLabel num=new JLabel("选课编号;");
      		JTextField numText=new JTextField();
      		num.setBounds(100, 450, 65, 30);
      		numText.setBounds(160, 450, 120, 30);
      		
      		//创建搜索按钮
      		JButton yes=new JButton("搜索");
      		yes.setBounds(300, 450, 65, 30);
      		//创建监听
      		yes.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(userType.equals("Student")) {
					JFrame claINfo=new JFrame();
					claINfo.setTitle("课程信息");
					claINfo.setSize(800,600);   	   
					claINfo.setResizable(false);//因为解决不了面板不随窗口动态变化大小，所以禁止了窗口变化大小
					claINfo.setLocationRelativeTo(getOwner());//将屏幕显示在屏幕中心   
					//****************************************************
					//根据编号查询课程信息并返回一个course对象
					course cinfo=(course)find.search(claINfo,numText);
					if(cinfo.getCid()!=null) {
					//面板属性					
			  	    JPanel pInput1 = new JPanel();	
			   		pInput1.setBounds(500, 300, 375, 90);//设置组件位置	
			   		pInput1.setLayout(null);//全局化
			   		 // 创建编号与编号输入框
   		            JLabel NumLable = new JLabel("课程编号："+cinfo.getCid());
                    NumLable.setBounds(250, 30, 300, 30);
                    NumLable.setFont(new Font("微软雅黑", Font.ITALIC, 20));
   		
   		            // 创建课程名与课程名输入框
                    JLabel NameLable = new JLabel("课程名："+cinfo.getCname());
                    NameLable.setBounds(250, 80, 300, 30);
                    NameLable.setFont(new Font("微软雅黑", Font.ITALIC, 20));
   		
                    // 创建教师与教师输入框
   		            JLabel teacher = new JLabel("教师："+cinfo.getTname());
                    teacher.setBounds(250, 130, 300, 30);
                    teacher.setFont(new Font("微软雅黑", Font.ITALIC, 20));
   		
                	// 创建时间与时间输入框
   		            JLabel time = new JLabel("时间："+cinfo.getTime());
                    time.setBounds(250, 180, 300, 30);;
                    time.setFont(new Font("微软雅黑", Font.ITALIC, 20));
   		
                   // 创建地点与地点输入框
   		           JLabel address = new JLabel("地点："+cinfo.getAddress());
                   address.setBounds(250, 230, 300, 30);;
                   address.setFont(new Font("微软雅黑", Font.ITALIC, 20));
   		
   		           // 创建课程性质框
   		           JLabel xz = new JLabel("课程性质："+cinfo.getChat());
   		           xz.setBounds(250, 280, 300, 30);;
   		           xz.setFont(new Font("微软雅黑", Font.ITALIC, 20));
   
   		           // 创建学  时与学  时输入框
   		   		   JLabel xs = new JLabel("学  时："+cinfo.getStutime());   		   		
   		   		   xs.setBounds(250, 330, 300, 30);;
   		   		   xs.setFont(new Font("微软雅黑", Font.ITALIC, 20));
   		
   		   	       // 创建额定人数与额定人数输入框
   		   		   JLabel edrs = new JLabel("额定人数："+cinfo.getEdnum());
   		   		   edrs.setBounds(250, 380, 300, 30);; 
   		   		  edrs.setFont(new Font("微软雅黑", Font.ITALIC, 20));
   	
   		   	       // 创建已选人数与已选人数输入框
   		   		   JLabel yxrs = new JLabel("已选人数："+cinfo.getYxnum());
                   yxrs.setBounds(250, 430, 300, 30);;
                   yxrs.setFont(new Font("微软雅黑", Font.ITALIC, 20));
   		  
                   //创建确认按钮
                   JButton yes =new JButton("确认");
                   yes.setBounds(300, 480, 65, 30);
                   //创建取消按钮
                   JButton no =new JButton("取消");
                   no.setBounds(380,480,65,30);
                   //创建监听
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
   							JOptionPane.showMessageDialog(claINfo, "课程人数已满！");
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
						JOptionPane.showMessageDialog(frame, "教师没权限搜哦!");
					}
				}
      			
				
      		});
      		//将组件添加到pInput面板
      		pInput.add(num);
      		pInput.add(numText);
      		pInput.add(yes);
      		pInput.add(scrollPane);
    	  return pInput;
      }
     //返回课表面板
      public JPanel get_Timetable() {
    	//面板属性
  	    JPanel pInput = new JPanel();	
   		pInput.setBounds(500, 300, 375, 90);//设置组件位置	
   		pInput.setLayout(null);//全局化
   		//创建课表表格
   	    // 创建表格内容的容器
  		Vector<Vector<Object>> contextList = new Vector<>();
  		
  		// 创建表头的数据容器
  		Vector<Object> titleList = new Vector<>();
  		titleList.add("课程名");
  		if(userType.equals("Student")) {titleList.add("教师");}
  		titleList.add("时间");
  		titleList.add("地点");
  		// 创建DefaultTableMode模型 管理数据容器
  		DefaultTableModel model = new DefaultTableModel(contextList, titleList);
  		
  	     //连接数据库，将数据传到table
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
  		// 创建表格
  		JTable table = new JTable(model);
  	    // 设置表格行宽
  		table.setRowHeight(30);
  		//使表格不可编辑
  		table.setEnabled(false);
  	    
	    // 创建table滚动窗体
  		JScrollPane scrollPane = new JScrollPane(table);
  		scrollPane.setBounds(1, 1, 780, 500);
  		pInput.add(scrollPane);
    	  return pInput;
      }
}


