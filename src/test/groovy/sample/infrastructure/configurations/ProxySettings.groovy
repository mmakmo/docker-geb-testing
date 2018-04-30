package sample.infrastructure.configurations

import org.apache.commons.lang3.StringUtils

import java.util.logging.Logger

class ProxySettings {
    private final Logger logger = Logger.getLogger("")
    private final String proxyHost
    private final Integer proxyPort

    ProxySettings() {
        this.proxyHost = "${Configuration.PROXY.proxyHost}"
        this.proxyPort = Integer.parseInt("${Configuration.PROXY.proxyPort}")

    }

    String getProxyHost() {
        return proxyHost
    }

    Integer getProxyPort() {
        return proxyPort
    }

    String getProxyUrl() {
        return proxyHost
                .concat(":")
                .concat(String.valueOf(proxyPort))
    }

    Boolean hasProxy() {
        logger.info(String.format("Using [%s], display size is [%d, %d].", deviceName, width, height))
        if (StringUtils.isEmpty(proxyName)) {
            return false
        }
        return true
    }
}
