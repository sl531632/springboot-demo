@echo on

REM 声明采用UTF-8编码
chcp 65001

echo 当前盘符：%~d0
echo 当前盘符和路径：%~dp0
echo 当前批处理全路径：%~f0
echo 当前盘符和路径的短文件名格式：%~sdp0
echo 当前CMD默认目录：%cd%

REM 设置JDK版本
set JAVA_HOME=D:\soft\jdk-soft\jdk11---zulu11.56.19-ca-jdk11.0.15-win_x64
set PATH=%JAVA_HOME%\bin;%PATH%

call mvn -v
echo -----------

call java -version
echo -----------
timeout 3


call mvn clean package 

pause




