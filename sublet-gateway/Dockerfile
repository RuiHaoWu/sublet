FROM moxm/java:1.8-full as builder
WORKDIR /build
ARG JAR_FILE=target/sublet-gateway.jar
COPY ${JAR_FILE} app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM moxm/java:1.8-full
MAINTAINER "wrh"
ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom  -XX:+PrintGCDetails"
WORKDIR /sublet

COPY --from=builder /build/dependencies/ ./
COPY --from=builder /build/snapshot-dependencies/ ./
COPY --from=builder /build/spring-boot-loader/ ./
COPY --from=builder /build/application/ ./

EXPOSE 8000

CMD sleep 60; java $JAVA_OPTS org.springframework.boot.loader.JarLauncher