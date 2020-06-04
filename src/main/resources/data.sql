INSERT INTO district (id, name) VALUES
(1, 'Ampara'),
(2, 'Anuradhapura'),
(3, 'Badulla'),
(4, 'Batticaloa'),
(5, 'Colombo'),
(6, 'Galle'),
(7, 'Gampaha'),
(8, 'Hambantota'),
(9, 'Jaffna'),
(10, 'Kalutara'),
(11, 'Kandy'),
(12, 'Kegalle'),
(13, 'Kilinochchi'),
(14, 'Kurunegala'),
(15, 'Mannar'),
(16, 'Matale'),
(17, 'Matara'),
(18, 'Moneragala'),
(19, 'Mullaitivu'),
(20, 'Nuwara Eliya'),
(21, 'Polonnaruwa'),
(22, 'Puttalam'),
(23, 'Ratnapura'),
(24, 'Trincomalee'),
(25, 'Vavuniya');

INSERT INTO medical_institute (id, address, name, type, district_id) VALUES 
(1, 'Colombo 07', 'National Hospital', 0, 5),
(2, 'Alfred Place', 'Durdans', 1, 5);

INSERT INTO system_user (id, user_name, password, active, roles, user_type, medical_institute_id) VALUES
	(1, 'super_admin', '$2a$10$DPXBa21gtCZuwJJI.R9/m.2gONVeqIQs82PBMNuSpbUCOA3IPCNES','Y', 'SUPER_ADMIN', 0, null),
  	(2, 'admin', '$2a$10$DPXBa21gtCZuwJJI.R9/m.2gONVeqIQs82PBMNuSpbUCOA3IPCNES','Y', 'ADMIN', 1, 1),
  	(3, 'admin_durdans', '$2a$10$DPXBa21gtCZuwJJI.R9/m.2gONVeqIQs82PBMNuSpbUCOA3IPCNES','Y', 'ADMIN', 1, 2),
  	(4, 'user', '$2a$10$DPXBa21gtCZuwJJI.R9/m.2gONVeqIQs82PBMNuSpbUCOA3IPCNES', 'Y', 'USER', 0, null);

INSERT INTO patient (id, address, dob, first_name, last_name, gender, nic, patient_status, district_id, medical_institute_id) VALUES
	(1, '26 Sir Marcus Fernando Mawatha', '1988-12-08','David', 'Barton', 0, '887456378v', 0, 5, 1),
	(2, '10 Flower Road', '1990-02-08','John', 'Grisham', 0, '907456378v', 1, 5, 1),
	(3, '400 McCallum Rd', '1983-02-08','Anna', 'Jarvis', 1, '8307456378v', 3, 5, 1),
	(4, '25 Gregorys Rd', '1993-02-08','Michelle', 'Fernando', 1, '9307456378v', 0, 5, 2),
	(5, '12 McCallum Rd', '1990-12-18','Scott', 'Jarvis', 0, '9007456378v', 2, 5, 2);


