@echo off

REM Windows script for running unit tests
REM You have to run server and capture some browser first
REM
REM Requirements:
REM - NodeJS (http://nodejs.org/)
REM - Testacular (npm install -g karma)

set CHROME_BIN=C:\Program Files (x86)\Google\Chrome\Application\chrome.exe
set FIREFOX_BIN=C:\Program Files (x86)\Mozilla Firefox\firefox.exe
set BASE_DIR=%~dp0
karma start "%BASE_DIR%\..\config\karma.conf.js" %*
