#Medical Web App Ecosystem

This repository contains a web application ecosystem for managing patients' admissions, diagnoses, treatments, and accounting. Each service is modular, built using Java Spring Boot with MySQL for data storage and Spring Security for in-memory authentication and authorization. The apps communicate with each other seamlessly, passing patient data through each stage of their care journey.

Table of Contents
Services
Admission Service
Diagnoses Service
Treatments Service
Accountancy Service
Technologies
How to Run
License
Services
1. Admission Service
The Admission Service is the entry point of the ecosystem. It accepts new patients and assigns them a unique identifier (UUID) if their name is not already in the system. Once the patient is registered, they are forwarded to the Diagnoses Service for further processing.

Endpoint: /admission
Main Responsibilities:
Register new patients and assign UUIDs
Cache patients' names to avoid duplication
Forward patients to the Diagnoses Service
2. Diagnoses Service
The Diagnoses Service is responsible for providing a diagnosis to the patient. If a valid diagnosis cannot be determined, the patient will receive a default diagnosis of "lupus." After the diagnosis is set, the patient is forwarded to the Treatments Service.

Endpoint: /patients
Main Responsibilities:
Receive patients and diagnose them
Default diagnosis: "lupus" (when no specific diagnosis can be made)
Forward patients to the Treatments Service
3. Treatments Service
The Treatments Service handles the treatment of patients based on the diagnosis provided by the Diagnoses Service. Each treatment is logged in the database for future reference, ensuring that the patient’s care history is properly recorded.

Endpoint: /treatment
Main Responsibilities:
Apply the appropriate treatment based on diagnosis
Save treatment records in the database
Forward patients with treatments to the Accountancy Service
4. Accountancy Service
The Accountancy Service is responsible for generating and managing patient invoices. Once a patient receives treatment, this service creates an invoice reflecting the treatment cost. After payment, the accountant updates the invoice status to "paid."

Endpoint: /invoices
Main Responsibilities:
Generate invoices for treatments
Save invoice details and status in the database
Allow accountants to update invoice status to "paid"
Technologies
Java Spring Boot: For building the microservices
MySQL: For database management
Spring Security: In-memory security for authentication and authorization
RESTful Communication: Services communicate with each other through REST APIs
How to Run
Clone the repository:

bash
Copy code
git clone https://github.com/your-repository-link.git
Set up the MySQL database for each service and configure connection details in the application.properties file of each service.

Run each service independently using Maven or an IDE like IntelliJ:

bash
Copy code
mvn spring-boot:run
The services will run on different ports, and the communication between them will be handled via the REST endpoints defined above.
