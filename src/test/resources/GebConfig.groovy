/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import sample.infrastructure.ChromeOptionsBuilder
import sample.infrastructure.FirefoxOptionsBuilder
import sample.infrastructure.configurations.ProxySettings

import java.util.logging.Logger

waiting {
    timeout = 2
}

test {
    testLogging.showStandardStreams = true
}

environments {

    // run via “./gradlew chromeTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = {
            ChromeOptionsBuilder builder = new ChromeOptionsBuilder()
            new ChromeDriver(builder.build())
        }
    }

    // run via “./gradlew chromeHeadlessTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chromeHeadless {
        driver = {
            Logger logger = Logger.getLogger("")
            logger.info("I am a test info log")

            ProxySettings proxy = new ProxySettings()
            proxy.setHttpProxy(proxyUrl)
            proxy.setSslProxy(proxyUrl)


            ChromeOptions options = new ChromeOptions()
            options.setCapability("proxy", proxy)
            options.setHeadless(true)
//            options.addArguments('headless')
            options.addArguments('no-sandbox')
            options.addArguments('disable-gpu')
            options.addArguments("--disable-extensions")
            options.addArguments('test-type')

            new ChromeDriver(options)

        }
    }

    // run via “./gradlew firefoxTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        atCheckWaiting = 1
        driver = {
            FirefoxOptionsBuilder builder = new FirefoxOptionsBuilder()
            new FirefoxDriver(builder.build())
        }
    }

    // run via “./gradlew firefoxTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefoxHeadless {
        atCheckWaiting = 1
        driver = {
            FirefoxOptionsBuilder builder = new FirefoxOptionsBuilder()
            new FirefoxDriver(builder.withHeadless().build())
        }
    }
}

// To run the tests with all browsers just run “./gradlew test”

baseUrl = "http://gebish.org"
