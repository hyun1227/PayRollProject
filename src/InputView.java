import java.util.*;
import java.io.*;

public class InputView {
    private BufferedReader infile;
    private final String EOF = "!";

    public InputView(String fileName) {
        try {
            infile = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + fileName);
        }
    }

    public List<UserPayInfo> getUserPayInfosFromFile() {
        List<UserPayInfo> userPayInfos = new ArrayList<>();

        if (infile == null) {
            System.out.println("Error: Input file not initialized.");
            return userPayInfos;
        }

        try {
            String line;
            while ((line = infile.readLine()) != null) {
                if (EOF.equals(line.trim())) {
                    break;
                }

                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                if (tokenizer.countTokens() != 4) {
                    System.out.println("Invalid record format: " + line);
                    continue;
                }

                try {
                    String name = tokenizer.nextToken().trim();
                    double amountPerHour = Double.parseDouble(tokenizer.nextToken().trim());
                    double workedTime = Double.parseDouble(tokenizer.nextToken().trim());
                    boolean isFreelancer = Integer.parseInt(tokenizer.nextToken().trim()) == 1;

                    userPayInfos.add(UserPayInfo.of(name,workedTime,amountPerHour,isFreelancer));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in record: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                infile.close();
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }

        return userPayInfos;
    }
}

//1이면 적용자
//    public List<UserPayInfo> getUserPayInfosFromUserAction() {
//        return List.of(
//                UserPayInfo.of("4", 10, 100000, false),
//                UserPayInfo.of("4-1", 10, 100000, false),
//                UserPayInfo.of("x", 10, 100000, true)
//        );
//    }


