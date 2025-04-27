CREATE TABLE IF NOT EXISTS deck (
    id        UUID PRIMARY KEY,
    owner_id  UUID NOT NULL REFERENCES account (id),
    name      TEXT NOT NULL,
    type      TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS deck_card (
    id          UUID PRIMARY KEY,
    deck_id     UUID NOT NULL REFERENCES deck (id),
    card_id     TEXT NOT NULL REFERENCES card (id),
    quantity    int
);

