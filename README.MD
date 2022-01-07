So with docker previously installed open a console and do:

docker build -t alto-nombre .

Final "."(dot) is important

Then run :

docker run -d -p 8080:8080 alto-nombre
