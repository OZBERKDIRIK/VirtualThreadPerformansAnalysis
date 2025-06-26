package core;

public class User {
        private String id;
        private String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }

        // Getter
        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        // Setter
        public void setName(String name) {
            this.name = name;
        }

        // toString
        @Override
        public String toString() {
            return "User{id='" + id + "', name='" + name + "'}";
        }
    }


