import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestFailureListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        System.out.println("Test passed: " + tr.getName());
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        System.out.println("Test Failed: " + tr.getName());
        System.out.println("Exception: " + tr.getThrowable());
    }
}
