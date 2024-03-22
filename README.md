<h1> Services SHOP-NOW </h1>



<h2> Docker Images </h2>
  
cd shop-now 

docker-compose up --build

ms-order   --> port 8080
ms-user    --> port 8081
ms-product --> port 8082

<h2> Token and Call Api </h2>

<h3>Sign up</h3>  
curl --location 'http://localhost:8081/user/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "usuario",
    "password": "password",
    "email": "email-user@gmail.com",
    "fullName": "user test"
}'

<h3>Sign in</h3> 

curl --location 'http://localhost:8080/user/login' \
--header 'Content-Type: application/json' \
--data '{
    "username":"usuario",
    "password":"password"
}'

<h3> token returned </h3> 
{
    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJBUEkgZG8gTG9naW4iLCJzdWIiOiJ1c3VhcmlvIiwiaWF0IjoxNzExMDg1NTcxLCJleHAiOjE3MTExNzE5NzF9.Pe9PFtm9zq3X9eE1boK7hY1QNYiCrtG3TsiMWq5MhLvO1cBtjP2fDZbyzcQNSX2KMk2rS7rx1Pk_UAaCHrzm5A",
    "status": "LOGGED IN",
    "username": "usuario"
}

<h3>Example call API with token</h3> 

curl --location 'http://localhost:8080/orders' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJBUEkgZG8gTG9naW4iLCJzdWIiOiJSYWZhZWwiLCJpYXQiOjE3MTEwNDYzMDMsImV4cCI6MTcxMTEzMjcwM30.ZwIOpAwfafmOc2pSKGTb2sg8nOnvNYG7Og7Wu5mNP6W43hZo5flWN4RtJukZWzPxtMe6SOvRC1gZCOLY329A0A' \
--data '{
    "orderNumber": 234,
    "orderDate" : "2023-10-01T01:02:01",
    "totalPrice": 122.23,
    "idClient" : 14
}'





