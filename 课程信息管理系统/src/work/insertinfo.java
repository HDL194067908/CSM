package work;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.course;

public class insertinfo {

	//����ʦ��Ϣ������ݿ�
	public boolean net_ter_info(JFrame terFrame,String ID ,String password ,String name ,String sex ,String school ,String phone ,
			String subject) {
		
		  connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	  String sql = "insert into user values(?,?,?,?,?,?)";
	  	   String tsql = "insert into teacher values(?,?)";
	  	   
	  	try {
	  		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	  		ps.setString(1, ID);
	  		ps.setString(2, password);
	  		ps.setString(3, name);
	  		ps.setString(4, sex);	  		
	  		ps.setString(5, school);
	  		ps.setString(6, phone);
	  		int i=ps.executeUpdate();
	  		PreparedStatement tps = (PreparedStatement) con.prepareStatement(tsql);
	  		tps.setString(1, ID);
	  		tps.setString(2, subject);
	  		int j=tps.executeUpdate();
	  	//����û������ʦ�����ɹ��򷵻�true
            if (i>0&&j>0) {
            	JOptionPane.showMessageDialog(terFrame,  "ע��ɹ�");
                ps.close();
                tps.close();
                return true;}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(terFrame, "��ȷ����Ϣ��д�Ƿ���ȷ");
			//if(e.getMessage().equals("Duplicate entry"+"'"+ID+"'"+"for PRIMARY")) {JOptionPane.showMessageDialog(terFrame, ID+"�ѱ�ע��");}
			JOptionPane.showMessageDialog(terFrame, e.getMessage());
			
			// e.printStackTrace();
		} finally {
			c.close(con);
		}
	  	return false;
	  	
	}
	//��ѧ����Ϣ������ݿ�
	public boolean net_stu_info(JFrame stuFrame,String ID ,String password ,String name ,String sex ,String school ,String phone ,
				String subject,String classes,String date) {
			
			connetsql c = new connetsql();    //�������෽��
		  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
		  	  String sql = "insert into user values(?,?,?,?,?,?)";
		  	String ssql = "insert into student values(?,?,?,?)";
		  	
		  	
		  	try {
		  		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		  		ps.setString(1, ID);
		  		ps.setString(2, password);
		  		ps.setString(3, name);
		  		ps.setString(4, sex);	  		
		  		ps.setString(5, school);
		  		ps.setString(6, phone);
		  		int i=ps.executeUpdate();
		  		
		  		PreparedStatement sps = (PreparedStatement) con.prepareStatement(ssql);
		  		sps.setString(1, ID);
		  		sps.setString(2, subject);
		  		sps.setString(3, classes);
		  		sps.setString(4, date);
		  		int j=sps.executeUpdate();
		  		//����û�����ѧ�������ɹ��򷵻�true
	            if (i>0&&j>0) {
	            	JOptionPane.showMessageDialog(stuFrame,  "ע��ɹ�");
	                ps.close();
	                sps.close();
	                return true;}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(stuFrame, "��ȷ����Ϣ��д�Ƿ���ȷ");
				JOptionPane.showMessageDialog(stuFrame, e.getMessage());
				
				// e.printStackTrace();
			} finally {
				c.close(con);
			}
		  	return false;
		  	
		}
    //���γ���Ϣ������ݿ�
	public boolean net_cour_info(JFrame frame,String sid,String tid,String Name,String teacher,String time,String address,String xz,String xs,int edrs,int yxrs) {
		connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	  String sql = "insert into class values(?,?,?,?,?,?,?,?,?,?)";
	  	   
	  	   
	  	try {
	  		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	  		ps.setString(1, sid);
	  		ps.setString(2, tid);
	  		ps.setString(3, Name);
	  		ps.setString(4, teacher);	  		
	  		ps.setString(5, time);
	  		ps.setString(6, address);
	  		ps.setString(7, xz);
	  		ps.setString(8, xs);
	  		ps.setInt(9, edrs);
	  		ps.setInt(10, yxrs);
	  		int i=ps.executeUpdate();
	  		
	  	//����γ���Ϣ����ɹ��򷵻�true
          if (i>0) {
          	JOptionPane.showMessageDialog(frame,  "��ӳɹ�");
              ps.close();
              return true;}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "��ȷ����Ϣ��д�Ƿ���ȷ");
			JOptionPane.showMessageDialog(frame, e.getMessage());
			
			// e.printStackTrace();
		} finally {
			c.close(con);
		}
	  	return false;
	}
    //����ҵ��Ϣ�������ݿ�
	public boolean net_work_info(JFrame frame,String work_no,String class1,String subject,String content,String time1,String time2) {
		  connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	  String sql = "insert into work values(?,?,?,?,?,?)";
	  	   
	  	   
	  	try {
	  		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	  		ps.setString(1, work_no);
	  		ps.setString(2, class1);
	  		ps.setString(3, subject);
	  		ps.setString(4, content);	  		
	  		ps.setString(5, time1);
	  		ps.setString(6, time2);
	  		
	  		int i=ps.executeUpdate();
	  		
	  	//����γ���Ϣ����ɹ��򷵻�true
        if (i>0) {
        	JOptionPane.showMessageDialog(frame,  "�����ɹ���");
            ps.close();
            return true;}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "��ȷ����Ϣ��д�Ƿ���ȷ");
			JOptionPane.showMessageDialog(frame, e.getMessage());
			
			// e.printStackTrace();
		} finally {
			c.close(con);
		}
	  	return false;
	}
    //��ѡ����Ϣ�������ݿ�
	public boolean net_course_info(JFrame frame,String user,course info) {
		  boolean flag = true;
		  connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	  String Cxsql = "select cname from schedule where sid=?";
	  	  try {
	  	   PreparedStatement Cxps = (PreparedStatement) con.prepareStatement(Cxsql);
	  	   Cxps.setString(1, user);
	  	   ResultSet rs = Cxps.executeQuery();
	  	/*����user�Ƿ������ؿγ�
	  	 * �������flag=false
	  	 * ����true
	  	 */
	  	 while(rs.next()){
	  		 if(rs.getString("cname").equals(info.getCname())) {	  			 
	  			flag=false;
	  			break;	  			
	  		 }
	  	 }
	  	 if(flag) {
	  	   String sql = "insert into schedule values(?,?,?,?,?,?)";	   
	  	  
	  		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	  		ps.setString(1, null);
	  		ps.setString(2, user);
	  		ps.setString(3, info.getCname());
	  		ps.setString(4, info.getTname());
	  		ps.setString(5, info.getTime());	  		
	  		ps.setString(6, info.getAddress());
	  		
	  		int i=ps.executeUpdate();
	  		
	  	//����γ���Ϣ����ɹ��򷵻�true
          if (i>0) {
      	    JOptionPane.showMessageDialog(frame,  "ѡ�γɹ���");    	    
      	    //ѡ��������1
      	    info.setYxnum(info.getYxnum()+1);
      	    updateSql up=new updateSql();
      	    up.update_num(frame,info);
            ps.close();
            return true;}}
	  	 if(!false) {
	  		JOptionPane.showMessageDialog(frame, "����ѡ�ÿ��ˣ�");
	  	 }
			
		} catch (SQLException e) {			
			JOptionPane.showMessageDialog(frame, e.getMessage());
			// e.printStackTrace();
		} finally {
			c.close(con);
		}
	  	return false;
	
	}

}
