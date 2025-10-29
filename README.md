# 🧩 POKÉMON – Application Kotlin modulaire en Clean Architecture

Ce projet a pour objectif de créer une application **Android** modulaire en **Clean Architecture**, développée en **Kotlin**, et basée sur l’API publique [Tyradex](https://tyradex.vercel.app/api/v1/).

L’application permet de récupérer, afficher et mettre en cache des Pokémon grâce à une architecture claire, évolutive et découplée.

---

## 🚀 Fonctionnalités principales

- 🧱 **Architecture modulaire** : séparation en modules `data`, `domain`, `ui`, et `api` pour une meilleure maintenabilité.  
- 🎨 **Thème clair / sombre** : prise en charge complète du thème système.  
- 🗣️ **Gestion des chaines de caractères** : utilisation des fichiers `strings.xml` pour centraliser le texte de l’application.  
- 📱 **Extensions de contexte** : ajout de fonctionnalités natives (vibrations, sons, etc.).  
- 💉 **Injection de dépendances** : mise en place via **Koin** pour un code clair et testable.  
- 💾 **Mise en cache locale avec Room** : gestion des entités et DAO pour la persistance hors ligne.  
- 🌐 **Appels API avec Ktor** : communication réseau avec gestion du parsing JSON.  
- 🧭 **Extension d’Activity** : personnalisation du comportement du téléphone (ex. gestion de la `BottomNavBar`).  

## ⚙️ Technologies utilisées

| Catégorie | Outil / Librairie |
|------------|-------------------|
| Langage | **Kotlin** |
| Architecture | **Clean Architecture** |
| DI | **Koin** |
| Réseau | **Ktor** |
| Base de données | **Room** |
| Sérialisation | **kotlinx.serialization** |
| UI | **Jetpack Compose** |
| Thème | **Material 3 + Mode clair/sombre** |
| Gestion de contexte | Extensions (`Context`, `Activity`) personnalisées |

---

## 🧩 Fonctionnement général

1. **Ktor** appelle l’API Tyradex pour récupérer la liste ou le détail des Pokémon.  
2. Les données sont **converties en modèles locaux** (`PokemonModel`) via un **mapper**.  
3. Les données sont ensuite **stockées dans Room** (DAO) pour le cache local.  
4. L’interface utilisateur (UI) observe les données via le **ViewModel** et s’actualise automatiquement.  
5. En cas d’absence de réseau, la donnée est **récupérée depuis la base locale**.

---

## 🧰 Points techniques notables

- **Extension de contexte**  
  → permet de gérer les vibrations et sons système simplement.  

- **Extension d’Activity**  
  → pour activer le mode plein écran ou gérer les barres système.  

- **Utilisation de `@TypeConverters`**  
  → pour convertir des types complexes dans Room.

---

## 🧑‍💻 Auteur

👤 **Théo Laforge**  
Projet réalisé dans le cadre d’un apprentissage autour de **Kotlin**, **Clean Architecture**, et des **bonnes pratiques Android modernes**.
Ce README a été rédigé et relu avec l’aide de ChatGPT.
