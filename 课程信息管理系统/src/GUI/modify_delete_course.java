package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.course;
import work.deleteSql;
import work.updateSql;

public class modify_delete_course extends JFrame{
	private DefaultTableModel model;
	private JTable table;
	private JPanel pInput;
	private JPanel pInput_modify;
	private JPanel pInput_detele;
	private JFrame frame;
	public void display(course cinfo,JTable table,DefaultTableModel model) {
		this.table=table;
		this.model=model;
		//窗口信息
		frame=new JFrame();
		frame.setSize(800,600);	
		frame.setTitle("课程信息"); //设置窗口左上角命名	
		frame.setLayout(new BorderLayout());//组件全局化
		frame.setResizable(false);//因为解决不了面板不随窗口动态变化大小，所以禁止了窗口变化大小
		frame.setLocationRelativeTo(getOwner());//将屏幕显示在屏幕中心
		
		//面板属性	
		pInput=new JPanel();
   		pInput.setBounds(0, 0, 800, 600);//设置组件位置	
   		pInput.setLayout(null);//全局化
   		 // 创建编号与编号输入框
        JLabel NumLable = new JLabel("课程编号："+cinfo.getCid());
        NumLable.setBounds(250, 30, 300, 30);
        NumLable.setFont(new Font("微软雅黑", 0, 18));

           // 创建课程名与课程名输入框
        JLabel NameLable = new JLabel("课程名："+cinfo.getCname());
        NameLable.setBounds(250, 80, 300, 30);
        NameLable.setFont(new Font("微软雅黑", 0, 18));

        // 创建教师与教师输入框
           JLabel teacher = new JLabel("教师："+cinfo.getTname());
        teacher.setBounds(250, 130, 300, 15);
        teacher.setFont(new Font("微软雅黑", 0, 18));

    	// 创建时间与时间输入框
           JLabel time = new JLabel("时间："+cinfo.getTime());
        time.setBounds(250, 180, 300, 30);;
        time.setFont(new Font("微软雅黑", 0, 18));

       // 创建地点与地点输入框
        JLabel address = new JLabel("地点："+cinfo.getAddress());
       address.setBounds(250, 230, 300, 30);;
       address.setFont(new Font("微软雅黑", 0, 18));

          // 创建课程性质框
          JLabel xz = new JLabel("课程性质："+cinfo.getChat());
          xz.setBounds(250, 280, 300, 30);;
          xz.setFont(new Font("微软雅黑",0, 18));

          // 创建学  时与学  时输入框
  		   JLabel xs = new JLabel("学  时："+cinfo.getStutime());   		   		
  		   xs.setBounds(250, 330, 300, 30);;
  		   xs.setFont(new Font("微软雅黑", 0, 18));

  	       // 创建额定人数与额定人数输入框
  		   JLabel edrs = new JLabel("额定人数："+cinfo.getEdnum());
  		   edrs.setBounds(250, 380, 300, 30);; 
  		  edrs.setFont(new Font("微软雅黑", 0, 18));

  	       // 创建已选人数与已选人数输入框
  		   JLabel yxrs = new JLabel("已选人数："+cinfo.getYxnum());
           yxrs.setBounds(250, 430, 300, 30);;
           yxrs.setFont(new Font("微软雅黑", 0, 18));
           
         //创建修改按钮
     		JButton modify=new JButton("修改");
     		modify.setBounds(300, 480, 65, 30);
     		modify.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					pInput_modify.setVisible(true);
					pInput.setVisible(false);
					
				}
     			
     		});
     		//创建返回按钮
     		JButton back=new JButton("返回");
     		back.setBounds(380, 480, 65, 30);
     		back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					
				}	
     		});
     		//创建删除按钮
     		JButton delete=new JButton("删除");
     		delete.setBounds(220, 480, 65, 30);
     		delete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					pInput_detele.setVisible(true);
					pInput.setVisible(false);
					
				}	
     		});
     	pInput.add(back);
     	pInput.add(delete);
     	pInput.add(modify);
   		pInput.add(NumLable);
  		pInput.add(NameLable);
  		pInput.add(teacher);
  		pInput.add(time);
  		pInput.add(address);
  		pInput.add(xz);
  		pInput.add(xs);
  		pInput.add(edrs);
  		pInput.add(yxrs);
  		frame.add(pInput_modify=(JPanel)modify(cinfo) );
  		frame.add(pInput_detele=(JPanel)delete(cinfo) );
  		frame.add(pInput);
  		frame.setVisible(true);
   		
	}
	//修改面板
	public JPanel modify(course cinfo) {
		pInput_modify = new JPanel();	
		pInput_modify.setBounds(0, 0, 800, 600);//设置组件位置	
		pInput_modify.setLayout(null);//全局化
   		
   	 // 创建编号与编号输入框
        JLabel NumLable = new JLabel("课程编号：");
        NumLable.setBounds(250, 30, 100, 30);
        NumLable.setFont(new Font("微软雅黑", 0, 18));
        
        JTextField NumTextField = new JTextField(cinfo.getCid());
   		NumTextField.setBounds(360, 30, 100, 30);
   		String ys_cid=NumTextField.getText();
           // 创建课程名与课程名输入框
        JLabel NameLable = new JLabel("课程名：");
        NameLable.setBounds(250, 80, 100, 30);
        NameLable.setFont(new Font("微软雅黑", 0, 18));
        
        JTextField NameTextField = new JTextField(cinfo.getCname());
   		NameTextField.setBounds(360, 80, 100, 30);

        // 创建教师与教师输入框
           JLabel teacher = new JLabel("教师：");
        teacher.setBounds(250, 130, 100, 15);
        teacher.setFont(new Font("微软雅黑", 0, 18));
        
    	JTextField teacherTextField = new JTextField(cinfo.getTname());
   		teacherTextField.setBounds(360, 130, 100, 30);

    	// 创建时间与时间输入框
           JLabel time = new JLabel("时间：");
        time.setBounds(250, 180, 100, 30);;
        time.setFont(new Font("微软雅黑", 0, 18));
        
        JTextField timeTextField = new JTextField(cinfo.getTime());
		timeTextField.setBounds(360, 180, 100, 30);

       // 创建地点与地点输入框
        JLabel address = new JLabel("地点：");
       address.setBounds(250, 230, 100, 30);;
       address.setFont(new Font("微软雅黑", 0, 18));
       
       JTextField addressTextField = new JTextField(cinfo.getAddress());
  		addressTextField.setBounds(360, 230, 100, 30);

          // 创建课程性质框
          JLabel xz = new JLabel("课程性质：");
          xz.setBounds(250, 280, 100, 30);;
          xz.setFont(new Font("微软雅黑",0, 18));
          
        //创建课程性质容器
     		JComboBox<String> xz_box=new JComboBox<>();
     		xz_box.addItem("专业课");
     		xz_box.addItem("教育通识课");
     		xz_box.setBounds(360, 280, 100, 30);

          // 创建学  时与学  时输入框
  		   JLabel xs = new JLabel("学  时：");   		   		
  		   xs.setBounds(250, 330, 100, 30);;
  		   xs.setFont(new Font("微软雅黑", 0, 18));	 
  		   
  		 JTextField xsTextField = new JTextField(cinfo.getStutime());
    		xsTextField.setBounds(360, 330, 100, 30);

  	       // 创建额定人数与额定人数输入框
  		   JLabel edrs = new JLabel("额定人数：");
  		   edrs.setBounds(250, 380, 100, 30);; 
  		  edrs.setFont(new Font("微软雅黑", 0, 18));
  		  
  		JTextField edrsTextField = new JTextField(Integer.toString(cinfo.getEdnum()));
   		edrsTextField.setBounds(360, 380, 100, 30);

  	       // 创建已选人数与已选人数输入框
  		   JLabel yxrs = new JLabel("已选人数：");
           yxrs.setBounds(250, 430, 100, 30);;
           yxrs.setFont(new Font("微软雅黑", 0, 18));
        
           JTextField yxrsTextField = new JTextField( Integer.toString(cinfo.getYxnum()));
      		yxrsTextField.setBounds(360, 430, 100, 30);
   		//***************************************************
      		//创建返回按钮
      		JButton back=new JButton("返回");
      		back.setBounds(380, 480, 65, 30);
      		back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					pInput_modify.setVisible(false);
					pInput.setVisible(true);
					
				}
      			
      		});
      		
      		//创建确定按钮
      		JButton yes=new JButton("确定");
      		yes.setBounds(300, 480, 65, 30);
      		yes.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//将修改内容重新给cinfo赋值
					cinfo.setCid(NumTextField.getText());
					cinfo.setCname(NameTextField.getText());
					cinfo.setTname(teacherTextField.getText());
					cinfo.setTime(timeTextField.getText());
					cinfo.setAddress(addressTextField.getText());
					cinfo.setChat(xz_box.getSelectedItem().toString());
					cinfo.setStutime(xsTextField.getText());
					cinfo.setEdnum(Integer.parseInt(edrsTextField.getText()));
					cinfo.setYxnum(Integer.parseInt(yxrsTextField.getText()));
					
					updateSql file=new updateSql();
					if(file.update_course(frame,cinfo,ys_cid)) {
						for(int j = 0;j < table.getRowCount();j ++){
						//获得删除时选择的ID在JTABLE中的行号

						if(table.getValueAt(j, 0).equals(cinfo.getCid())){

						int selIndex = j;

						if( selIndex < 0 || selIndex >=table.getRowCount() ){

						return ;

						}

						//刷新

						model.fireTableDataChanged();

						break;
						

						}

						}
						
						frame.dispose();
						display(cinfo,table,model);
					}
					
					
				}
      			
      		});
      	pInput_modify.add(back);
      	pInput_modify.add(yes);
      	pInput_modify.add(NumLable);
      	pInput_modify.add(NumTextField);
      	pInput_modify.add(NameLable);
      	pInput_modify.add(NameTextField);
      	pInput_modify.add(teacher);
  		pInput_modify.add(teacherTextField);
  		pInput_modify.add(time);
  		pInput_modify.add(timeTextField);
  		pInput_modify.add(address);
  		pInput_modify.add(addressTextField);
  		pInput_modify.add(xz);
  		pInput_modify.add(xz_box);
  		pInput_modify.add(xs);
  		pInput_modify.add(xsTextField);
  		pInput_modify.add(edrs);
  		pInput_modify.add(edrsTextField);
  		pInput_modify.add(yxrs);
  		pInput_modify.add(yxrsTextField);
  		pInput_modify.setVisible(false);
		return pInput_modify;
		
	}
    
	//删除面板
	public JPanel delete(course cinfo) {
		pInput_detele=new JPanel();
		pInput_detele.setBounds(0, 0, 800, 600);//设置组件位置	
		pInput_detele.setLayout(null);//全局化
		
		//创建ensure jLabel 
		JLabel ensure = new JLabel("请确定是否删除课程："+cinfo.getCname());
		ensure.setBounds(230, 100, 350, 30);
		ensure.setFont(new Font("微软雅黑", 0, 20));
		
		//创建确认按钮
		JButton yes=new JButton("确认");
		yes.setBounds(300, 200, 65, 30);
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteSql delete=new deleteSql();				
				if(delete.delete_course(frame, cinfo)) {
					for(int j = 0;j < table.getRowCount();j ++){
						

						//获得删除时选择的ID在JTABLE中的行号

						if(table.getValueAt(j, 0).equals(cinfo.getCid())){

						int selIndex = j;

						if( selIndex < 0 || selIndex >=table.getRowCount() ){

						return ;

						}
						//删除这一行

						model.removeRow(selIndex) ;

						//刷新

						model.fireTableDataChanged();

						break;
						

						}

						}
						
					frame.dispose();
				}
			}
			
		});
		
		//创建取消按钮
		JButton no=new JButton("取消");
		no.setBounds(380, 200, 65, 30);
		no.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pInput_detele.setVisible(false);
				pInput.setVisible(true);
			}
			
		});
		
		pInput_detele.add(ensure);
		pInput_detele.add(yes);
		pInput_detele.add(no);
		pInput_detele.setVisible(false);
		
		return pInput_detele;}
}
