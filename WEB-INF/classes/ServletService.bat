set JAVA_HOME=C:\Users\Tanjir\Desktop\JSTL\jdk1.8.0_92
set PATH=C:\Users\Tanjir\Desktop\JSTL\jdk1.8.0_92\bin
set CATALINA_HOME=C:\Users\Tanjir\Desktop\JSTL\apache-tomcat-9.0.6-windows-x64\apache-tomcat-9.0.6


javac *.java

javac ./models/*.java
javac ./controllers/*.java


start C:\Users\Tanjir\Desktop\JSTL\apache-tomcat-9.0.6-windows-x64\apache-tomcat-9.0.6\bin\startup.bat
start "" http://localhost:8080/framework/ABC/login
echo "Press any key to shutdown"
pause 1
start C:\Users\Tanjir\Desktop\JSTL\apache-tomcat-9.0.6-windows-x64\apache-tomcat-9.0.6\bin\shutdown.bat