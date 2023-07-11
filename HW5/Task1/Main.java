package HW5.Task1;

public class Main {
    public static void main(String[] args) {
        Contacts phoneBook = new Contacts();
        phoneBook.addNote("+9945555555", "Ivanov");
        phoneBook.addNote("+12345678", "Alexander");
        phoneBook.addNote("+55555555", "Cristiano");
        phoneBook.addNote("+98776543213", "Mbappe");
        phoneBook.addNote("+1234654", "Messi");
        phoneBook.addNote("+599323435", "Ivanov");

        System.out.println(phoneBook.findByName("Ivanov"));
    }    
}
