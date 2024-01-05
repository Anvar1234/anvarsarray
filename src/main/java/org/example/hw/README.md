# Примечания по ДЗ
## Задачи:

1. с помощью Optional обработать все ошибки, в частности, если не пришло ни одного аргумента.
2. разобраться с лямбдами (до этого с функциональным программированием, функциональными интерфейсами). 
3. Разобраться с рекурсией. 
4. разобраться со статическим блоком инициализации.
5. реализовать алгоритм быстрой сортировки.
6. повторить алгоритм сортировки слиянием еще раз.

**Прошу пардону, что в репозитории по ссылке такой бардак, не стал заново создавать его, оставил то с чем работали...**

## Ответы и пояснения:
**Ответ по №1 (см. класс Task2):**
1. Если я правильно разобрался в теме, то Optional класс нужно использовать в случае, если null в принципе 
допускается, например, в случае поиска по БД метод может вернуть null, если объекта не найдено, или в метод может 
прилететь null в ходе нормального выполнения программы. Если null недопустим в ходе выполнения программы, то это ошибка, 
и ее нужно исправлять в коде.

***Пояснение по №1:*** <br> В ДЗ с помощью Optional я обработал случаи, когда: 
* не введен ни один операнд,
* вместо операнда приходит null, 
* кол-во операндов не соответствует оператору,
* приходит не верный оператор.

Так как мне кажется вполне логичным, что в ходе нормального выполнения программы это все может произойти: 
или пользователь что-то напутает, или какой-то метод может передать в качестве аргумента уже в наш метод что-то не то. 

В классе **Task2** я оставил закомментированный код, чтобы можно было сравнить что было, и что стало, там приведены 
3 варианта: "Было так", "Вариант без Optional", "Вариант с Optional".

Также немного разобрался с вариативным вводом. Мне хотелось избавиться в мейне от ручного изменения 
количества аргументов метода, поэтому в метод **calculate**(char operator, ***double... arguments***) я добавил вариативный 
ввод чисел, так как при сложении нужно 2 числа, а при возведении в степень - одно.

Также добавил мапу **operatorsAccount**, в которой содержиться информация сколько аргументов (чисел) должно быть
при таком-то операторе. То есть если + - * / - должно быть 2 числа, при возведении в степень - одно.


**Ответ по №2 (см. класс FuncInterfaceANDLambdas):**  
Ознакомился с функциональными интерфейсами, порешал простенькие задачки с лямбдами.

**Ответ по №3:**  
Как работает рекурсия понял, порядок возврата значений тоже.

**Ответ по №4:**  
В статический блок инициализации сильно не закапывался, понял только, что кроме иницализации переменных в нем можно
прописывать более сложную логику, использовать методы и тд, чтобы всё, что должно быть готово к началу работы программы 
было инициализированно и подгружено.

**Ответ по №5 (см. классы AnvarQuickSort и AnvarQuickSort2):**  
Сделал быструю сортировку сначала по своему (AnvarQuickSort, через создание дополнительных двух массивов), там 
по тупому использовал внутри списки (АррайЛисты), так как массивы неизменяемы. Скорее всего можно было как-то через 
массивы все же сделать.  
Во втором способе (AnvarQuickSort2) сделал через индексы и указатели, этот метод я самостоятельно изначально сообразить 
не смог, подсмотрел, потом реализовал не глядя, но была ошибка в рекурсивном вызове метода - **не ясно**, 
почему именно так выбираются новые границы?

**Ответ по №6 (см. класс AnvarMergeSort и MergeSort):**  
Сделал без подглядываний, получилось вроде грубее, чем при совместной работе, но главное, что получилось. Запушил также 
класс MergeSort - это мы делали на созвоне, для сравнения с моим написание AnvarMergeSort, может будет видно, что именно 
мне нужно подтянуть.

