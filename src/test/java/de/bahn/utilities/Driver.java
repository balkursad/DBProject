package de.bahn.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {





    private Driver(){}



    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();



    public static WebDriver getDriver(){
        if (driverPool.get() == null){


            String browserType = ConfigurationReaders.getProperty("browser");



            switch (browserType){
                case "remote-chrome":
                    // assign your grid server address
                    String gridAddress = "44.202.63.224"; // put your own Linux grid IP here
                    try {
                        URL url = new URL("http://"+gridAddress+":4444/wd/hub");
                        DesiredCapabilities capabilities= new DesiredCapabilities();
                        capabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url,capabilities));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;



            }
        }

        return driverPool.get();
    }

    @Test
    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit();   //this line will terminate the existing session. value will not even be null
            driverPool.remove();
        }
    }

}
