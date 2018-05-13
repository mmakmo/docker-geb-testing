package sample.infrastructure

import org.openqa.selenium.chrome.ChromeOptions
import sample.infrastructure.configurations.ProxySettings

class ChromeOptionsBuilder {

    private final ChromeOptions options

    ChromeOptionsBuilder() {
        options = new ChromeOptions()
        options.addArguments('no-sandbox')
        options.addArguments('disable-gpu')
        options.addArguments("--disable-extensions")
        options.addArguments('test-type')
    }

    ChromeOptionsBuilder withProxy() {
        ProxySettings proxySettings = new ProxySettings()
        Proxy proxy = new Proxy()
        proxy.setHttpProxy(proxySettings.getProxyUrl())
        proxy.setSslProxy(proxySettings.getProxyUrl())
        options.setCapability("proxy", proxy)
        return this
    }

    ChromeOptionsBuilder withHeadless() {
        options.addArguments("--headless")
        return this
    }

    ChromeOptionsBuilder withDeviceType() {
        options.addArguments("--window-size=640,480")
        return this;
    }

    ChromeOptions build() {
        return options
    }

}
