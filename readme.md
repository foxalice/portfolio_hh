###### Проект по автоматизации тестирования IBS

###### 🚀: Содержание:

➠ Технологии и инструменты

➠ Реализованные проверки

➠ Сборка в Jenkins

➠ Запуск из терминала

➠ Примеры использования

➠ Allure отчет

➠ Отчет в Telegram

➠ Видео примеры прохождения тестов

###### 🧰: Технологии и инструменты

IDEA Java Github JUnit 5 Gradle Selenide Selenoid Allure Jenkins

###### Реализованные проверки

💥: Тест 1
✓ Открыть сайт ibs.ru
✓ Нажать в быстрый поиск
✓ Выполнить поиск вакансии QA
✓ Проверить что в выдаче результатов есть вакансия

💥: Тест 2
✓ Открыть сайт ibs.ru
✓ Проверить что в названии присутствует текст "IBS — ведущая российская IT-сервисная компания"
✓ Проверить что среди отображаемых направлений работы присутствует фиксированный список

💥: Тест 3
✓ Открыть сайт ibs.ru
✓ Перейти в раздел "Все новости"
✓ Выбрать фильтр "Мероприятия"
✓ Проверить что на странице содержиться статьи с хэштегом "Мероприятия"

💥: Тест 4
✓ Открыть сайт ibs.ru
✓ Проверить что в заголовке присутствует текст "IBS — ведущая российская IT-сервисная компания"
✓ Нажать на кнопку "Принимаю условия" (cookie)
✓ Сменить язык содержимого сайта на английский (ENG)
✓ Проверить что среди отображаемых направлений работы присутствует фиксированный список

💥: Тест 5
✓ Открыть сайт ibs.ru
✓ Перейти в раздел "Контакты"
✓ Проверить что адрес главного офиса соответствует переменной

Jenkins Jenkins job
Jenkins

###### 🐦: Параметры сборки в Jenkins:

-Dbrowser (браузер, по умолчанию chrome)

-DbrowserVersion (версия браузера, по умолчанию 99.)

-DbrowserSize (размер окна браузера, по умолчанию 1920x1080)

REMOTE_URL (Selenoid url, по умолчанию selenoid.autotests.cloud/wd/hub)

🏗️: Запуск тестов 

Удаленный запуск:

clean
test
-Dbrowser=${Browser}
-DbrowserVersion=${Browser_version}
-DbrowserSize=${Browser_size}

Примеры использования
Выдать отчет:

allure serve build/allure-results
Allure Отчет в Allure report

💹: Основной отчет
![report.png](C:\Users\natalya.saveleva\Pictures\allure_report.png)️

🧪: Тесты (последовательное выполнение)
Allure Tests
![report.png](C:\Users\natalya.saveleva\Pictures\suites.png)️

Allure Уведомление в Telegram при помощи бота

![report.png](C:\Users\natalya.saveleva\Pictures\telegram_img.png)

Jenkins Видео прохождения тестов

<a href="https://youtu.be/5OZ32Tchgog" target="_blank"><img src="http://img.youtube.com/vi/ID_ВИДЕОРОЛИКА_НА_YOUTUBE/0.jpg"
alt="Прохождение теста" width="240" height="180" border="10" /></a>