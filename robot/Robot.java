package robot;

import java.util.HashMap;
import java.util.Map;

public class Robot {
    public static int x_bound;
    public static int y_bound;
    public int x;
    public int y;
    private int currentDirection;
    private Map directionMap;
    public char[] direction = new char[]{'N', 'E', 'S', 'W'};
    public int[] x_moves = new int[]{0, 1, 0, -1};
    public int[] y_moves = new int[]{1, 0, -1, 0};

    public Robot() {
        directionMap = new HashMap();
        directionMap.put('N',0);
        directionMap.put('E',1);
        directionMap.put('S',2);
        directionMap.put('W',3);
    }

    public String control(String orderString) {
        char[] orders = orderString.toCharArray();
        for (char order : orders) {
            order = Character.toUpperCase(order);
            switch (order) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    moveForward();
                    break;
                case 'B':
                    moveBack();
                    break;
            }
            if (this.checkError()) {
                return "RIP";
            }

        }
        return x + " " + y + " " + direction[currentDirection];
    }

    public void setCurrentDirection(char currentDirection) {
        this.currentDirection = (Integer) directionMap.get(currentDirection);
    }

    public void turnLeft() {
        currentDirection = (currentDirection + 3) % 4;
    }

    public void turnRight() {
        currentDirection = (currentDirection + 1) % 4;
    }

    public void moveForward() {
        x += x_moves[currentDirection];
        y += y_moves[currentDirection];
    }

    public void moveBack() {
        x -= x_moves[currentDirection];
        y -= y_moves[currentDirection];
    }

    private boolean checkError() {
        if (this.x > x_bound || this.x < 0 || this.y > y_bound || this.y < 0) {
            return true;
        }
        return false;
    }
}
