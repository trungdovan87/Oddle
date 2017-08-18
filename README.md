# Oddle

Server:
1. Install Docker
sudo apt install docker
2. run with images "mysql/mysql-server" 
	docker run --name oddle-mysql -p 3340:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_ROOT_HOST=% -d mysql/mysql-server:8.0

you can connect mysql: mysql -h127.0.0.1 -P3340 -uroot -p123456

2. run it twice: 
	./gradlew :tdv-gateway:bootRun

------------
Client:
3. install npm:
	sudo apt install npm
4. install nodejs-legacy:
	sudo apt install nodejs-legacy
5. Change dir "react-web-client". run: 
	sudo npm install
	npm start

---- DONE -----
