# Docker GEB Testing Environment


## Run Test On Local PC (Google Chrome / Firefox / Internet Explorer(Windows Only))

```bash
./gradlew {browser_type}Test
```

`{browser_type}`
* chrome
* firefox
* chromeHeadless
* firefox


## Run Test On Docker Container (Google Chrome / Firefox)
This environment is installed Jenkins.

### Pre Requirement
#### for Mac/Linux
* Docker
* Docker Compose

#### for Windows
* [Docker Tool Box](https://download.docker.com/win/stable/DockerToolbox.exe) (for Windows)
* Any bash tool

### Setup

```bash
# build docker container
$ docker-compose build

# run docker container
$ docker-compose up -d
```

### Run Test
1. access to Jenkins
    - for Mac/Linux: access `http://localhost:8080/`
    - for Windows: access `http://192.168.99.100:8080/`

2. 