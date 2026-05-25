public class SizeRange {
    public static void main(String[] args) {

        System.out.println("Byte Size: " + Byte.SIZE / 8 + " bytes");
        System.out.println("Byte Range: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);

        System.out.println("Short Size: " + Short.SIZE / 8 + " bytes");
        System.out.println("Short Range: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);

        System.out.println("Int Size: " + Integer.SIZE / 8 + " bytes");
        System.out.println("Int Range: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);

        System.out.println("Long Size: " + Long.SIZE / 8 + " bytes");
        System.out.println("Long Range: " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);

        System.out.println("Float Size: " + Float.SIZE / 8 + " bytes");
        System.out.println("Float Range: " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);

        System.out.println("Double Size: " + Double.SIZE / 8 + " bytes");
        System.out.println("Double Range: " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);

        System.out.println("Character Size: " + Character.SIZE / 8 + " bytes");
    }
}