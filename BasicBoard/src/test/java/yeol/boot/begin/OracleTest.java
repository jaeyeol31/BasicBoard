package yeol.boot.begin;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class OracleTest {

//			spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
//			spring.datasource.url=jdbc:oracle:thin:@127.0.0.1:1521:xe
//			spring.datasource.username=basicBoard
//			spring.datasource.password=1234

	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static final String USER = "basicBoard";
	private static final String PASSWORD = "1234";

	@Test
	public void testDataBaseConnection() {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
