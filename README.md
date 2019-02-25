### Build the application

```
./mvnw clean install
```

### Build docker image

```
./mvnw clean install dockerfile:build
```

### Push the docker image to registry

```
./mvnw dockerfile:push
``` 

### Start the mysql container

```
docker run --name mysql -e MYSQL_ROOT_PASSWORD=password -d mysql
```