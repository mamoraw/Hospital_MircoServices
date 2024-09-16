# Medical Web App Ecosystem

This repository contains a web application ecosystem for managing patients' admissions, diagnoses, treatments, and accounting. Each service is modular, built using Java Spring Boot with MySQL/MongoDB for data storage and Spring Security authentication and authorization. The apps communicate with each other seamlessly, passing patient data through each stage of their care journey.

## Services

### 1. Admission Service

The Admission Service is the entry point of the ecosystem. It accepts new patients and assigns them a unique identifier (UUID) if their name is not already in the system. Once the patient is registered, they are forwarded to the Diagnoses Service for further processing.

### 2. Diagnoses Service

The Diagnoses Service is responsible for providing a diagnosis to the patient. If a valid diagnosis cannot be determined, the patient will receive a default diagnosis of "lupus." After the diagnosis is set, the patient is forwarded to the Treatments Service.

### 3. Treatments Service

The Treatments Service handles the treatment of patients based on the diagnosis provided by the Diagnoses Service. Each treatment is logged in the database (MongoDB) for future reference, ensuring that the patient’s care history is properly recorded.

### 4. Accountancy Service

The Accountancy Service is responsible for generating and managing patient invoices. Once a patient receives treatment, this service creates an invoice reflecting the treatment cost. After payment, the accountant updates the invoice status to "paid." Invoices are stored in a MySQL database.

## Technologies\

- Java Spring Boot: For building the microservices
- MySQL/MongoDB: For database management
- Spring Security: file-based configuration
- RESTful Communication: Services communicate with each other through REST APIs
- JUnit and Mockito for testing\
