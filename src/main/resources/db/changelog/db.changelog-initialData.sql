-- liquibase formatted sql

-- changeset liquibase:1
create table if not exists Product (
    id serial primary key,
    productName varchar(100) not null,
    price numeric not null
);

-- changeset liquibase:2
create table if not exists DiscountCard (
    id serial primary key,
    discount integer not null
);

-- changeset liquibase:3
insert into Product(productName, price)
values ('Арматура 8мм А3 (1п.м.)', 12),
       ('Болт оцинкованный М8х80 (50шт.уп.)', 104),
       ('Бумага наждачная шлифовальная М40 (1 п.м.)', 88),
       ('Гайка М6 шестигранная оцинкованная (450шт.уп.)', 72),
       ('Гвозди строительные 3x70мм', 32),
       ('Гофра к унитазу 1м.', 92),
       ('Грунт-эмаль по ржавчине - Синяя (ведро 20кг)', 1199.6),
       ('Кирпич лицевой одинарный (размер 250х120х65) М150 цвет абрикос', 10),
       ('Кирпич строительный двойной щелевой М150 (250х120х130мм)', 6.8),
       ('Клей монтажный КНАУФ Перлфикс / KNAUF Perlfix (30 кг.)', 132),
       ('Клейкая лента фольгированная алюминиевая', 60),
       ('КНАУФ Тифенгрунд / KNAUF Tiefengrund грунтовка универсальная (10л)', 300),
       ('Коллектор с вентильными кранами (Comisa) 3\4-1\2, 4 выхода (88.20.060)', 360),
       ('Кран шаровой ф50 (4SPK0766)', 260),
       ('Миксер(Мешалка) для смешивания смесей 100*500', 84),
       ('Пена монтажная Титан для блоков 750 мл.', 180),
       ('ПЕНОПЛЭКС КРОВЛЯ (пл.35 ) 1200х600х50мм 5.76 м2, 0.288 м3, (8 шт)', 592),
       ('Перфоратор Макита HR2450 780 Вт.', 3396),
       ('ПЕРЧАТКИ рабочие трикотажные с точечным покрытием', 8),
       ('Просечка ЦПВС штукатурная, размер 1х10м (10м2)', 100),
       ('Радиатор биметаллический XTREME 500*100 (12секций) Италия', 4200),
       ('Саморезы по дереву 3.8х55', 100),
       ('Саморезы с прессшайбой 4,2 х 16 острый наконечник', 112),
       ('Тачка строительная 2 колесная 110л', 1400),
       ('ТИККУРИЛА Евро 2 / TIKKURILA Euro 2 краска матовая латексная (9 л)', 980),
       ('Уголок металлический 32 мм (1 п.м.)', 48),
       ('Утеплитель Роквул (Rockwool) Лайт Баттс Скандик 5.76м2 (0.288м3) 800*600*50мм', 180),
       ('Фильтр промывной для холодной воды с регулятором давления Honeywell FK06-3\4AA(100мк.)', 1684),
       ('ХЕБЕЛЬ / HEBEL пеноблок 250х600 толщина 100 мм', 28.8),
       ('ЦЕРЕЗИТ СТ 17 / CERESIT CT 17 грунт универсальный (10 л)', 231.6);

-- changeset liquibase:4
insert into DiscountCard(discount)
values (3), (5), (1), (2), (6), (7), (8), (10), (4), (9),
       (1), (4), (3), (2), (7), (9), (5), (8), (10), (6),
       (7), (6), (4), (8), (10), (1), (2), (5), (9), (3);
