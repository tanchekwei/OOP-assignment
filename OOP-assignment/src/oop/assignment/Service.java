
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JT
 */
public class Service {

    private String code, name, desc, type;
    private double netPrice;
    private int duration;

    public Service(String code, String name, String desc, String type, double netPrice, int duration) {
        this.code = code;
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.netPrice = netPrice;
        this.duration = duration;
    }

    public String toString() {
        return String.format("%-3s %-15s %-30s %-9s %3.2f %d", code, name, desc, type, netPrice, duration);
    }

    //Mutator
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    //Accessor
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public int getDuration() {
        return duration;
    }

    public static void addService() {
        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        String code, name, desc, type;
        double netPrice;
        int duration;
        char confirm;

        do {
            System.out.print("Enter service code: ");
            code = in.next();
            in.nextLine(); //Clear buffer

            System.out.print("Enter service name: ");
            name = in.nextLine();

            System.out.print("Enter service description: ");
            desc = in.nextLine();

            System.out.print("Enter service type: ");
            type = in.nextLine();

            System.out.print("Enter service net price: ");
            netPrice = in.nextDouble();

            System.out.print("Enter service duration: ");
            duration = in.nextInt();
            do {
                System.out.println("\n\nService code: " + code);
                System.out.println("Service name: " + name);
                System.out.println("Service description: " + desc);
                System.out.println("Service type: " + type);
                System.out.println("Service net price: " + netPrice);
                System.out.println("Service duration: " + duration);
                System.out.print("Are you sure you want to add this service? (Y/N): ");
                confirm = in.next().charAt(0);

                if (Character.toUpperCase(confirm) == 'Y') {
                    try (PrintWriter out = new PrintWriter(new FileOutputStream(
                            new File("Service.txt"), true))) { //append file
                        out.printf("%s#%s#%s#%s#%f#%d\n", code, name, desc, type, netPrice, duration);
                        System.out.println("New service created!");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (Character.toUpperCase(confirm) == 'N') {
                    break;
                } else {
                    System.out.println("Please enter Y or N only!");
                }
            } while (Character.toUpperCase(confirm) != 'Y' && Character.toUpperCase(confirm) != 'N');

            do{
            System.out.print("Anymore service to add? (Y/N): ");
            confirm = in.next().charAt(0);
            }while(Character.toUpperCase(confirm) != 'Y' && Character.toUpperCase(confirm) != 'N');
        } while (Character.toUpperCase(confirm) == 'Y');
    }

    public static void modifyService() {
        ArrayList<Service> service = new ArrayList<Service>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Service.txt"), "Cp1252")); //file from Windows have ANSI encoding (Cp1252)
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] x = line.split("#");
                double netprice = Double.parseDouble(x[4]);
                int duration = Integer.parseInt(x[5]);
                service.add(new Service(x[0], x[1], x[2], x[3], netprice, duration));
                //service[i] = new Service(x[0], x[1], x[2], x[3], netprice, duration);
                i++;
            }
            br.close();

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.printf("%-4s%-14s%-35s\n", "No", "Service Code", "Service Name");
        int i = 0;
        for(Service s : service){
            System.out.printf("%-4d%-14s%-35s\n", i+1,s.getCode(), s.getName());
            i++;
        }
        System.out.printf("Enter the service you want to modify (1 to " + service.size()+ "): ");
        
    }
}
