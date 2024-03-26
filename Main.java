import java.util.*;

public class Main {
    private static String password = "password";
    static int attempts = 3;

    public static void login(String enteredPassword) throws InvalidPasswordException{
        attempts--;
        if(!password.equals(enteredPassword)){
            throw new InvalidPasswordException();
        }

        System.out.println("Login successful");

    }

    public static void main(String[] args) throws MaxTriesException, InvalidPasswordException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                if(attempts == 0){
                    throw new MaxTriesException();
                }
                System.out.print("Enter Password: ");
                String input = scanner.next();
                login(input);
                break;
            } catch (MaxTriesException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}