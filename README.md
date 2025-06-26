# 🚀 Starship Viewer - Proyecto DIS 2025

Aplicación web desarrollada en Vaadin + Spring Boot para visualizar una lista de naves de Star Wars desde un JSON, y generar un PDF individual para cada una.

## 🧪 Tecnologías

- ✅ **Java 17 (Amazon Corretto)**
- ✅ **Spring Boot 3.5.3**
- ✅ **Vaadin 24**
- ✅ **Gson 2.11.0** (serialización)
- ✅ **Apache PDFBox** (generación de PDFs)
- ✅ **Docker**
- ✅ **GitFlow** (estructura de ramas)

```bash
cd backend
docker build -t backend:latest .
docker run -d -p 8088:8080 backend:latest
cd frontend
docker build -t frontend:latest .
docker run -d -p 8080:8080 frontend:latest
```

Eduardo Alarcón – UFV – Desarrollo e Integración del Software

less
Copiar
Editar
