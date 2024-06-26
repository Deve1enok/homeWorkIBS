package org.ibs.fazlyakhmetov.tests;

import org.aeonbits.owner.ConfigFactory;
import org.ibs.fazlyakhmetov.config.QualitConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static QualitConfig configOwner = ConfigFactory.create(QualitConfig.class);

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chromedriver.driver", configOwner.chromeDriver());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get(configOwner.baseUrl());

    }

    @AfterAll
    static void afterAll() {
        driver.close();
        driver.quit();
    }
}

