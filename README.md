# Legătura dintre Model, Repository, Service și DTO în Spring Boot

1. Model / Entity (model/Task.java):
- Ce este? Clasa Java care modelează o entitate din baza de date (ex: Task: id, title, description, completed)

- Rol: Definește structura datelor ce vor fi salvate în DB, mapată prin JPA/Hibernate la tabela SQL

- E baza operațiilor tale pe date. Fiecare tabel important are o entitate asociată.

2. Repository (repository/TaskRepository.java):
Ce este? Interfață care extinde JpaRepository și gestionează CRUD automat

- Rol: Abstracție pentru accesul la date (salvezi, citești, ștergi, actualizezi Task-uri)

- Legătură: Repository-ul primește și returnează Entity-urile (Task), ascunzând SQL-ul efectiv — nu are logică de business !

- Fără repository, aplicația nu poate lucra cu baza de date.

3. Service Layer (service/TaskService.java):
Ce este? Clasă (sau interfață + clasa) ce conține logica aplicației (business logic)

- Rol: Primiți cereri din Controller → aplicați validări, reguli, transformări

- Lucrați cu Repository-ul pentru a accesa datele

- Decideți ce date se vor transmite mai departe (de obicei ca DTO)

- Poate orcheza operații din mai multe Repository-uri

- Poate gestiona tranzacții (@Transactional)

- Legătură: Primește DTO-urile de la Controller, transformă în Entity, trimite spre Repository, primește Entity, îl transformă în alt DTO și îl trimite Controller-ului.​

- Service Layer este OBLIGATORIU pentru orice aplicație cu logică peste CRUD simplu.

4. DTO (Data Transfer Object):
Ce este? Clasa Java folosită pentru schimb de date între straturi, specifică unui request sau response

Rol:

- Ascunde detaliile Entity-ului față de client

- Permite validări/mapping personalizate

De exemplu:

- TaskCreateDTO (pentru cereri de creare: fără id, fără completed)

- TaskResponseDTO (pentru răspunsuri: doar ce expui la client)

- Legătură: Controller primește DTO din request, îl trimite Service-ului, Service-ul îl transformă în Entity pentru Repository și invers pentru răspuns.

- DTO-urile sunt bune practici, mai ales pentru aplicații REST.

5. Legătura dintre ele – exemplu simplificat
- Clientul trimite un request HTTP (ex: POST /tasks) → Controller primește un DTO (TaskCreateDTO)

- Controller apelează TaskService cu acest DTO

- TaskService:

- Validează logica de business

- Transformă DTO în Task Entity

- Apelează TaskRepository să salveze în DB

- Primește un Task salvat

- Transformă în TaskResponseDTO pentru output

- Controller trimite TaskResponseDTO înapoi către client

