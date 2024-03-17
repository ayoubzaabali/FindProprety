FROM node:20.11.1-alpine AS builder
WORKDIR /app

RUN npm cache clean --force

COPY . .

#RUN npm config set registry http://registry.npmjs.org/

# RUN npm config set registry https://registry.npmjs.org/
# RUN npm config rm proxy
# RUN npm config rm https-proxy


# RUN npm install -g npm@10.2.4
# RUN npm cache clean --force
# RUN npm config set fetch-retry-mintimeout 20000
# RUN npm config set fetch-retry-maxtimeout 120000
# RUN npm config set registry https://mirrors.cloud.tencent.com/npm/
# RUN npm config set https-proxy http://user:password@proxy.company.priv:80
# RUN npm config set proxy http://user:password@proxy.company.priv:80
RUN npm install
RUN npm i -g @angular/cli
RUN ng build


FROM nginx:stable
COPY --from=builder /app/dist/real_estate_fe/ /usr/share/nginx/html/
COPY /nginx.conf /etc/nginx/conf.d/default.conf