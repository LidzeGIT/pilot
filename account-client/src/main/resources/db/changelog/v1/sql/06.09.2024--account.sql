--liquibase formatted sql

--changeset lmegrelidze:06.09.2024--account.sql

-- Таблица для типов счетов
CREATE TABLE account_types (
    account_type_id SERIAL PRIMARY KEY,
    account_type VARCHAR(50) UNIQUE NOT NULL   -- SAVINGS, CURRENT и т.д.
);

-- Таблица для валют
CREATE TABLE currencies (
    currency_id SERIAL PRIMARY KEY,
    currency_code VARCHAR(5) UNIQUE NOT NULL   -- например, USD, EUR
);

-- Таблица для счетов
CREATE TABLE accounts (
    account_id SERIAL PRIMARY KEY,
    account_type_id INT REFERENCES account_types(account_type_id) ON DELETE CASCADE,
    user_id INT,
    is_deleted boolean DEFAULT true,
    amount NUMERIC(15, 2) DEFAULT 0.00,
    currency_id INT REFERENCES currencies(currency_id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO account_types (account_type)
VALUES
    ('SAVINGS'),
    ('CURRENT'),
    ('CORPORATE'),
    ('JUNIOR'),
    ('JOINT');

INSERT INTO currencies (currency_code)
VALUES
    ('USD'),
    ('EUR'),
    ('GBP'),
    ('RUB');
