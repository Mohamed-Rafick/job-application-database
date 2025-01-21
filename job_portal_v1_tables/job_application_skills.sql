CREATE TABLE Job_Application_Skills (
    application_id INT NOT NULL,          -- Job application ID (links to Job_Applications table)
    user_id INT NOT NULL,                 -- User ID (links to Users table)
    job_id INT NOT NULL,                  -- Job ID (links to Jobs table)
    skills JSON NOT NULL,                 -- Skills stored as a JSON array
    PRIMARY KEY (application_id, user_id, job_id),  -- Composite primary key for uniqueness
    FOREIGN KEY (application_id) REFERENCES Job_Applications(application_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (job_id) REFERENCES Jobs(job_id) ON DELETE CASCADE
);

INSERT INTO Job_Application_Skills (application_id, user_id, job_id, skills)
VALUES 
(1, 2, 1, '["Java", "Spring Boot", "SQL"]');
