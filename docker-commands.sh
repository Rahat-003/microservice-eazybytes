
#Give the following commands inside each service directory. (accounts, cards, loans)
# Microservices/microservice-eazybytes/accounts


# To sync the docker desktop with the terminal's docker context.
# Before running this command, Get help from internet
docker context show

unset DOCKER_HOST

docker context use desktop-linux

docker context show




#Show all images
docker images

#Show all containers
docker ps


#To run a Dockerfile: this will create a image of Dockerfile
docker build . -t rahat1722/accounts:section4

#To run the image: this will create a container of the image.
docker run -p 8080:8080 rahat1722/accounts:section4

# To run the image in detached mode. It will be used mostly, if you want to run multiple containers.
# If you don't run in detached mode, closing terminal will close the container.
docker run -d -p 8080:8080 rahat1722/accounts:section4

# To stop a container
docker stop <container_id>

# To remove a container
docker rm <container_id>

# after adding following in pom.xml of loans service run the following command
#  <image>
#			<name>rahat1722/${project.artifactId}:section4</name>
#  </image>
mvn spring-boot:build-image


# To create image using jib, search internet for jib-maven-plugin for cards service.
# Using jib, docker image can be directly uploaded to remote repository like docker hub, google cloud or amazon elastic container registry.
# Can use CI/CD pipeline to upload image to remote repository.

#<plugin>
#  <groupId>com.google.cloud.tools</groupId>
#  <artifactId>jib-maven-plugin</artifactId>
#  <version>3.3.2</version>
#  <configuration>
#      <to>
#        <image>rahat1722/${project.artifactId}:section4</image>
#      </to>
#  </configuration>
#</plugin>
mvn compile jib:dockerBuild



# Use buildpacks for creating images. Best option so far.


# To run the images of docker-compose.yml
# Following command will run all the containers in docker-compose.yml
docker compose up -d

# To stop and remove all the containers in docker-compose.yml
docker compose down

# To stop all the containers in docker-compose.yml
docker compose stop

# To start all the containers in docker-compose.yml
docker compose start


# Last checked: s6 - updating Docker Compose fie

# for using webhook to
hookdeck listen 8071 Source --path /monitor
