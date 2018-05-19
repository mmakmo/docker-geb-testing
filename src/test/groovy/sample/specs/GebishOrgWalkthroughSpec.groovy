package sample.specs

import org.junit.experimental.categories.Category
import sample.infrastructure.testcategories.Walkthrough
import sample.pages.GebishOrgHomePage
import sample.pages.TheBookOfGebPage
import sample.pages.base.BaseGebSpec

@Category(Walkthrough)
class GebishOrgWalkthroughSpec extends BaseGebSpec {

    def "can get to the current Book of Geb"() {
        given:
        logger.info("[Walkthrough Test]")
        baseUrl = "http://gebish.org"

        when:
        to GebishOrgHomePage
        browser.report("screen")
        logger.info("first")

        and:
        manualsMenu.open()
        logger.info("second")

        then:
        manualsMenu.links[0].text().startsWith("current")
        logger.info("third")

        when:
        manualsMenu.links[0].click()
        logger.info("fourth")

        then:
        at TheBookOfGebPage
        browser.report("screen")
        logger.info("fifth")
    }
}