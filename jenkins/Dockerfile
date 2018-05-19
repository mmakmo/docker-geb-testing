# https://technologyconversations.com/2017/06/16/automating-jenkins-docker-setup/
# https://github.com/liatrio/pipeline-developer
FROM jenkins:latest

USER root

RUN \
    echo 'root:root' |chpasswd &&\
    echo 'jenkins:jenkins' |chpasswd &&\
    echo "jenkins ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

RUN \
    apt-get update &&\
    apt-get install -y curl &&\
    # Dependencies to make "headless" chrome/selenium work:
    apt-get -y install xorg xvfb gtk2-engines-pixbuf &&\
    apt-get -y install dbus-x11 xfonts-base xfonts-100dpi xfonts-75dpi xfonts-cyrillic \
        fonts-liberation xdg-utils libxss1 libappindicator1 libindicator7 libxi6 libgconf-2-4 \
        # Optional but nifty: For capturing screenshots of Xvfb display:
        imagemagick x11-apps

# Install Firefox package
RUN apt-get update &&\
    apt-get install -y --no-install-recommends \
    firefox-esr

# Install latest Firefox
RUN \
    wget -O FirefoxSetup.tar.bz2 "https://download.mozilla.org/?product=firefox-latest&os=linux64&lang=en-US" &&\
    mkdir /opt/firefox &&\
    tar xjf FirefoxSetup.tar.bz2 -C /opt/firefox/ &&\
    mv /usr/lib/firefox-esr/firefox-esr /usr/lib/firefox-esr/firefox-esr_orig &&\
    ln -s /opt/firefox/firefox/firefox /usr/lib/firefox-esr/firefox-esr &&\
    rm FirefoxSetup.tar.bz2

# Install latest Google Chrome
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - &&\
    echo 'deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main' | tee /etc/apt/sources.list.d/google-chrome.list &&\
    apt-get update -y &&\
    apt-get install -y google-chrome-stable

# Install Japanese Font
RUN \
    wget -O IPAfont00303.zip http://ipafont.ipa.go.jp/old/ipafont/IPAfont00303.php &&\
    unzip IPAfont00303.zip -d /usr/share/fonts/ &&\
    rm IPAfont00303.zip &&\
    fc-cache -fv

COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY jobs /usr/share/jenkins/ref/jobs/
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

ENV DISPLAY=:91.0
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

USER jenkins

COPY jenkins.sh /usr/local/bin/jenkins.sh

WORKDIR ${JENKINS_HOME}

ENTRYPOINT ["/bin/tini", "--", "/usr/local/bin/jenkins.sh"]
