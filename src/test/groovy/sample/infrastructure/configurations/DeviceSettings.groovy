package sample.infrastructure.configurations

import org.openqa.selenium.Dimension

import java.util.logging.Logger

class DeviceSettings {
    private final Logger logger = Logger.getLogger("")
    private final String deviceName
    private final String userAgent
    private final Integer width
    private final Integer height

    DeviceSettings() {
        this.deviceName = "${Configuration.DEVICE.deviceName}"
        this.userAgent = "${Configuration.DEVICE.userAgent}"
        this.width = Integer.parseInt("${Configuration.DEVICE.width}")
        this.height = Integer.parseInt("${Configuration.DEVICE.height}")
    }

    Dimension getDeviceSize() {
        logger.info(String.format("Using [%s], display size is [%d, %d].", deviceName, width, height))
        return new Dimension(width, height)
    }
}
