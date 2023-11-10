 [![Gitter](https://img.shields.io/badge/Available%20on-Intersystems%20Open%20Exchange-00b2a9.svg)](https://openexchange.intersystems.com/package/jirisreport)
 [![Quality Gate Status](https://community.objectscriptquality.com/api/project_badges/measure?project=intersystems_iris_community%2Fjirisreport&metric=alert_status)](https://community.objectscriptquality.com/dashboard?id=intersystems_iris_community%2Fjirisreport)
 [![Reliability Rating](https://community.objectscriptquality.com/api/project_badges/measure?project=intersystems_iris_community%2Fjirisreport&metric=reliability_rating)](https://community.objectscriptquality.com/dashboard?id=intersystems_iris_community%2Fjirisreport)

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg?style=flat&logo=AdGuard)](LICENSE)
# JIRISReport
This is a tool for create and execute JasperReports on InterSystems IRIS.

## Description
The JIRISReport allows you:
* Design reports using JasperReports Studio
* Run the report files (jrxml files) and get PDF, Word, Excel or HTML reports


## Prerequisites
* TTF fonts, if you dont have Arial or other fonts on your Linux install ttf-mscorefonts-installer
* Use JasperReports Studio CE (Community Edition) to design your reports on https://community.jaspersoft.com/community-download
* Connect from JasperReports to IRIS using the IRIS JDBC driver on https://github.com/intersystems-community/iris-driver-distribution/tree/main/JDBC
* You need InterSystems IRIS (any version)

## Installation with Docker

Clone/git pull the repo into any local directory

```
$ git clone https://github.com/yurimarx/jirisreport.git
```

Open the terminal in this directory and call the command to build and run InterSystems IRIS in container:
*Note: Users running containers on a Linux CLI, should use "docker compose" instead of "docker-compose"*
*See [Install the Compose plugin](https://docs.docker.com/compose/install/linux/)*



```
$ docker-compose up -d
```

## Installation with ZPM

```
USER> zpm install jirisreport
```

If your OS host is Linux, install ttf fonts:

```
sudo echo ttf-mscorefonts-installer msttcorefonts/accepted-mscorefonts-eula select true | debconf-set-selections
apt-get update && \ 
apt-get install ttf-mscorefonts-installer -y && \
apt-get install fontconfig -y
sudo fc-cache -v -f /usr/share/fonts
```

