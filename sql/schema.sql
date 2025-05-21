CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  profile_picture VARCHAR(255),
  bio TEXT
);

CREATE TABLE lists (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  list_name VARCHAR(255) NOT NULL,
  description TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE dog_images (
  id INT PRIMARY KEY AUTO_INCREMENT,
  list_id INT NOT NULL,
  image_url VARCHAR(255) NOT NULL,
  response_code INT NOT NULL,
  caption TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (list_id) REFERENCES lists(id)
);

CREATE TABLE user_list_likes (
  user_id INT NOT NULL,
  list_id INT NOT NULL,
  PRIMARY KEY (user_id, list_id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (list_id) REFERENCES lists(id)
);

CREATE TABLE user_image_likes (
  user_id INT NOT NULL,
  image_id INT NOT NULL,
  PRIMARY KEY (user_id, image_id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (image_id) REFERENCES dog_images(id)
);

CREATE TABLE comments (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  image_id INT NOT NULL,
  comment TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (image_id) REFERENCES dog_images(id)
);

