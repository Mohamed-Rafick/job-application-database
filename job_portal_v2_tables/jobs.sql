CREATE TABLE Jobs (
    job_id INT AUTO_INCREMENT PRIMARY KEY,   -- Unique identifier for each job
    user_id INT NOT NULL,                    -- ID of the user posting the job
    position VARCHAR(100) NOT NULL,          -- Job position
    company VARCHAR(100) NOT NULL,           -- Company offering the job
    experience VARCHAR(50),                  -- Experience required for the position
    skills JSON NOT NULL,                    -- List of required skills (JSON format)
    salary VARCHAR(50),                      -- Salary for the job
    location VARCHAR(100),                   -- Location of the job
    education VARCHAR(100),                  -- Education required for the job
    job_type ENUM('Full_Time', 'Part_Time', 'Remote', 'Contract') NOT NULL,  -- Type of job
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Timestamp of job creation
    last_date DATE NOT NULL,                 -- Last date for applying to the job
    hiring_done BOOLEAN DEFAULT FALSE,       -- Whether the hiring is completed or not
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- Timestamp of last update
    description TEXT,                        -- Description of the job role and responsibilities
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,  -- Foreign key to Users table
);

