package UITests.Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestThatFails {
    @Test(priority = 1, description = "test that fails")
    @Story("Story:this fails")
    @Severity(SeverityLevel.TRIVIAL)
    public void failedTest() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertTrue(false,"message of failed test");
    }
}
