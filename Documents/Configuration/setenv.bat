set JAVA_OPTS=-XX:MaxPermSize=512m -XX:+UseParNewGC -XX:MaxNewSize=512m -XX:NewSize=512m -Xms1024m -Xmx1024m -XX:SurvivorRatio=128 -XX:MaxTenuringThreshold=0  -XX:+UseTLAB -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -XX:+CMSPermGenSweepingEnabled -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/var/log/ALeague/heapdump/ -Xloggc:/var/log/ALeague/gc/gc.log -verbose:gc -XX:+PrintGCDateStamps -Dlog4j.configurationFile=file://E:/apache-tomcat-8.5.6/conf/log4j2.xml