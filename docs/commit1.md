# Шаг 01 — Стартовый Ktor-проект

**Коммит:** `ed6cfd6` — *Add initial Ktor 3.4 starter project*

---

## О чём этот проект (вводная часть)

Это **backend-сервер** для Android-приложения с информацией о персонажах аниме **«Магическая битва» (Jujutsu Kaisen / JJK)**.

### Что такое Ktor?

**Ktor** — фреймворк от JetBrains для написания HTTP-серверов и клиентов на **Kotlin**. Он:

- работает поверх движка (у нас — **Netty**);
- позволяет описывать **маршруты** (`GET /jjk/heroes`, `GET /images/...`);
- подключает **плагины** (логирование, JSON, DI и т.д.);
- хорошо сочетается с **корутинами** и **kotlinx.serialization**.

По сути Ktor — это «скелет» веб-сервера: ты собираешь из плагинов и своего кода то, что нужно приложению.

### Кто с кем «разъезжается» (архитектура в будущем)

```
┌─────────────────┐         HTTP/JSON          ┌──────────────────────────┐
│  Android-приложение │  ──────────────────►  │  Ktor Server (этот проект) │
│  (клиент)           │  ◄──────────────────  │  Character Server / JJK API │
└─────────────────┘                            └──────────────────────────┘
         │                                                │
         │  Room + Paging                                 │  Repository (данные)
         │  Coil (картинки)                               │  Статика /images
         └────────────────────────────────────────────────┘
```

- **Клиент** (Android) запрашивает список героев, поиск, картинки.
- **Сервер** отдаёт JSON и файлы изображений.
- Позже между слоями сервера появятся: **модели**, **репозиторий**, **маршруты**, **Koin (DI)**, **плагины**.

### Какая задача у сервера в будущем

После всех шагов (см. `ROADMAP.md`) сервер должен:

| Эндпоинт | Назначение |
|----------|------------|
| `GET /` | Приветствие |
| `GET /jjk/heroes?page=1..5` | Список героев с пагинацией |
| `GET /jjk/heroes/search?name=...` | Поиск по имени |
| `GET /images/{file}.jpg` | Аватары персонажей |

Ответы — в формате **JSON** (`ApiResponse` + список `Hero`). Поле `lastUpdater` нужно Android-клиенту для решения: обновлять кэш или нет (`RemoteMediator`).

---

## Что было на этом шаге

Создан **пустой** проект с [start.ktor.io](https://start.ktor.io):

- движок **Netty**;
- сборка **Gradle (Kotlin DSL)**;
- конфигурация **HOCON** (`application.conf`);
- порт **8080**;
- минимальный маршрут `GET /` → `"Hello, World!"`.

Также в репозиторий добавлен файл **`ROADMAP.md`** — пошаговая инструкция, по которой мы дальше достраиваем проект.

---

## Структура проекта после шага 01

```
ktor-example/
├── ROADMAP.md                 ← дорожная карта
├── build.gradle.kts
├── settings.gradle.kts
├── gradle/libs.versions.toml
├── src/main/kotlin/
│   ├── main.kt                ← точка входа
│   └── Routing.kt             ← единственный маршрут
├── src/main/resources/
│   ├── application.conf       ← порт, modules
│   └── logback.xml            ← логирование
└── src/test/kotlin/
    └── ServerTest.kt          ← проверка GET /
```

---

## Ключевые файлы и код

### `main.kt` — запуск Netty

```kotlin
package com.example

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}
```

`EngineMain` читает `application.conf`, поднимает Netty и вызывает функции из `modules = [...]`.

### `Routing.kt` — первый маршрут

```kotlin
package com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello, World!")
        }
    }
}
```

### `application.conf`

```hocon
ktor {
  deployment {
    port = 8080
    port = ${?PORT}
  }
  application {
    modules = [
      com.example.RoutingKt.configureRouting
    ]
  }
}
```

Ktor вызывает **extension-функцию** `configureRouting` на объекте `Application` — это стандартный способ подключить модуль.

### `build.gradle.kts` (минимальный набор)

На старте были только:

- `ktor-server-core`
- `ktor-server-netty`
- `logback-classic`

Версии Ktor подтягивались через **version catalog** `ktorLibs` в `settings.gradle.kts`.

### `ServerTest.kt`

```kotlin
@Test
fun `test root endpoint`() = testApplication {
    configure()
    assertEquals(HttpStatusCode.OK, client.get("/").status)
}
```

Проверка: корень отвечает **200 OK**.

---

## Как запустить

```bash
./gradlew run
```

В логах ожидаем:

```
Application started ...
Responding at http://0.0.0.0:8080
```

В браузере: http://localhost:8080/ → `Hello, World!`

---

## Что ещё НЕ сделано (будет в следующих шагах)

- JSON и модели `Hero` / `ApiResponse`
- Репозиторий с 15 героями и пагинацией
- Koin, плагины, API `/jjk/heroes`
- Статика картинок
- Полный набор тестов

---

## Связь с Android

Сейчас сервер — «заготовка». Android-приложение (`ktorinfocharacterapp`) позже будет обращаться к полноценному API. На этом шаге достаточно убедиться, что **сервер стартует** и отвечает на `/`.

**Следующий шаг:** [02-gradle-dependencies](../02-gradle-dependencies/)

