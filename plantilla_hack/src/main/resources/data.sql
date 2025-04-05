INSERT INTO users (id, full_name, email, password, created_at, updated_at)
VALUES (1, 'Jon Doe', 'jon.doe@example.com', '$2a$10$DummyPasswordHashHere', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
--la psw es password123. ta encriptada

INSERT INTO consum (consum_date, ducha, grifo, lavadora, cisterna, lavaplatos, total, user_id)
VALUES ('2025-04-01', 70, 20, 15, 30, 18, 153, 1),
       ('2025-04-02', 65, 18, 20, 25, 16, 144, 1),
       ('2025-04-03', 80, 22, 10, 28, 17, 157, 1);