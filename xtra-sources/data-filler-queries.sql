-- sample sql queries to fill your data
-- 📘 customer (10 entries)
INSERT INTO customer (id, name, email, contact_number, birth_date, membership_date, is_fee_paid)
VALUES
  (1, 'Amit Sharma', 'amit@example.com', '9876543210', '1995-06-15', '2023-01-01', b'1'),
  (2, 'Neha Rao', 'neha@example.com', '9823456789', '1997-02-22', '2023-02-15', b'1'),
  (3, 'John Doe', 'john@example.com', '9998887776', '1992-10-05', '2024-03-01', b'0'),
  (4, 'Priya Menon', 'priya@example.com', '9988776655', '1994-09-12', '2024-01-10', b'1'),
  (5, 'Arjun Verma', 'arjun@example.com', '9911223344', '1993-08-21', '2023-12-01', b'1'),
  (6, 'Kavita Rani', 'kavita@example.com', '9876501234', '1996-11-23', '2024-04-01', b'1'),
  (7, 'Rahul Singh', 'rahul@example.com', '9988123456', '1991-03-17', '2023-06-20', b'0'),
  (8, 'Sneha Patil', 'sneha@example.com', '9876123450', '1998-01-30', '2023-11-11', b'1'),
  (9, 'Siddharth Mehta', 'sid@example.com', '9001122334', '1990-12-08', '2024-05-15', b'1'),
  (10, 'Divya Kapoor', 'divya@example.com', '9022334455', '1993-07-19', '2024-06-01', b'1');


-- 📚 book (50 entries)
INSERT INTO book (id, title, author, total_copies, available_copies)
VALUES
  (1, 'Effective Java', 'Joshua Bloch', 5, 3),
  (2, 'Clean Code', 'Robert C. Martin', 3, 0),
  (3, 'Spring in Action', 'Craig Walls', 4, 2),
  (4, 'Head First Java', 'Kathy Sierra', 5, 1),
  (5, 'Java Concurrency in Practice', 'Brian Goetz', 3, 1),
  (6, 'The Pragmatic Programmer', 'Andy Hunt', 4, 3),
  (7, 'Refactoring', 'Martin Fowler', 4, 2),
  (8, 'Design Patterns', 'Erich Gamma', 2, 2),
  (9, 'Introduction to Algorithms', 'Cormen', 3, 2),
  (10, 'Cracking the Coding Interview', 'Gayle Laakmann', 5, 5),
  (11, 'The Art of Computer Programming', 'Knuth', 1, 1),
  (12, 'Data Structures in Java', 'Narasimha Karumanchi', 3, 2),
  (13, 'Algorithms in Java', 'Sedgewick', 2, 1),
  (14, 'Grokking Algorithms', 'Aditya Bhargava', 4, 3),
  (15, 'Microservices Patterns', 'Chris Richardson', 3, 3),
  (16, 'Cloud Native Java', 'Josh Long', 2, 1),
  (17, 'Test-Driven Development', 'Kent Beck', 2, 1),
  (18, 'Agile Software Development', 'Robert C. Martin', 3, 3),
  (19, 'Domain-Driven Design', 'Eric Evans', 2, 1),
  (20, 'Java Puzzlers', 'Joshua Bloch', 2, 2),
  (21, 'Java: The Complete Reference', 'Herbert Schildt', 5, 3),
  (22, 'Pro Spring Boot', 'Felipe Gutierrez', 3, 2),
  (23, 'Spring Boot in Practice', 'Somnath Musib', 3, 1),
  (24, 'Beginning Spring Boot', 'K. Siva Prasad Reddy', 2, 2),
  (25, 'Building Microservices', 'Sam Newman', 4, 2),
  (26, 'Kubernetes in Action', 'Marko Luksa', 2, 2),
  (27, 'Docker Deep Dive', 'Nigel Poulton', 2, 2),
  (28, 'CI/CD for Java', 'Jenkins Team', 2, 2),
  (29, 'System Design Interview', 'Alex Xu', 4, 3),
  (30, 'Java 21 Features', 'Oracle Team', 2, 2),
  (31, 'API Design in Java', 'Jaroslav Tulach', 2, 1),
  (32, 'RESTful Java', 'Bill Burke', 3, 3),
  (33, 'Building REST APIs with Spring', 'John Carnell', 2, 2),
  (34, 'Learning Spring Security', 'Mick Knutson', 2, 2),
  (35, 'OAuth 2 in Action', 'Justin Richer', 2, 2),
  (36, 'Java Performance Tuning', 'Charlie Hunt', 3, 2),
  (37, 'Java Memory Management', 'Ming-Yee Iu', 2, 2),
  (38, 'Modern Java Recipes', 'Ken Kousen', 3, 3),
  (39, 'Reactive Spring', 'Josh Long', 2, 2),
  (40, 'Reactive Programming in Java', 'Venkat Subramaniam', 2, 2),
  (41, 'Concurrency in Practice', 'Brian Goetz', 3, 3),
  (42, 'Designing Data-Intensive Applications', 'Martin Kleppmann', 4, 4),
  (43, 'The Clean Coder', 'Robert C. Martin', 3, 3),
  (44, 'Soft Skills for Developers', 'John Sonmez', 2, 2),
  (45, 'Code Complete', 'Steve McConnell', 3, 3),
  (46, 'Programming Pearls', 'Jon Bentley', 2, 2),
  (47, 'Working Effectively with Legacy Code', 'Michael Feathers', 3, 3),
  (48, 'Essential Scrum', 'Kenneth Rubin', 2, 2),
  (49, 'Refactoring UI', 'Adam Wathan', 2, 2),
  (50, 'Understanding the 4 Pillars of OOP', 'David West', 2, 2);


-- 🔄 issued_book (15 entries)
INSERT INTO issued_book (id, issued_date, due_date, return_date, is_returned, fine_amount, customer_id, book_id)
VALUES
  (1, '2024-07-01', '2024-07-10', NULL, b'0', NULL, 1, 1),
  (2, '2024-07-02', '2024-07-12', NULL, b'0', NULL, 1, 3),
  (3, '2024-06-01', '2024-06-10', '2024-06-20', b'1', 100, 2, 2),
  (4, '2024-07-05', '2024-07-15', NULL, b'0', NULL, 4, 4),
  (5, '2024-07-06', '2024-07-16', NULL, b'0', NULL, 5, 5),
  (6, '2024-07-06', '2024-07-16', NULL, b'0', NULL, 6, 6),
  (7, '2024-07-06', '2024-07-16', NULL, b'0', NULL, 7, 7),
  (8, '2024-07-06', '2024-07-16', NULL, b'0', NULL, 8, 8),
  (9, '2024-07-06', '2024-07-16', NULL, b'0', NULL, 9, 9),
  (10, '2024-07-06', '2024-07-16', NULL, b'0', NULL, 10, 10),
  (11, '2024-07-01', '2024-07-12', NULL, b'0', NULL, 1, 11),
  (12, '2024-07-01', '2024-07-12', NULL, b'0', NULL, 2, 12),
  (13, '2024-07-01', '2024-07-12', NULL, b'0', NULL, 3, 13),
  (14, '2024-07-01', '2024-07-12', NULL, b'0', NULL, 4, 14),
  (15, '2024-07-01', '2024-07-12', NULL, b'0', NULL, 5, 15);


-- 💳 payment (10 entries)
INSERT INTO payment (id, amount, is_successful, payment_date, payment_id, customer_id)
VALUES
  (1, 251.00, b'1', '2024-07-01', 'PAY001', 1),
  (2, 251.00, b'1', '2024-07-01', 'PAY002', 2),
  (3, 251.00, b'0', '2024-07-01', 'PAY003', 3),
  (4, 251.00, b'1', '2024-07-01', 'PAY004', 4),
  (5, 251.00, b'1', '2024-07-01', 'PAY005', 5),
  (6, 251.00, b'1', '2024-07-01', 'PAY006', 6),
  (7, 251.00, b'0', '2024-07-01', 'PAY007', 7),
  (8, 251.00, b'1', '2024-07-01', 'PAY008', 8),
  (9, 251.00, b'1', '2024-07-01', 'PAY009', 9),
  (10
  , 251.00, b'1', '2024-07-01', 'PAY010', 10);


-- ⭐ review (10+ entries)
INSERT INTO review (id, comment, rating, customer_id, book_id)
VALUES
  (1, 'Excellent book.', 5, 1, 1),
  (2, 'Very informative.', 4, 2, 2),
  (3, 'Too advanced for beginners.', 3, 3, 3),
  (4, 'Must-read for Java devs.', 5, 4, 4),
  (5, 'Good coverage of Spring.', 4, 5, 5),
  (6, 'Average content.', 3, 6, 6),
  (7, 'Nice examples.', 4, 7, 7),
  (8, 'Helped in interviews.', 5, 8, 8),
  (9, 'Classic material.', 5, 9, 9),
  (10, 'Well structured.', 4, 10, 10);