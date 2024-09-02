# Skeleton

Скелет наших сервисов

# Важно
Для начала разработки необходимо подготовить локальную среду. Это можно сделать либо вручную, либо при помощи docker

# Настройка postgres

1) Устанавливаем postgres. [Ссылка](https://www.postgresql.org/download/)
2) Создаем в приложении postgres сервер (дефолтно на порту 5432).
3) Далее переходим в dbeaver и подключаемся к нашему серверу.
4) Создаем нашу первую таблицу. Пример:
```roomsql
-- Таблица пользователей
CREATE TABLE IF NOT EXISTS "user" (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    date_joined TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    avatar_url VARCHAR(255),
    role_id INTEGER REFERENCES UserRole(role_id) DEFAULT (SELECT role_id FROM UserRole WHERE role_name = 'user')
);

-- Индекс на user_id в таблице "User"
CREATE INDEX idx_user_id ON "user"(user_id);

-- Таблица ролей пользователей
CREATE TABLE IF NOT EXISTS UserRole (
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(50) UNIQUE NOT NULL
);
```
5) SERIAL представляет автоинкрементирующееся числовое значение.
6) При успешном создании таблицы в логе будет текст:
```text
Query CREATE TABLE IF NOT EXISTS "test" (
   user_id SERIAL PRIMARY KEY
   );
дата создания
```
7) Добавляем наши креды в application.yml
```yaml
datasource:
  platform: postgres
  driverClassName: org.postgresql.Driver
  url: jdbc:postgresql://localhost:5432/ваша_база
  username: юзер
  password: пароль
```

# Настройка Kafka

1) Устанавливаем Kafka через brew или с офф сайта. Скачивать Binary downloads: Scala 2.13 [Ссылка](https://kafka.apache.org/downloads)
2) Создаем папку data в разархивированном архиве Kafka.
3) В папке data создаем еще две папки Kafka и Zookeeper. 
4) Копируем путь до этих файлов
```text
абсолютный путь/kafka_2.13-3.6.1/data/kafka
абсолютный путь/kafka_2.13-3.6.1/data/zookeper
```
5) Переходим в папку абсолютный путь/config/ и редактируем файл zookeeper.properties. Находим dataDir и вставляем путь до /kafka_2.13-3.6.1/data/zookeper.
6) Редактируем файл server.properties. Находим в нем log.dirs и прописываем путь до /kafka_2.13-3.6.1/data/kafka.
7) Переходим в корневую папку kafka_2.13-3.6.1
8) Запускаем Zookeeper 
```shell
bin/zookeeper-server-start.sh config/zookeeper.properties. 
```
При правильной настройке в логах будет сообщение:
```text
[2024-02-07 09:48:54,563] INFO binding to port 0.0.0.0/0.0.0.0:2181 (org.apache.zookeeper.server.NIOServerCnxnFactory)
```
9) Далее открываем второй терминал и выполняем вторую команду. 
```shell
bin/kafka-server-start.sh config/server.properties
```
При правильной настройке в логах будет сообщение:
```text
[2024-02-07 09:51:01,535] INFO [KafkaServer id=0] started (kafka.server.KafkaServer)
```
10) Открываем новый терминал и создаем наш первый topic
```shell
bin/kafka-topics.sh --create --topic имя_топика --partitions 3 --replication-factor 1 --bootstrap-server localhost:9092
```
При успешном создании в логе будет выведен текст
```text
Created topic имя топика.
```
Параметры:
```text
--create	Создает новый топик.
--topic <topic_name>	Имя топика.
--partitions <number>	Количество разделов.
--replication-factor <factor>	Репликация.
--bootstrap-server <server>	Адрес брокера.
```
11) Добавляем наши креды в application.yml
```yaml
kafka:
  bootstrap-servers: ${KAFKA_URL}
  consumer:
    group-id: your-group-id
    auto-offset-reset: earliest
    key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
    value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
  producer:
    key-serializer: org.apache.kafka.common.serialization.StringSerializer
    value-serializer: org.apache.kafka.common.serialization.StringSerializer
``` 

# Настройка через Docker

1) Запустите программу Docker Desktop

2) В терминале в папке с файлом:
[docker-compose.yml](docker-compose.yml)
запустите команду
```shell
docker compose up
```
В результате у вас должны стартовать контейнеры postgresql, kafka, kafka-ui, zookeeper. 
Это можно проверить через ui программы Docker Desktop. Названия контейнеров могут быть с префиксом

# Что умеет проект
1) Настроена интеграция с postgres
2) Настроена интеграцяи с Kafka
3) Умеет в дефолтное логирование 
4) Умеет обрабатывать ошибки для http
```java
 @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handeException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
``` 
5) Сваггер доступен по ссылке 
```text
localhost:8080/swagger-ui/index.html#/
``` 
6) Умеет в базовую авторизацию, для выполнения http запросов необходимо провести Basic auth. Креды указаны в application.yml
```yaml
security:
  user:
    password: password
```

# Поздравляю, проект настроен.

    