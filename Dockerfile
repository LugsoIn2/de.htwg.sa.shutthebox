FROM hseeberger/scala-sbt:8u222_1.3.5_2.13.1
WORKDIR /shutthebox
ADD . /shutthebox
RUN apt-get update -y &&\
    apt-get install -y libxext-dev &&\
    apt-get install -y libxrender-dev &&\
    apt-get install -y libxtst6

CMD sbt run