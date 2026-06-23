create table users (
    id bigserial primary key,
    username varchar(100) not null unique,
    balance numeric(19, 2) not null default 0,
    created_at timestamp not null default current_timestamp
);

create table events (
    id bigserial primary key,
    home_team varchar(100) not null,
    away_team varchar(100) not null,
    start_time timestamp not null,
    status varchar(20) not null,
    created_at timestamp not null default current_timestamp
);

create table markets (
    id bigserial primary key,
    event_id bigint not null,
    name varchar(100) not null,

    constraint fk_market_event
        foreign key (event_id)
        references events(id)
);

create table bet_slips (
    id bigserial primary key,
    user_id bigint not null,
    stake numeric(19, 2) not null,
    total_odds numeric(12, 4) not null,
    potential_payout numeric(19, 2) not null,
    status varchar(20) not null,
    created_at timestamp not null default current_timestamp,

    constraint fk_betslip_user
        foreign key (user_id)
        references users(id)
);

create table bet_selections (
    id bigserial primary key,
    bet_slip_id bigint not null,
    outcome_id bigint not null,
    odds numeric(10, 2) nto null,
    result varchar(20)

    constraint fk_selection_betslip
        foreign key (bet_slip_id)
        references bet_slips(id),

    constraint fk_selection_outcome
        foreign key (outcome_id)
        references outcomes(id)
);

create table transactions (
    id bigserial primary key,
    user_id bigint not null,
    amount numeric(19, 2) not null,
    type varchar(20) not null,
    created_at timestamp not null default current_timestamp,

    constraint fk_selection_outcome
        foreign key (user_id)
        references users(id)
);