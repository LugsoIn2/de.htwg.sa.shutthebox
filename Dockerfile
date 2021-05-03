FROM hseeberger/scala-sbt:8u222_1.3.5_2.13.1
WORKDIR /shutthebox
ADD . /shutthebox
RUN apt-get update -y &&\
    apt-get install -y libxext-dev &&\
    apt-get install -y libxrender-dev &&\
    apt-get install -y libxtst6 &&\
    apt-get install -y postgresql &&\
    /etc/init.d/postgresql start

USER postgres
RUN /etc/init.d/postgresql start &&\
    psql --command "CREATE USER dbuser WITH PASSWORD 'Abc123';" &&\
    psql --command "CREATE DATABASE playerdb;" &&\
    psql --command "GRANT ALL PRIVILEGES ON DATABASE playerdb TO playerdbuser;"

USER root
CMD /etc/init.d/postgresql restart ; sbt run