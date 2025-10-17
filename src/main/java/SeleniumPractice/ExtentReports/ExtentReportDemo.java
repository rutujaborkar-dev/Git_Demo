package SeleniumPractice.ExtentReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo
{
        public ExtentReports extent;

        @BeforeTest
        public void  config()
        {
            //Extentreports, ExtentSparkReporter --> responsible for creating html report
            String path = System.getProperty("user.dir")+"\\reports\\index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Web Automation Results");
            reporter.config().setDocumentTitle("Test Results");

            //responsible to drive report execution
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester","Rutuja");

            System.out.println("I want to commit this code");

        }

        @Test
        public void initialDemo()
        {
            extent.createTest("Initial Demo");
            System.setProperty("webdriver.chrome.driver",
                    "C:/Users/rutujab/OneDrive - AMDOCS/Desktop/personal/chromedriver-win64/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://rahulshettyacademy.com/");
            System.out.println(driver.getTitle());
            extent.flush();
        }


    }
