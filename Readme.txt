#run project on docker

1- unzip the attached project 
2- open cmd or shill 
3- go to the project directory in cmd
4- run : docker build -f Dockerfile -t docker-jumia-service 
5- run : docker run -p 8080:8080 docker-jumia-service
6- open browser put url : http://localhost:8080/

#run project on IDE

1- unzip the attached project 
2- open IDE
3- import exist mavin project select the project
4- run the project as spring boot application