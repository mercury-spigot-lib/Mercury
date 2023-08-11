# Mercury Spigot Library (1.13+)

![](https://ledev.ru/files/github/MercuryPOSTER.png)

## Содержание

* Установка
   * импорт библиотеки в pom.xml

* Начало разработки
   * редактирование главного класса
   * новый функционал главного класса
     * метод getInstance
     * методы для работы с файлом конфигурации

* Класс Mercury
   * получение Uptime
   * получение Tps

* О проекте и тех его создал 
   * о проекте
   * об авторах
   * отдельная благодарность

## Документация

### Установка

> Нашу библеотеку можно установить только с помощью Maven

Для того чтобы установить нашу библиотеку нужно:

1. Открыть файл pom.xml

2. Вствить внутри тега repositories:

```java

<repository>
  <id>spigotmc-repo</id>
  <url>https://hub.spigotmc.org/nexus/content/repositories/snapshots/</url>
</repository>

```
   
3. Вствить внутри тега dependencies:

```java

<dependency>
  <groupId>ru.mercuryspigot</groupId>
  <artifactId>mercuryspigotlibrary</artifactId>
  <version>1.13-R0.1-SNAPSHOT</version>
  <scope>provided</scope>
</dependency>

```

4. Обновить Maven
