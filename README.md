# 📁 Cloud Document Management System

A robust enterprise-grade document management system built with Spring Boot and AWS S3, enabling secure cloud storage, retrieval, and management of business documents and files.

## 🎯 Overview

This application provides a RESTful API for managing documents in the cloud, perfect for businesses that need to:
- Store employee documents, contracts, and records securely
- Manage media assets for marketing teams
- Archive financial documents and invoices
- Share files across distributed teams
- Maintain compliance with document retention policies

## ✨ Features

- **📤 File Upload**: Securely upload documents to AWS S3 with unique identifiers
- **📥 File Download**: Retrieve stored documents on-demand with proper content headers
- **🗑️ File Deletion**: Remove obsolete or unwanted files from cloud storage
- **☁️ Cloud-Native**: Leverages AWS S3 for unlimited scalable storage
- **🔒 Secure**: Built-in security with Spring Boot best practices
- **🚀 RESTful API**: Easy integration with web and mobile applications

## 🛠️ Technologies Used

- **Java 17+** - Modern Java development
- **Spring Boot 3.x** - Application framework
- **AWS SDK for Java** - S3 integration
- **Maven** - Dependency management and build tool
- **AWS S3** - Cloud object storage

## 📋 Prerequisites

Before running this application, ensure you have:

- Java 17 or higher installed
- Maven 3.6+ installed
- AWS Account with S3 access
- AWS credentials configured (Access Key ID and Secret Access Key)

## ⚙️ Configuration

1. **AWS Credentials Setup**

   Configure your AWS credentials in `application.properties`:

   ```properties
   # AWS Configuration
   cloud.aws.credentials.access-key=YOUR_ACCESS_KEY
   cloud.aws.credentials.secret-key=YOUR_SECRET_KEY
   cloud.aws.region.static=us-east-1
   cloud.aws.stack.auto=false
   
   # S3 Bucket Configuration
   aws.s3.bucket-name=your-bucket-name
   ```

2. **Create S3 Bucket**

   - Log in to AWS Console
   - Navigate to S3 service
   - Create a new bucket with appropriate permissions
   - Update bucket name in application.properties

## 🚀 Getting Started

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd AWSs3SpringBoot
   ```

2. Configure AWS credentials in `src/main/resources/application.properties`

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

## 📡 API Endpoints

### Upload File

Upload a document to cloud storage.

**Endpoint:** `POST /s3/upload`

**Request:**
- Content-Type: `multipart/form-data`
- Parameter: `file` (MultipartFile)

**Example:**
```bash
curl -X POST http://localhost:8080/s3/upload \
  -F "file=@/path/to/document.pdf"
```

**Response:**
```json
"File uploaded successfully: document-123456.pdf"
```

---

### Download File

Retrieve a document from cloud storage.

**Endpoint:** `GET /s3/download/{fileName}`

**Path Variable:**
- `fileName` - Name of the file to download

**Example:**
```bash
curl -X GET http://localhost:8080/s3/download/document-123456.pdf \
  -o downloaded-file.pdf
```

**Response:**
- Binary file content with appropriate headers

---

### Delete File

Remove a document from cloud storage.

**Endpoint:** `DELETE /s3/delete/{fileName}`

**Path Variable:**
- `fileName` - Name of the file to delete

**Example:**
```bash
curl -X DELETE http://localhost:8080/s3/delete/document-123456.pdf
```

**Response:**
```json
"File deleted successfully: document-123456.pdf"
```

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/AWS_S3Practice/
│   │       ├── AwsS3PracticeApplication.java    # Main application class
│   │       ├── Controllers/
│   │       │   └── S3Controller.java             # REST API endpoints
│   │       └── Services/
│   │           └── S3Service.java                # Business logic for S3 operations
│   └── resources/
│       └── application.properties                # Application configuration
└── test/
    └── java/                                     # Unit tests
```

## 🔍 Use Cases

### 1. **HR Document Management**
Store employee onboarding documents, resumes, contracts, and performance reviews securely in the cloud.

### 2. **Invoice & Receipt Archive**
Maintain digital copies of financial documents for accounting and audit purposes.

### 3. **Marketing Asset Library**
Centralized storage for images, videos, and design files accessible by marketing teams.

### 4. **Legal Document Repository**
Secure storage and retrieval of contracts, agreements, and legal correspondence.

### 5. **Customer File Portal**
Allow customers to upload and download documents like applications, forms, and statements.

## 🧪 Testing

Run the test suite:

```bash
mvn test
```

## 🔐 Security Considerations

- **Never commit AWS credentials** to version control
- Use **IAM roles** when deploying to AWS EC2/ECS
- Implement **authentication and authorization** before production deployment
- Enable **S3 bucket encryption** at rest
- Configure **S3 bucket policies** to restrict access
- Use **HTTPS** for all API communications

## 📈 Future Enhancements

- [ ] Add file type validation and virus scanning
- [ ] Implement user authentication with Spring Security
- [ ] Add file metadata storage (size, upload date, owner)
- [ ] Support for file versioning
- [ ] Batch upload/download capabilities
- [ ] File sharing with expiring links
- [ ] Search and filter functionality
- [ ] Integration with cloud CDN for faster downloads
- [ ] Docker containerization
- [ ] Swagger/OpenAPI documentation

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Contact

For questions or support, please open an issue in the repository.

---

**Built with ☕ and ☁️ by [Your Name]**
