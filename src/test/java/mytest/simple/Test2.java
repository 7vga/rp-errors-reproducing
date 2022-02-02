package mytest.simple;

import com.epam.reportportal.annotations.Step;
import mytest.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 extends BaseTest {

    @Test
    public void test4() {
        log.info("This test uses step");
        log2F.debug("This test uses step");
        stepMethod();
    }

    @Step
    public void stepMethod() {
        log.info("This is step calling");
        log2F.debug("This is step calling");
    }

    @Test(dataProvider = "myProvider")
    public void test5(int n) {
        log.info("Data provider gives {}", n);
        log2F.debug("Data provider gives {}", n);
    }

    @DataProvider(name = "myProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }
}
