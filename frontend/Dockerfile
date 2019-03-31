FROM node:10.15-alpine

RUN mkdir -p /home/frontend
WORKDIR /home/frontend

COPY package.json /home/frontend
COPY package-lock.json /home/frontend

RUN npm install

COPY . /home/frontend

CMD ["npm", "start"]