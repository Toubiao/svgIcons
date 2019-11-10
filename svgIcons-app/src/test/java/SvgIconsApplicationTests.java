import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import xyz.hos6dev.svgIcons.svgIconsApp.logic.FilesResolver;
import xyz.hos6dev.svgIcons.svgIconsApp.logic.FilesResolverDev;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = xyz.hos6dev.svgIcons.svgIconsApp.SvgIconsApplication.class)
class SvgIconsApplicationTests {

	@Autowired
	private FilesResolverDev filesResolver;

	@Test
	void contextLoads() {
		long start = System.currentTimeMillis();
		filesResolver.listFiles();
		long end = System.currentTimeMillis();
		float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
	}

}
