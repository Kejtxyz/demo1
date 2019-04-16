package pl.sda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void contextLoads() {
		HelloWorldRestController controller = applicationContext.getBean(HelloWorldRestController.class);
		Iterable<Greeting> allGreetings = controller.getAllGreetings();
		//assertThat(allGreetings).isNull();
	}
}
