create index idx_event_status
on events(status);

create index idx_betslip_user
on bet_slips(user_id);

create index idx_market_event
on markets(event_id);

create index idx_outcome_market
on outcomes(market_id);

create index idx_transaction_user
on transactions(user_id);