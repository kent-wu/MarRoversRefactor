package robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Client {
	public static void main(String[] args) throws Exception {
		Robot robot=new Robot();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        initRobot(robot, br);
        while(true){
            outputResult(robot, br);
        }
        
	}

    private static void outputResult(Robot robot, BufferedReader br) throws IOException {
        System.out.println("Enter your Robot orders:");

        String result=robot.controlRefactor(br.readLine());

        System.out.println(result);
    }

    private static void initRobot(Robot robot, BufferedReader br) throws IOException {
        System.out.println("Enter your robot initial x,y and direstion:");
        String[] initPos= br.readLine().split(" ");

        robot.x=Integer.parseInt(initPos[0]);
        robot.y=Integer.parseInt(initPos[1]);
        robot.currentDirection =Character.toUpperCase(initPos[2].charAt(0));
    }

    private static void init(BufferedReader br) throws IOException {
        System.out.println("Enter your Boundary x and y:");
        String[] boundaryArr= br.readLine().split(" ");

        if(!idDigit(boundaryArr[0]) || !idDigit(boundaryArr[1])){
        	System.out.println("Boundary x and y are must be digit,and input them again:");
        }

        Robot.x_bound =Integer.parseInt(boundaryArr[0]);
        Robot.y_bound =Integer.parseInt(boundaryArr[1]);
    }

    public static boolean idDigit(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();
	}
}
