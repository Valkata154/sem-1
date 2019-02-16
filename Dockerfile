FROM openjdk:latest
COPY ./target/seMethods-0.1-alpha-2-jar-with-dependencies.jar /tmp
WORKDIR /tmp

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.5.0/wait /wait
RUN chmod +x /wait

CMD /wait && java -jar seMethods-0.1-alpha-2-jar-with-dependencies.jar
