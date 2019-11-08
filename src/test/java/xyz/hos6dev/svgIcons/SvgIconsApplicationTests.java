package xyz.hos6dev.svgIcons;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.hos6dev.svgIcons.svgIconsApp.logic.FilesResolver;

@SpringBootTest
class SvgIconsApplicationTests {

	@Autowired
	private FilesResolver filesResolver;

	@Test
	void contextLoads() {
		long start = System.currentTimeMillis();
		filesResolver.listFiles();
		long end = System.currentTimeMillis();
		float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
	}

}
