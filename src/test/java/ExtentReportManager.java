import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter; // UI of the report
    public ExtentReports extent;   // populate common info on the report
    public ExtentTest test; // creating test case entries in the report and updating status of the test methods

    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/report.html");

        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name","localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("Tester Name","Karim");
        extent.setSystemInfo("OS Name","Windows10");
        extent.setSystemInfo("Browser Name","Chrome");

    }

    public void onTestStart(ITestResult result) {
        System.out.println("This is onTestStart...");
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case Passed is : "+ result.getName());
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is : "+ result.getName());
        test.log(Status.FAIL, "Test case FAILURE cause is : "+ result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is : "+ result.getName());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
