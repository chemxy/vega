FROM node:16.7.0

LABEL version="1.0"
LABEL description="This is the base docker image for the Venus application nodejs backend"

WORKDIR /app
# add `./node_modules/.bin` to $PATH
ENV PATH ./node_modules/.bin:$PATH
COPY ["package.json", "package-lock.json", "./"]

RUN npm install 

COPY . ./

EXPOSE 8000

CMD ["npm", "start"]
