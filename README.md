# 🗳️ VotingApp

**VotingApp** is a full-stack online voting system built with **Spring Boot**, **MySQL**, and **React + Vite**. It leverages Domain-Driven Design (DDD) principles for clean architecture and JWT authentication for security.

## 📚 Features

- Voter registration & login (JWT)
- Cast a voteModel for candidateModels
- Real-time result tallying
- Admin panel for managing candidateModels
- Route protection for authenticated users

## 🗂️ Project Structure

### Backend (`com.bolton.votingapp`)

```
com.bolton.votingapp
├── application                 # App configuration, service layer, mappers, adapters
│   ├── config                 # Spring beans, CORS, etc.
│   ├── mapper                 # Domain ↔ Response mapping
│   ├── repository             # Interfaces to access data
│   └── security               # JWT, filters
├── domain                     # Core business logic
│   ├── exception              # Domain-specific exceptions
│   ├── model                  # Entities (Voter, Candidate, Vote)
│   ├── usecase                # Business use cases (cast voteModel, tally)
│   └── valueobject            # Immutable types (VoteId, Email)
├── infrastructure.persistence # MySQL & JPA persistence
│   └── entity
│       ├── VoterRepository
│       ├── CandidateRepository
│       └── VoteRepository
├── web                        # REST API layer
│   ├── controller             # Controllers
│   ├── errors                 # Exception handlers
│   └── service                # Web layer services
├── VotingApp                  # Main Spring Boot app class
├── CorsConfig                 # CORS settings
├── DefaultProfileUtil         # Default Spring profiles
└── WebSocketConfig            # (Optional) WebSocket config
```

### Frontend (`voting-app-frontend`)

```
src/
├── api/                       # Axios client setup
├── assets/                    # Images & static files
├── components/                # Reusable UI components
├── context/                   # React context providers
├── features/                  # Domain features (auth, voting)
│   ├── auth/
│   └── voting/
├── hooks/                     # Custom hooks
├── routes/                    # React Router config
├── App.tsx                    # Root component
└── main.tsx                   # Entry point
```

## ⚙️ Setup & Run

Follow these steps to get the project up and running locally.

### Backend Setup

1. **Clone the repository**:
   ```bash
   git clone <`https://github.com/Empero47/VotingApp`>
   cd VotingApp `idea .` or `code .`
   ```
2. **Configure MySQL**:
    - Create database `voting_db` in your MySQL server.
    - Update `application.yml` with your MySQL credentials.
3. **Build & Run**:
   ```bash
   ./mvnw clean package
   java -jar target/votingapp-0.0.1-SNAPSHOT.jar
   ```
4. **API Endpoints**:
    - `POST /api/auth/register` — register and receive JWT
    - `POST /api/auth/login` — login & receive JWT
    - `POST /api/votes?voterId=&candidateId=` — cast voteModel (auth)
    - `GET /api/votes/results` — View results (auth)
    - `GET /api/admin/candidateModels` — list candidateModels (auth)

### Frontend Setup

1. **Navigate to the frontend folder**:
   ```bash
   cd `src/main/webapp/`
   ```
2. **Install dependencies**:
   ```bash
   npm install
   ```
3. **Start the development server**:
   ```bash
   npm run dev
   ```
4. **Access the app**:
    - Open `http://localhost:3000` In your browser.

## 🧪 Testing

### Backend Tests

```bash
./mvnw test
```

### Frontend Tests

```bash
npm test
```

## 🧪 Testing

### Backend Tests

```bash
./mvnw test
```

### Frontend Tests

```bash
npm test
```

## 📑 Dependencies

### Backend (Maven `pom.xml`)

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Spring Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- JWT -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Test Dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.testcontainers</groupId>
        <artifactId>mysql</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Frontend (`package.json`)

```json
{
  "dependencies": {
    "axios": "^1.0.0",
    "react": "^18.0.0",
    "react-dom": "^18.0.0",
    "react-router-dom": "^6.0.0",
    "jwt-decode": "^3.1.2"
  },
  "devDependencies": {
    "@types/jest": "^28.0.0",
    "@types/node": "^18.0.0",
    "@types/react": "^18.0.0",
    "@types/react-dom": "^18.0.0",
    "@vitejs/plugin-react": "^2.0.0",
    "typescript": "^4.8.0",
    "vite": "^4.0.0",
    "jest": "^28.0.0",
    "@testing-library/react": "^13.0.0",
    "@testing-library/jest-dom": "^5.16.0"
  }
}
```

## 📄 License

MIT License

