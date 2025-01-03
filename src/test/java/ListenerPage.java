import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerPage implements ITestListener {

    public void onStart(ITestContext context) {
        System.out.println("This is OnStart...");
    }

    public void onTestStart(ITestResult result) {
        System.out.println("This is onTestStart...");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("This is onTestSuccess...");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("This is onTestSkipped...");
    }

    public void onFinish(ITestContext context) {
        System.out.println("This is onFinish...");
    }


}
