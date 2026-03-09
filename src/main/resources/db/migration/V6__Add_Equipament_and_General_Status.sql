CREATE Table equipment (
    id BIGINT NOT NULL  AUTO_INCREMENT ,
    model varchar(20),
    serial_number varchar(15),
    status_general ENUM('ACTIVE', 'INACTIVE') NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE weighing
    ADD COLUMN equipment_id BIGINT NOT NULL,
ADD CONSTRAINT fk_weighing_equipment
    FOREIGN KEY (equipment_id) REFERENCES equipment(id);
