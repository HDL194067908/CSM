package work;
import java.sql.*;     //导入java.sql包
public class connetsql {//创建connetsql类，保证文件名与类名相同
          Connection con;//声明Connection对象
          Statement sql;
          ResultSet res;
          public Connection getConnection() {  //建立返回值为Connection的方法
        	  try {        //加载数据库驱动类
        		  Class.forName("com.mysql.jdbc.Driver");
        		  System.out.println("数据库驱动加载成功");
        	  }catch(ClassNotFoundException e){
        		  e.printStackTrace();
        	  }
        	  try {
        		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/courseinfomation",
        				  "root","970612");//通过访问数据库的URL获取数据库连接对象
        		  System.out.println("数据库连接成功");
        	  }catch(SQLException e) {
        		  e.printStackTrace();
        	  }
        	  return con;//按方法要求返回一个Connection对象
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
