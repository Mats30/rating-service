# Rating service

Rating service app was created with Spring Boot, Docker, MongoDb, React and Redux

### Backend & Database

To run application you need to have installed Docker with Docker Compose and NodeJS with npm. After clone you need to run 

```
docker-compose up --build
```

in main directory with `docker-compose.yml` file

After that backend and database should be ready, you can check db access via mongo-express with your browser

```
localhost:8081 or ip_address_of_docker:8081
```

Database is initialized with few records. Backend is listening on port 8080.


### Frontend

To run frontend part you need to have NodeJS with npm. After clone you need to go to "frontend" directory and run

```
npm install
```

After that please check endpoint urls, you'll find it in `frontend/src/config/config.js` file. Set `baseUrl` to backend address. Then you can run
application with 

```
npm start
```

Application should open in your default browser, if not, type below address

```
http://localhost:9000
```




## Authors

* **Mateusz Rataj** - [Mats30](https://github.com/Mats30)
