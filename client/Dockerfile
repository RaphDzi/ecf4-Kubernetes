# ─────────────────────────────────────────
# Stage 1 : Build
# ─────────────────────────────────────────
# node-sass@4.14.1 requiert Node 14 max
# (node-gyp incompatible avec Node 16+)
FROM node:14-alpine AS builder

WORKDIR /app

# Dépendances système nécessaires pour compiler node-sass via node-gyp
RUN apk add --no-cache python3 make g++

# Copier package.json en premier pour profiter du cache npm
COPY package.json ./
RUN npm install --legacy-peer-deps

# Copier le reste du code source
COPY . .

# Variables d'environnement pour le build de production
ARG REACT_APP_ENVIRONMENT=production
ENV REACT_APP_ENVIRONMENT=$REACT_APP_ENVIRONMENT

RUN npm run build

# ─────────────────────────────────────────
# Stage 2 : Serve avec Nginx
# ─────────────────────────────────────────
FROM nginx:1.25-alpine AS runtime

LABEL maintainer="ecommerce-team"
LABEL service="client-react"

# Supprimer la config nginx par défaut
RUN rm /etc/nginx/conf.d/default.conf

# Copier notre config nginx personnalisée
COPY nginx.conf /etc/nginx/conf.d/app.conf

# Copier le build React depuis le stage builder
COPY --from=builder /app/build /usr/share/nginx/html

EXPOSE 3000

HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 \
  CMD wget -qO- http://localhost:3000/ || exit 1

CMD ["nginx", "-g", "daemon off;"]