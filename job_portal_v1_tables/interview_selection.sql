CREATE TABLE Interview_Selection (
    interview_id INT AUTO_INCREMENT PRIMARY KEY,
    job_id INT,
    user_id INT,
    interview_date DATETIME,
    interview_outcome ENUM('selected', 'rejected'),
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by INT,
    FOREIGN KEY (job_id) REFERENCES Jobs(job_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (created_by) REFERENCES Users(user_id) ON DELETE SET NULL
);
INSERT INTO Interview_Selection (interview_id, job_id, user_id, interview_date, interview_outcome, created_by)
VALUES 
(1, 1, 1, '2025-01-25 10:00:00', 'selected', 3);