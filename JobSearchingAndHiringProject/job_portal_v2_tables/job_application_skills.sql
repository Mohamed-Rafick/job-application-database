CREATE TABLE Job_Application_Skills (
    job_application_skills_id INT NOT NULL AUTO_INCREMENT,  -- Unique ID for the table
    application_id INT NOT NULL,          -- Job application ID (links to Job_Applications table)
    user_id INT NOT NULL,                 -- User ID (links to Users table)
    job_id INT NOT NULL,                  -- Job ID (links to Jobs table)
    skills JSON NOT NULL,                 -- Skills stored as a JSON array
    PRIMARY KEY (job_application_skills_id),  -- Single primary key for the table
    FOREIGN KEY (application_id) REFERENCES Job_Applications(application_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (job_id) REFERENCES Jobs(job_id) ON DELETE CASCADE
);
