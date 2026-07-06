# Spring Boot Upload Demo

A sample Spring Boot project demonstrating single and multiple file upload functionality.

## Features

- Single file upload via `/upload` POST endpoint
- Multiple file upload via `/upload/multiple` POST endpoint
- Files stored in the system temporary directory
- Max file size limit of 1MB
- Bootstrap 5 frontend with dedicated pages for single and multiple uploads
- EditorConfig validation during build

## Tech Stack

- **Spring Boot 4.1.0** with Java 26
- **Spring WebMVC** for REST endpoints
- **Thymeleaf** (dependency included for template support)
- **Lombok** for reducing boilerplate
- **Bootstrap 5.3** for UI styling
- **Maven** build tool

## Quick Start

```bash
# Run the application
./mvnw spring-boot:run
```

The app starts on `http://localhost:8080`.

## Usage

1. Open the home page at `http://localhost:8080`
2. Choose **Single** upload to upload one file at a time
3. Choose **Multiple** upload to upload several files at once
4. Uploaded files are saved to `java.io.tmpdir`

## API Endpoints

| Method | Path               | Description        |
|--------|--------------------|--------------------|
| POST   | `/upload`          | Upload a single file |
| POST   | `/upload/multiple` | Upload multiple files |

## Build

```bash
./mvnw clean verify
```

The build runs EditorConfig checks during the `verify` phase.

## License

This project is open source and available under the [LICENSE](LICENSE) file.
