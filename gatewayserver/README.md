# Comando para rodar redis no docker

``docker run -p 6379:6379 --name nexoredis -d redis``

# Comando para rodar relatório apache benchmark

`` ab -n 10 -c 2 -v 3 http://localhost:8072/nexopay/cards/api/contact-info``