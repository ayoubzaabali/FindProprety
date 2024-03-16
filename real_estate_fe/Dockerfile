FROM node:20.11.1-alpine AS builder
WORKDIR /app

RUN npm cache clean --force

COPY . .

#RUN npm config set registry http://registry.npmjs.org/

RUN npm install
RUN npm i -g @angular/cli
RUN ng build


FROM nginx:stable
COPY --from=builder /app/dist/real_estate_fe/ /usr/share/nginx/html/
COPY /nginx.conf /etc/nginx/conf.d/default.conf