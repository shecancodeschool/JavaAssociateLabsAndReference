import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import service.Palindrome;


@Listeners(TestFailureListener.class)
public class TestNGTest {

    @DataProvider(name = "mydata")
    public String[] getData() {
        return new String[]{"Maxwell", "Odoom", "Kofi"};
    }

    @DataProvider(name = "palindrome-data")
    public String[] getPalindromeData() {
        return new String[]{"level", "civic", "refer", "radar"};
    }

    @Test(dataProvider = "palindrome-data")
    public void testIsPalindromeIsTrue(String word) {

        boolean actualValue = Palindrome.isPalindrome(word);
        Assert.assertTrue(actualValue);
    }

    @Test(dataProvider = "mydata")
    public void testIsPalindromeIsFalse(String word) {

        boolean actualValue = Palindrome.isPalindrome(word);
        Assert.assertFalse(actualValue);
    }
}
