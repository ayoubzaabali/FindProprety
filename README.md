# 🐳 Docker + Spring/Spring boot +  Angular 16 + Nginx + Mariadb

![stack](https://github.com/ayoubzaabali/FindProprety/assets/78790570/58187b1b-616a-429e-b04c-38f01717a6ee)



# Description 📋

A complete stack for running Spring/Spring boot & Angular 16 App into Docker containers using the docker-compose tool, with a proxy Nginx between front and back (connected to the DB container).

# List of  containers:

- `real_estate_fe`, the one that runs the build of Angular APP in a container with Nginx.
- `backend`, this container is running the business logic using spring JDBC and SQL queries & rest API, this container contains 3 modules (business, modules, rest)
- `mariadb` storing the MariaDB database Tables.
- `phpmyadmin` handles the administration of MariaDB.

# Testing ⌨

0. You need **docker** and **docker-compose** where you are going to launch this so if you do not have it... refer to this link [HERE]([https://github.com/Inushin/dockerAngularNginxNodePostgreSQL#installing-docker-and-docker-compose-](https://docs.docker.com/engine/install/))

1. Clone this rep.
   ```
   git clone https://github.com/ayoubzaabali/FindProprety
   ```

2. To check that everything runs correctly Run :
   ```
   docker-compose up
   ```  

3. If there are no errors, stop (`ctrl+C`) and delete containers with :
   ```
   docker-compose up -d
   ```  
  This will run the container logs in the background.
   

8. To check that everything is running correctly in the background, run:
   ```
   docker-compose ps -a
   ```
   and you will see the running containers.






## ⭐ Feedback and bugs 🐞

If you find any bugs or you just want to give us feedback ^^, **Feel free to do it**. ^^ ^^


