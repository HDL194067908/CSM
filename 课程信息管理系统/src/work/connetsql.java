package work;
import java.sql.*;     //����java.sql��
public class connetsql {//����connetsql�࣬��֤�ļ�����������ͬ
          Connection con;//����Connection����
          Statement sql;
          ResultSet res;
          public Connection getConnection() {  //��������ֵΪConnection�ķ���
        	  try {        //�������ݿ�������
        		  Class.forName("com.mysql.jdbc.Driver");
        		  System.out.println("���ݿ��������سɹ�");
        	  }catch(ClassNotFoundException e){
        		  e.printStackTrace();
        	  }
        	  try {
        		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/courseinfomation",
        				  "root","970612");//ͨ���������ݿ��URL��ȡ���ݿ����Ӷ���
        		  System.out.println("���ݿ����ӳɹ�");
        	  }catch(SQLException e) {
        		  e.printStackTrace();
        	  }
        	  return con;//������Ҫ�󷵻�һ��Connection����
          }
          public void close(Connection con) {
      		if (con != null) {
      			try {
      				con.close();
      			} catch (SQLException e) {
      				e.printStackTrace();
      			}
      		}
      	}

      
          
}
