import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by freddy on 01/12/2016.
 */
public class Day1_1 {

    private static String FILE_PATH = "C:\\Users\\freddy\\Devel\\IdeaProjects\\office-repo\\java\\advent-of-code\\advent-of-code-2016\\resource\\Input_Day1_1";
    private static String NORTH = "n";
    private static String SOUTH = "s";
    private static String EAST = "e";
    private static String WEST = "w";
    private static List<Point> visitedCoordinates= new ArrayList<Point>();
    private static Point visitedTwice = null;

    public static void main(String[] args) {

        List<String> instructions = new ArrayList<String>();
        String currentFacing = NORTH;
        Point initialCoordinate = new Point(0,0);
        Point currentCoordinate = new Point(0,0);
        //visitedCoordinates.add(new Point(initialCoordinate.x, initialCoordinate.y));

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    instructions.addAll(Arrays.asList(line.split(", ")));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String instruction : instructions) {
            int steps;
            if(instruction.contains("L")){
                steps = Integer.parseInt(instruction.substring(instruction.indexOf("L") + 1));
                currentCoordinate = moveLeft(steps, currentCoordinate, currentFacing);
                currentFacing = updateFacing("L", currentFacing);
            } else if(instruction.contains("R")){
                steps = Integer.parseInt(instruction.substring(instruction.indexOf("R") + 1));
                currentCoordinate = moveRight(steps, currentCoordinate, currentFacing);
                currentFacing = updateFacing("R", currentFacing);
            }
        }

        // Taxicab formula d(AB)= (y2 - y1) + (x2 - x1);
        // In this case x1 = 0 ; y1 = 0

        int distance = (currentCoordinate.y - initialCoordinate.y) + (currentCoordinate.x - initialCoordinate.x);
        int distanceToVisitedTwice = (visitedTwice.y - initialCoordinate.y) + (visitedTwice.x - initialCoordinate.x);

        System.out.println("Last Coordinate: " + currentCoordinate);
        System.out.println("Last Coordinate distance: " + distance);

        System.out.println("Visited Twice Coordinate: " + visitedTwice);
        System.out.println("Visited Twice Coordinate distance: " + distanceToVisitedTwice);
    }

    private static boolean isVisited(Point currentCoordinate, List<Point> visitedCoordinates){
        for (Point visited : visitedCoordinates) {
            if(visited.x == currentCoordinate.x && visited.y == currentCoordinate.y){
                return true;
            }
        }

        return false;
    }

    private static String updateFacing(String direction, String currentFacing){

        if(direction.equals("L")){
            if(currentFacing.equals(NORTH)){
                return WEST;
            }
            if(currentFacing.equals(SOUTH)){
                return EAST;
            }
            if(currentFacing.equals(EAST)){
                return NORTH;
            }
            if(currentFacing.equals(WEST)){
                return SOUTH;
            }

        } else if (direction.equals("R")){
            if(currentFacing.equals(NORTH)){
                return EAST;
            }
            if(currentFacing.equals(SOUTH)){
                return WEST;
            }
            if(currentFacing.equals(EAST)){
                return SOUTH;
            }
            if(currentFacing.equals(WEST)){
                return NORTH;
            }
        }

        return null;
    }

    private static Point moveLeft(int steps, Point currentCoordinate, String currentFacing){
        int moveX;
        int moveY;

        if(currentFacing.equals(NORTH)){
            moveX = (-1)*steps;
            moveY = 0;
            addVisited(currentCoordinate, moveX, moveY);
            currentCoordinate.translate(moveX, moveY);
        } else if(currentFacing.equals(SOUTH)){
            moveX = steps;
            moveY = 0;
            addVisited(currentCoordinate, moveX, moveY);
            currentCoordinate.translate(moveX, moveY);
        } else if(currentFacing.equals(EAST)){
            moveX = 0;
            moveY = steps;
            addVisited(currentCoordinate, moveX, moveY);
            currentCoordinate.translate(moveX, moveY);
        } else if(currentFacing.equals(WEST)){
            moveX = 0;
            moveY = (-1)*steps;
            addVisited(currentCoordinate, moveX, moveY);
            currentCoordinate.translate(moveX, moveY);
        }

        return currentCoordinate;
    }

    private static Point moveRight(int steps, Point currentCoordinate, String currentFacing){
        int moveX;
        int moveY;

        if(currentFacing.equals(NORTH)){
            moveX = steps;
            moveY = 0;
            addVisited(currentCoordinate, moveX, moveY);
            currentCoordinate.translate(moveX, moveY);
        } else if(currentFacing.equals(SOUTH)){
            moveX = (-1)*steps;
            moveY = 0;
            addVisited(currentCoordinate, moveX, moveY);
            currentCoordinate.translate(moveX, moveY);
        } else if(currentFacing.equals(EAST)){
            moveX = 0;
            moveY = (-1)*steps;
            addVisited(currentCoordinate, moveX, moveY);
            currentCoordinate.translate(moveX, moveY);
        } else if(currentFacing.equals(WEST)){
            moveX = 0;
            moveY = steps;
            addVisited(currentCoordinate, moveX, moveY);
            currentCoordinate.translate(moveX, moveY);
        }

        return currentCoordinate;
    }

    private static void addVisited(Point currentCoordinate, int moveX, int moveY) {

        int currentX = currentCoordinate.x;
        int currentY = currentCoordinate.y;

        int lastX = currentX + moveX;
        int lastY = currentY + moveY;

        if(moveX != 0){
            if(moveX > 0){
                for (int i = currentX + 1; i <= lastX ; i++) {
                    Point currentPoint = new Point(i, currentY);
                    if(visitedTwice == null && isVisited(currentPoint, visitedCoordinates)){
                        visitedTwice = new Point(currentPoint.x , currentPoint.y);
                    }
                    visitedCoordinates.add(currentPoint);
                }
            } else if(moveX < 0){
                for (int i = currentX - 1; i >= lastX ; i--) {
                    Point currentPoint = new Point(i, currentY);
                    if(visitedTwice == null && isVisited(currentPoint, visitedCoordinates)){
                        visitedTwice = new Point(currentPoint.x , currentPoint.y);
                    }
                    visitedCoordinates.add(currentPoint);
                }
            }
        } else if(moveY != 0){
            if(moveY > 0){
                for (int i = currentY + 1; i <= lastY ; i++) {
                    Point currentPoint = new Point(currentX, i);
                    if(visitedTwice == null && isVisited(currentPoint, visitedCoordinates)){
                        visitedTwice = new Point(currentPoint.x , currentPoint.y);
                    }
                    visitedCoordinates.add(currentPoint);
                }
            } else if(moveY < 0){
                for (int i = currentY - 1; i >= lastY ; i--) {
                    Point currentPoint = new Point(currentX, i);
                    if(visitedTwice == null && isVisited(currentPoint, visitedCoordinates)){
                        visitedTwice = new Point(currentPoint.x , currentPoint.y);
                    }
                    visitedCoordinates.add(currentPoint);
                }
            }
        }

    }

}
