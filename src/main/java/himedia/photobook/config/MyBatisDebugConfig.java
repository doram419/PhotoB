package himedia.photobook.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages = "himedia.photobook")  // 패키지 경로 맞추기
public class MyBatisDebugConfig {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void printMappedStatements() {
        if (sqlSessionFactory != null) {
            org.apache.ibatis.session.Configuration myBatisConfig = sqlSessionFactory.getConfiguration(); // 패키지를 명확히 지정
            System.out.println("=== MyBatis 등록된 Mapped Statements 목록 ===");
            for (String mappedStatement : myBatisConfig.getMappedStatementNames()) {
                System.out.println("Mapped Statement: " + mappedStatement);
            }
        } else {
            System.out.println("🚨 SqlSessionFactory가 주입되지 않았습니다! MyBatis 설정을 확인하세요.");
        }
    }
}
