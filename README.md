# CarRental
Web application to rent cars on specific date
# How to run
- Shift + F10
- mvn spring-boot:run
- mvn clean install and then java -jar target/CarRental-0.0.1-SNAPSHOT.jar
# Technology stack
- Java
- Spring Boot
- MySQL
- HTML Thymeleaf
# How to use app
Firstly we open homepage on http://localhost:8080/home
![image](https://user-images.githubusercontent.com/73071921/184552765-1a57036f-ada9-4eba-8c83-f6240597507a.png)

Then we log in or create account if we don't have
![paneluser](https://user-images.githubusercontent.com/73071921/184552919-3a00a9ae-f405-4bc8-8ecf-31e005428ea5.png)

Now, we have three options: logout, check our rental history or browse available cars

This is a cars panel
![image](https://user-images.githubusercontent.com/73071921/184553529-56afdef3-ad5f-4294-961c-815b7c1da50a.png)

By click a plus button we are directed on rental panel  
We have to set our rental span and start date. The final date and price are set automatically.
If a specific car is available in span of our rental span, we can rent it, instead of we get log "Car is not available"
![rentcar](https://user-images.githubusercontent.com/73071921/184553695-fc03bc6c-c731-43cc-9995-c40f678715bf.png)
![image](https://user-images.githubusercontent.com/73071921/184553863-93ea3386-50a6-4968-802e-bf861e1a1ed7.png)



