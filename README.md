# administrare app

Te Administrare app intends to solve an actual problem I have on the job. Currently I work
with lots of tabels (more than 100) and I manually open them to search information about
the products. That takes almost half of my time, and it could be spent better.

This is where the Administrare app comes in place. I want to bring all the tables into a database
and to be able to access them with a web interface. The interface should allow me to:
- Search (with a search bar)
- Create, Update and Delete records individually
- Import and export the database tables to and from .csv files.
- #### Optionally
- Possibility to search, fill and save multiple rows (like an invoice)
- Possibility to save this to a .csv file that it can be modified.

### Progress

* Mysql database and Workbench install.
* Created separate user for the application access and created the database.
* Application.properties proper configuration and connection to the db.
* Figured out the **ManyToOne** relationship needed for the application model.
* Created **JPA repository** for the entities and mapped them to the db.
* Implemented **SequenceGenerator** for the ID's and the **Unique constraint**.
* *Learned about **Lombok** and the **Builder pattern** (I don't use them, I want to practice more with the core code)
* Implemented **Unit Tests** for all the transactions needed by the app.
* [Test cu link](https://google.com)

### In progress
* Implemented the Service class (haven't seen the need for adding an implementation class)
* Implemented the Controller classes - in progress


Text normal
### TODO
* View / controller
* Stoc local (id, cod produs fk, categorie (cautare dupa cat), in stoc, stoc, rezervate, disponibile, rezervari)
* Rezervare (id, cod produs fk, cantitate rezervata, user, data, detalii text)
* Oferta/proforma (id, user, data, produse) // posibil api extern?
* 
* security/login
* unit tests
* pictures
* pagination
* exceptions
* log
* //optional - profiles calculator
* import/export .csv and .pdf
* 