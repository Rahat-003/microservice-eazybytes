
#Give the following commands inside each service directory. (accounts, cards, loans)
# Microservices/microservice-eazybytes/accounts

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


Last checked: 45-Running accounts microservice as a Docker container.mp4