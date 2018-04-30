package sample.specs

import geb.spock.GebSpec
import sample.infrastructure.configurations.DeviceSettings
import sample.pages.GebishOrgHomePage
import sample.pages.TheBookOfGebPage

//@Category(RedirectionTest)
class GebishOrgSpec extends GebSpec {

    def "can get to the current Book of Geb"() {
        given:
        DeviceSettings deviceSettings = new DeviceSettings()
        driver.manage().window().size = deviceSettings.getDeviceSize()

        when:
        to GebishOrgHomePage

        and:
        manualsMenu.open()

        then:
        manualsMenu.links[0].text().startsWith("current")

        when:
        manualsMenu.links[0].click()

        then:
        at TheBookOfGebPage
        browser.report("screen")
    }
}