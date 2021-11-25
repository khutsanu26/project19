package project19;

import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.junit.Test;

public class ImageAvailabilityTest {
	@Test
	public void test() {

		boolean imageIsAvailable = true;
		BufferedImage img;

		try {
			img = ImageIO.read(new URL(
					"https://images-eds-ssl.xboxlive.com/image?url=wHwbXKif8cus8csoZ03RWwcxuUQ9WVT6xh5XaeeZD02wEfGZeuD.XMoGFVYkwHDqOvKL5.b64ptqP4wCgGHRTxwx1P_DSfovQtLEySE1pNzNK42XWRtEDSaVa412Zj4eNFPxK5ViMa9ywAVcCPaUuqBYg_n_45gsGgbj79L5TQM-"));
		} catch (IOException e) {
			e.printStackTrace();
			imageIsAvailable = false;
		}
		assertTrue(imageIsAvailable);
	}
}
