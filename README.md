#Kafka for windows:
1. Download kafka file from apache kafka website.
2. extract the file
3. Go to the folder level where you can see the bin folder
4. open cmd from there
5. start Zookeeper by using bin\windows\zookeeper-server-start.bat config\zookeeper.properties
6. Open another cmd and start kafka server using bin\kafka-server-start.bat config\server.properties
7. create a topic using bin\windows\kafka-topics --create --topic topic-name --bootstrap-server localhost:9092
   
