/*
* 2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питаение(есть/нет), wifi(есть/нет), свободен/занят)
 */
public class Room {
    private byte quantity;
    private boolean wc;
    private boolean eat;
    private boolean wifi;
    private boolean isFree;
    private byte roomNumber;

    public Room(byte quantity, boolean wc, boolean eat, boolean wifi,byte roomNumber) {
        this.quantity = quantity;
        this.wc = wc;
        this.eat = eat;
        this.wifi = wifi;
        this.isFree = true;
        this.roomNumber = roomNumber;
    }


    public byte getRoomNumber() {
        return roomNumber;
    }

    public byte getQuantity() {
        return quantity;
    }

    public boolean isWc() {
        return wc;
    }

    public boolean isEat() {
        return eat;
    }

    public boolean isWifi() {
        return wifi;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
    public void getDescriptions () {
        System.out.print("Кол-во мест: "+this.quantity+". Сан.узел: ");
        if (this.wc) System.out.print("есть. ");
        else System.out.print("нет. ");
        System.out.print("Питание: ");
        if (this.eat) System.out.print("включено. ");
        else System.out.print("не включено. ");
        System.out.print("Wi-Fi: ");
        if (this.wifi) System.out.println("есть.");
        else System.out.println("нет.");
    }
}
