# 🐳 Docker + Spring/Spring boot +  Angular 16 + Nginx + Mariadb

![stack](https://github.com/ayoubzaabali/FindProprety/assets/78790570/58187b1b-616a-429e-b04c-38f01717a6ee)



## Description 📋

![docker_facebook_share](https://user-images.githubusercontent.com/57062736/139103227-36f3cb32-c3c1-4158-b99e-25a31e955f44.png)

A complete stack for running Spring/Spring boot & Angular 16 App into Docker containers using the docker-compose tool, with a proxy Nginx between front and back (connected to the DB container).

# List of  containers:

- `real_estate_fe`, the one that runs the build of Angular APP in a container with Nginx.
- `backend`, this container is running the business logic using spring JDBC and SQL queries & rest API, this container contains 3 modules (business, modules, rest)
- `mariadb` storing the MariaDB database Tables.
- `phpmyadmin` handles the administration of MySQL over the Web.

## starting the app ⌨

0. You need **Docker** and **Docker Compose** where you are going to launch this so, if you do not have it... click [HERE]([https://github.com/Inushin/dockerAngularNginxNodePostgreSQL#installing-docker-and-docker-compose-](https://docs.docker.com/engine/install/))

1. Clone this rep.

3. Run `docker-compose up` to check that everything runs correctly. If there are no errors, stop (`ctrl+C`) and delete containers with `docker-compose down`. Now you can run it with `docker-compose up -d`. This will run the container logs in the background.

4. To check that everything is running correctly in the background, run `docker-compose ps -a` and you will see the running containers.

## Docker's useful commands 📑

![Docker Commands Illustration](https://user-images.githubusercontent.com/57062736/139102966-25f28be1-f768-49bd-a8a1-915a8465de9e.png)

- Run Docker Compose: `docker compose up -d` / `docker compose up`

- Check Docker Compose's volumens status: `docker compose ps -a` / `docker compose ps`

- Check Docker's images: `docker images -a`

- Remove Docker's images: `docker rmi -f imageID1 imageID2 ...` (-f = force)

- Enter to a Docker's volumen: `docker compose exec VolumenID sh` / `docker compose exec VolumenID bash`

- Copy a file to the docker we want to: `docker cp file docker_id:/dir`

- Remove all dangling (not tagged or associated with a container) containers, volumes, networks and images: `docker system prune`

- Remove all unused containers and images with at least one container associated to them: `docker system prune -a`

- Shows all unused local images: `docker images ls -f dangling=true`

- Shows all unused local volumes: `docker volume ls -f dangling=true`

- Remove all local volumes not used by at least one container: `docker volume prune`

## Installing Docker and Docker Compose 🛠

![Docker Composer](https://user-images.githubusercontent.com/57062736/141182130-b8ed2d7a-9a68-4387-b838-ba0d44bb4e0e.png)

**Adjust the installation to your OS. Here you have the one for Linux Mint (Ubuntu based)**

### Docker installation

1. Download and install Docker: `apt install docker`

2. Gives permisions so you can run it everywhere: `sudo usermod -aG docker $USER`

3. Starts Docker's service: `service docker start`

4. Starts Docker's service each time you run the SO: `chkconfig docker on`


## ⭐ Feedback and bugs 🐞

If you find any bug or just want to give your feedback (remember the ⭐ ^^), **Feel free to do it**. I am, as you, constantly learning and things change so quickly that... no one knows ^^

## Version control 📝

- [v1.0](https://github.com/Inushin/dockerAngularNginxNodePostgreSQL/tree/v1.0) - Repository created - 26/06/2022
- [v2.0](https://github.com/Inushin/dockerAngularNginxNodePostgreSQL/tree/v2.0) - Update to Angular 15 - 20/04/2023
- [v2.1 - Current](https://github.com/Inushin/dockerAngularNginxNodePostgreSQL/tree/v2.1) - Update Dockerfiles and Node to Node 18.16 (Alpine) - 13/05/2023
