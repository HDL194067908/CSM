package work;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.course;

public class deleteSql {
	//ɾ���γ���Ϣ
	public boolean delete_course(JFrame frame,course cinfo) {
		connetsql c = new connetsql();    //�������෽��
	  	  Connection con =(Connection) c.getConnection();//�����������ݿ�ķ���
	  	  String sql = "delete from class where cid=?";
	  	   
	  	   
	  	try {
	  		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	  		ps.setString(1, cinfo.getCid());
	  		
	  		
	  		int i=ps.executeUpdate();
	  		
	  	//����γ���Ϣɾ���ɹ��򷵻�true
      if (i>0) {
      	JOptionPane.showMessageDialog(frame,  "ɾ���ɹ��ɹ���");
          ps.close();
          return true;}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "ɾ������");
			JOptionPane.showMessageDialog(frame, e.getMessage());
			
			// e.printStackTrace();
		} finally {
			c.close(con);
		}
	  	return false;
	}
	

}
