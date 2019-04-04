FROM maven:latest
WORKDIR /tmp

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.5.0/wait /wait
RUN chmod +x /wait

CMD /wait && cd /var/code && mvn test -Dtest=com.napier.sem.AppIntegrationTest
