# 🚀 Task Manager - Production-Ready Kubernetes Application

[![Live Demo](https://img.shields.io/badge/Live%20Demo-tm.ggdevs.site-blue?style=for-the-badge&logo=kubernetes)](https://tm.ggdevs.site)
[![Backend](https://img.shields.io/badge/Backend-Spring%20Boot%203.5.6-green?style=for-the-badge&logo=spring)](https://spring.io)
[![Frontend](https://img.shields.io/badge/Frontend-React%2018-61DAFB?style=for-the-badge&logo=react)](https://react.dev)
[![Database](https://img.shields.io/badge/Database-PostgreSQL%2016-336791?style=for-the-badge&logo=postgresql)](https://www.postgresql.org)
[![Kubernetes](https://img.shields.io/badge/Platform-Kubernetes-326CE5?style=for-the-badge&logo=kubernetes)](https://kubernetes.io)

> A full-stack task management application deployed on a production Kubernetes cluster with zero-trust security via Cloudflare Tunnel. Built with modern technologies and cloud-native best practices.

**🌐 Live Application:** [https://tm.ggdevs.site](https://tm.ggdevs.site)

---

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Security](#-security)
- [What I Learned](#-what-i-learned)
- [License](#-license)

---

## ✨ Features

### Core Functionality
- ✅ **User Authentication** - Secure registration and login with JWT tokens
- ✅ **Task Management** - Full CRUD operations (Create, Read, Update, Delete)
- ✅ **Task Status Toggle** - Mark tasks as completed/incomplete
- ✅ **User Isolation** - Each user can only access their own tasks
- ✅ **Persistent Storage** - Data stored in PostgreSQL with 5GB persistent volume
- ✅ **Real-time Updates** - React SPA with instant UI feedback

### Cloud-Native Features
- 🔐 **Zero-Trust Security** - Cloudflare Tunnel (no exposed ports)
- 🌍 **Global CDN** - Cloudflare edge network for low latency
- 🛡️ **DDoS Protection** - Built-in Layer 7 protection
- ⚡ **High Availability** - 2 replicas for frontend and backend
- 🔄 **Auto-scaling** - Kubernetes horizontal pod autoscaling
- 📊 **Monitoring** - Readiness and liveness probes

---

## 🛠️ Tech Stack <a name="tech-stack"></a>

### Backend
- **Framework:** Spring Boot 3.5.6
- **Language:** Java 21 (LTS)
- **Security:** Spring Security 6 + JWT (JJWT 0.12.6)
- **Database:** PostgreSQL 16 (Alpine)
- **ORM:** Hibernate / JPA
- **Connection Pool:** HikariCP
- **Build Tool:** Maven 3.9
- **Container:** Eclipse Temurin 21 JRE Alpine

### Frontend
- **Framework:** React 18
- **Build Tool:** Vite 5
- **UI Library:** Custom CSS (responsive design)
- **HTTP Client:** Fetch API
- **Routing:** React Router DOM
- **Web Server:** Nginx 1.29 (Alpine)

### Infrastructure
- **Orchestration:** Kubernetes
- **Container Runtime:** Docker
- **Ingress Controller:** Traefik
- **Tunnel:** Cloudflare Tunnel (cloudflared)
- **DNS & SSL:** Cloudflare (Universal SSL)
- **Registry:** Docker Hub
- **Storage:** Kubernetes Persistent Volumes

### DevOps & Tools
- **CI/CD:** Docker multi-stage builds
- **Version Control:** Git / GitHub
- **Secrets Management:** Kubernetes Secrets
- **Configuration:** ConfigMaps, Environment Variables

---

## 🏗️ Architecture <a name="architecture"></a>

### System Architecture Diagram

<img width="1539" height="901" alt="diagram-export-10-23-2025-1_28_59-PM" src="https://github.com/user-attachments/assets/eaab983b-af55-4e97-ac97-fdcbefe8a0d3" />


### Key Architectural Decisions

**1. Cloudflare Tunnel (Zero-Trust)**
- No public IP exposure - cluster remains private
- Encrypted outbound-only connection
- Built-in DDoS protection and WAF
- Automatic SSL certificate management

**2. Microservices Pattern**
- Decoupled frontend and backend
- Independent scaling capabilities
- Service mesh ready architecture

**3. Stateful Database with Persistent Storage**
- PostgreSQL StatefulSet for stable network identity
- PersistentVolumeClaim ensures data durability
- Automated backups capability

**4. JWT-Based Authentication**
- Stateless authentication (no sessions)
- Scalable across multiple backend replicas
- Secure token validation with secret key

---

## 🔒 Security

### Authentication & Authorization
- **JWT Tokens:** Stateless authentication with 10-hour expiration
- **BCrypt Hashing:** Passwords hashed with BCrypt (strength: 10)
- **Spring Security:** Role-based access control (RBAC)
- **CORS:** Configured for production domain only

### Infrastructure Security
- **Zero-Trust Architecture:** Cloudflare Tunnel eliminates exposed ports
- **Secrets Management:** Kubernetes Secrets (base64 encoded at rest)
- **Network Policies:** Internal cluster communication only
- **SSL/TLS:** Automatic certificate management via Cloudflare

## 📚 What I Learned

This project was a comprehensive learning journey in modern full-stack development and cloud-native technologies:

### Backend Development
- **Spring Boot Ecosystem:** Deep dive into Spring Security, Spring Data JPA, and REST API design
- **JWT Implementation:** Stateless authentication with JJWT library
- **Database Design:** PostgreSQL schema design, JPA relationships, and HikariCP optimization
- **Security Best Practices:** BCrypt password hashing, CORS configuration, and HTTPS enforcement

### Frontend Development
- **React Hooks:** useState, useEffect, useContext for state management
- **SPA Routing:** Client-side routing with React Router
- **API Integration:** Asynchronous data fetching with error handling
- **Responsive Design:** Mobile-first CSS with modern layouts

### DevOps & Cloud Infrastructure
- **Containerization:** Multi-stage Dockerfiles for optimized image sizes
- **Kubernetes Orchestration:** 
  - Deployments, StatefulSets, Services, Ingress
  - ConfigMaps and Secrets management
  - Resource requests and limits
  - Health probes and auto-healing
- **Cloudflare Tunnel:** Zero-trust networking without public IP exposure
- **High Availability:** Load balancing across multiple replicas
- **Persistent Storage:** StatefulSets with PersistentVolumeClaims

### CI/CD & GitOps
- **Docker Hub:** Container registry management
- **Declarative Infrastructure:** Kubernetes manifests as code
- **Version Control:** Git workflows for infrastructure changes

### Networking
- **Service Discovery:** Kubernetes DNS for inter-service communication
- **Ingress Controllers:** Traefik for path-based routing
- **SSL/TLS Termination:** Cloudflare managed certificates
- **CORS:** Cross-origin resource sharing configuration

---


## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Gabriel Florea**

- Website: [tm.ggdevs.site](https://tm.ggdevs.site)
- GitHub: [@floreaGabriel](https://github.com/floreaGabriel)
- LinkedIn: [Gabriel Florea](https://www.linkedin.com/in/cristian-gabriel-florea/)

---

## 🙏 Acknowledgments

- Spring Boot Documentation
- React Official Docs
- Kubernetes Documentation
- Cloudflare Tunnel Guides
- Docker Best Practices

---

<div align="center">

**⭐ Star this repo if you found it helpful!**

[![GitHub stars](https://img.shields.io/github/stars/floreaGabriel/task-manager-k8s?style=social)](https://github.com/floreaGabriel/task-manager-k8s/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/floreaGabriel/task-manager-k8s?style=social)](https://github.com/floreaGabriel/task-manager-k8s/network/members)

Made with ❤️ and ☕ | Deployed on Kubernetes

</div>
