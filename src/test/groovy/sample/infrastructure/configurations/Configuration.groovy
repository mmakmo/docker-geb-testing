package sample.infrastructure.configurations

class Configuration {
    private static def ENVIRONMENTS_LOCATION = './settings/Environments.groovy'
    private static def PROXIES_LOCATION = './settings/Proxies.groovy'
    private static def DEVICES_LOCATION = './settings/Devices.groovy'

    public static final def ENVIRONMENT = parseSettings(ENVIRONMENTS_LOCATION).profiles[environment()]

    public static final def PROXY = parseSettings(PROXIES_LOCATION).profiles[proxy()]

    public static final def DEVICE = parseSettings(DEVICES_LOCATION).profiles[device()]

    Configuration() {}

    private static def environment() {
        System.getProperty("environment", "development")
    }

    private static def proxy() {
        System.getProperty("proxy", "noProxy")
    }

    private static def device() {
        System.getProperty("device", "pc")
    }

    private static def parseSettings(String location) {
        def configFile = new Configuration().getClass().getClassLoader().getResource(location).toExternalForm().toURI().toURL()
        new ConfigSlurper().parse(configFile)
    }

}
