package CommonUtils;

import java.util.Random;

public class JavaUtils {

	public int getRandomNumber() {
		Random r=new Random();
		int rn = r.nextInt(500);
		return rn;

	}

}
