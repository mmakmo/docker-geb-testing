package sample.specs

import org.junit.experimental.categories.Category
import sample.infrastructure.BaseGebSpec
import sample.infrastructure.testCategory.Redirection
import sample.pages.GebishOrgHomePage
import sample.pages.TheBookOfGebPage

@Category(Redirection)
class GebishOrgSpec extends BaseGebSpec {

    def "can get to the current Book of Geb"() {
        given:
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