# Projet ChaTôp

Pour faire fonctionner le code de ce repo, rendez-vous sur le [frontend](https://github.com/Emiliengrbn/ChaTop-Front) et suivez les instructions.

## Pour commencer

### Prérequis

ChaTôp utilise la stack suivante :

- [Mysql](https://www.mysql.com/fr/)
- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [AWS](https://eu-north-1.signin.aws.amazon.com/oauth?response_type=code&client_id=arn%3Aaws%3Asignin%3A%3A%3Aconsole%2Fcanvas&redirect_uri=https%3A%2F%2Fconsole.aws.amazon.com%2Fconsole%2Fhome%3FhashArgs%3D%2523%26isauthcode%3Dtrue%26nc2%3Dh_ct%26src%3Dheader-signin%26state%3DhashArgsFromTB_eu-north-1_538d993248926378&forceMobileLayout=0&forceMobileApp=0&code_challenge=IEWVmnFXZ5c5donry0PL3rp_2Wg4rw1hmXiMTe0OtPo&code_challenge_method=SHA-256)

Assurez-vous d'avoir les bonnes versions.

### Instructions

1. Forkez ce repo
1. Clonez le dépôt sur votre ordinateur
2. Dans la configuration, vérifiez la version de java (21), et dans la partie "run" tapez "spring-boot:run"
3. Dans le aaplication.properties, remplacez les variables d'environnement par vos informations (mysql, aws)
1. Lancez la commande de run

Votre serveur devrait maintenant être en cours d'exécution à l'adresse http://localhost:9080
```
