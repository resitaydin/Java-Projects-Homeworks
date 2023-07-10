import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class CSE222Map {
    int start_point_x;
    int start_point_y;

    int end_point_x;
    int end_point_y;

    int row;
    int column;

    String[][] matrix;
    String fileName;

    BufferedImage image;

    public CSE222Map(String inputFile, int row, int column) {
        this.row = row;
        this.column = column;
        fileName = inputFile;
        matrix = new String[row][column];
        readFromFile();
    }

    public int getR() {
        return row;
    }

    public int getC() {
        return column;
    }

    private void readFromFile() {
        int counter = 0;
        try {
            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().replace("-1", "1");
                if (counter == 0) {
                    String[] values = line.split(","); // Optimise this code
                    start_point_x = Integer.parseInt(values[0]);
                    start_point_y = Integer.parseInt(values[1]);
                } else if (counter == 1) {
                    String[] values = line.split(",");
                    end_point_x = Integer.parseInt(values[0]);
                    end_point_y = Integer.parseInt(values[1]);
                } else {
                    matrix[counter - 2] = line.split(",");
                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printMap() {
        for (int i = 0; i < getR(); ++i) {
            for (int j = 0; j < getC(); ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void convertPNG() {
        image = new BufferedImage(matrix.length, matrix[0].length, BufferedImage.TYPE_INT_RGB);
        int white = (255 << 16) | (255 << 8) | 255;
        int gray = (128 << 16) | (128 << 8) | 128;

        for (int x = 0; x < getR(); x++) {
            for (int y = 0; y < getC(); y++) {
                if (matrix[x][y].equals("0")) {
                    image.setRGB(x, y, white);
                } else {
                    image.setRGB(x, y, gray);
                }
            }
        }
        File ImageFile = new File(fileName.split(".txt")[0] + "_BlankMap.png");
        try {
            ImageIO.write(image, "png", ImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawLine(List<String> path) {
        Graphics g = image.getGraphics();
        g.setColor(java.awt.Color.RED);

        for (int i = 0; i < path.size() - 1; ++i) {
            String[] values = path.get(i).split(",");
            int x1 = Integer.parseInt(values[0]);
            int y1 = Integer.parseInt(values[1]);
            values = path.get(i + 1).split(",");
            int x2 = Integer.parseInt(values[0]);
            int y2 = Integer.parseInt(values[1]);
            g.drawLine(x1, y1, x2, y2);
        }
        g.dispose();
        // write the updated BufferedImage to a file

        File ImageFile = new File(fileName.split(".txt")[0] + "_PathPrintedMap.png");
        try {
            ImageIO.write(image, "png", ImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writePath(List<String> path) {
        File file = new File(fileName.split(".txt")[0] + "_path.txt");
        for (int i = 0; i < path.size(); ++i) {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(path.get(i) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}