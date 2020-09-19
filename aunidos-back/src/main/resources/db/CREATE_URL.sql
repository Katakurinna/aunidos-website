CREATE TABLE url (
    id INT primary key auto_increment,
    provincia INT,
    social_media INT,
    url VARCHAR(150),
    FOREIGN KEY (provincia) REFERENCES provincia(id),
    FOREIGN KEY (social_media) REFERENCES socialmedia(id)
);
ALTER TABLE `url` ADD UNIQUE `unique_index`(`provincia`, `social_media`);