# irbis test
Проект написан на Spring boot 3.0.  
Он содержит авторизацию через JWT токен.  
В проекте использована библиотека Flyway.  
Доступ к базе через Spring Data JPA.  
Также приложены Dockerfile и докер компос файлы к проекту.  
Для разворачивания проекта в докере необходимо: 
1. "сбилдить проект" 
2. получившийся .jar скопировать в одну и ту же папку с докер файлами и выполнить команду запуска в командной строке  
Приложение стартанёт по адресу http://localhost:8090/api/v1/  
Страница документации http://localhost:8090/api/v1/swagger-ui   
В файле конфигурации можно выбирать директорию для сохранения табличек в  свойстве reportPath
