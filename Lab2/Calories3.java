import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Calories3{
	public static void main(String[] args) throws FileNotFoundException, NullPointerException{
		boolean a = fileExist();
		if(a == false){
			System.out.println("Please revise your file, you have some mistakes.");
			System.exit(0);
		}
		boolean b = fileValidation();
		if(b == false){
			System.out.println("It seems like your file has some mistakes");
			System.exit(0);
		}
		userInfo();

	}

	public static void userInfo() throws FileNotFoundException{
		File file = new File("input3.txt");
		Scanner scnr = new Scanner(file);
		double[][] foodConsumed = new double[7][];
		int row = 0;
		while(scnr.hasNextLine()){
			String newLine = scnr.nextLine();
			String[] splitter = newLine.split(" ");
			double[] u = new double[splitter.length];
			foodConsumed[row] = new double[u.length];
				for(int i = 0; i < splitter.length; i++){
					u[i] = Integer.parseInt(splitter[i]);
					foodConsumed[row][i] = u[i];
				}
			row++;
		}
		for(int i = 0; i < foodConsumed.length; i++){
			for(int j = 0; j < foodConsumed[i].length; j++){
				System.out.println(foodConsumed[i][j]);
			}
			System.out.println(foodConsumed[0][i].length);
		}

		double[] avg = averagePerDay(foodConsumed);
		String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		double[] avgMealType = avgMeal(foodConsumed);

		System.out.println("************************** Calorie Summary *****************************");
		for(int i =0; i < avg.length; i++){
			System.out.println("Average on " + week[i] + " is: " + avg[i]);
			System.out.println();
		}
		for(int i = 0; i < avgMealType.length; i++){
			System.out.println("Average meal type: " + avgMealType[i]);
		}

			System.out.println();
		}

		public static int LongestLenght(double[][] caloriesEaten){
			int max = caloriesEaten[0].length;
			for(int i = 1; i < caloriesEaten[i].length; i++){
				if(caloriesEaten[i].length > max) max = caloriesEaten[i].length;
			}
			return max;
		}

		public static double[] avgMeal(double[][] calories){
			int length = LongestLenght(calories);
			int counter = 0;
			double[] sums = new double[5];
			for(int i = 0; i < calories.length; i++){
				for(int j = 0; j < calories[i].length; j++){
						sums[j] = sums[j] + calories[i][j];
				}
			}
			return sums;
		}

		public static double[] averagePerDay(double[][] caloriesEaten){
			double[] avg = new double[7];
			for(int i = 0; i < caloriesEaten.length; i++){
				for(int j = 0; j < caloriesEaten[i].length; j++){
					avg[i] = avg[i] + caloriesEaten[i][j] / caloriesEaten[i].length;
				}
			}
			return avg;
		}

	public static boolean fileValidation() throws FileNotFoundException{
		File file = new File("input3.txt");
		Scanner scnr = new Scanner(file);

		int row = 0;

		while(scnr.hasNextLine()){
			String newLine = scnr.nextLine();
			row++;
		}

		if(row == 7) return true;
		return false;
	}

	public static boolean fileExist() throws FileNotFoundException{
		try{
			File file = new File("input3.txt");
			Scanner scnr = new Scanner(file);

			String a = "";

			while(scnr.hasNextLine()){
				a = scnr.nextLine();
			}
			if(a.length() > 0) return true;
			}catch(FileNotFoundException FNE){
				System.out.println("We did not find your file!");
				System.exit(0);
			}
		return false;
	}
}
