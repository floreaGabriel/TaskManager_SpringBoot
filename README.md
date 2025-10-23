# GGDevs Task Manager App

**A full-stack task management application built with Spring Boot (backend) and React (frontend) implementing modern app architecture and best practices.**

## Main Features

- **RESTful API** with Spring Boot (Java)
- **Task CRUD operations** (Create, Read, Update, Delete)
- **Task priorities and categories** (customizable, using enums and strings)
- **Deadlines and automatic timestamps** (`createdAt`, `deadline`)
- **DTO pattern & layered architecture**
    - Entity, DTO for creation and response
    - Service layer for business logic (validation, mapping)
    - Repository layer for DB access
- **Persistent database** using H2 (on disk) for development – ready for migration to MySQL/PostgreSQL
- **Frontend in React/Vite**
    - Fetch, display and manage tasks in real time
    - Clean error, loading, and CORS handling
    - Modular code with services and components

## Tech Stack

- **Backend:** Spring Boot 3, Java 17+, H2 DB
- **Frontend:** React (Vite), JavaScript/JSX
- **Integration:** REST API, .env config, CORS setup

<img width="1339" height="665" alt="Screenshot 2025-10-23 at 13 25 04" src="https://github.com/user-attachments/assets/b31a83f6-5106-4fc3-a95a-461366290d67" />


## Getting Started

1. Clone the repository
2. Configure backend (`application.properties`) for H2 persistent mode
3. Start backend (`mvn spring-boot:run`)
4. Create `.env` in `frontend` with your API URL and start Vite dev server (`npm run dev`)
5. Open the React app and use the Task Manager UI

### Example endpoints
- `GET /api/tasks` — list all tasks
- `POST /api/tasks` — add a new task with priority, category, deadline

## Project Structure

- **/model:** Task entity (with enums and timestamps)
- **/dto:** DTOs for create/update/response
- **/service:** Business logic (validation, mapping)
- **/repository:** JPA repositories
- **/controller:** REST endpoints

## Best Practices Used

- DTO separation (never expose entities directly)
- Layered approach (service, repository, entity)
- Persistent storage in development using H2
- CORS/local dev integration with React
- Ready for extension: add more features, swap DB to production (MySQL/PostgreSQL), security, tests

**Contributions welcome!**


