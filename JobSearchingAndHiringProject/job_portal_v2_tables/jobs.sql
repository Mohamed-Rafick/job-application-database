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
    updated_by INT,                          -- ID of the user who last updated the job posting
    description TEXT,                        -- Description of the job role and responsibilities
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,  -- Foreign key to Users table
    FOREIGN KEY (updated_by) REFERENCES Users(user_id) ON DELETE SET NULL  -- Foreign key for updates
);
INSERT INTO Jobs (user_id, position, company, experience, skills, salary, location, education, job_type, last_date, updated_by, description) 
VALUES 
(1, 'Dentist', 'SmileCare Dental', '3-5 years', '["General Dentistry", "Oral Surgery", "Patient Care"]', '$120,000/year', 'Los Angeles, CA', "Doctor of Dental Surgery (D.D.S.)", 'Full-Time', '2025-03-15', 1, 'Provide dental care services, including examinations, cleanings, and treatment of dental diseases. Perform oral surgeries and educate patients on oral hygiene. Ensure high-quality care in a comfortable environment.');
