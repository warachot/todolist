# todolist
RESTful Web Service with Spring Boot 

### ใช้ Gradle เป็นเครื่องมือในสำหรับ Build, Test และ  Deploy
* สร้าง folder todolist รันคำสั่ง gradle init Gradle จะสร้าง file ต่างๆที่เกี่ยวข้องให้ 
* นำ file build.gradle  และ folder src ที่จากการ clone จาก repository ไป replace ไฟล์ที่ gradle สร้างให้ 
* รันคำสั่ง gradle build เพื่อ build 
* รันคำสั่ง gradle bootRun เพื่อ run project ทดสอบ service ใช้ได้หรือไม่ เรียก http://localhost:8080/todo/list

หลังจากแน่ใจแล้วว่า service ใช้ได้ ให้ท่าน clone [todolist_client](https://github.com/warachot/todolist_client)   
เพื่อใช้ในการทดสอบการทำงาน

### [SpringBoot](http://projects.spring.io/spring-boot/)
 เป็นเครื่องมือสำหรับพัฒนา Spring application ที่ทำให้ง่ายต่อการพัฒนามี configuration เพียงเล็กน้อย configuration file path src/main/resources/application.properties
* spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
* spring.datasource.username=warachotd
* spring.datasource.password=

### SQL (Postgres)

CREATE TABLE todolist (
id SERIAL PRIMARY KEY,
subject varchar not null,
task text null,
status varchar not null default 'Pending',
creation_date timestamp without time zone
);
