package sample.infrastructure

import org.apache.commons.lang3.StringUtils
import sample.configurations.Proxy


class Profile {

    private final String proxyName
    private final Integer portNumber

    public Profile() {
        this.proxyName = "${Proxy.PROXY.proxyName}"
        this.portNumber = Integer.parseInt("${Proxy.PROXY.proxyPort}")

    }



    public Boolean hasProxy() {
        if (StringUtils.isEmpty(proxyName)) {
            return false
        }
        return true
    }
}
