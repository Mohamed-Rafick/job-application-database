CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,  -- Unique identifier for each user (AUTO_INCREMENT in MySQL)
    user_name VARCHAR(100) NOT NULL,         -- Readable username for the user
    first_name VARCHAR(50) NOT NULL,         -- User's first name
    last_name VARCHAR(50) NOT NULL,          -- User's last name
    email VARCHAR(255) UNIQUE NOT NULL,      -- Email ID (should be unique)
    password TEXT NOT NULL,                  -- Encrypted password using bcrypt or hashing function
    ssn VARCHAR(20) UNIQUE,                         -- Encrypted SSN (only for job seekers) using bcrypt or hashing function
    phone_number VARCHAR(20) NOT NULL,       -- Contact number
    role ENUM('JOB_SEEKER', 'HIRING_PERSON') DEFAULT NULL,  -- Use the ENUM type for role
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Account creation time
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- Last update time (MySQL syntax for auto-updating timestamp)
);

-- Insert a sample user
INSERT INTO Users (user_name, first_name, last_name, email, password, ssn, phone_number, role)
VALUES ('john_doe', 'John', 'Doe', 'john.doe@example.com', 'password123', '123-45-6789', '555-1234', 'JOB_SEEKER');

