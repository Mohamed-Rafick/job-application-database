CREATE TABLE Certifications (
    certification_id INT AUTO_INCREMENT PRIMARY KEY,
    job_seeker_id INT,
    name VARCHAR(255) NOT NULL,
    issuer VARCHAR(255),
    issued_date DATE NOT NULL,
    valid_until DATE,
    FOREIGN KEY (job_seeker_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
