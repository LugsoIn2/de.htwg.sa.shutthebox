FROM hseeberger/scala-sbt:8u222_1.3.5_2.13.1
WORKDIR /shutthebox
ADD . /shutthebox
RUN apt-get update -y &&\
    apt-get install -y libxext-dev &&\
    apt-get install -y libxrender-dev &&\
    apt-get install -y libxtst6 &&\
    apt-get install -y mysql-server
    #/etc/init.d/mysql start

RUN /etc/init.d/mysql start &&\
    #psql --command "CREATE USER playerdbuser WITH PASSWORD 'Abc123';" &&\
    #psql --command "CREATE DATABASE playerdb;" &&\
    #psql --command "GRANT ALL PRIVILEGES ON DATABASE playerdb TO playerdbuser;"
    mysql -u root -e "CREATE DATABASE playerdb;" &&\
    mysql -u root -e "CREATE USER 'playerdbuser'@'localhost' IDENTIFIED BY 'Abc123';" &&\
    mysql -u root -e "GRANT ALL PRIVILEGES ON playerdb . * TO 'playerdbuser'@'localhost';" &&\
    mysql -u root -e "FLUSH PRIVILEGES;"

CMD /etc/init.d/mysql restart ; sbt run