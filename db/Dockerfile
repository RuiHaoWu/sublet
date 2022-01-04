FROM mysql:8.0.24

MAINTAINER wrh

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY ./sublet.sql /docker-entrypoint-initdb.d

COPY ./sublet_nacos.sql /docker-entrypoint-initdb.d
