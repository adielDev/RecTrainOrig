package adiel.rectrain.utils;

/**
 * Created by dov on 27/05/15.
 * convert between metric unit system and the english unit system
 */
public class UnitConvert {

    public static double feetToMeter(double feet)
    {
        return feet*0.3048;
    }

    public static double meterToFeet(double meter)
    {
        return meter*3.2808399;
    }

    public static double kmToMile(double km)
    {
        return km*0.621371192;
    }

    public static double mileToKm(double mile)
    {
        return mile*1.609344;
    }

    public static double inchToCm(double inch)
    {
        return inch*2.54;
    }

    public static double CmToInch(double cm)
    {
        return cm*0.393700787;
    }

}
