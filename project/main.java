import java.util.*;
import java.io.*;
public class Project {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
//            System.out.print("Input name: ");
//            System.out.print("Input age: ");
            System.out.print("Input weight in kilogram: ");
            double weight = scanner.nextDouble();
            System.out.print("Input height in meters: ");
            double height = scanner.nextDouble();
            PersonalInfo person = new PersonalInfo("Nhi", 20, height, weight);
            double BMI = person.BMICalculator();
            System.out.println("The Body Mass Index (BMI) is "  + BMI + " kg/m2");
            if(BMI > 20) {
                System.out.println("You need to loss weight");
                System.out.println("Recommendation: Follow a balanced diet with controlled calorie intake.");
                System.out.println("Here's a sample meal plan:");
                System.out.println("Breakfast: Oatmeal with fruits and nuts");
                System.out.println("Lunch: Grilled chicken salad");
                System.out.println("Dinner: Baked fish with steamed vegetables");
                System.out.println("Consult a nutritionist for a personalized meal plan.");
            }
            if(BMI < 20){
                System.out.println("You are thin");
                System.out.println("Recommendation: Consume a balanced diet with extra focus on nutrient-dense foods.");
                System.out.println("Here's a sample meal plan:");
                System.out.println("Breakfast: Whole grain toast with avocado and poached eggs");
                System.out.println("Lunch: Quinoa salad with grilled chicken and mixed vegetables");
                System.out.println("Dinner: Grilled salmon with roasted sweet potatoes and steamed broccoli");
                System.out.println("Ensure to eat regular meals and snacks throughout the day to meet your calorie needs.");
                System.out.println("Consult a nutritionist for a personalized meal plan.");
            }
            FitnessTracker tracker = new FitnessTracker();

            // Add weights and heights
            tracker.addWeightHeight(70);
            tracker.addWeightHeight(170);

            // Add food names and calories
            tracker.addFoodCalories("Apple", 52);
            tracker.addFoodCalories("Banana", 89);
            tracker.addFoodCalories("Orange", 47);
            tracker.addFoodCalories("Chicken breast", 237);
            tracker.addFoodCalories("Tofu", 81);

            // Generate meal plan
            List<String> mealPlan = tracker.generateMealPlan(300);


            // Print meal plan
            System.out.println("Meal Plan:");
            for (String meal : mealPlan) {
                System.out.println(meal);
            }

            System.out.print("Do you want to continue?");
            running = (scanner.next().equals("y"));
        }
    }


}
//




