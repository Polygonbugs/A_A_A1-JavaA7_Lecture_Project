package kr.co.main;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class OracleConnection {
// spring 때는 사용되지 않는다고 한다.
    public static SqlSession getSqlSession() {
        SqlSession sess = null;

        // Resources.getResourceAsStream(resource 디렉토리에서 mybatis 설정이 있는 디렉토리)
        try(InputStream is = Resources.getResourceAsStream("mybatis/mybatis-config.xml")) {
            // SqlSessionFactoryBuilder(is, "development") : 세션을 만드는 함수.
            // 매개변수 is : InputStream 객체에 데이터를 저장한다.
            // 매개변수 "development" : SQL 세션을 "mybatis/mybatis-config.xml"에 있는 <environments default = "development"> 의 연결 환경을 사용하여 만든다.
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is, "development");
            sess = factory.openSession(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sess;
    }
    public static void main(String[] args) {
        SqlSession session = OracleConnection.getSqlSession();
        // sessioon.selectOne(mapper_namespace.SQL_ID)
        // 문제가 생길 경우 오타 의심 -> pom.xml쪽 mapper 참고
        String res = session.selectOne("test.hello");
        System.out.println(res);
        session.close();
    }
}
