DROP DATABASE IF EXISTS manufacture;
CREATE DATABASE manufacture;

\c manufacture;

CREATE TABLE Car (
    car_id SERIAL PRIMARY KEY,
    brand VARCHAR(100),
    model VARCHAR(100),
    UNIQUE (brand, model)
);

CREATE TABLE Engineer (
    engineer_id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    country CHAR(11),
    car_id INT,
    UNIQUE (name, country),
    CONSTRAINT fk_car_id FOREIGN KEY(car_id) REFERENCES Car(car_id)
);

INSERT INTO Car (brand, model) VALUES ('Mercedes', '124');
INSERT INTO Car (brand, model) VALUES ('Toyota', 'Camry');
INSERT INTO Car (brand, model) VALUES ('Audi', 'S4');

INSERT INTO Engineer (name, country, car_id) VALUES('Tom Young', 'Japan', 2);
INSERT INTO Engineer (name, country, car_id) VALUES('Brian Johnson', 'Germany', 1);
INSERT INTO Engineer (name, country, car_id) VALUES('Mathew Carban', 'Germany' ,1);
INSERT INTO Engineer (name, country, car_id) VALUES('Smart Win', 'Japan', 2);
INSERT INTO Engineer (name, country, car_id) VALUES('Umaru Sulejah', 'Germany' ,1);
INSERT INTO Engineer (name, country, car_id) VALUES('Jason Bethacker', 'Germany' ,3);