# Spring cloud example

## Samples

 * custom spring-boot-thrift starter
 * custom spring-boot-thrift client with apache object pool
 * zuul with custom thrift filter for add authentication data to thrift objects
 * Hystrix dashboard in gateway-server, see http://{you_docker_machine_host}:9000/hystrix/
 * consule http://{you_docker_machine_host}:8500/

## Build, run, rebuild

build: `./gradlew build`
run: `docker-compose up -d`
rebuild: `./rebuild-{sub-project-name}`

rebuild script redeploy app automatically

example:

    ./gradlew build && docker-compose up -d && ./rebuild-fbi-service
