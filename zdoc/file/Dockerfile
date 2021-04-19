FROM openjdk:8u181-alpine
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD check-service.jar /check-service.jar
EXPOSE 8031
RUN sh -c 'touch / check-service.jar'
ENTRYPOINT [ "sh", "-c", "java -jar /check-service.jar" ]

