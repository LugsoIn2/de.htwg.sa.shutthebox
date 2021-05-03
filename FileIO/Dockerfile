FROM hseeberger/scala-sbt:8u222_1.3.5_2.13.1 AS FileIO
EXPOSE 9004
WORKDIR /FileIO
ADD . /FileIO
RUN apt-get update -y &&\
    apt-get install -y libxext-dev &&\
    apt-get install -y libxrender-dev &&\
    apt-get install -y libxtst6 &&\
    apt-get install -y mysql-server

RUN /etc/init.d/mysql start &&\
    mysql -u root -e "CREATE DATABASE fileiodb;" &&\
    mysql -u root -e "CREATE USER 'fileiodbuser'@'localhost' IDENTIFIED BY 'Abc123';" &&\
    mysql -u root -e "GRANT ALL PRIVILEGES ON fileiodb . * TO 'fileiodbuser'@'localhost';" &&\
    mysql -u root -e "FLUSH PRIVILEGES;"

CMD /etc/init.d/mysql restart ; sbt run