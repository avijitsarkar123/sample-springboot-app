### Build the application

```
./mvnw clean install
```

### Build docker image

```
./mvnw dockerfile:build
```

### Push the docker image to registry

```
./mvnw dockerfile:push
```