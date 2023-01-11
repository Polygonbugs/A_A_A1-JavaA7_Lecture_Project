package database.connect;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class OracleConnection {

	public static SqlSession getSqlSession() {
		SqlSession sess = null;
		
		try(InputStream is = Resources.getResourceAsStream("resources/mybatis-config.xml")) {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			sess = factory.openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sess;
	}
	
}
