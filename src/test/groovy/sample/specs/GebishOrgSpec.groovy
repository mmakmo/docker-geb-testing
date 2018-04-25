package sample.specs

import geb.spock.GebSpec
import org.openqa.selenium.Dimension
import sample.pages.GebishOrgHomePage
import sample.pages.TheBookOfGebPage

class GebishOrgSpec extends GebSpec {

    def "can get to the current Book of Geb"() {
        given:
        driver.manage().window().size = new Dimension(640, 960)

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