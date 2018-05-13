/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import sample.infrastructure.ChromeOptionsBuilder
import sample.infrastructure.FirefoxOptionsBuilder

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
            new ChromeDriver(builder.withDeviceType().build())
        }
    }

    // run via “./gradlew chromeHeadlessTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chromeHeadless {
        driver = {
            ChromeOptionsBuilder builder = new ChromeOptionsBuilder()
            new ChromeDriver(builder.withDeviceType().withHeadless().build())
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

    // run via “./gradlew firefoxHeadlessTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefoxHeadless {
        atCheckWaiting = 1
        driver = {
            FirefoxOptionsBuilder builder = new FirefoxOptionsBuilder()
            new FirefoxDriver(builder.withHeadless().build())
        }
    }

    // run via “./gradlew firefoxTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver

    // https://qiita.com/ryotax/items/fc2b62c4b1712cb40ea9
    ie {
        atCheckWaiting = 1
        driver = {
            new InternetExplorerDriver()
        }

    }

}