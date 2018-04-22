/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver

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

        Logger logger = Logger.getLogger("")
        logger.info ("I am a test info log")

        driver = { new ChromeDriver() }
	}

	// run via “./gradlew chromeHeadlessTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chromeHeadless {
		driver = {
			Logger logger = Logger.getLogger("")
			logger.info ("I am a test info log")


			ChromeOptions o = new ChromeOptions()
			o.addArguments('headless')
            o.addArguments('no-sandbox')
            o.addArguments('disable-gpu')
			new ChromeDriver(o)
		}
    }
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		atCheckWaiting = 1

		driver = { new FirefoxDriver() }
	}

}

// To run the tests with all browsers just run “./gradlew test”

baseUrl = "http://gebish.org"
