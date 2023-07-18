package HW_6;

public class Laptop {
    private int id;
    private String company;
    private String name;
    private String cpu;
    private String card;
    private int ram;
    private int hdd;

    public Laptop(int id, String company, String name, String cpu, String card, int ram, int hdd) {
        this.id = id;
        this.company = company;
        this.name = name;
        this.cpu = cpu;
        this.card = card;
        this.ram = ram;
        this.hdd = hdd;
    }
    
    public int getId() {
        return id;
    }
    
    public String getCompany() {
        return company;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCpu() {
        return cpu;
    }

    public String getCard() {
        return card;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    @Override
    public String toString() {
        return String.format("%s %s Процессор: %s Видеокарта: %s Объём оперативной памяти: %dГБ Объём жёсткого диска: %dГБ", company, name, cpu, card, ram, hdd);
    }
}
