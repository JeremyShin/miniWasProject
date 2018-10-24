package examples.dao.main;

import examples.dao.config.ApplicationConfig;
import examples.dao.dao.MemberDao;
import examples.dao.dto.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberInsertTest {
    public static void main(String[] args) {
        ApplicationContext ac
                = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        MemberDao memberDao
                = ac.getBean(MemberDao.class);

        Member member = memberDao.getMember("a");
        System.out.println(member);
    }
}
