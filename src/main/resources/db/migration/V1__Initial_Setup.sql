CREATE TABLE users
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role     VARCHAR(255) NOT NULL
);

CREATE TABLE user_seq (
                          next_val BIGINT
);

INSERT INTO user_seq VALUES (0);

CREATE TABLE tickets
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(100) NOT NULL,
    description TEXT,
    status      VARCHAR(20)  NOT NULL,
    user_id     BIGINT,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE tickets_seq (
                            next_val BIGINT NOT NULL
);

INSERT INTO tickets_seq (next_val) VALUES (1);