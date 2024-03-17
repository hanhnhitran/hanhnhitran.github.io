class PersonalInfo {
    //    private ArrayList<Object> Info = new ArrayList<Object>;
        private String name;
        private int age;
        private double height;
        private double weight;
    
        /**
         * Constructor
         * @param name name of client
         * @param age age of client
         * @param height height of client
         * @param weight weight of client
         */
        public PersonalInfo(String name, int age, double height, double weight){
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
    //        Info.add(name);
    //        Info.add(age);
    //        Info.add(height);
    //        Info.add(weight);
        }
    
        /**
         * Accessors of different fields
         */
        public String getName(){
            return this.name;
        }
    
        public int getAge(){
            return this.age;
        }
    
        public double getHeight(){
            return this.height;
        }
    
        public double getWeight(){
            return this.weight;
        }
    
        /**
         * Mutators of different fields
         */
        public void setName(String name){
            this.name = name;
        }
        public void setAge(int age){
            this.age = age;
        }
        public void setHeight(double height){
            this.height = height;
        }
        public void setWeight(double weight){
            this.weight = weight;
        }
        /**
         * BMI Calculator
         * @return the BMI of the client
         */
        public double BMICalculator(){
            double BMI = this.getWeight() / Math.pow(this.getHeight(), 2);
            return BMI;
    
        }
    
    
    
    }
    //
    
