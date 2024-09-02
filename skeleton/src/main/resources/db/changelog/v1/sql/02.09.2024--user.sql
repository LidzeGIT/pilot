--liquibase formatted sql

--changeset lmegrelidze:02.09.2024--user.sql
CREATE TABLE users_role (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE "user" (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    date_joined TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_login TIMESTAMP,
    avatar_url VARCHAR(255),
    role_id BIGINT,
    FOREIGN KEY (role_id) REFERENCES users_role(id)
);

INSERT INTO users_role (id, name) VALUES
    (1, 'user'),
    (2, 'admin');

INSERT INTO "user" (username, email, password, role_id) VALUES
    ('admin', 'admin@mail.ru', 'qwerty', 2);