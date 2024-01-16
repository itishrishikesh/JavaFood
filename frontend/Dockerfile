# Stage 1 - Build the application
FROM node:16 as build
WORKDIR /app
COPY package.json ./
RUN npm install
COPY . .

# Stage 2 - Serve the application using Nginx
FROM nginx:alpine
COPY --from=build /app/dist/food-ordering-app /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "demon off;"]

