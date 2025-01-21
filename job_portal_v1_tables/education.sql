CREATE TABLE Education (
    education_id INT AUTO_INCREMENT PRIMARY KEY,
    job_seeker_id INT,
    degree VARCHAR(255) NOT NULL,
    major VARCHAR(255),
    institute_name VARCHAR(255) NOT NULL,
    year_of_passing YEAR NOT NULL,
    FOREIGN KEY (job_seeker_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
INSERT INTO Education (job_seeker_id, degree, major, institute_name, year_of_passing)
VALUES 
    (1, 'Bachelor\'s', 'Computer Science', 'Tech University', 2022),
    (1, 'Master\'s', 'Software Engineering', 'Global Tech Institute', 2024);