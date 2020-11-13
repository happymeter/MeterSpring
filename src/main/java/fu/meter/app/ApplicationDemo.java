
package fu.meter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @desc 程序启动入口
 * @author meter
 * @date 2019/11/8 11:13
 */
@SpringBootApplication
@ComponentScan({ "fu.meter.modules","fu.meter.common" })
public class ApplicationDemo extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationDemo.class, args);
	}

}