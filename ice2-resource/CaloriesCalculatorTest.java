public class CaloriesCalculatorTest {
    public static void main(String[] args) {

        NewYearGoodie tart = new NewYearGoodie("Pineapple Tarts", 82.5, 20);
        NewYearGoodie bakKwa = new NewYearGoodie("Bak Kwa", 115, 28);
        NewYearGoodie loveLetters = new NewYearGoodie("Love Letters", 56.5, 13);

        System.out.println("Pineapple Tarts more sinful than Bak Kwa: " + tart.isMoreSinful(bakKwa));

        System.out.println("\nPineapple Tarts (calories per gram) :" + String.format("%.2f", tart.getCaloriesPerGram()));
        System.out.println("Bak Kwa (calories per gram) :" + String.format("%.2f", bakKwa.getCaloriesPerGram()));
        System.out.println("Love Letters (calories per gram) :" + String.format("%.2f", loveLetters.getCaloriesPerGram()));

        CaloriesCalculator calCal = new CaloriesCalculator();
        calCal.addNewYearGoodie(tart, 2);
        calCal.addNewYearGoodie(bakKwa, 3);
        calCal.addNewYearGoodie(loveLetters, 5);

        System.out.println("Total Calories :" + String.format("%.2f", calCal.getTotalCalories()));
        System.out.println("Most sinful goodie :" + calCal.getMostSinfulGoodie().getName());
        
    }
}
