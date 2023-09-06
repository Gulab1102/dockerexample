# dockerexample

docker images

docker run hello-world

docker -v

docker ps -a


docker run --name python-c1 -d python

docker exec -it 2eda900722eb python



docker run --name mysqldb --network examportal -e MYSQL_ROOT_PASSWORD=Gulab1102 -e MYSQL_DATABASE=exam -e MYSQL_USER=$a -e MYSQL__PASSWORD=Gulab1102 -d mysql

docker network create examportal
docker network ls  

docker-compose up

javac Test.java 




docker build -t gulab1102/hello .


docker run 


docker run -p 9090:8080 11b0e5e6100a


docker network create examportal

docker run --name mysqldb --network examportal -e MYSQL_ROOT_PASSWORD=Gulab1102 -e MYSQL_DATABASE=user -e MYSQL_USER=exam -e MYSQL__PASSWORD=Gulab1102 -d mysql
docker build -t gulab1102/hello .

docker run --network  examportal --name examportalc1 -p 8080:8080 gulab1102/examproject

