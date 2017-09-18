# Oddle

Server:
1. Install Docker:

sudo apt install docker.io

2. run with images "mysql/mysql-server":

	docker run --name oddle-mysql -p 3340:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_ROOT_HOST=% -d mysql/mysql-server:8.0

you can connect mysql: 
	mysql -h127.0.0.1 -P3340 -uroot -p123456

3. run it TWO TIME (second run will init sample data for mySQL database): 

	./gradlew :tdv-gateway:bootRun
	
	./gradlew :tdv-gateway:bootRun

------------
Client:

4. install npm:

	sudo apt install npm

5. install nodejs-legacy:

	sudo apt install nodejs-legacy

6. Change dir "react-web-client". run:

	sudo npm install
	
	npm start

---- DONE -----
