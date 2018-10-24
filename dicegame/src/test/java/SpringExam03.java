import my.examples.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam03 {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("diceplayer.xml");
        Game game = context.getBean(Game.class);
        game.play();

    }
}
