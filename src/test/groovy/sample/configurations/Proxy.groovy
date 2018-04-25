package sample.configurations

class Proxy {
   private static def PROFILES_LOCATION = '/Profiles.groovy'

    private static def PROXIES_LOCATION = '/Proxies.groovy'


    public static final def PROXY = parseSettings().profiles[proxies()]


    Proxy() {

   }

    private static def parseSettings() {
        def configFile = new Proxy().getClass().getClassLoader().getResource(PROXIES_LOCATION).toExternalForm().toURI().toURL()
        new ConfigSlurper().parse(configFile)
    }

    private static def proxies() {
        System.getProperty("proxies", "developmentProxy")
    }


}
