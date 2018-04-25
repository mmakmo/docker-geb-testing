/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import sample.configurations.Config

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

        driver = {

            Config.CONFIG

            Proxy proxy = new Proxy()
            proxy.setHttpProxy(proxyUrl)
            proxy.setSslProxy(proxyUrl)


            ChromeOptions options = new ChromeOptions()
            options.setCapability("proxy", proxy)
            options.addArguments('no-sandbox')
            options.addArguments('disable-gpu')
            options.addArguments("--disable-extensions")
            options.addArguments('test-type')
            new ChromeDriver(options)
        }
	}

	// run via “./gradlew chromeHeadlessTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chromeHeadless {
		driver = {
			Logger logger = Logger.getLogger("")
			logger.info ("I am a test info log")

            Proxy proxy = new Proxy()
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

            FirefoxProfile profile = new FirefoxProfile()
//            profile.setPreference("network.proxy.type", 1)
//            profile.setPreference("network.proxy.http", ProxyUrl.getProxyName())
//            profile.setPreference("network.proxy.http_port", ProxyUrl.getProxyPort())
//            profile.setPreference("network.proxy.ssl", ProxyUrl.getProxyName());
//            profile.setPreference("network.proxy.ssl_port", ProxyUrl.getProxyPort());
            profile.setPreference("intl.accept_languages", "en")

            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile)
            options.setCapability(FirefoxOptions.FIREFOX_OPTIONS,options)

            options.setHeadless(true)

            new FirefoxDriver(options)

        }
	}

    // run via “./gradlew firefoxTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefoxHeadless {
        atCheckWaiting = 1

        driver = {

            FirefoxProfile profile = new FirefoxProfile()
//            profile.setPreference("network.proxy.type", 1)
//            profile.setPreference("network.proxy.http", ProxyUrl.getProxyName())
//            profile.setPreference("network.proxy.http_port", ProxyUrl.getProxyPort())
//            profile.setPreference("network.proxy.ssl", ProxyUrl.getProxyName());
//            profile.setPreference("network.proxy.ssl_port", ProxyUrl.getProxyPort());
            profile.setPreference("intl.accept_languages", "en")

            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile)
            options.setCapability(FirefoxOptions.FIREFOX_OPTIONS,options)

            options.setHeadless(true)

            new FirefoxDriver(options)

        }
    }
}

// To run the tests with all browsers just run “./gradlew test”

baseUrl = "http://gebish.org"
