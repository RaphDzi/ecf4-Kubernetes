# 🛒 E-Commerce Microservices Architecture – ECF

## 📌 Contexte

Ce projet s’inscrit dans le cadre de l’**ECF (Évaluation en Cours de Formation)** portant sur l’amélioration et l’extension d’une architecture microservices e-commerce.

L’objectif principal est de démontrer des compétences en :
- analyse d’architecture existante
- amélioration de la qualité logicielle
- conception de nouveaux microservices
- conteneurisation et orchestration (Docker & Kubernetes)

---

## 🎯 Objectifs du projet

### 1. Analyse critique de l’existant
- Étude de l’architecture microservices fournie
- Identification des points faibles :
  - couplage entre services
  - manque de résilience
  - absence d’observabilité
  - gestion des erreurs limitée
  - sécurité perfectible
- Proposition d’améliorations documentées

---

### 2. Implémentation du service manquant

#### 🔍 Service de suggestions de recherche
- Développé en **Spring Boot**
- Fournit des suggestions en temps réel
- Intégré avec :
  - base de données MySQL
  - cache Redis
  - autres microservices

---

### 3. Extension de l’architecture (Bonus)

Ajout de nouveaux microservices cohérents avec le domaine e-commerce :

#### ✉️ Service de notifications
- Envoi d’événements (commande, confirmation, etc.)
- Extensible (email, push, etc.)

#### ⭐ Service de gestion des avis
- Ajout et consultation de reviews produits
- Gestion des notes utilisateurs

👉 Ces services respectent :
- le principe de responsabilité unique
- l’isolation des données
- une architecture découplée

---

## 🏗️ Architecture

### 📊 Diagramme C4

Un diagramme C4 représentant l’architecture globale est disponible ici : diagramme/c4_diagram.png


Il décrit :
- les interactions entre microservices
- les flux de données
- l’intégration frontend/backend

---

## ⚙️ Stack technique

### Backend
- Java 11 / 17
- Spring Boot
- Maven

### Frontend
- React (CRA)

### Infrastructure
- Docker
- Docker Compose
- Kubernetes

### Base de données & cache
- MySQL
- Redis

---

## 🐳 Dockerisation

Chaque composant dispose de son propre Dockerfile :
- microservices (multi-stage build avec Maven)
- frontend React (build + Nginx)

---

## ☸️ Orchestration Kubernetes

Des manifests Kubernetes sont fournis pour :
- Deployments
- Services
- Volumes persistants
- Configuration réseau

Possibilité de génération initiale via `kompose`, puis adaptation manuelle.

---

## 🚀 Lancement du projet

### 🔧 Prérequis
- Docker
- Docker Compose
- (optionnel) Kubernetes

---

### ▶️ Lancer avec Docker Compose

```bash
docker-compose build
docker-compose up