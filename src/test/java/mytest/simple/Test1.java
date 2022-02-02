package mytest.simple;

import mytest.BaseTest;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {


    @Test
    public void test1() {
        log.info("This test should pass");
        log2F.debug("This test should pass");
    }

    @Test
    public void test2() {
        log.info("This test should be skipped");
        log2F.debug("This test should be skipped");
        throw new SkipException("This test should be skipped");
    }

    @Test
    public void test3() {
        log.info("This test should fail");
        log2F.debug("This test should fail");
        Assert.fail("This test should fail");
    }
}
