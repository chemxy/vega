FROM node:16.7.0

LABEL version="1.0"
LABEL description="This is the base docker image for the Venus application nodejs backend"

WORKDIR /app

COPY ["package.json", "package-lock.json", "./"]

RUN npm install --production

COPY . .

EXPOSE 8000

CMD ["npm", "start"]
