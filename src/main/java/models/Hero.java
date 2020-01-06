package models;

public class Hero {




        private String name;
        private int age;
        private String power;
        private String weakness;
        private int id;

        public Hero(String name,int id){
            this.name = name;
            this.id = id;
        }

        public String getName(){
            return name;
        }

        public int age(){
            return age;
        }

        public String getPower(){
            return power;
        }

        public String getWeakness(){
            return weakness;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


    }



