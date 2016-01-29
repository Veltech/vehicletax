# Vehicles schema

# --- !Ups

CREATE TABLE Vehicles (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    number varchar(255) NOT NULL,
        make varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE Vehicles;