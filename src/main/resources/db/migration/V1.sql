CREATE TABLE public.users
(
    id         int8    NOT NULL,
    login      varchar NOT NULL, -- Логин пользователя
    "password" varchar NOT NULL, -- Пароль пользователя.
    CONSTRAINT users_pk PRIMARY KEY (id)
);
COMMENT
ON TABLE public.users IS 'Таблица пользователей.';
COMMENT
ON COLUMN public.users.id IS 'Идентификатор пользователя';
COMMENT
ON COLUMN public.users.login IS 'Логин пользователя';
COMMENT
ON COLUMN public.users."password" IS 'Пароль пользователя.';

CREATE TABLE public.publishers
(
    id              int8    NOT NULL, -- Идетификатор источника
    "name"          varchar NOT NULL, -- Наименование источника
    report_interval varchar NULL,     -- Интервал создания отчёта(Выражение CRON)
    CONSTRAINT publishers_pk PRIMARY KEY (id)
);
COMMENT
ON TABLE public.publishers IS 'Таблица с источниками новостей';
COMMENT
ON COLUMN public.publishers."name" IS 'Наименование источника';
COMMENT
ON COLUMN public.publishers.report_interval IS 'Интервал создания отчёта(Выражение CRON)';
COMMENT
ON COLUMN public.publishers.id IS 'Идетификатор источника';

CREATE TABLE public.topics
(
    id           int8    NOT NULL, -- Идентификатор темы.
    description  varchar NOT NULL, -- Описание тематики
    publisher_id int8 NULL,        -- Идентификатор источника
    CONSTRAINT topics_pk PRIMARY KEY (id)
);
COMMENT
ON TABLE public.topics IS 'Таблица для хранения тематик новостей.';
COMMENT
ON COLUMN public.topics.id IS 'Идентификатор темы.';
COMMENT
ON COLUMN public.topics.description IS 'Описание тематики';
COMMENT
ON COLUMN public.topics.publisher_id IS 'Идентификатор источника';

ALTER TABLE public.topics
    ADD CONSTRAINT topics_fk FOREIGN KEY (publisher_id) REFERENCES public.publishers (id);

CREATE TABLE public.news
(
    id       int8    NOT NULL, -- Идентификатор новости
    topic_id int8    NOT NULL, -- Идентификатор темы
    "text"   varchar NOT NULL, -- Текст новости
    CONSTRAINT news_pk PRIMARY KEY (id)
);
COMMENT
ON TABLE public.news IS 'Таблица для хранения новостей';

COMMENT
ON COLUMN public.news.id IS 'Идентификатор новости';
COMMENT
ON COLUMN public.news.topic_id IS 'Идентификатор темы';
COMMENT
ON COLUMN public.news."text" IS 'Текст новости';

ALTER TABLE public.news
    ADD CONSTRAINT news_fk_1 FOREIGN KEY (topic_id) REFERENCES public.topics (id);

INSERT INTO public.publishers (id, "name", report_interval)
VALUES (1, 'irbis.plus', '*/5 * * * *');
INSERT INTO public.publishers (id, "name", report_interval)
VALUES (2, 'praktika.irbis.plus', '* * * * *');

INSERT INTO public.topics (id, description, publisher_id)
VALUES (1, 'Помощь юр. лицам', 1);
INSERT INTO public.topics (id, description, publisher_id)
VALUES (2, 'Помощь физ. лицам', 1);
INSERT INTO public.topics (id, description, publisher_id)
VALUES (3, 'О нас', 1);
INSERT INTO public.topics (id, description, publisher_id)
VALUES (4, 'Обновления сервиса', 2);

INSERT INTO public.news (id, topic_id, "text")
VALUES (1, 1, 'Обновления законодательства в 2022 году.');
INSERT INTO public.news (id, topic_id, "text")
VALUES (2, 1, 'Обновления законодательства в 2023 г.');
INSERT INTO public.news (id, topic_id, "text")
VALUES (3, 2, 'Рассказываем о том как обезопасить себя от мошенников');
INSERT INTO public.news (id, topic_id, "text")
VALUES (4, 3, 'Рассказываем о том как отдыхают наши работники');
INSERT INTO public.news (id, topic_id, "text")
VALUES (5, 3, 'Знакомим с нашими клиентами. Часть 1');
INSERT INTO public.news (id, topic_id, "text")
VALUES (6, 3, 'Знакомим с нашими клиентами. Часть 2');
INSERT INTO public.news (id, topic_id, "text")
VALUES (7, 4, 'Знакомство с сервисом');
INSERT INTO public.news (id, topic_id, "text")
VALUES (8, 4, 'Нововведения во вкладке "Суды"');

INSERT INTO public.users (id, login, "password")
VALUES (1, 'user', '$2a$08$WGFVSLfhxNBWuqqeuw.e9eiZGZBwuu/uZ20x79uzGReMC2Jv0gGB6');

