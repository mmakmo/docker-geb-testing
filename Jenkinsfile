#!groovy

pipeline {
    agent {
        label 'master'
    }

    parameters {
        choice(name: 'ENV', choices: 'development\nproduction', description: 'Target environment')
        choice(name: 'TYPE', choices: 'redirection\nfullPath', description: 'Testing type.')
        choice(name: 'BROWSER', choices: 'chrome\nfirefox\nfirefoxHeadless\nall', description: 'Using browser(s) for testing.')
    }

    stages {
        stage(browserTesting) {
            steps(pc) {
                script {
                    if (params.BROWSER == 'all') {
                        def browsers = [:]
                        for (browser in ["chrome", "firefox"]) {
                          def choice = browser
                          browsers[choice] = {
                            echo "Execute test uses ${choice}"
                            sh "./gradlew ${choice}Test -Dprofiles=${params.ENV}"
                          }
                        }
                        parallel(browsers)
                    } else {
                        echo "Execute test uses ${params.BROWSER}"
                        sh "./gradlew ${params.BROWSER}Test -Dprofiles=${params.ENV}"
                    }
                }
            }
        }
    }
}