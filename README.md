# Application de Gestion de Championnat de Football

## Description

Ce projet est une application web permettant de gérer des championnats de football. Elle a été réalisée dans le cadre d'un TP de développement web avec **Spring Boot**.  
L'application permet la gestion des équipes, des championnats, des matches et des classements, avec une interface publique et un backoffice sécurisé.

---

## Fonctionnalités

### Partie publique
- Affichage de la liste des championnats
- Affichage du classement d'un championnat
- Affichage des résultats d'une journée
- Affichage de la fiche détaillée d'une équipe

### Partie privée (Backoffice)
- Authentification sécurisée (Spring Security, mots de passe cryptés)
- Gestion des championnats (ajout, modification, suppression)
- Gestion des équipes (ajout, modification, suppression)
- Gestion des matches et des résultats

---

## Technologies utilisées

- **Java 17+**
- **Spring Boot 3**
- **Spring MVC**
- **Spring Data JPA (Hibernate)**
- **Spring Security 6**
- **Thymeleaf**
- **MySQL**
- **Tailwind CSS** (via CDN)
- **Maven**

---

## Installation et lancement

1. **Cloner le projet**
   ```bash
   git clone <lien-du-repo>
   cd TPgestionchampionnat
   ```

2. **Configurer la base de données**

   Crée une base de données MySQL (exemple : `championnatdb`) et adapte le fichier `src/main/resources/application.properties` :

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/championnatdb
   spring.datasource.username=ton_user
   spring.datasource.password=ton_mot_de_passe
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. **Lancer l'application**
   - Avec Maven :
     ```bash
     ./mvnw spring-boot:run
     ```
   - Ou en lançant la classe `TPgestionchampionnatApplication` depuis votre IDE.

4. **Accéder à l'application**
   - Interface publique : [http://localhost:8080/](http://localhost:8080/)
   - Backoffice (après connexion) : [http://localhost:8080/team/admin](http://localhost:8080/team/admin)

---

## Sécurité

- L'accès au backoffice est protégé par Spring Security.
- Les mots de passe sont stockés de façon sécurisée (cryptage BCrypt).

---

## Design

- L'interface utilise **Tailwind CSS** via le CDN pour un rendu moderne et responsive.
- Les pages Thymeleaf sont dans `src/main/resources/templates/`.

---

## Auteur

- Anthony Béal
- Ouadia Ben Khalifa
- Remi Perez
- TP réalisé dans le cadre du cours de développement web (Igensia)

