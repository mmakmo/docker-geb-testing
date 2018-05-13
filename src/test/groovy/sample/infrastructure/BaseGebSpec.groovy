package sample.infrastructure

import geb.spock.GebReportingSpec
import sample.infrastructure.configurations.DeviceSettings

import java.util.logging.Logger

class BaseGebSpec extends GebReportingSpec {

    Logger logger = Logger.getLogger("")

    def setupSpec() {
//        if (!(driver instanceof ChromeDriver)) {
//            DeviceSettings deviceSettings = new DeviceSettings()
//            driver.manage().window().size = deviceSettings.getDeviceSize()
//        }

        DeviceSettings deviceSettings = new DeviceSettings()
        driver.manage().window().size = deviceSettings.getDeviceSize()

    }

}