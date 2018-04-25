package sample.configurations

class Config {
   private static def PROFILES_LOCATION = '/Profiles.groovy'

    private static def PROXIES_LOCATION = '/Proxies.groovy'

    public static final def CONFIG = parseProfiles().profiles[profile()]

    public static final def PROXY = parseSettings(PROXIES_LOCATION).profiles[proxies()]


    Config() {

   }

   private static def parseProfiles() {
      def configFile = new Config().getClass().getClassLoader().getResource(PROFILES_LOCATION).toExternalForm().toURI().toURL()
      new ConfigSlurper().parse(configFile)
   }

   private static def profile() {
      System.getProperty("profile", "production")
   }


    private static def parseSettings(String location) {
        def configFile = new Config().getClass().getClassLoader().getResource(PROXIES_LOCATION).toExternalForm().toURI().toURL()
        new ConfigSlurper().parse(configFile)
    }

    private static def proxies() {
        System.getProperty("proxies", "developmentProxy")
    }


}
