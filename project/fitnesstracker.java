import java.util.*;
class FitnessTracker {
    private ArrayList<Double> weightsHeights;
    private HashMap<String, Integer> foodCalories;

    public FitnessTracker() {
        weightsHeights = new ArrayList<Double>();
        foodCalories = new HashMap<String, Integer>();
    }

    public void addWeightHeight(double weightHeight) {
        weightsHeights.add(weightHeight);
    }

    public void addFoodCalories(String foodName, int calorieCount) {
        foodCalories.put(foodName, calorieCount);
    }
    public List<String> generateMealPlan(int dailyCalories) {
        List<String> mealPlan = new ArrayList<String>();
        int remainingCalories = dailyCalories;

        for (Map.Entry<String, Integer> entry : foodCalories.entrySet()) {
            String food = entry.getKey();
            int calories = entry.getValue();

            if (calories <= remainingCalories) {
                // still within budget, add this food to the meal plan
                mealPlan.add(food);
                remainingCalories -= calories;
            }

        }

        return mealPlan;
    }
}




