# 💬 Chat Application

A full-stack **Chat Application** built with **Spring Boot (WebSocket backend)** and **React + Vite (frontend)**.  
This project demonstrates **real-time communication** using WebSocket (STOMP over SockJS), **REST API integration**, **MongoDB Atlas persistence**, and a **responsive UI** for chat rooms.

---

## 🚀 Features
- 🔐 **User Authentication** with JWT
- 💬 **Real-time Chat** using WebSocket (STOMP over SockJS)
- 🗄️ **MongoDB Atlas** for storing users, rooms, and messages
- 🎨 **Responsive UI** with React + Vite + Tailwind CSS
- 🌍 **Environment-based configuration** for flexible deployment

---

## 🛠️ Tech Stack

| Layer       | Tech |
|-------------|------|
| **Backend** | Java 17, Spring Boot, WebSocket (STOMP), MongoDB Atlas |
| **Frontend**| React, Vite, Axios, Tailwind CSS |
| **Deployment** | Render (backend), Vercel/Netlify (frontend) |

---

## 📂 Project Structure

ChatApp/
├── chat-app-backend/        # Spring Boot backend
│   ├── src/main/java/...    # Controllers, Services, Models
│   ├── src/main/resources/  # application.properties
│   └── .env                 # MongoDB URI, JWT secret, port
└── chat-app-frontend/       # React + Vite frontend
├── src/                 # Components, Pages, WebSocket client
├── public/              # Static assets
└── .env                 # VITE_API_BASE_URL
