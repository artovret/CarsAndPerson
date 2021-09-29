###  Реализация backend + api (Rest) + БД (PostgreSql) под следующий функционал:

Сохранение объекта Person

Сохранение объекта Car

Выдача объекта PersonWithCars, содержащего поля объекта Person, найденного по id=personid с массивом объектов Car, у которых ownerid=person.id

Формирование объекта Statistics

Удаление всех ранее сохраненных объектов (Person, Car)

### Настройка
Необходимо задать переменные окружения

windows:

`set DB_NAME=<ИМЯ БД>`

`set DB_PASS=<ПАРОЛЬ БД>`

`set DB_URL=<ССЫЛКА НА ИСТОЧНИК ДАННЫХ>`

linux:


`export DB_NAME=<ИМЯ БД>`

`export DB_PASS=<ПАРОЛЬ БД>`

`export DB_URL=<ССЫЛКА НА ИСТОЧНИК ДАННЫХ`

### Сборка zip

`mvn clean package`
