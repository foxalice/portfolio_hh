## Проект по автоматизации тестирования IBS

### 🚀: Содержание:

➠ Технологии и инструменты

➠ Реализованные проверки

➠ Сборка в Jenkins

➠ Запуск из терминала

➠ Примеры использования

➠ Allure отчет

➠ Отчет в Telegram

➠ Видео примеры прохождения тестов

### 🧰: Технологии и инструменты

IDEA Java Github JUnit 5 Gradle Selenide Selenoid Allure Jenkins

### Реализованные проверки

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

### 🐦: Параметры сборки в Jenkins:

-Dbrowser (браузер, по умолчанию chrome)

-Dbrowser_version (версия браузера, по умолчанию 100)

-DbrowserSize (размер окна браузера, по умолчанию 1920x1080)

### 🏗️: Запуск тестов 

Удаленный запуск:

`clean
remote_test
"-Dbrowser=${BROWSER}"
"-DbrowserSize=${BROWSERSIZE}"
"-Dbrowser_version=${BROWSER_VERSION}"`

Примеры использования
Выдать отчет:

allure serve build/allure-results

### Allure Отчет в Allure report

💹: Основной отчет
![report.png](https://github.com/foxalice/portfolio_hh/tree/main/img/allure_report.png)️

🧪: Тесты (последовательное выполнение)
Allure Tests
![report.png](https://github.com/foxalice/portfolio_hh/tree/main/img/suites.png)️

Allure Уведомление в Telegram при помощи бота

![report.png](https://github.com/foxalice/portfolio_hh/blob/main/img/telegram_img.png)


###  💹: Jenkins Видео прохождения тестов


[![Watch the video](https://github.com/foxalice/portfolio_hh/tree/main/img/start.png)](https://youtu.be/5OZ32Tchgog)
