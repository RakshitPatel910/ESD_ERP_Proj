# -- Disable foreign key checks to allow resetting tables with dependencies
# SET FOREIGN_KEY_CHECKS = 0;
#
# -- Reset all tables
# TRUNCATE TABLE placement_specialisation;
# TRUNCATE TABLE placement_domain;
# TRUNCATE TABLE placement;
# TRUNCATE TABLE specialisation;
# TRUNCATE TABLE domain;
# TRUNCATE TABLE employee;
# TRUNCATE TABLE organisation;
#
# -- Re-enable foreign key checks
# SET FOREIGN_KEY_CHECKS = 1;


# INSERT INTO organisation (name, address) VALUES ('ABC Corp', '123 Street, City');
# INSERT INTO organisation (name, address) VALUES ('XYZ Ltd', '456 Avenue, Town');
#
# INSERT INTO employee (first_name, last_name, email, department_id, password) VALUES ('employee', '1', 'employee1@gmail.com', 3, 'password');
#
# INSERT INTO domain (name) VALUES
#     ('MTech CSE'),
#     ('iMTech ECE'),
#     ('BTech IT'),
#     ('BTech EEE');
#
# INSERT INTO specialisation (code, name, description, cred_required) VALUES
#     ('T&S', 'Theory & Systems', 'Focus on core systems and theoretical aspects of computing.', 120.0),
#     ('DS', 'Data Science', 'Specialisation in big data, machine learning, and AI.', 130.0),
#     ('VLSI', 'VLSI Design', 'Specialisation in Very-Large-Scale Integration for hardware.', 125.0),
#     ('Robotics', 'Robotics', 'Focus on robotics and automation systems.', 128.0);


-- Organisation Table
INSERT INTO organisation (name, address)
SELECT 'ABC Corp', '123 Street, City'
WHERE NOT EXISTS (
    SELECT 1 FROM organisation WHERE name = 'ABC Corp' AND address = '123 Street, City'
);

INSERT INTO organisation (name, address)
SELECT 'XYZ Ltd', '456 Avenue, Town'
WHERE NOT EXISTS (
    SELECT 1 FROM organisation WHERE name = 'XYZ Ltd' AND address = '456 Avenue, Town'
);

-- Domain Table
INSERT INTO domain (name)
SELECT 'MTech CSE'
WHERE NOT EXISTS (SELECT 1 FROM domain WHERE name = 'MTech CSE');

INSERT INTO domain (name)
SELECT 'iMTech ECE'
WHERE NOT EXISTS (SELECT 1 FROM domain WHERE name = 'iMTech ECE');

INSERT INTO domain (name)
SELECT 'BTech IT'
WHERE NOT EXISTS (SELECT 1 FROM domain WHERE name = 'BTech IT');

INSERT INTO domain (name)
SELECT 'BTech EEE'
WHERE NOT EXISTS (SELECT 1 FROM domain WHERE name = 'BTech EEE');

-- Specialisation Table
INSERT INTO specialisation (code, name, description, cred_required)
SELECT 'T&S', 'Theory & Systems', 'Focus on core systems and theoretical aspects of computing.', 120.0
WHERE NOT EXISTS (SELECT 1 FROM specialisation WHERE code = 'T&S' AND name = 'Theory & Systems');

INSERT INTO specialisation (code, name, description, cred_required)
SELECT 'DS', 'Data Science', 'Specialisation in big data, machine learning, and AI.', 130.0
WHERE NOT EXISTS (SELECT 1 FROM specialisation WHERE code = 'DS' AND name = 'Data Science');

INSERT INTO specialisation (code, name, description, cred_required)
SELECT 'VLSI', 'VLSI Design', 'Specialisation in Very-Large-Scale Integration for hardware.', 125.0
WHERE NOT EXISTS (SELECT 1 FROM specialisation WHERE code = 'VLSI' AND name = 'VLSI Design');

INSERT INTO specialisation (code, name, description, cred_required)
SELECT 'Robotics', 'Robotics', 'Focus on robotics and automation systems.', 128.0
WHERE NOT EXISTS (SELECT 1 FROM specialisation WHERE code = 'Robotics' AND name = 'Robotics');

-- Employee Table $2a$10$rrfaQZDWOO9bA7EThiC2DuD1hmdsV.EtCbhW5zPTLwFPk0bsfWVlS
INSERT INTO employee (first_name, last_name, email, department_id, password)
-- SELECT 'employee', '1', 'employee1@gmail.com', 3, 'password'
SELECT 'employee', '1', 'employee1@gmail.com', 3, '$2a$10$rrfaQZDWOO9bA7EThiC2DuD1hmdsV.EtCbhW5zPTLwFPk0bsfWVlS'
WHERE NOT EXISTS (
    SELECT 1 FROM employee WHERE email = 'employee1@gmail.com'
);

INSERT INTO employee (first_name, last_name, email, department_id, password)
SELECT 'employee', '2', 'employee2@gmail.com', 1, '$2a$10$rrfaQZDWOO9bA7EThiC2DuD1hmdsV.EtCbhW5zPTLwFPk0bsfWVlS'
WHERE NOT EXISTS (
    SELECT 1 FROM employee WHERE email = 'employee2@gmail.com'
);
