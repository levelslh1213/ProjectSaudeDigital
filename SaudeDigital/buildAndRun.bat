@echo off
call mvn clean package
call docker build -t com.mycompany/SaudeDigital .
call docker rm -f SaudeDigital
call docker run -d -p 9080:9080 -p 9443:9443 --name SaudeDigital com.mycompany/SaudeDigital