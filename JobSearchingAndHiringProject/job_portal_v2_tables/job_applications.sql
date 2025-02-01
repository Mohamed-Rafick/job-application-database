CREATE TABLE Job_Applications (
    application_id INT AUTO_INCREMENT PRIMARY KEY,
    job_id INT NOT NULL,
    job_seeker_id INT NOT NULL,
    resume BLOB,
    experience VARCHAR(100),
    work_authorization ENUM('US Citizen', 'Green Card', 'H1B', 'OPT', 'Other') NOT NULL,
    status ENUM('Pending', 'Shortlisted', 'Hired', 'Interviewed', 'Rejected') DEFAULT 'Pending',
    applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by INT,
    FOREIGN KEY (job_id) REFERENCES Jobs(job_id) ON DELETE CASCADE,
    FOREIGN KEY (job_seeker_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (updated_by) REFERENCES Users(user_id) ON DELETE SET NULL
);

INSERT INTO Job_Applications (job_id, job_seeker_id, resume, experience, work_authorization, status, updated_by)
VALUES 
(1, 2, LOAD_FILE(''), '3 years', 'H1B', 'Pending', 3);