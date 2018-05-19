package sample.pages.base

import geb.spock.GebReportingSpec
import sample.infrastructure.configurations.DeviceSettings

import java.util.logging.Logger

class BaseGebSpec extends GebReportingSpec {

    Logger logger = Logger.getLogger("")

    def setupSpec() {
        DeviceSettings deviceSettings = new DeviceSettings()
        driver.manage().window().size = deviceSettings.getDeviceSize()

    }

}