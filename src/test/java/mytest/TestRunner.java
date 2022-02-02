package mytest;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestRunner {

    public static void main(String[] args) {

        XmlSuite mySuite = new XmlSuite();
        mySuite.setParallel(XmlSuite.ParallelMode.CLASSES);
        List<XmlTest> tests = new ArrayList<>();
        tests.addAll(createTests(Map.of("My api tests", "mytest.simple",
                "My ui tests","mytest.ui"), mySuite));
        TestNG tng = new TestNG();
        tng.setXmlSuites(List.of(mySuite));
        tng.addListener(new com.epam.reportportal.testng.ReportPortalTestNGListener());
        tng.addListener(new com.codeborne.selenide.testng.ScreenShooter());
        tng.run();
        System.exit(0);
    }

    private static List<XmlTest> createTests(Map<String, String> content, XmlSuite suite) {
        return content.entrySet().stream().map(e -> {
            var test = new XmlTest(suite);
            test.setName(e.getKey());
            test.setPackages(List.of(new XmlPackage(e.getValue())));
            return test;
        }).collect(Collectors.toList());
    }
}
