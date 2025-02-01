CREATE TABLE Notifications (
    notification_id INT AUTO_INCREMENT PRIMARY KEY,
    sent_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    sent_by INT,
    job_id INT,
    job_seeker_id INT,
    notification_type VARCHAR(50),  -- e.g., 'call', 'SMS', 'email', 'paper mail'
    FOREIGN KEY (sent_by) REFERENCES Users(user_id) ON DELETE SET NULL,
    FOREIGN KEY (job_id) REFERENCES Jobs(job_id) ON DELETE CASCADE,
    FOREIGN KEY (job_seeker_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
INSERT INTO Notifications (sent_by, job_id, job_seeker_id, notification_type)
VALUES (3, 1, 1, 'email');