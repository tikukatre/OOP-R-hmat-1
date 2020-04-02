public class Peaklass {
    public static void main(String[] args) {
        System.out.println("Tere!");

        if(args[0].equalsIgnoreCase("Naine")){
            new Naine(args[1],Integer.parseInt(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Integer.parseInt(args[5]));

        }
    }
}
