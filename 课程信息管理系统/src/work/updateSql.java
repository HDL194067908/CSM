package work;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.course;

public class updateSql {

	//��������
	public boolean updatepw(JFrame frame,String user,JPasswordField yspwTextField,JPasswordField newpwTextField) {
		boolean flag = false;
		 connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	String sql = "update user set password =? where ID=? and password = ?";
		try {
	       PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	  		ps.setString(1, newpwTextField.getText());
	  		ps.setString(2, user);
	  		ps.setString(3, yspwTextField.getText());  		
	  		int i=ps.executeUpdate();
	  		if(i>0) {
	  			flag=true;
	  			JOptionPane.showMessageDialog(frame, "�޸ĳɹ��������µ�¼");
	  			return flag;
	  			
	  		}
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(frame, e.getMessage());
	       
	      } finally {
	         c.close(con);
	}
		if(!flag) {
			JOptionPane.showMessageDialog(frame, "ԭ����������������룡");
		}
		return flag;
	}

    //�޸Ŀγ�
	public boolean update_course(JFrame frame ,course cinfo,String ys_cid) {
		boolean flag = false;
		 connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	String sql = "update class set cid=?,cname=?,tname=?,time=?,address=?,chat=?,ednum=?,yxnum=? where cid=?";
		try {
	       PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	  		ps.setString(1, cinfo.getCid());
	  		ps.setString(2, cinfo.getCname());
	  		ps.setString(3, cinfo.getTname()); 
	  		ps.setString(4, cinfo.getTime());
	  	    ps.setString(5, cinfo.getAddress());
	  		ps.setString(6, cinfo.getChat());
	  		ps.setInt(7, cinfo.getEdnum());
	  		ps.setInt(8, cinfo.getYxnum());
	  		ps.setString(9,ys_cid);
	  		int i=ps.executeUpdate();
	  		if(i>0) {
	  			flag=true;
	  			JOptionPane.showMessageDialog(frame, "�޸ĳɹ�");
	  			return flag;
	  			
	  		}
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(frame, e.getMessage());
	       
	      } finally {
	         c.close(con);
	}
		if(!flag) {
			JOptionPane.showMessageDialog(frame, "�޸�ʧ�ܣ�");
		}
		return false;
		
	}
	//������ѡ����
	public void update_num(JFrame frame ,course cinfo) {
		
		 connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	String sql = "update class set yxnum=? where cid=?";
		try {
	       PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	        ps.setInt(1, cinfo.getYxnum());
	  		ps.setString(2, cinfo.getCid());
 		
	  		ps.executeUpdate();
	  		
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(frame, e.getMessage());
	       
	      } finally {
	         c.close(con);	}
	}
}
