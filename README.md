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


## Deep Explanation
- A real-time chat backend using Spring Boot.
- Features: user registration, authentication, sending/receiving messages, chat history.
- Database: MongoDB for storing messages.
- Can be extended with WebSocket for live chat.
- Frontend: React + Vite (optional).

## Interview Questions (Chat-Application)
- Explain the architecture of your chat app.
- How do you store chat messages?.
- How would you implement real-time communication?.
- What challenges did you face with MongoDB schema design?.
- How do you handle authentication?.
- What is the difference between REST API and WebSocket?.
- How would you scale this application?.
