public class Peaklass {
    public static void main(String[] args) {
        System.out.println("Tere!");

        if(args[0].equalsIgnoreCase("Naine")){
            Isik isik = new Naine(args[1],Integer.parseInt(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Integer.parseInt(args[5]));

        }else if (args[0].equalsIgnoreCase("Mees")){
            Isik isik = new Mees(args[1],Integer.parseInt(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Integer.parseInt(args[5]));
        }
        Toit toit = new Toit(args[6],Double.parseDouble(args[7]),Integer.parseInt(args[8]));
    }
}
