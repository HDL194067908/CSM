package work;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import GUI.work_window;
import entity.course;
import entity.schedule;
import entity.work;

public class queryInfo {

	//��¼��Ϣ��֤
	public void landinfo(JFrame frame,String userType,JTextField userText,JPasswordField pwText) {
		//�û���֤�ɹ�Ϊtrue������false
		boolean flag=false;
		boolean flag1=false;
		  connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	String sql = "select ID,password from user";
	  	String Ssql = "select sid from student";
	  	String Tsql = "select tid from teacher";
		try {
			//��֤ѧ�����Ƿ�����û�
			if(userType.equals("Student")) {
				   PreparedStatement Sps = (PreparedStatement) con.prepareStatement(Ssql);
			       ResultSet Srs = Sps.executeQuery();
			       while (Srs.next()) {if(userText.getText().equals(Srs.getString("sid"))) flag1=true; }}
			//��֤��ʦ���Ƿ�����û�
			if(userType.equals("Teacher")) {
				   PreparedStatement Tps = (PreparedStatement) con.prepareStatement(Tsql);
			       ResultSet Trs = Tps.executeQuery();
			       while (Trs.next()) {if(userText.getText().equals(Trs.getString("tid"))) flag1=true; }}
			//������û�����֤����
			if(flag1) {
	       PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	       ResultSet rs = ps.executeQuery();
	       while (rs.next()) {
		          if(userText.getText().equals(rs.getString("ID"))&&pwText.getText().equals(rs.getString("password"))) {
		        	  flag=true;
		        	  work_window work=new work_window();
		  			  work.work(userType,userText.getText());
		  			  frame.dispose();
		          }
		         
	           }}
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(frame, e.getMessage());
	       
	      } finally {
	         c.close(con);
	}
		if(!flag) {
			JOptionPane.showMessageDialog(frame, "�û������ڻ����������");
		}

	}
    //���ҿγ���Ϣ
	public course search(JFrame claINfo,JTextField numText) {
		     course couinfo=new course();
		
		      //�γ̴���Ϊtrue������false
				 boolean flag=false;
				  connetsql c = new connetsql();    //�������෽��
			  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
			  	String sql = "select * from class where cid =?";
				try {
			       PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			       ps.setString(1, numText.getText());
			       ResultSet rs = ps.executeQuery();
			       
			       
			       while (rs.next()) {
			    	   couinfo.setCid(rs.getString(1));
			    	   
			    	   couinfo.setCname(rs.getString(3));   
			    	   couinfo.setTname(rs.getString(4)); 
			    	   couinfo.setTime(rs.getString(5));
			    	   couinfo.setAddress(rs.getString(6));
			    	   couinfo.setChat(rs.getString(7));
			    	   couinfo.setStutime(rs.getString(8));
			    	   couinfo.setEdnum(Integer.parseInt(rs.getString(9)));
			    	   couinfo.setYxnum(Integer.parseInt(rs.getString(10)));
			    	   flag=true;
			           }
			        } catch (SQLException e) {
			        	JOptionPane.showMessageDialog(claINfo, e.getMessage());
			       
			      } finally {
			         c.close(con);
			}
				if(!flag) {
					JOptionPane.showMessageDialog(claINfo, "�γ̱�Ų����ڣ�");
				}	
		return couinfo;
	}
    //��������Ϣ��ӡ�����
	public ArrayList<work> search_wifo(JFrame frame) {
		connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	String sql = "select * from work";
		try {
	       PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	       ResultSet rs = ps.executeQuery();
	       ArrayList<work> list = new ArrayList<work>();
	       while (rs.next()) {
	    	   work winfo=new work();
	    	   winfo.setHID(rs.getString(1));  
	    	   winfo.setClass1(rs.getString(2));
	    	   winfo.setCname(rs.getString(3)); 
	    	   winfo.setContent(rs.getString(4));
	    	   winfo.setTime1(rs.getString(5));
	    	   winfo.setTime2(rs.getString(6));
	    	   list.add(winfo);
	           }
	       return list;
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(frame, e.getMessage());
	        	return null;
	       
	      } finally {
	         c.close(con);}
	
	}
  
	//��ѧ���α���Ϣ��ӡ�����
	public ArrayList<schedule> search_Scinfo(JFrame frame,String user) {
		
		connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	String Ssql = "select * from schedule where sid=?";
		try {
	       PreparedStatement Sps = (PreparedStatement) con.prepareStatement(Ssql);
	       Sps.setString(1, user);
	       ResultSet rs = Sps.executeQuery();
	       ArrayList<schedule> list = new ArrayList<schedule>();
	       while (rs.next()) {
	    	   schedule couinfo=new schedule();
	    	   couinfo.setCname(rs.getString(3));   
	    	   couinfo.setTname(rs.getString(4)); 
	    	   couinfo.setTime(rs.getString(5));
	    	   couinfo.setAddress(rs.getString(6));
	    	   list.add(couinfo);
	           }
	       return list;
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(frame, e.getMessage());
	        	return null;
	       
	      } finally {
	         c.close(con);}
	
}

	//���γ���Ϣ��ӡ�����
	public ArrayList  search_course(JFrame frame) {
		
	
			  connetsql c = new connetsql();    //�������෽��
		  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
		  	String sql = "select * from class";
			try {
		       PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		       ResultSet rs = ps.executeQuery();
		       ArrayList<course> list = new ArrayList<course>();
		       while (rs.next()) {
		    	   course couinfo=new course();
		    	   couinfo.setCid(rs.getString(1));
		    	   couinfo.setSid(rs.getString(2));
		    	   couinfo.setCname(rs.getString(3));   
		    	   couinfo.setTname(rs.getString(4)); 
		    	   couinfo.setTime(rs.getString(5));
		    	   couinfo.setAddress(rs.getString(6));
		    	   couinfo.setChat(rs.getString(7));
		    	   couinfo.setStutime(rs.getString(8));
		    	   couinfo.setEdnum(Integer.parseInt(rs.getString(9)));
		    	   couinfo.setYxnum(Integer.parseInt(rs.getString(10)));
		    	   list.add(couinfo);
		           }
		       return list;
		        } catch (SQLException e) {
		        	JOptionPane.showMessageDialog(frame, e.getMessage());
		        	return null;
		       
		      } finally {
		         c.close(con);}
		
	}

    //����ʦ�α��ӡ�����
    public ArrayList<course> search_Tcinfo(JFrame frame,String user) {
		
		connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	String Ssql = "select * from class where tid=?";
		try {
	       PreparedStatement Sps = (PreparedStatement) con.prepareStatement(Ssql);
	       Sps.setString(1, user);
	       ResultSet rs = Sps.executeQuery();
	       ArrayList<course> list = new ArrayList<course>();
	       while (rs.next()) {
	    	   course couinfo=new course();
	    	   couinfo.setCname(rs.getString(3));    
	    	   couinfo.setTime(rs.getString(5));
	    	   couinfo.setAddress(rs.getString(6));
	    	   list.add(couinfo);
	           }
	       return list;
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(frame, e.getMessage());
	        	return null;
	       
	      } finally {
	         c.close(con);}
	
}

}
