CREATE TABLE Educations (
    education_id INT AUTO_INCREMENT PRIMARY KEY,
    job_seeker_id INT,
    degree VARCHAR(255) NOT NULL,
    major VARCHAR(255),
    institute_name VARCHAR(255) NOT NULL,
    year_of_passing YEAR NOT NULL
);
