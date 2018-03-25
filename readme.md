Задание:


Написать программу, в которой будет две функции: добавить в БД строку и вывести все строки на экран.
БД - одна таблица с двумя колонками: id и name. Соответственно будет два графических интерфейса:

- Интерфейс добавления строки: поле ввода имени и кнопка Добавить.
- Интерфейс вывода строк на экран - таблица с двумя колонкам: Ид и Имя. Над таблицей должен присутствовать фильтр для поиска в таблице.

В качестве БД использовать MySQL.

В качестве фреймворков - желательно (но не обязательно) spring. Для доступа к БД - jdbc (spring-jdbc).
По графическим интерфейсам: желательно, чтобы интерфейсы были сделаны с испоьзованием паттерна MVC (spring-mvc приветствуется).


Описание выполнения проекта
-

- Архитектурная модель Spring MVC https://www.genuitec.com/docs/web-apps/spring-web/myeclipse-spring-reference-blueprints/
- При выполнении тестов база данных удаляется и создается заново, с заполнением тестовых данных.
- При старте приложения база данных создается и заполняется значениями
- С помощью Maven проект собирается в war и его необходимо запустить с помщью tomcat
- В приложении подключено логгирование

Настройка проекта
-
- В файл настройки журнала /src/main/resources/logback.xml добавить путь, где будет создан log файл в строке 8
  или отключить логирование в журнал, удалив строку 26
- Настройка DB
    - Использовал 10.1.25-MariaDB т.к. она уже была установлена
    - Настойка mysql происходит в файле /src/main/resources/db/mysql.properties
    - У пользователя DB должны быть права на создание таблиц

     
    