
<h1> Services SHOP-NOW </h1>

# shop-now
Back-end REST-Api for manage Products, Users and Orders

# Technologies
- Java 11
- Spring Boot
- Spring Security
- Spring Data JPA
- Spring Cloud Config
- RestTemplate
- Docker
- Docker Compose
- Postgres
- Lombok
- Junit
- Mockito
 
# Apis Postman
[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/6946726-681a7af9-5146-4a0f-adb4-603e485e74f9?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D6946726-681a7af9-5146-4a0f-adb4-603e485e74f9%26entityType%3Dcollection%26workspaceId%3D3f4cd110-d225-4592-9e38-24d353fef539#?env%5Bshop-now%5D=W10=)


# Step 1
on directory shop-now run command
```bash 
docker-compose up --build 
```


<table> 
  <tr>
    <th>Service</th>
    <th>Port</th>
  </tr>
  <tr>
    <td>ms-order</td>
    <td>8080</td>
  </tr>
  <tr>
    <td>ms-user</td>
    <td>8081</td>
  </tr>
  <tr>
    <td>ms-product</td>
    <td>8082</td>
  </tr>
</table>

# Step 2
<h3> Create User </h3>
Create a user with the following command

```bash 

curl --location 'http://localhost:8081/user/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "usuario",
    "password": "1020",
    "email": "email-01@gmail.com",
    "fullName": "usuaio"
}'

```
# Step 3
<h3> get new Token </h3>

```bash
curl --location 'http://localhost:8080/user/login' \
--header 'Content-Type: application/json' \
--data '{
    "username":"usuario",
    "password":"password"
}'

```
<h3> Json With token returned </h3>

```
{
    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJBUEkgZG8gTG9naW4iLCJzdWIiOiJ1c3VhcmlvIiwiaWF0IjoxNzExMDg1NTcxLCJleHAiOjE3MTExNzE5NzF9.Pe9PFtm9zq3X9eE1boK7hY1QNYiCrtG3TsiMWq5MhLvO1cBtjP2fDZbyzcQNSX2KMk2rS7rx1Pk_UAaCHrzm5A",
    "status": "LOGGED IN",
    "username": "usuario"
}

```
<h3>Example call API with token</h3> 
```
curl --location 'http://localhost:8080/orders' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJBUEkgZG8gTG9naW4iLCJzdWIiOiJSYWZhZWwiLCJpYXQiOjE3MTEwNDYzMDMsImV4cCI6MTcxMTEzMjcwM30.ZwIOpAwfafmOc2pSKGTb2sg8nOnvNYG7Og7Wu5mNP6W43hZo5flWN4RtJukZWzPxtMe6SOvRC1gZCOLY329A0A' \
--data '{
    "orderNumber": 234,
    "orderDate" : "2023-10-01T01:02:01",
    "totalPrice": 122.23,
    "idClient" : 14
}'
```
