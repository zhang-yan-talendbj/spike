package spike.spike;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ClassLoaderTest {

	@Test
	public void bootStrapClassLoaderClassDirectory() throws Exception {
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			// Bootstrap Classload load class directory.
			System.out.println(urls[i].toExternalForm());
		}
		// Bootstrap Classload load class directory env
		System.out.println(System.getProperty("sun.boot.class.path"));
	}

	@Test
	public void getClassLoader() throws Exception {
		ClassLoader loader = ClassLoaderTest.class.getClassLoader(); // 获得加载ClassLoaderTest.class这个类的类加载器
		while (loader != null) {
			System.out.println(loader);
			loader = loader.getParent(); // 获得父类加载器的引用
		}
		System.out.println(loader);
	}
}
