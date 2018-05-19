package sample.specs

import org.junit.experimental.categories.Category
import sample.infrastructure.testcategories.InstallationCheck
import sample.pages.GebishOrgHomePage
import sample.pages.base.BaseGebSpec

@Category(InstallationCheck)
class InstallationCheckSpec extends BaseGebSpec {

    def "can get to the current Book of Geb"() {
        given:
        logger.info("[InstallationCheck]")
        baseUrl = "http://gebish.org"

        when:
        to GebishOrgHomePage

        then:
        at GebishOrgHomePage
    }
}