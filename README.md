# Sessão Técnica - Confluent + Kafka + Protocol Buffers

Uma abordagem sobre um projeto JAVA empregando as tecnologias Confluent + Kafka + Protocol Buffers.

## O que é o Apache Kafka?

Apache Kafka é uma plataforma de streaming de eventos distribuída pela comunidade, capaz de lidar com trilhões de eventos por dia. Inicialmente concebido como uma fila de mensagens, o Kafka é baseado na abstração de um log de confirmação distribuído.

---

![image](https://images.ctfassets.net/8vofjvai1hpv/44dWd6zER4khIrMsHfYUW8/da88fd9313b7b4c9750f564c7374ce0d/where_apache_fits_in.png)
## O que é o Confluent?

Fundado pelos desenvolvedores originais do Apache Kafka, o Confluent oferece a distribuição mais completa do Kafka com o Confluent Platform. O Confluent Platform aprimora o Kafka com recursos adicionais de comunidade e comerciais projetados para aprimorar a experiência de streaming de operadores e desenvolvedores em produção, em grande escala.

## O que é o Protocol Buffers?

Protocol Buffers (protobuf) é um mecanismo ou método de serializar dados estruturados. Muito útil para comunicação entre serviços ou até mesmo guardar dados. Criado pelo google para ser mais rápido e comprimido que o XML.

Veja mais em: [https://developers.google.com/protocol-buffers](https://developers.google.com/protocol-buffers)



## Comandos

Verificar Tópicos

```shell
kafka-topics --list --bootstrap-server localhost:9092
```

Criar Tópico

```shell
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test-meetup
```
