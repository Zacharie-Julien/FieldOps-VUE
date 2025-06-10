# 🌾 FieldOps – Application de Gestion Agricole

**Projet BTS SIO SLAM – Épreuve E6**  
Auteur : Zacharie Julien  
Période : Avril – Juin 2025  
Lieu : Marseille  
Lien : [fieldops.d4cd13ger.fr](http://fieldops.d4cd13ger.fr)  
Code source : [GitHub](https://github.com/Zacharie-Julien/FieldOps-VUE)

---

## 🎯 Objectif du Projet

FieldOps est une application web destinée aux exploitants agricoles. Elle centralise les informations liées aux champs, ouvriers, produits et traitements. L’objectif est de faciliter :

- Le suivi des interventions,
- La planification des traitements,
- La traçabilité des actions.

---

## 👥 Profils Utilisateurs

- **Administrateur** : Gestion complète des entités (champs, ouvriers, traitements, domaine).
- **Ouvrier** : Consultation des tâches et validation des traitements.

---

## 🧠 Fonctionnalités Clés

- Ajout / modification / suppression de :
  - Champs agricoles
  - Ouvriers
  - Traitements phytosanitaires
- Attribution de traitements aux ouvriers
- Suivi de l’historique des interventions

---

## 🛠️ Architecture et Technologies

### 🔄 Architecture 3-tiers
- **Front-end** : Vue.js
- **Back-end** : Java EE (WildFly)
- **Base de données** : MySQL (MariaDB)

### 📦 Stack technique

| Élément                  | Technologie            |
|--------------------------|------------------------|
| Front-end                | Vue.js                 |
| Back-end                | Java EE (JAX-RS)       |
| Serveur d'application   | WildFly                |
| SGBD                    | MySQL / MariaDB        |
| Serveur Web             | Apache2                |
| OS (App)                | Debian 12              |
| OS (DB)                 | Ubuntu Server          |
| Versioning              | GitHub / GitLab        |

---

## 🔐 Comptes de Test

- 👨‍🌾 **Administrateur**  
  login : `proprietaire@test.com`  
  mot de passe : `/\:Passwd123_`

- 🧑‍🔧 **Ouvrier**  
  login : `ouvrier@test.com`  
  mot de passe : `/\:Passwd123_`

---

## 📊 MCD et Navigation

L'application repose sur un MCD structuré avec les entités suivantes :

- Domaine, Champ, Type de sol
- Traitement, Produit
- Utilisateur (Admin / Ouvrier)

Navigation intuitive :
- Interface dédiée pour chaque profil
- Dashboard administrateur avec graphiques météo et suivi
- Interface simplifiée pour les ouvriers

---

## 🧪 Tests & Déploiement

- Déploiement auto-hébergé (serveurs Linux)
- Application responsive
- Tests manuels des parcours utilisateurs (CRUD, navigation, permissions)

---

## 📁 Accès et Documentation

- Interface utilisateur accessible : [fieldops.d4cd13ger.fr](http://fieldops.d4cd13ger.fr)
- Code source complet : [GitHub Repository](https://github.com/Zacharie-Julien/FieldOps-VUE)

---

## 🏁 Conclusion

FieldOps propose une solution moderne et sécurisée pour la gestion d’une exploitation agricole. Elle améliore le pilotage des interventions terrain tout en assurant la traçabilité et la sécurité des données.

---
