import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import beans.Employee;

public class MainApp {
	public static void main(String [] args) {
		
		//System.out.println("Hello app");
		try {
			Connection con = TestConnection();
			List<Employee> list =  GetProducts(con);
			System.out.println("-------List employees---------");
			for (Employee item : list) {
				System.out.println(item);
			}
		} catch (Exception e) {
			System.out.println("Bad connection");
		}
		
	}
	private static Connection TestConnection() 
			throws SQLException, ClassNotFoundException
	{
		String hostName = "localhost";
		String dbName = "montanadb";
		String userName = "montana";
		String password = "123456";
		
		
			Class.forName("org.mariadb.jdbc.Driver");
			String connectionURL = "jdbc:mariadb://" + hostName + ":3306/" + dbName;
			Connection conn = DriverManager.getConnection(connectionURL, userName, password);
			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}
			return conn;

//		} catch (SQLException e) {
//			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//
//		} catch (Exception ex) {
//			System.out.println("Problem connect jdbc maria db");
//		}
//		return null;
	}
	
	private static List<Employee> GetProducts(Connection conn)
			throws SQLException {
		List<Employee> result = new ArrayList<Employee>();

        String SQL_SELECT = "Select * from tbl_employees";
        
        PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);

        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {

            long id = resultSet.getLong("ID");
            String name = resultSet.getString("NAME");
            BigDecimal salary = resultSet.getBigDecimal("SALARY");
            Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");

            Employee obj = new Employee();
            obj.setId(id);
            obj.setName(name);
            obj.setSalary(salary);
            // Timestamp -> LocalDateTime
            obj.setCreatedDate(createdDate.toLocalDateTime());

            result.add(obj);
            
        }
        return result;
	}
}
