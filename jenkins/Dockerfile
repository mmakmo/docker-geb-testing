# https://technologyconversations.com/2017/06/16/automating-jenkins-docker-setup/
# https://github.com/liatrio/pipeline-developer
FROM jenkins:latest

USER root

RUN \
    echo 'root:root' |chpasswd &&\
    echo 'jenkins:jenkins' |chpasswd &&\
    echo "jenkins ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

RUN apt-get update &&\
    apt-get install -y curl &&\
    # Dependencies to make "headless" chrome/selenium work:
#    apt-get -y install xorg xvfb gtk2-engines-pixbuf &&\
    apt-get -y install dbus-x11 xfonts-base xfonts-100dpi xfonts-75dpi xfonts-cyrillic \
        fonts-liberation xdg-utils libxss1 libappindicator1 libindicator7 libxi6 libgconf-2-4 \
        # Optional but nifty: For capturing screenshots of Xvfb display:
        imagemagick x11-apps

# "Starting X virtual framebuffer (Xvfb) in background..."
RUN Xvfb :91 -screen 0 2930x2080x24 &

RUN apt-get update &&\
    apt-get install -y --no-install-recommends \
    firefox-esr

RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - &&\
    echo 'deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main' | tee /etc/apt/sources.list.d/google-chrome.list &&\
    apt-get update -y &&\
    apt-get install -y google-chrome-stable

ENV DISPLAY=:91
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY jobs /usr/share/jenkins/ref/jobs/
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

USER jenkins

WORKDIR ${JENKINS_HOME}


ENTRYPOINT ["/bin/tini", "--", "/usr/local/bin/jenkins.sh"]
