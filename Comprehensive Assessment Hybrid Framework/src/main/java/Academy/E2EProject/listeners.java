package Academy.E2EProject;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
public class listeners implements ITestListener{
    base b = new base();
	public void onTestFailure(ITestResult result) {
		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
