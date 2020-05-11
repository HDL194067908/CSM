package work;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.course;

public class deleteSql {
	//删除课程信息
	public boolean delete_course(JFrame frame,course cinfo) {
		connetsql c = new connetsql();    //创建本类方法
	  	  Connection con =(Connection) c.getConnection();//调用连接数据库的方法
	  	  String sql = "delete from class where cid=?";
	  	   
	  	   
	  	try {
	  		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	  		ps.setString(1, cinfo.getCid());
	  		
	  		
	  		int i=ps.executeUpdate();
	  		
	  	//如果课程信息删除成功则返回true
      if (i>0) {
      	JOptionPane.showMessageDialog(frame,  "删除成功成功！");
          ps.close();
          return true;}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "删除错误！");
			JOptionPane.showMessageDialog(frame, e.getMessage());
			
			// e.printStackTrace();
		} finally {
			c.close(con);
		}
	  	return false;
	}
	

}
