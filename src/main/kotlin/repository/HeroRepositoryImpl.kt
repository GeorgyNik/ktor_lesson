package com.example.repository

import com.example.models.ApiResponse
import com.example.models.Hero
import javax.management.Query

const val NEXT_PAGE_KEY = "nextPage"
const val PREV_PAGE_KEY = "prevPage"


class HeroRepositoryImpl() : HeroRepository {
    override val heroes: Map<Int, List<Hero>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5
        )
    }


    override val page1 = listOf(
        Hero(
            id = 1,
            name = "Юдзи Итадори",
            image = "/images/itadori.jpg",
            about = "Студент первого курса Токийского технического колледжа магии. Сосуд Рёмена Сукуны.",
            rating = 4.8,
            power = 85,
            month = "Март",
            day = "20",
            family = listOf("Итадори"),
            natureTypes = listOf("Ближний бой", "Проклятая энергия"),
            abilities = listOf("Чёрная вспышка", "Расширение территории", "Сила Сукуны")
        ),
        Hero(
            id = 2,
            name = "Сатору Годжо",
            image = "/images/gojo.jpg",
            about = "Сильнейший современный колдун. Преподаватель в Токийском колледже магии.",
            rating = 5.0,
            power = 100,
            month = "Декабрь",
            day = "7",
            family = listOf("Годжо"),
            natureTypes = listOf("Бесконечность", "Шесть глаз"),
            abilities = listOf("Бесконечность", "Синий", "Красный", "Фиолетовый", "Расширение территории")
        ),
        Hero(
            id = 3,
            name = "Тодзи Фушигуро",
            image = "/images/toji.jpg",
            about = "Наёмный колдун без проклятой энергии. Отец Мегуми Фусигуро.",
            rating = 4.7,
            power = 92,
            month = "Декабрь",
            day = "31",
            family = listOf("Фушигуро", "Дзенин"),
            natureTypes = listOf("Физическая сила", "Оружие"),
            abilities = listOf("Инвертированная проклятая техника", "Божественная собака", "Мастерство оружия")
        )
    )

    override val page2 = listOf(
        Hero(
            id = 4,
            name = "Мегуми Фушигуро",
            image = "/images/megumi.jpg",
            about = "Студент первого курса, специалист по призыву сёгунов через Теневую технику.",
            rating = 4.6,
            power = 82,
            month = "Декабрь",
            day = "22",
            family = listOf("Фушигуро"),
            natureTypes = listOf("Теневая техника", "Призыв"),
            abilities = listOf("Дивина собака", "Нуэ", "Махорага", "Расширение территории")
        ),
        Hero(
            id = 5,
            name = "Нобара Кугиcаки",
            image = "/images/nobara.jpg",
            about = "Студентка первого курса, использует технику молотка и гвоздей.",
            rating = 4.5,
            power = 78,
            month = "Август",
            day = "7",
            family = listOf("Кугиcаки"),
            natureTypes = listOf("Строительная техника", "Проклятые предметы"),
            abilities = listOf("Резонанс", "Взрывной гвоздь", "Чёрная вспышка")
        ),
        Hero(
            id = 6,
            name = "Рёмен Сукуна",
            image = "/images/sukuna.jpg",
            about = "Король проклятий, заключённый в теле Юдзи Итадори.",
            rating = 4.9,
            power = 99,
            month = "Неизвестно",
            day = "—",
            family = listOf("Сукуна"),
            natureTypes = listOf("Проклятая энергия", "Резня"),
            abilities = listOf("Разрез", "Огонь", "Расширение территории", "Махорага")
        )
    )

    override val page3 = listOf(
        Hero(
            id = 7,
            name = "Панда",
            image = "/images/panda.jpg",
            about = "Аномальный труп, студент второго курса Токийского колледжа магии.",
            rating = 4.3,
            power = 75,
            month = "Март",
            day = "5",
            family = listOf("—"),
            natureTypes = listOf("Проклятый труп", "Трансформация"),
            abilities = listOf("Три ядра", "Горилла", "Триггер")
        ),
        Hero(
            id = 8,
            name = "Тоге Инумаки",
            image = "/images/toge.jpg",
            about = "Студент второго курса с техникой Проклятой речи.",
            rating = 4.4,
            power = 76,
            month = "Октябрь",
            day = "23",
            family = listOf("Инумаки"),
            natureTypes = listOf("Проклятая речь"),
            abilities = listOf("Спи", "Взрывайся", "Беги", "Расширение территории")
        ),
        Hero(
            id = 9,
            name = "Маки Дзэнин",
            image = "/images/maki.jpg",
            about = "Студентка второго курса клана Дзэнин, мастер оружия ближнего боя.",
            rating = 4.6,
            power = 88,
            month = "Январь",
            day = "7",
            family = listOf("Дзэнин"),
            natureTypes = listOf("Физическая сила", "Оружие"),
            abilities = listOf("Мастерство оружия", "Небесное ограничение", "Чёрная вспышка")
        )
    )

    override val page4 = listOf(
        Hero(
            id = 10,
            name = "Аои Тодо",
            image = "/images/todo.jpg",
            about = "Студент третьего курса Киотского колледжа магии, мастер ближнего боя.",
            rating = 4.5,
            power = 84,
            month = "Сентябрь",
            day = "23",
            family = listOf("Тодо"),
            natureTypes = listOf("Ближний бой", "Обмен"),
            abilities = listOf("Буэ", "Обмен позиций", "Чёрная вспышка")
        ),
        Hero(
            id = 11,
            name = "Кенто Нанами",
            image = "/images/nanami.jpg",
            about = "Бывший офисный работник, ставший колдуном первого класса.",
            rating = 4.7,
            power = 86,
            month = "Июль",
            day = "3",
            family = listOf("Нанами"),
            natureTypes = listOf("Соотношение", "Меч"),
            abilities = listOf("Соотношение 7:3", "Расширение территории", "Чёрная вспышка")
        ),
        Hero(
            id = 12,
            name = "Махито",
            image = "/images/mahito.jpg",
            about = "Проклятие особого класса, манипулирующее душами.",
            rating = 4.2,
            power = 90,
            month = "Неизвестно",
            day = "—",
            family = listOf("—"),
            natureTypes = listOf("Идл", "Трансфигурация"),
            abilities = listOf("Простое домен", "Мгновенная смерть", "Расширение территории")
        )
    )

    override val page5 = listOf(
        Hero(
            id = 13,
            name = "Джого",
            image = "/images/jogo.jpg",
            about = "Проклятие особого класса, воплощение страха перед землетрясениями и огнём.",
            rating = 4.1,
            power = 87,
            month = "Неизвестно",
            day = "—",
            family = listOf("—"),
            natureTypes = listOf("Огонь", "Вулкан"),
            abilities = listOf("Максимум: метеор", "Домен", "Инферно")
        ),
        Hero(
            id = 14,
            name = "Ханами",
            image = "/images/hanami.jpg",
            about = "Проклятие особого класса, связанное с природой и растениями.",
            rating = 4.0,
            power = 83,
            month = "Неизвестно",
            day = "—",
            family = listOf("—"),
            natureTypes = listOf("Природа", "Растения"),
            abilities = listOf("Домен", "Цветочная техника", "Регенерация")
        ),
        Hero(
            id = 15,
            name = "Чосо",
            image = "/images/choso.jpg",
            about = "Проклятая кровь, старший из братьев Камо.",
            rating = 4.4,
            power = 85,
            month = "Март",
            day = "12",
            family = listOf("Камо"),
            natureTypes = listOf("Кровь", "Манипуляция"),
            abilities = listOf("Кровавая манипуляция", "Суперновая", "Расширение территории")
        )
    )

    override suspend fun getAllHeroes(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = "OK",
            prevPage = calculatePage(page)[PREV_PAGE_KEY],
            nextPage = calculatePage(page)[NEXT_PAGE_KEY],
            heroes = heroes[page]!!,
            lastUpdater = System.currentTimeMillis()
        )
    }

    override suspend fun searchHeroes(name: String?): ApiResponse {
        return ApiResponse(
            success = true,
            message = "OK",
            prevPage = null,
            nextPage = null,
            heroes = findHeroes(name),
            lastUpdater = null
        )
    }

    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page

        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }

        if (page == 5) {
            nextPage = null
        }

        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }

        if (page == 1) {
            prevPage = null
        }

        return mapOf(
            PREV_PAGE_KEY to prevPage,
            NEXT_PAGE_KEY to nextPage
        )

    }

    private fun findHeroes(query: String?): List<Hero> {
        val founded: MutableList<Hero> = mutableListOf<Hero>()

        return if (!query.isNullOrEmpty()) {
            heroes.forEach { _, heroes ->
                heroes.forEach { hero ->
                    if (hero.name.lowercase().contains(query.lowercase())) {
                        founded.add(hero)
                    }
                }
            }
            founded
        } else {emptyList()}
    }
}