package sample.infrastructure

import org.openqa.selenium.chrome.ChromeDriver
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

    ChromeOptionsBuilder withProxu() {
        ProxySettings proxySettings = new ProxySettings()
        Proxy proxy = new Proxy()
        proxy.setHttpProxy(proxySettings.getProxyUrl())
        proxy.setSslProxy(proxySettings.getProxyUrl())
        options.setCapability("proxy", proxy)
        return this
    }

    ChromeDriver build() {
        return options
    }

}
