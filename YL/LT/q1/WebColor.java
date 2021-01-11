/*
* Name: Wei Minn
* Email ID: wei.minn.2018
*/
public class WebColor {

    private int red;
    private int green;
    private int blue;

    public WebColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        if(this.red > 255 || this.green > 255 || this.blue > 255) throw new IllegalArgumentException("invalid int value");
        if(this.red < 0 || this.green < 0 || this.blue < 0) throw new IllegalArgumentException("invalid int value");
        
    }

    public WebColor(String hexString) {
        if(hexString.length() != 7) throw new IllegalArgumentException("invalid hexstring");
        String redS = hexString.substring(1,3);
        String greenS = hexString.substring(2,4);
        String blueS = hexString.substring(5,7);

        System.out.println("retrieved hex: " + redS + greenS);
        
        this.red = Integer.parseInt(redS, 16);
        this.green = Integer.parseInt(greenS, 16);
        this.blue = Integer.parseInt(blueS, 16);

    }

    public WebColor add(WebColor another) {
        return new WebColor(
            (int) (((double)this.red*another.red)/255),
            (int) (((double)this.green*another.green)/255),
            (int) (((double)this.blue*another.blue)/255)
            );
    }

    public String toHexString() {
        return "#" + Integer.toHexString(this.red).toUpperCase() + Integer.toHexString(this.green).toUpperCase() + Integer.toHexString(this.blue).toUpperCase();
    }

    public String toString() {
        return this.red + ":" + this.green + ":" + this.blue;
    }
}
