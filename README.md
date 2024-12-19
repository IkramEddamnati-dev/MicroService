# Microservices pour une Plateforme de Commerce en Ligne

Ce projet implémente une architecture basée sur des microservices pour gérer les produits, les commandes et les catalogues d'une plateforme de commerce en ligne.

## Microservices

### 1. **Service Produit**
- **Base de données** : MongoDB
- **Port** : `8086`
- **Fonctionnalités** :
  - Création, affichage, modification et suppression des produits.

### 2. **Service Commande**
- **Base de données** : MySQL
- **Port** : `8087`
- **Fonctionnalités** :
  - Gestion des commandes et des articles de commande.
  - Vérification de la disponibilité des produits via le Service Catalogue.

### 3. **Service Catalogue**
- **Base de données** : MySQL
- **Port** : `8082`
- **Fonctionnalités** :
  - Liste des produits disponibles.
  - Vérification de la disponibilité des produits par SKU.

## Communication
- **Type** : Synchrone via `WebClient`
- Le Service Commande communique avec le Service Catalogue pour vérifier les stocks avant de valider une commande.

## Prérequis
- **Java 17+**
- **MongoDB** et **MySQL**
- **Postman** (pour tester les APIs REST)

## Installation
1. Cloner ce dépôt : `git clone https://github.com/MicroService.git`
2. Configurer les bases de données :
   - MongoDB pour le Service Produit.
   - MySQL pour le Service Commande et le Service Catalogue.
3. Démarrer chaque microservice avec votre IDE ou Maven.
