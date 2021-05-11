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

RUN wget -qO - https://www.mongodb.org/static/pgp/server-4.4.asc | apt-key add - &&\
    echo "deb http://repo.mongodb.org/apt/debian stretch/mongodb-org/4.4 main" | tee /etc/apt/sources.list.d/mongodb-org-4.4.list &&\
    ln -T /bin/true /usr/bin/systemctl &&\
    apt-get update &&\
    apt-get install -y mongodb-org &&\
    rm /usr/bin/systemctl

CMD /etc/init.d/mysql restart; mongod --fork --logpath /var/log/mongodb/db.log -f /etc/mongod.conf; sbt run