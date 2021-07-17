**Preconditions:**

1. Install Docker on your local machine.
2. Run "docker-compose up" cli command from spring-boot-basics directory.
3. Analyze database schema, identify relationship.

**Tasks:**

1. Design & implement "Car" CRUD REST interface based on prepared infrastructure.
2. Cover the most important pieces by unit tests
   (it is allowed to use third party dependencies).
3. Design & implement REST endpoint which takes brand name and returns the list of engineers' names who are responsible for given
   brand. Identify different implementations and compare performance
   (Use Spring JDBC Template and plain SQL).
4. Build so-called "fat" jar with all necessary dependencies for easy run the application.
5. Implemented secure endpoints with HTTP Basic authentication.
6. Speed up "find by given criteria" requests on database layer in case of huge amount of entities if possible.

**Useful docker cli commands:**

- containers: docker ps -a
- images: docker images
- connect to running container: docker exec -it ${container_id} /bin/sh
- delete all containers: docker rm -vf $(docker ps -a -q)
- delete all images: docker rmi -f $(docker images -a -q)