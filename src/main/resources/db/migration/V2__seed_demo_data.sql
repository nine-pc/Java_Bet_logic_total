insert into users(id, username, balance)
values
(1, 'john', 1000.00),
(2, 'alice', 500.00);

insert into events(
    id,
    home_team,
    away_team,
    start_time,
    status
)
values
(
    1,
    'Arsenal',
    'Chelsea',
    now() + interval '1 day',
    'OPEN'
);

insert into markets(
    id,
    event_id,
    name
)
values
(
    1,
    1,
    'MATCH WINNER'
);

insert into outcomes(
    id,
    market_id,
    name,
    odds,
    active
)
values
(1, 1, 'HOME', 1.80, true),
(2, 1, 'DRAW', 3.20, true),
(3, 1, 'AWAY', 4.10, true);

select setval('users_id_seq', 2, true);
select setval('events_id_seq', 1, true);
select setval('markets_id_seq', 1, true);
select setval('outcomes_id_seq', 3, true);