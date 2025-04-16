# latest RabbitMQ 4.x

docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management

### Para montar um webhook fake

- https://console.hookdeck.com/

- Menu Developer->HookDeck Console
  - Rodar comandos

hookdeck listen 8071 source --cli-path /monitor   