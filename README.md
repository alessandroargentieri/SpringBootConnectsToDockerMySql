l'app si connette al container di docker che è in ascolto sulla porta 6603 e contiene
un server mysql che internamente al container è in ascolto sulla porta 3306.
nel container con mysql è definito un database dal nome mydockerdb.

le tabelle del database sono create automaticamente da JPA all'atto del primo run della web application java.
le tabelle possono essere create dal Java perchè ho definito spring.jpa.hibernate.ddl-auto=create-drop.
Altrimenti, se avessi messo none avrei dovuto creare anche le tabelle in mysql e riempire i dati con JPA.

istruzioni per docker:
 1. installa docker sulla macchina server dove installerai anche il jar di questa applicazione
 2. fai il run di docker
 3. esegui queste istruzioni di docker:
     a. docker run -d --name=mymysql -p 6603:3306 --env="MYSQL_ROOT_PASSWORD=mypassword" mysql

     b. docker ps

     c. docker exec -it mymysql mysql -uroot -p

     d. (inserisci la password di mysql)

     e. CREATE DATABASE mydockerdb;

 4. deploya o fai il run di questa applicazione sulla stessa macchina dove è installato docker e dove è avviato il container mysql
 5. vai su postman e testa i metodi del RestController.java inserendo qualche _ToDo tramite x-www-form-urlencoded in cui basta inserire la description: id e createdAt sono automaticamente generati.

Qui le istruzioni relative soltanto alla command line di mysql, quindi utilizzabili solo dopo il punto c. quando si è entrati in mysql
https://www.a2hosting.com/kb/developer-corner/mysql/managing-mysql-databases-and-users-from-the-command-line

Questo un fantastico tutorial su docker e mysql:
https://severalnines.com/blog/mysql-docker-containers-understanding-basics

Questo link è utile per lo stesso motivo di sopra:
https://dev.mysql.com/doc/mysql-installation-excerpt/5.5/en/docker-mysql-getting-started.html

Questo se volessimo inserire in un'immagine docker anche la web application spring (in questo caso non lo facciamo):
https://jugbd.org/2017/09/29/5-steps-deploy-spring-boot-application-using-docker/

