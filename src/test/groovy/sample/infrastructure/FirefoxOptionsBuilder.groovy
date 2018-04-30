package sample.infrastructure

import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import sample.infrastructure.configurations.ProxySettings

class FirefoxOptionsBuilder {

    private final FirefoxProfile profile
    private final FirefoxOptions options

    FirefoxOptionsBuilder() {
        profile = new FirefoxProfile()
        profile.setPreference("intl.accept_languages", "jp")
        options = new FirefoxOptions()
        options.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options)


    }

    FirefoxOptions build() {
        options.setProfile(profile)
        return options
    }

    FirefoxOptionsBuilder withProxy() {
        ProxySettings proxySettings = new ProxySettings()
        profile.setPreference("network.proxy.type", 1)
        profile.setPreference("network.proxy.http", proxySettings.getProxyHost())
        profile.setPreference("network.proxy.http_port", proxySettings.getProxyPort())
        profile.setPreference("network.proxy.ssl", proxySettings.getProxyHost());
        profile.setPreference("network.proxy.ssl_port", proxySettings.getProxyPort())
        return this
    }

    FirefoxOptionsBuilder withHeadless() {
        options.setHeadless(true)
        return this
    }
}
