package ro.cmutica.crypto.run;

import java.util.Optional;
import ro.cmutica.crypto.impl.Crypto;

/**
 *
 * @author cmutica
 */
public class Main {
    
    public static void printHelp(){
        System.out.println("This utility (de)crypts the provided input.");
        System.out.println("In order to work the environment variable \" APPS_KEY \" must be set, and shoud contain the symmetric encryption key.");
        System.out.println("Call the program with the following arguments:");
        System.out.println("\t <program path> <flag> <input>");
        
        System.out.println("Flags (should be inserted before the input text):");
        System.out.println("\t -d \t for decryption");
        System.out.println("\t -c \t for encrytion");
        System.out.println("\t -h \t for help");
    }
    
    public static void main(String[] args) {
        
        if (args == null || args.length < 1) {
            System.out.println("You din not set any flag!");
            return;
        }
        
        if (args[0].equalsIgnoreCase("-h")) {
            printHelp();
            return;
        }
        
        Optional<Boolean> _encrypt = switch(args[0].toLowerCase()) {
            case "-d":
                yield Optional.of(Boolean.FALSE);
            case "-c":
                yield Optional.of(Boolean.TRUE);
            default:
                yield Optional.empty();
        };
        
        if (_encrypt.isEmpty()) {
            System.out.println("The flag is not permitted!");
        }
        
        if (args.length < 2) {
            System.out.println("You din not provided any input for (de)cryption!");
            return;
        }
        
        try {
            if (_encrypt.get()){
                System.out.println("Text input: " + args[1]);
                System.out.println("Text criptat: " + Crypto.encrypt(args[1]));
            } else {
                System.out.println("Text input: " + args[1]);
                System.out.println("Text criptat: " + Crypto.decrypt(args[1]));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
