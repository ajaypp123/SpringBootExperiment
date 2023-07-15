
INSERT INTO users (name) VALUES
    ('User 1'),
    ('User 2'),
    ('User 3'),
    ('User 4'),
    ('User 5'),
    ('User 6'),
    ('User 7'),
    ('User 8'),
    ('User 9'),
    ('User 10'),
    ('User 11'),
    ('User 12'),
    ('User 13'),
    ('User 14'),
    ('User 15');

INSERT INTO posts (title, content, user_id) VALUES
    ('Post 1', 'Content 1', 1),
    ('Post 2', 'Content 2', 1),
    ('Post 3', 'Content 3', 1),
    ('Post 16', 'Content 16', 2),
    ('Post 17', 'Content 17', 2),
    ('Post 18', 'Content 18', 2),
    ('Post 31', 'Content 31', 3),
    ('Post 32', 'Content 32', 3),
    ('Post 33', 'Content 33', 3);

INSERT INTO comments (text, user_id, post_id) VALUES
    ('Comment 1', 1, 1),
    ('Comment 2', 2, 1),
    ('Comment 3', 3, 2);
