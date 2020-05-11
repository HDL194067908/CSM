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
		//������Ϣ
		frame=new JFrame();
		frame.setSize(800,600);	
		frame.setTitle("�γ���Ϣ"); //���ô������Ͻ�����	
		frame.setLayout(new BorderLayout());//���ȫ�ֻ�
		frame.setResizable(false);//��Ϊ���������岻�洰�ڶ�̬�仯��С�����Խ�ֹ�˴��ڱ仯��С
		frame.setLocationRelativeTo(getOwner());//����Ļ��ʾ����Ļ����
		
		//�������	
		pInput=new JPanel();
   		pInput.setBounds(0, 0, 800, 600);//�������λ��	
   		pInput.setLayout(null);//ȫ�ֻ�
   		 // ����������������
        JLabel NumLable = new JLabel("�γ̱�ţ�"+cinfo.getCid());
        NumLable.setBounds(250, 30, 300, 30);
        NumLable.setFont(new Font("΢���ź�", 0, 18));

           // �����γ�����γ��������
        JLabel NameLable = new JLabel("�γ�����"+cinfo.getCname());
        NameLable.setBounds(250, 80, 300, 30);
        NameLable.setFont(new Font("΢���ź�", 0, 18));

        // ������ʦ���ʦ�����
           JLabel teacher = new JLabel("��ʦ��"+cinfo.getTname());
        teacher.setBounds(250, 130, 300, 15);
        teacher.setFont(new Font("΢���ź�", 0, 18));

    	// ����ʱ����ʱ�������
           JLabel time = new JLabel("ʱ�䣺"+cinfo.getTime());
        time.setBounds(250, 180, 300, 30);;
        time.setFont(new Font("΢���ź�", 0, 18));

       // �����ص���ص������
        JLabel address = new JLabel("�ص㣺"+cinfo.getAddress());
       address.setBounds(250, 230, 300, 30);;
       address.setFont(new Font("΢���ź�", 0, 18));

          // �����γ����ʿ�
          JLabel xz = new JLabel("�γ����ʣ�"+cinfo.getChat());
          xz.setBounds(250, 280, 300, 30);;
          xz.setFont(new Font("΢���ź�",0, 18));

          // ����ѧ  ʱ��ѧ  ʱ�����
  		   JLabel xs = new JLabel("ѧ  ʱ��"+cinfo.getStutime());   		   		
  		   xs.setBounds(250, 330, 300, 30);;
  		   xs.setFont(new Font("΢���ź�", 0, 18));

  	       // ��������������������
  		   JLabel edrs = new JLabel("�������"+cinfo.getEdnum());
  		   edrs.setBounds(250, 380, 300, 30);; 
  		  edrs.setFont(new Font("΢���ź�", 0, 18));

  	       // ������ѡ��������ѡ���������
  		   JLabel yxrs = new JLabel("��ѡ������"+cinfo.getYxnum());
           yxrs.setBounds(250, 430, 300, 30);;
           yxrs.setFont(new Font("΢���ź�", 0, 18));
           
         //�����޸İ�ť
     		JButton modify=new JButton("�޸�");
     		modify.setBounds(300, 480, 65, 30);
     		modify.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					pInput_modify.setVisible(true);
					pInput.setVisible(false);
					
				}
     			
     		});
     		//�������ذ�ť
     		JButton back=new JButton("����");
     		back.setBounds(380, 480, 65, 30);
     		back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					
				}	
     		});
     		//����ɾ����ť
     		JButton delete=new JButton("ɾ��");
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
	//�޸����
	public JPanel modify(course cinfo) {
		pInput_modify = new JPanel();	
		pInput_modify.setBounds(0, 0, 800, 600);//�������λ��	
		pInput_modify.setLayout(null);//ȫ�ֻ�
   		
   	 // ����������������
        JLabel NumLable = new JLabel("�γ̱�ţ�");
        NumLable.setBounds(250, 30, 100, 30);
        NumLable.setFont(new Font("΢���ź�", 0, 18));
        
        JTextField NumTextField = new JTextField(cinfo.getCid());
   		NumTextField.setBounds(360, 30, 100, 30);
   		String ys_cid=NumTextField.getText();
           // �����γ�����γ��������
        JLabel NameLable = new JLabel("�γ�����");
        NameLable.setBounds(250, 80, 100, 30);
        NameLable.setFont(new Font("΢���ź�", 0, 18));
        
        JTextField NameTextField = new JTextField(cinfo.getCname());
   		NameTextField.setBounds(360, 80, 100, 30);

        // ������ʦ���ʦ�����
           JLabel teacher = new JLabel("��ʦ��");
        teacher.setBounds(250, 130, 100, 15);
        teacher.setFont(new Font("΢���ź�", 0, 18));
        
    	JTextField teacherTextField = new JTextField(cinfo.getTname());
   		teacherTextField.setBounds(360, 130, 100, 30);

    	// ����ʱ����ʱ�������
           JLabel time = new JLabel("ʱ�䣺");
        time.setBounds(250, 180, 100, 30);;
        time.setFont(new Font("΢���ź�", 0, 18));
        
        JTextField timeTextField = new JTextField(cinfo.getTime());
		timeTextField.setBounds(360, 180, 100, 30);

       // �����ص���ص������
        JLabel address = new JLabel("�ص㣺");
       address.setBounds(250, 230, 100, 30);;
       address.setFont(new Font("΢���ź�", 0, 18));
       
       JTextField addressTextField = new JTextField(cinfo.getAddress());
  		addressTextField.setBounds(360, 230, 100, 30);

          // �����γ����ʿ�
          JLabel xz = new JLabel("�γ����ʣ�");
          xz.setBounds(250, 280, 100, 30);;
          xz.setFont(new Font("΢���ź�",0, 18));
          
        //�����γ���������
     		JComboBox<String> xz_box=new JComboBox<>();
     		xz_box.addItem("רҵ��");
     		xz_box.addItem("����ͨʶ��");
     		xz_box.setBounds(360, 280, 100, 30);

          // ����ѧ  ʱ��ѧ  ʱ�����
  		   JLabel xs = new JLabel("ѧ  ʱ��");   		   		
  		   xs.setBounds(250, 330, 100, 30);;
  		   xs.setFont(new Font("΢���ź�", 0, 18));	 
  		   
  		 JTextField xsTextField = new JTextField(cinfo.getStutime());
    		xsTextField.setBounds(360, 330, 100, 30);

  	       // ��������������������
  		   JLabel edrs = new JLabel("�������");
  		   edrs.setBounds(250, 380, 100, 30);; 
  		  edrs.setFont(new Font("΢���ź�", 0, 18));
  		  
  		JTextField edrsTextField = new JTextField(Integer.toString(cinfo.getEdnum()));
   		edrsTextField.setBounds(360, 380, 100, 30);

  	       // ������ѡ��������ѡ���������
  		   JLabel yxrs = new JLabel("��ѡ������");
           yxrs.setBounds(250, 430, 100, 30);;
           yxrs.setFont(new Font("΢���ź�", 0, 18));
        
           JTextField yxrsTextField = new JTextField( Integer.toString(cinfo.getYxnum()));
      		yxrsTextField.setBounds(360, 430, 100, 30);
   		//***************************************************
      		//�������ذ�ť
      		JButton back=new JButton("����");
      		back.setBounds(380, 480, 65, 30);
      		back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					pInput_modify.setVisible(false);
					pInput.setVisible(true);
					
				}
      			
      		});
      		
      		//����ȷ����ť
      		JButton yes=new JButton("ȷ��");
      		yes.setBounds(300, 480, 65, 30);
      		yes.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//���޸��������¸�cinfo��ֵ
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
						//���ɾ��ʱѡ���ID��JTABLE�е��к�

						if(table.getValueAt(j, 0).equals(cinfo.getCid())){

						int selIndex = j;

						if( selIndex < 0 || selIndex >=table.getRowCount() ){

						return ;

						}

						//ˢ��

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
    
	//ɾ�����
	public JPanel delete(course cinfo) {
		pInput_detele=new JPanel();
		pInput_detele.setBounds(0, 0, 800, 600);//�������λ��	
		pInput_detele.setLayout(null);//ȫ�ֻ�
		
		//����ensure jLabel 
		JLabel ensure = new JLabel("��ȷ���Ƿ�ɾ���γ̣�"+cinfo.getCname());
		ensure.setBounds(230, 100, 350, 30);
		ensure.setFont(new Font("΢���ź�", 0, 20));
		
		//����ȷ�ϰ�ť
		JButton yes=new JButton("ȷ��");
		yes.setBounds(300, 200, 65, 30);
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteSql delete=new deleteSql();				
				if(delete.delete_course(frame, cinfo)) {
					for(int j = 0;j < table.getRowCount();j ++){
						

						//���ɾ��ʱѡ���ID��JTABLE�е��к�

						if(table.getValueAt(j, 0).equals(cinfo.getCid())){

						int selIndex = j;

						if( selIndex < 0 || selIndex >=table.getRowCount() ){

						return ;

						}
						//ɾ����һ��

						model.removeRow(selIndex) ;

						//ˢ��

						model.fireTableDataChanged();

						break;
						

						}

						}
						
					frame.dispose();
				}
			}
			
		});
		
		//����ȡ����ť
		JButton no=new JButton("ȡ��");
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
