# Docker and Kubernetes

You can find the code base related to Docker and Kubernetes knowldge base sessions. 

## Web Running Command

    docker run -d --rm -p 4200:4200 --name web -v $(pwd)/web:/app -v /app/node_modules web

## ApiService Running Command
    docker run 
    -d 
    --rm 
    -p 4200:4200 
    --name web 
    -v $(pwd)/web:/app 
    -v /app/node_modules 
    web
