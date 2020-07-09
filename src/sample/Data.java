package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Data {


    //Controller control = new Controller();
private String pizza;
private String iceCream;
private String pizzaToppings;
private String iceCreamToppings;
private String soda;



    public Data() {
    }

    public String getPizzaToppings() {
        return pizzaToppings;
    }

    public void setPizzaToppings(String pizzaToppings) {
        this.pizzaToppings = pizzaToppings;
    }

    public String getIceCreamToppings() {
        return iceCreamToppings;
    }

    public void setIceCreamToppings(String iceCreamToppings) {
        this.iceCreamToppings = iceCreamToppings;
    }

    public String getSoda() {
        return soda;
    }

    public void setSoda(String soda) {
        this.soda = soda;
    }

    public String getPizza() {
        return pizza;
    }

    public String getIceCream() {
        return iceCream;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public void setIceCream(String iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String toString() {
        return "You want " + pizzaToppings + " " + pizza + " pizza with a " + soda + " and some " + iceCream + " ice cream " + iceCreamToppings + " on top for dessert";
    }

    public void WriteFile(File file)
    {
        try
        {

            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write( this.toString() );    ///Write file contents.

            //close file when done
            out.close();
        }
        catch (Exception e)		//Catch exception if any
        {
            System.err.println("Error: " + e.getMessage());
        }

    }

}
