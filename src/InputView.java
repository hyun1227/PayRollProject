import java.util.*;

public class InputView {
    private BufferedReader infile;
    private final String EOF="!";
    private String name;
    private double hours,payrate;
    private int insurance;


    public InputView(String file_name){
        try{
            infile=new BufferedReader(new FileReader(file_name));
        }
        catch (Exception e){
            System.out.println("PayrollReader Error bad file_name")
        }
    }

    public boolean getNextRecord(){
        boolean result =false;
        try{
            if(infile.ready()){
                String line=infile.readLine();
                StringTokenizer t=new StringTokenizer(line,",");
                String s=t.nextToken().trim();
                if (!EOF.equals(s)) {
                    if (t.countTokens() == 3) {
                        name = s;
                        hours = Double.parseDouble(t.nextToken().trim());
                        payrate = Double.parseDouble(t.nextToken().trim());
                        insurance=Integer.parseInt(t.nextToken().trim())
                        result = true;
                    } else {
                        throw new RuntimeException(line);
                    }
                }
            } catch (IOException e) {
                System.out.println("PayrollReader Error : " + e.getMessage());
            }
            catch (RuntimeException e) {
                System.out.println("PayrollReader Error - bad record format: " + e.getMessage() + " Skipping");
                result = getNextRecord(); // 다음 줄 시도
            }
            return result;


                }
        }
    }

    public List<UserPayInfo> getUserPayInfosFromFile() {
        ArrayList<UserPayInfo> arr=new ArrayList<>():
        arr.add(name);
        arr.add(hours);
        arr.add(payrate);
        if insurance==1
            arr.add(true);
        else
            arr.add(false);

    }
//1이면 적용자
//    public List<UserPayInfo> getUserPayInfosFromUserAction() {
//        return List.of(
//                UserPayInfo.of("4", 10, 100000, false),
//                UserPayInfo.of("4-1", 10, 100000, false),
//                UserPayInfo.of("x", 10, 100000, true)
//        );
//    }

}
