This api is made to be run from Docker. You do not need Java nor Maven to run it, since 
it builds a docker image with all dependencies needed and running in a container.

If you already have Java 11 and Maven, you can clone and run it as any Java app.

Otherwise

So with docker previously installed open a console and do:
````
docker build -t alto-nombre .
````
Final "."(dot) is important

Then run :
````
docker run -d -p 8080:8080 alto-nombre
````

Api is running on port 8080

For testing you have available 2 users whose credentials are:
````
With ROLE_USER
username : fdherrera@gmail.com 
password : 12345

With ROLE_ADMIN
username : otroemail@repiola.com
password : 12345
````

To create new User 
Only creating users with ROLE_USER
POST: /users/sign-up

```yaml
{
    "username" : "String",
    "firstName" : "String",
    "lastName" : "String",
    "password" : "String"
}
```

LOGIN is x-www-form-urlencoded

POST: /login 

With params:
````
username 
password
````

It will return a token in headers, needed in any request

Users with ROLE_USER are available only to do get requests to resources
GET: /reports -> See al reports
GET: /sections/{SectionId} -> See al reports in a section where {SectionId} is an integer number

Users with ROLE_ADMIN can post new articles
POST: /sections -> To create a new Section
```yaml
{
    "name" : "String"
}
```
POST: /sections/{SectionId} -> To create a new Tag in an existing Section where {SectionId} is an integer number
```yaml
{
    "name" : "String"
}
```
POST: /sections/{SectionId}/{TagId} -> To create a new report in Section with Tag, where {SectionId} and {TagId} are integer numbers of already existing sections and id
```yaml
{
    "title" : "String",
    "subtitle" : "String",
    "body" : "String",
    "photos" : [
        {
            "photography" : "String",
            "footer" : "String", 
            "paragraph" : "String"
        }
] -> photos is a list of objects, max is 3
}
```
