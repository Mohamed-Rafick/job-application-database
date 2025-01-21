CREATE TABLE Certifications (
    certification_id INT AUTO_INCREMENT PRIMARY KEY,
    job_seeker_id INT,
    name VARCHAR(255) NOT NULL,
    issuer VARCHAR(255),
    issued_date DATE NOT NULL,
    valid_until DATE,
    FOREIGN KEY (job_seeker_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
INSERT INTO Certifications (job_seeker_id, name, issuer, issued_date, valid_until)
VALUES 
    (1, 'AWS Certified Developer', 'Amazon', '2023-06-15', '2025-06-15'),
    (1, 'Java SE 8 Programmer', 'Oracle', '2022-09-10', NULL);